package com.bootcamp.demo.demo_forum.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_forum.dto.FullDataDto;
import com.bootcamp.demo.demo_forum.model.CommentDTO;

@Component
public class CommentMapper {
  public FullDataDto.PostDto.CommentDto map(CommentDTO commentDTO) {
    return FullDataDto.PostDto.CommentDto.builder() //
        .id(commentDTO.getId()) //
        .body(commentDTO.getBody()) //
        .email(commentDTO.getEmail()) //
        .name(commentDTO.getName()) //
        .build();
  }
}