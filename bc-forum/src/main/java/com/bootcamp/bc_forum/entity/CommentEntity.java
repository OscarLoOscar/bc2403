package com.bootcamp.bc_forum.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Comments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "COMMENT_ID")
  Long id;

  @Column(name = "COMMENT_NAME")
  private String name;

  @Column(name = "COMMENT_BODY",length = 1000)
  private String body;

  @Column(name = "COMMENT_EMAIL")
  private String email;

  @ManyToOne
  @JsonIgnore
  @JoinColumn(name = "POST_ID", nullable = false)
  private PostEntity post;

}
