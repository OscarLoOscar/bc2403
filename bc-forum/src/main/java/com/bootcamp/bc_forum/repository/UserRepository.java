package com.bootcamp.bc_forum.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.bootcamp.bc_forum.entity.UserEntity;
import com.bootcamp.bc_forum.model.ForumResponse;
import io.lettuce.core.dynamic.annotation.Param;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

  @Query(
      value = "SELECT new com.bootcamp.bc_forum.model.ForumResponse(u.id, u.name) "
          + //
          "FROM UserEntity u WHERE u.id = :id")
  List<ForumResponse> findNameById(@Param("id") Long id);

//solution 1
@Query(
    value = "SELECT new com.bootcamp.bc_forum.model.ForumResponse(u.id, u.username, u.email, p.id, p.title, p.body, c.id, c.name, c.body) "
        + "FROM UserEntity u JOIN u.posts p JOIN p.comments c WHERE u.id = :id")
List<ForumResponse> getForumResponse(@Param("id") Long id);

//solution 2
@Query(
    value = "SELECT u.userID, u.username, u.email, p.POST_ID as postID, p.POST_TITLE as postTitle, p.POST_BODY as postBody, c.COMMENT_ID as commentID, c.COMMENT_NAME as commentName, c.COMMENT_BODY as commentBody "
        + "FROM Users u JOIN Posts p ON u.id = p.USER_ID "
        + "JOIN Comments c ON p.POST_ID = c.POST_ID WHERE u.userID = :id", nativeQuery = true)
List<Object[]> getForumResponseByNativeQuery(@Param("id") Long id);

}
