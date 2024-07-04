package com.bootcamp.bc_forum.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.bc_forum.controller.UserOperations;
import com.bootcamp.bc_forum.infra.response.ApiResp;
import com.bootcamp.bc_forum.mapper.Mapper;
import com.bootcamp.bc_forum.model.ForumResponse;
import com.bootcamp.bc_forum.model.placeholder.UserRespDto;
import com.bootcamp.bc_forum.service.UserService;

@RestController
@RequestMapping(value = "/placeholder/v1")
public class UserController implements UserOperations {

  @Autowired
  private UserService userService;

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private Mapper mapper;

  @Override
  public ApiResp<List<UserRespDto>> getAll() {
    List<UserRespDto> users = userService.findAllFromDB().stream()
        .map(e -> mapper.map(e))//
        .collect(Collectors.toList());
    return ApiResp.<List<UserRespDto>>builder()//
        .ok()//
        .data(users)//
        .build();
  }

  @Override
  public ApiResp<UserRespDto> getById(String id) {
    UserRespDto user = modelMapper.map(userService.getById(Long.parseLong(id)),
        UserRespDto.class);

    return ApiResp.<UserRespDto>builder()//
        .ok()//
        .data(user)//
        .build();
  }

  @Override
  public List<ForumResponse> findNameById(String id) {
    return userService.findNameById(Long.parseLong(id));
  }


  @Override
  public ApiResp<UserRespDto> update(String id, UserRespDto user) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

}
