package com.bootcamp.bc_forum.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.bc_forum.controller.PostOperations;
import com.bootcamp.bc_forum.infra.response.ApiResp;
import com.bootcamp.bc_forum.model.PostReqDto;
import com.bootcamp.bc_forum.model.placeholder.PostRespDto;
import com.bootcamp.bc_forum.service.PostService;


@RestController
@RequestMapping(value = "/placeholder/v1")
public class PostController implements PostOperations {

  @Autowired
  PostService postService;

  @Autowired
  ModelMapper modelMapper;

  @Override
  public ApiResp<List<PostRespDto>> getByUserId(String id) {
    List<PostRespDto> posts = postService.getByUserId(Long.parseLong(id))
        .stream().map(e -> modelMapper.map(e, PostRespDto.class))
        .collect(Collectors.toList());

    return ApiResp.<List<PostRespDto>>builder().ok().data(posts).build();
  }

  @Override
  public ApiResp<List<PostRespDto>> getAll() {
    List<PostRespDto> postDtos = postService.getAllDataByAPI().stream()
        .map(e -> modelMapper.map(e, PostRespDto.class))
        .collect(Collectors.toList());
    return ApiResp.<List<PostRespDto>>builder().ok().data(postDtos).build();
  }

  @Override
  public ApiResp<Void> deletePostByPostID(String postID) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException(
        "Unimplemented method 'deletePostByPostID'");
  }

  @Override
  public ApiResp<PostRespDto> createPostByPostID(String postID,
      PostReqDto postReqDto) {
    postService.createPostByPostID(Long.parseLong(postID), postReqDto);
    return ApiResp.<PostRespDto>builder().ok().build();
  }
}
