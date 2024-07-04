package com.bootcamp.bc_forum.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.bootcamp.bc_forum.entity.PostEntity;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

  @Query(value = "SELECT * FROM Posts WHERE user_id = ?1", nativeQuery = true)
  List<PostEntity> findByUserId(Long userId);
}
