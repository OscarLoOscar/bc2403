package com.bootcamp.bc_forum.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.bootcamp.bc_forum.infra.response.ApiResp;
import com.bootcamp.bc_forum.model.ForumResponse;
import com.bootcamp.bc_forum.model.placeholder.UserRespDto;

public interface UserOperations {

  @GetMapping(value = "/users")
  @ResponseStatus(value = HttpStatus.FOUND) // if you do not mention it, default OK
  ApiResp<List<UserRespDto>> getAll();

  @GetMapping(value = "/user/{id}")
  @ResponseStatus(value = HttpStatus.FOUND)
  ApiResp<UserRespDto> getById//
  (@PathVariable(value = "id") String id);

  @GetMapping(value = "")
  @ResponseStatus(value = HttpStatus.FOUND)
  List<ForumResponse> findNameById(@RequestParam String id);

  @PutMapping(value = "/user")
  @ResponseStatus(value = HttpStatus.CREATED)
  ApiResp<UserRespDto> update(@RequestParam String id,
      @RequestBody UserRespDto user);
}
