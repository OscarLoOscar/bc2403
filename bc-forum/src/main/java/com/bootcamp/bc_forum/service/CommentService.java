package com.bootcamp.bc_forum.service;

import java.util.List;
import com.bootcamp.bc_forum.entity.CommentEntity;
import com.bootcamp.bc_forum.model.placeholder.CommentRespDto;

public interface CommentService {

  List<CommentRespDto> getAllDataByAPI();

  List<CommentRespDto> getByPostId(Long postId);

  List<CommentEntity> saveAll(List<CommentEntity> commentList);

  CommentEntity save(CommentEntity commentEntity);

  List<CommentEntity> findAllFromDB();

  CommentEntity findCommentFromDBByPostID(Long id);

  void deleteAll();

}
