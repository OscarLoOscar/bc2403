package com.bootcamp.bc_forum.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.bc_forum.infra.redis.RedisUtil;
import com.bootcamp.bc_forum.model.UserReqDto;
import com.bootcamp.bc_forum.model.placeholder.UserRespDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RedisService {

  private final String userRedisKey = "project-user:place-holder:users";

  @Autowired
  RedisUtil redisUtil;

  // @Autowired
  // RedisUtil<String> testRedisUtil;

  @Autowired
  ObjectMapper objectMapper;

  public void setUsers(UserRespDto[] users) {
    redisUtil.set(userRedisKey, users, 120000);
  }

  public UserRespDto[] getUsers() {
    try {
      String str = objectMapper.writeValueAsString(redisUtil.get(userRedisKey)); // Object -> String
      return objectMapper.readValue(str, UserRespDto[].class);
    } catch (JsonProcessingException e) {
      return new UserRespDto[] {};
    }
  }

  // public void set(String key, String value) {
  // testRedisUtil.set(key, value, 120000);
  // }

  // public Object get(String key) {
  // return testRedisUtil.get(key);
  // }

}
