package com.bootcamp.bc_forum.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.bc_forum.entity.UserEntity;
import com.bootcamp.bc_forum.infra.exceptions.NotFoundException;
import com.bootcamp.bc_forum.model.ForumResponse;
import com.bootcamp.bc_forum.model.placeholder.UserRespDto;
import com.bootcamp.bc_forum.repository.UserRepository;
import com.bootcamp.bc_forum.service.UserService;

@Service
public class UserServiceHolder implements UserService {
  // step 1 ： 搵RestTemplate bean
  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  @Qualifier(value = "userUrl")
  String userUrl;

  @Override
  public List<UserRespDto> getAllDataByAPI() {
    UserRespDto[] users =
        restTemplate.getForObject(userUrl, UserRespDto[].class);
    // userRepository.setUsers(users); // Async
    return Arrays.asList(users);
  }

  @Override
  public UserRespDto getById(Long id) {
    return this.getAllDataByAPI().stream().filter(e -> e.getId() == id) //
        .findFirst()
        // .get()
        .orElse(null);
    // public T orElse(T other) {
    // return value != null ? value : other;
    // }
    // public T get() {
    // if (value == null) {
    // throw new NoSuchElementException("No value present");
    // }
    // return value;

    // }
  }

  @Override
  public UserEntity deleteById(Long id) {
    Optional<UserEntity> user = userRepository.findById(id);
    if (user.isPresent())
      userRepository.deleteById(id);
    return user.get();
  }

  @Override
  public List<ForumResponse> findNameById(Long id) {
    return userRepository.findNameById(id);
  }

  @Override
  public List<UserEntity> saveAll(List<UserEntity> userList) {
    return userRepository.saveAll(userList);
  }

  @Override
  public UserEntity save(UserEntity userEntity) {
    return userRepository.save(userEntity);
  }

  @Override
  public List<UserEntity> findAllFromDB() {
    return userRepository.findAll();
  }

  @Override
  public UserEntity findUserFromDBByUserID(Long id) {
    return this.findAllFromDB().stream()//
        .filter(e -> e.getId().equals(id))//
        .findFirst()//
        .orElseThrow(() -> new NotFoundException());
  }

  @Override
  public void deleteAll() {
    userRepository.deleteAll();
  }

  @Override
  public ForumResponse getUserID(Long id) {
    return userRepository.findNameById(id).get(0);
  }

  @Override
  public List<ForumResponse> getForumResponse(Long id) {
    return userRepository.getForumResponse(id);
  }

  @Override
  public List<Object[]> getForumResponseByNativeQuery(Long id) {
    return userRepository.getForumResponseByNativeQuery(id);
  }


}
