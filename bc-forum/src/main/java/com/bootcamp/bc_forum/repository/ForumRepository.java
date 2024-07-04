// package com.bootcamp.bc_forum.repository;

// import java.util.List;
// import org.springframework.stereotype.Repository;
// import com.bootcamp.bc_forum.model.ForumResponse;
// import io.lettuce.core.dynamic.annotation.Param;
// import jakarta.persistence.EntityManager;
// import jakarta.persistence.PersistenceContext;

// @Repository
// public class ForumRepository {

//   @PersistenceContext
//   private EntityManager entityManager;

//   @SuppressWarnings("unchecked")
//   public List<ForumResponse> getForumResponse(@Param("id") Long id) {
//     return entityManager.createNativeQuery(
//         "SELECT u.id as userID, u.USER_NAME as username, u.USER_EMAIL, p.POST_ID as postID, p.POST_TITLE as postTitle, p.POST_BODY as postBody, c.COMMENT_ID as commentID, c.COMMENT_NAME as commentName, c.COMMENT_BODY as commentBody "
//             + "FROM Users u JOIN Posts p ON u.id = p.USER_ID "
//             + "JOIN Comments c ON p.POST_ID = c.POST_ID WHERE u.id = :id",
//             "ForumResponse").setParameter("id", id).getResultList();
//   }
// }
