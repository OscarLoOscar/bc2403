package com.bootcamp.bc_forum.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.bootcamp.bc_forum.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
  @Query(value = "SELECT * FROM Comments WHERE post_id = ?1",
      nativeQuery = true)
  List<CommentEntity> findByPostId(Long postId);
}
