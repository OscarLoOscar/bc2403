package com.bootcamp.bc_forum.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.bc_forum.mapper.Mapper;
import com.bootcamp.bc_forum.model.ForumResponse;
import com.bootcamp.bc_forum.model.ForumDTO.CommentDTO;
import com.bootcamp.bc_forum.model.ForumDTO.ForumCommentDTO;
import com.bootcamp.bc_forum.model.ForumDTO.ForumPostDTO;
import com.bootcamp.bc_forum.model.ForumDTO.ForumUserDTO;
import com.bootcamp.bc_forum.model.ForumDTO.UserCommentDTO;
import com.bootcamp.bc_forum.model.placeholder.UserRespDto;
import com.bootcamp.bc_forum.service.CommentService;
import com.bootcamp.bc_forum.service.ForumService;
import com.bootcamp.bc_forum.service.PostService;
import com.bootcamp.bc_forum.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ForumServiceHolder implements ForumService {

  @Autowired
  private UserService userService;

  @Autowired
  private PostService postService;

  @Autowired
  private CommentService commentService;

  // @Autowired
  // private ForumRepository forumRepository;
  
  @Autowired
  private Mapper mapper;

  @Override
  public List<ForumUserDTO> getAllUser() {
    List<ForumUserDTO> userList = new ArrayList<>();

    userService.getAllDataByAPI().forEach(user -> {
      List<ForumPostDTO> postList =
          postService.getByUserId(user.getId()).stream()//
              .map(post -> {
                List<ForumCommentDTO> commentList =
                    commentService.getByPostId(post.getId())//
                        .stream().map(comment -> mapper.map(comment))//
                        .collect(Collectors.toList());
                return mapper.map(post, commentList);
              })//
              .collect(Collectors.toList());

      userList.add(mapper.map(user, postList));
    });
    return userList;
  }

  // @Override
  // public UserCommentDTO getComment(long userID) {
  // UserReqDto userReqDto = userService.getById(userID);
  // List<List<CommentDTO>> comments =
  // postService.getByUserId(userID).stream()//
  // .map(post -> {
  // return commentService.getByPostId(post.getId())
  // .stream()//
  // .map(comment -> {
  // return CommentDTO.builder()//
  // .name(comment.getName())//
  // .email(comment.getEmail())//
  // .body(comment.getBody())//
  // .build();
  // })//
  // .collect(Collectors.toList());
  // }).collect(Collectors.toList());
  // log.info("" + comments);
  // return UserCommentDTO.builder().id(userReqDto.getId())
  // .username(userReqDto.getUsername())//
  // // .comments(comments)
  // .build();

  // }
  @Override
  public UserCommentDTO getComment(long userID) {
    UserRespDto userReqDto = userService.getById(userID);
    List<CommentDTO> comments = postService.getByUserId(userID).stream()//
        .flatMap(post -> commentService.getByPostId(post.getId()).stream())//
        .map(comment -> CommentDTO.builder()//
            .name(comment.getName())//
            .email(comment.getEmail())//
            .body(comment.getBody())//
            .build())//
        .collect(Collectors.toList());

    return UserCommentDTO.builder().id(userReqDto.getId())
        .username(userReqDto.getUsername())//
        .comments(comments).build();

  }

  @Override
  public List<ForumResponse> getForumResponse(long userID) {
    return userService.getForumResponse(userID);
  }

  @Override
  public List<ForumResponse> getForumResponseByNativeQuery(Long id){
    return this.getMappedForumResponse(id);
  }

  private List<ForumResponse> getMappedForumResponse(Long id) {
    List<Object[]> results = userService.getForumResponseByNativeQuery(id);
    List<ForumResponse> responses = new ArrayList<>();
    for (Object[] result : results) {
        ForumResponse response = new ForumResponse(
            (Long) result[0], // userID
            (String) result[1], // username
            (String) result[2], // email
            (Long) result[3], // postID
            (String) result[4], // postTitle
            (String) result[5], // postBody
            (Long) result[6], // commentID
            (String) result[7], // commentName
            (String) result[8] // commentBody
        );
        responses.add(response);
    }
    return responses;
}

}
