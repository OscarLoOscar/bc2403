package com.bootcamp.bc_forum.model.ForumDTO;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserCommentDTO {
  private Long id;
  private String username;
  private List<CommentDTO> comments = new ArrayList<>();
}
