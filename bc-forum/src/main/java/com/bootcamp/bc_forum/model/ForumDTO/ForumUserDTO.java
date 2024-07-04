package com.bootcamp.bc_forum.model.ForumDTO;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ForumUserDTO {

  private Long id;
  private String name;
  private String username;
  private String email;
  private Address address;
  private String phone;
  private String website;
  private Company company;
  private List<ForumPostDTO> post = new ArrayList<>();


  @Getter
  @AllArgsConstructor
  @NoArgsConstructor
  @Builder
  public static class Address {

    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Geo {

      @JsonProperty(value = "lat")
      private String lat;
      @JsonProperty(value = "lng")
      private String lng;

    }
  }

  @Getter
  @AllArgsConstructor
  @NoArgsConstructor
  @Builder
  public static class Company {

    private String name;
    private String catchPhrase;
    private String bs;

  }


}
