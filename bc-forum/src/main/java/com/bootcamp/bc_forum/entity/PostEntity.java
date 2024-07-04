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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "Posts")
public class PostEntity implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "POST_ID")
  private Long id;

  @Column(name = "POST_TITLE")
  private String title;

  @Column(name = "POST_BODY")
  private String body;

  // Because set the FOREIGN KEY REFERENCES to JSONUSERS
  @ManyToOne(cascade = CascadeType.PERSIST)
  @JsonIgnore
  @JoinColumn(name = "USER_ID", nullable = false)
  private UserEntity user;

  @OneToMany(mappedBy = "post", cascade = CascadeType.REFRESH,
      orphanRemoval = true)
  @JsonIgnore
  final List<CommentEntity> comments = new ArrayList<>();

  public boolean addComment(CommentEntity comment) {
    return comments.add(comment);
  }
}
