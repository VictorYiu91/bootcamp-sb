package com.bootcamp.demo.demo_forum.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_forum.entity.PostEntity;
import com.bootcamp.demo.demo_forum.model.PostDTO;

@Component
public class PostEntityMapper {
  public PostEntity map(PostDTO dto) {
    return PostEntity.builder() //
      .origPostId(dto.getId())
      .title(dto.getTitle()) //
      .body(dto.getBody()) //
      .build();
  }
}