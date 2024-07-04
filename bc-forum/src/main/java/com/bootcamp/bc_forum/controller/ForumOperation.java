package com.bootcamp.bc_forum.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.bootcamp.bc_forum.model.ForumResponse;
import com.bootcamp.bc_forum.model.ForumDTO.ForumUserDTO;
import com.bootcamp.bc_forum.model.ForumDTO.UserCommentDTO;

public interface ForumOperation {

  @GetMapping("/alluser")
  @ResponseStatus(HttpStatus.OK)
  public  List<ForumUserDTO> getAllUser();

  @GetMapping("/comment")
  @ResponseStatus(HttpStatus.OK)
  public UserCommentDTO getComment(@RequestParam String userID);

  @GetMapping("/solution1")
  @ResponseStatus(HttpStatus.OK)
  public List<ForumResponse> getForumResponse(@RequestParam String userID);

  @GetMapping("/solution2")
  @ResponseStatus(HttpStatus.OK)
  public List<ForumResponse> getForumResponseByNativeQuery(@RequestParam String userID);

}