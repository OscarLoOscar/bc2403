package com.bootcamp.bc_forum.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserReqDto implements Serializable {

  private Long id;
  private String name;
  private String username;
  private String email;
  private String phone;
  private String website;

}
