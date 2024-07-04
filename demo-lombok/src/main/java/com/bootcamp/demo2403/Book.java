package com.bootcamp.demo2403;

import lombok.Data;
import lombok.NonNull;

@Data // @RequiredArgsConstructor, @ToString, @EqualsANDHashCode, @Getter, @Setter
// @AllArgsConstructor
// @NoArgsConstructor
public class Book {

  private final String name;
  @NonNull
  private Color color;

  public static void main(String[] args) {
    
  }

}
