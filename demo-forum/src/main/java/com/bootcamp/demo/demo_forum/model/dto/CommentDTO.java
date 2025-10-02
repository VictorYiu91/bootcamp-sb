package com.bootcamp.demo.demo_forum.model.dto;

import lombok.Getter;

@Getter
public class CommentDTO {
  private Long postId;
  private Long id;
  private String name;
  private String email;
  private String body;
}
