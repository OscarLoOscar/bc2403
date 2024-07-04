package com.bootcamp.bc_forum.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.bc_forum.controller.CommentOperations;
import com.bootcamp.bc_forum.infra.response.ApiResp;
import com.bootcamp.bc_forum.model.CommentReqDto;
import com.bootcamp.bc_forum.model.placeholder.CommentRespDto;
import com.bootcamp.bc_forum.service.CommentService;


@RestController
@RequestMapping(value = "/placeholder/v1")
public class CommentController implements CommentOperations {

  @Autowired
  CommentService commentService;

  @Autowired
  ModelMapper modelMapper;

  @Override
  public ApiResp<List<CommentRespDto>> getByPostId(String postId) {
    List<CommentRespDto> comments =
        commentService.getByPostId(Long.parseLong(postId)).stream()
            .map(e -> modelMapper.map(e, CommentRespDto.class))
            .collect(Collectors.toList());

    return ApiResp.<List<CommentRespDto>>builder()//
        .ok()//
        .data(comments)//
        .build();
  }

  @Override
  public ApiResp<List<CommentRespDto>> getAll() {
    List<CommentRespDto> commentDtos = commentService.getAllDataByAPI().stream()
        .map(e -> modelMapper.map(e, CommentRespDto.class))
        .collect(Collectors.toList());
    return ApiResp.<List<CommentRespDto>>builder()//
        .ok()//
        .data(commentDtos)//
        .build();
  }

  @Override
  public ApiResp<CommentRespDto> updateCommentBodyByCommentID(
      String commentID) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'updateCommentBodyByCommentID'");
  }

  @Override
  public ApiResp<CommentRespDto> addCommentByPostID(String postID,
      CommentReqDto commentReqDto) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'addCommentByPostID'");
  }
}
