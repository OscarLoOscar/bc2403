package com.bootcamp.bc_forum.service;

import java.util.List;
import com.bootcamp.bc_forum.model.ForumResponse;
import com.bootcamp.bc_forum.model.ForumDTO.ForumUserDTO;
import com.bootcamp.bc_forum.model.ForumDTO.UserCommentDTO;

public interface ForumService {
  public  List<ForumUserDTO> getAllUser();

  public UserCommentDTO getComment(long userID);

  public List<ForumResponse> getForumResponse(long userID);

  public List<ForumResponse> getForumResponseByNativeQuery(Long id);
}
