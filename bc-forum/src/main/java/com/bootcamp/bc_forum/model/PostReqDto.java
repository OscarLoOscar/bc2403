package com.bootcamp.bc_forum.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostReqDto {
  Long userId;
  Long id;
  String title;
  String body;
}
