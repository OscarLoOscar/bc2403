package com.bootcamp.bc_forum.model.ForumDTO;import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ForumCommentDTO {
  Long postId;
  Long id;
  String name;
  String email;
  String body;
}
