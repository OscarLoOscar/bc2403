package com.bootcamp.bc_forum.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.bc_forum.entity.PostEntity;
import com.bootcamp.bc_forum.infra.exceptions.NotFoundException;
import com.bootcamp.bc_forum.model.PostReqDto;
import com.bootcamp.bc_forum.model.placeholder.PostRespDto;
import com.bootcamp.bc_forum.repository.PostRepository;
import com.bootcamp.bc_forum.service.PostService;


@Service
public class PostServiceHolder implements PostService {

  @Autowired
  @Qualifier(value = "postUrl")
  String postUrl;

  @Autowired
  RestTemplate restTemplate;

  @Autowired
  private PostRepository postRepository;

  @Override
  public List<PostRespDto> getAllDataByAPI() {
    return Arrays
        .asList(restTemplate.getForObject(postUrl, PostRespDto[].class));
  }

  @Override
  public List<PostRespDto> getByUserId(Long id) {
    return this.getAllDataByAPI().stream().filter(e -> {
      // line of code
      return e.getUserId() == id;
    }).collect(Collectors.toList());
  }

  @Override
  public List<PostEntity> saveAll(List<PostEntity> postList) {
    return postRepository.saveAll(postList);
  }

  @Override
  public PostEntity save(PostEntity postEntity) {
    return postRepository.save(postEntity);
  }

  @Override
  public List<PostEntity> findAllFromDB() {
    return postRepository.findAll();
  }

  @Override
  public PostEntity findPostFromDBByPostID(Long id) {
    return this.findAllFromDB().stream()//
        .filter(e -> e.getId().equals(id))//
        .findFirst()//
        .orElseThrow(() -> new NotFoundException());
  }

  @Override
  public void createPostByPostID(long long1, PostReqDto postReqDto) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException(
        "Unimplemented method 'createPostByPostID'");
  }

  @Override
  public void deleteAll() {
    postRepository.deleteAll();
  }
}
