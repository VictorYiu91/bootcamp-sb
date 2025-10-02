package com.bootcamp.demo.demo_database.model;

import lombok.Getter;

@Getter
public class Post {
  private Long id;
  private String title;
  private String body;
  private Long userId;
}