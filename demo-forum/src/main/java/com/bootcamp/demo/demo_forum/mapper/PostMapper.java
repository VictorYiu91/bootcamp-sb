package com.bootcamp.demo.demo_forum.mapper;

import java.util.List;
import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_forum.dto.FullDataDto.PostDto;
import com.bootcamp.demo.demo_forum.dto.FullDataDto.PostDto.CommentDto;
import com.bootcamp.demo.demo_forum.entity.PostEntity;
import com.bootcamp.demo.demo_forum.entity.UserEntity;
import com.bootcamp.demo.demo_forum.model.dto.PostDTO;

@Component
public class PostMapper {
  public PostDto mapPost(PostDTO postDTO, List<CommentDto> commentsDto) {
    return PostDto.builder()//
        .id(postDTO.getId())//
        .tittle(postDTO.getTitle())//
        .body(postDTO.getBody())//
        .comments(commentsDto).build();
  }

  public PostEntity mapPostEntity(PostDTO postDTO, UserEntity userEntity) {
    return PostEntity.builder()//
    .title(postDTO.getTitle())//
    .body(postDTO.getBody())//
    .userEntity(userEntity)//
    .build();
  }
}
