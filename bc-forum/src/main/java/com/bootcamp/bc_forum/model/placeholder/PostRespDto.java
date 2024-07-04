package com.bootcamp.bc_forum.model.placeholder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PostRespDto {
  Long userId;
  Long id;
  String title;
  String body;
}
