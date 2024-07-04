package com.bootcamp.bc_forum.model;

import jakarta.persistence.EntityResult;
import jakarta.persistence.FieldResult;
import jakarta.persistence.SqlResultSetMapping;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @SqlResultSetMapping(//
//     name = "ForumResponse", //
//     entities = {//
//         @EntityResult(entityClass = ForumResponse.class,
//             fields = {@FieldResult(name = "userID", column = "userID"),
//                 @FieldResult(name = "username", column = "username"),
//                 @FieldResult(name = "email", column = "email"),
//                 @FieldResult(name = "postID", column = "postID"),
//                 @FieldResult(name = "postTitle", column = "postTitle"),
//                 @FieldResult(name = "postBody", column = "postBody"),
//                 @FieldResult(name = "commentID", column = "commentID"),
//                 @FieldResult(name = "commentName", column = "commentName"),
//                 @FieldResult(name = "commentBody", column = "commentBody")})})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ForumResponse {
  private Long userID;
  private String username;
  private String email;
  private Long postID;
  private String postTitle;
  private String postBody;
  private Long commentID;
  private String commentName;
  private String commentBody;

  public ForumResponse(Long userID, String username) {
    this.userID = userID;
    this.username = username;
  }
}
