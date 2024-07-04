package com.bootcamp.bc_forum.service;

import java.util.List;
import com.bootcamp.bc_forum.entity.UserEntity;
import com.bootcamp.bc_forum.model.ForumResponse;
import com.bootcamp.bc_forum.model.placeholder.UserRespDto;

public interface UserService {

  List<UserRespDto> getAllDataByAPI();

  UserRespDto getById(Long id);

  UserEntity deleteById(Long id);

  List<ForumResponse> findNameById(Long id);

  List<UserEntity> saveAll(List<UserEntity> userList);

  UserEntity save(UserEntity userEntity);

  List<UserEntity> findAllFromDB();

  UserEntity findUserFromDBByUserID(Long id);

  void deleteAll();

  ForumResponse getUserID(Long id);

  // ApiResp<UserReqDto> update(UserReqDto user);
  List<ForumResponse> getForumResponse(Long id);

  List<Object[]> getForumResponseByNativeQuery(Long id);

}
