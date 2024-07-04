package com.bootcamp.bc_forum.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.bc_forum.controller.ForumOperation;
import com.bootcamp.bc_forum.model.ForumResponse;
import com.bootcamp.bc_forum.model.ForumDTO.ForumUserDTO;
import com.bootcamp.bc_forum.model.ForumDTO.UserCommentDTO;
import com.bootcamp.bc_forum.service.ForumService;

@RestController
@RequestMapping("/forum")
public class ForumController implements ForumOperation {

  @Autowired
  private ForumService forumService;

  @Override
  public List<ForumUserDTO> getAllUser() {
    return forumService.getAllUser();
  }

  @Override
  public UserCommentDTO getComment(String userID) {
    return forumService.getComment(Long.parseLong(userID));
  }

  @Override
  public List<ForumResponse> getForumResponse(String userID) {
    return forumService.getForumResponse(Long.parseLong(userID));
  }

  @Override
  public List<ForumResponse> getForumResponseByNativeQuery(String userID) {
    return forumService.getForumResponseByNativeQuery(Long.parseLong(userID));
  }

}
