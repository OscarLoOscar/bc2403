package com.bootcamp.bc_forum.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.bc_forum.entity.CommentEntity;
import com.bootcamp.bc_forum.infra.exceptions.NotFoundException;
import com.bootcamp.bc_forum.model.placeholder.CommentRespDto;
import com.bootcamp.bc_forum.repository.CommentRepository;
import com.bootcamp.bc_forum.service.CommentService;


@Service
public class CommentServiceHolder implements CommentService {

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private CommentRepository commentRepository;

  @Autowired
  @Qualifier(value = "commentUrl")
  String commentUrl;

  @Override
  public List<CommentRespDto> getAllDataByAPI() {
    return Arrays
        .asList(restTemplate.getForObject(commentUrl, CommentRespDto[].class));
  }

  @Override
  public List<CommentRespDto> getByPostId(Long id) {
    return this.getAllDataByAPI().stream().filter(e -> e.getPostId() == id)
        .collect(Collectors.toList());
  }

  @Override
  public List<CommentEntity> saveAll(List<CommentEntity> commentList) {
    return commentRepository.saveAll(commentList);
  }

  @Override
  public CommentEntity save(CommentEntity commentEntity) {
    return commentRepository.save(commentEntity);
  }

  @Override
  public List<CommentEntity> findAllFromDB() {
    return commentRepository.findAll();
  }

  @Override
  public CommentEntity findCommentFromDBByPostID(Long id) {
    return this.findAllFromDB().stream()//
        .filter(e -> e.getId().equals(id))//
        .findFirst()//
        .orElseThrow(() -> new NotFoundException());
  }

  @Override
  public void deleteAll() {
    commentRepository.deleteAll();
  }
}
