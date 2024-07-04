package com.bootcamp.bc_forum.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Users")
public class UserEntity implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "NAME")
  private String name;

  @Column(name = "USER_NAME")
  private String username;

  @Column(name = "USER_EMAIL")
  private String email;

  @Column(name = "USER_PHONE")
  private String phone;

  @Column(name = "USER_WEBSITE")
  private String website;

  @Column(name = "ADDRESS_STREET")
  private String street;
  @Column(name = "ADDRESS_SUITE")
  private String suite;
  @Column(name = "ADDRESS_CITY")
  private String city;
  @Column(name = "ADDRESS_ZIPCODE")
  private String zipcode;
  @Column(name = "GEO_LAT")
  private String lat;
  @Column(name = "GEO_LNG")
  private String lng;

  @Column(name = "COMPANY_NAME")
  private String companyName;

  @Column(name = "COMPANY_CATCH_PHRASE")
  private String companyCatchPhrase;

  @Column(name = "COMPANY_BS")
  private String companyBs;

  @OneToMany(mappedBy = "user", cascade = CascadeType.REFRESH,
      orphanRemoval = true)
  @JsonIgnore
  final List<PostEntity> posts = new ArrayList<>();

  public boolean addPost(PostEntity post) {
    return posts.add(post);
  }

  /**
   * 
   * EntityManager em = ...;
   * 
   * Parent parent = new Parent();
   * 
   * parent.setName("Parent");
   * 
   * Child child1 = new Child();
   * 
   * child1.setName("Child 1");
   * 
   * Child child2 = new Child();
   * 
   * child2.setName("Child 2");
   * 
   * parent.getChildren().add(child1);
   * 
   * parent.getChildren().add(child2);
   * 
   * em.persist(parent); // 将自动保存 child1 和 child2
   * 
   * em.merge(parent); // 将自动合并 child1 和 child2
   * 
   * em.remove(parent); // 将自动删除 child1 和 child2
   * 
   * em.refresh(parent); // 将自动刷新 child1 和 child2
   * 
   * em.detach(parent); // 将自动分离 child1 和 child2
   */
}
