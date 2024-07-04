package com.bootcamp.bc_forum.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CommentReqDto {
  Long postId;
  Long id;
  String name;
  String body;
}
