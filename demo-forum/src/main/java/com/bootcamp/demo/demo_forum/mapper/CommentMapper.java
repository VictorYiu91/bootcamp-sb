package com.bootcamp.demo.demo_forum.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_forum.dto.FullDataDto.PostDto.CommentDto;
import com.bootcamp.demo.demo_forum.entity.CommentEntity;
import com.bootcamp.demo.demo_forum.entity.PostEntity;
import com.bootcamp.demo.demo_forum.model.dto.CommentDTO;

@Component
public class CommentMapper {
  public CommentDto mapComment(CommentDTO commentDTO) {
    return CommentDto.builder()//
    .id(0L)//
    .name(commentDTO.getName())//
    .email(commentDTO.getEmail())//
    .body(commentDTO.getBody())//
    .build();
  }
  public CommentEntity mapCommentEntity(CommentDTO commentDTO, PostEntity postEntity) {
    return CommentEntity.builder()//
    .name(commentDTO.getName())//
    .email(commentDTO.getEmail())//
    .body(commentDTO.getBody())//
    .postEntity(postEntity)//
    .build();
  }
}
