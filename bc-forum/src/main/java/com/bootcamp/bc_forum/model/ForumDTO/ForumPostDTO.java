package com.bootcamp.bc_forum.model.ForumDTO;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class ForumPostDTO {
  private Long userId;
  private Long id;
  private String title;
  private String body;
  private List<ForumCommentDTO> comment = new ArrayList<>();

}
