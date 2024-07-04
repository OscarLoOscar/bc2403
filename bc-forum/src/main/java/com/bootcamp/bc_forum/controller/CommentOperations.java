package com.bootcamp.bc_forum.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.bootcamp.bc_forum.infra.response.ApiResp;
import com.bootcamp.bc_forum.model.CommentReqDto;
import com.bootcamp.bc_forum.model.placeholder.CommentRespDto;


public interface CommentOperations {

  @GetMapping(value = "/comment")
  @ResponseStatus(value = HttpStatus.FOUND)
  ApiResp<List<CommentRespDto>> getByPostId(@RequestParam String postId);

  @GetMapping(value = "/comments")
  @ResponseStatus(value = HttpStatus.FOUND)
  ApiResp<List<CommentRespDto>> getAll();


  @PostMapping(value = "/comment")
  @ResponseStatus(value = HttpStatus.CREATED)
  ApiResp<CommentRespDto> addCommentByPostID(@RequestParam String postID,
      @RequestBody CommentReqDto commentReqDto);

  @PatchMapping(value = "/comment")
  @ResponseStatus(value = HttpStatus.CREATED)
  ApiResp<CommentRespDto> updateCommentBodyByCommentID(
      @RequestParam String commentID);
}
