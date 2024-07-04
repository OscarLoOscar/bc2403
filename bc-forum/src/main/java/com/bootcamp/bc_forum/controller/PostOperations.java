package com.bootcamp.bc_forum.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.bootcamp.bc_forum.infra.response.ApiResp;
import com.bootcamp.bc_forum.model.PostReqDto;
import com.bootcamp.bc_forum.model.placeholder.PostRespDto;


public interface PostOperations {

  @GetMapping(value = "/user/{id}/posts")
  @ResponseStatus(value = HttpStatus.FOUND)
  ApiResp<List<PostRespDto>> getByUserId(
      @PathVariable(value = "id") String userId);

  @GetMapping(value = "/posts")
  @ResponseStatus(value = HttpStatus.FOUND)
  ApiResp<List<PostRespDto>> getAll();

  @PostMapping(value = "/post/{postID}")
  @ResponseStatus(value = HttpStatus.CREATED)
  ApiResp<PostRespDto> createPostByPostID(@PathVariable String postID,
      @RequestBody PostReqDto postReqDto);

  @DeleteMapping(value = "/post/{postID}")
  @ResponseStatus(value = HttpStatus.ACCEPTED)
  ApiResp<Void> deletePostByPostID(
      @PathVariable(value = "id") String postID);


  // @PostMapping(value = "/user/{id}/post")
  // ResponseEntity<ApiResponse<PostDto>> createByUserId(@PathVariable(value = "id") Long id);

}
