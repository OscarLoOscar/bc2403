package com.bootcamp.bc_forum.config;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import com.bootcamp.bc_forum.entity.CommentEntity;
import com.bootcamp.bc_forum.entity.PostEntity;
import com.bootcamp.bc_forum.entity.UserEntity;
import com.bootcamp.bc_forum.infra.exceptions.NotFoundException;
import com.bootcamp.bc_forum.mapper.Mapper;
import com.bootcamp.bc_forum.model.placeholder.CommentRespDto;
import com.bootcamp.bc_forum.model.placeholder.PostRespDto;
import com.bootcamp.bc_forum.model.placeholder.UserRespDto;
import com.bootcamp.bc_forum.service.CommentService;
import com.bootcamp.bc_forum.service.PostService;
import com.bootcamp.bc_forum.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class Runner implements CommandLineRunner {

  @Autowired
  private UserService userService;

  @Autowired
  private PostService postService;

  @Autowired
  private CommentService commentService;

  @Autowired
  private Mapper mapper;

  @Override
  public void run(String... args) throws Exception {

    List<UserRespDto> userRawData = userService.getAllDataByAPI();
    List<PostRespDto> postRawData = postService.getAllDataByAPI();
    List<CommentRespDto> commentRawData = commentService.getAllDataByAPI();

     if (userService.findAllFromDB().isEmpty()) {
      List<UserEntity> userEntities =
          userRawData.stream().map(e -> mapper.mapToEntity(e))//
              .collect(Collectors.toList());
      userService.saveAll(userEntities);
      log.info("User data saved");
      List<PostEntity> postEntities = postRawData.stream()//
          .map(post -> {
            UserEntity user = userEntities.stream()//
                .filter(u -> u.getId().equals(post.getUserId()))//
                .findFirst()//
                .orElseThrow(() -> new NotFoundException());
            return mapper.mapToEntity(post, user);
          })//
          .collect(Collectors.toList());
      postService.saveAll(postEntities);
      log.info("Post data saved");
      List<CommentEntity> commentEntities = commentRawData.stream()//
          .map(comment -> {
            PostEntity post = postEntities.stream()//
                .filter(p -> p.getId().equals(comment.getPostId()))//
                .findFirst()//
                .orElseThrow(() -> new NotFoundException());
            return mapper.mapToEntity(comment, post);
          })//
          .collect(Collectors.toList());
      commentService.saveAll(commentEntities);
      log.info("Comment data saved");
    }
  }
}
