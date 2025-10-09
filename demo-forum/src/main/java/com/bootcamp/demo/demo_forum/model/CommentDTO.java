package com.bootcamp.demo.demo_forum.model;

import lombok.Getter;

@Getter
public class CommentDTO {
  private Long id;
  private String name;
  private String email;
  private String body;
  private Long postId;
}