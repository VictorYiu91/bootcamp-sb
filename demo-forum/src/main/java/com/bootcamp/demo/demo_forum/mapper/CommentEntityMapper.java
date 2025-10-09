package com.bootcamp.demo.demo_forum.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_forum.entity.CommentEntity;
import com.bootcamp.demo.demo_forum.model.CommentDTO;

@Component
public class CommentEntityMapper {
  public CommentEntity map(CommentDTO dto) {
    return CommentEntity.builder() //
      .name(dto.getName())
      .body(dto.getBody())
      .email(dto.getEmail())
      .build();
  }
}