package com.bootcamp.bc_forum.model.placeholder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentRespDto {
  private Long postId;
  private Long id;
  private String name;
  private String email;
  private String body;
}
