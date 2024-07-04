package com.bootcamp.bc_forum.service;

import java.util.List;
import com.bootcamp.bc_forum.entity.PostEntity;
import com.bootcamp.bc_forum.model.PostReqDto;
import com.bootcamp.bc_forum.model.placeholder.PostRespDto;


public interface PostService {

  List<PostRespDto> getAllDataByAPI();

  List<PostRespDto> getByUserId(Long userId);

  List<PostEntity> saveAll(List<PostEntity> postList);

  PostEntity save(PostEntity postEntity);

  List<PostEntity> findAllFromDB();

  PostEntity findPostFromDBByPostID(Long id);

  void createPostByPostID(long long1, PostReqDto postReqDto);

  void deleteAll();

}
