package com.bootcamp.demo.demo_forum.controller.impl;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_forum.controller.ForumAppOperation;
import com.bootcamp.demo.demo_forum.dto.CommentByUserDto;
import com.bootcamp.demo.demo_forum.dto.FullDataDto;
import com.bootcamp.demo.demo_forum.dto.CommentByUserDto.CommentsNoId;
import com.bootcamp.demo.demo_forum.dto.FullDataDto.PostDto.CommentDto;
import com.bootcamp.demo.demo_forum.mapper.UserMapper;
import com.bootcamp.demo.demo_forum.model.dto.CommentDTO;
import com.bootcamp.demo.demo_forum.model.dto.PostDTO;
import com.bootcamp.demo.demo_forum.model.dto.UserDTO;
import com.bootcamp.demo.demo_forum.service.JPHService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class ForumAppController implements ForumAppOperation {
  @Autowired
  private JPHService jphService;
  @Autowired
  private UserMapper userMapper;

  @Override
  public List<FullDataDto> getFullData() {
    List<UserDTO> usersDTO = this.jphService.getUsers();
    List<PostDTO> postsDTO = this.jphService.getPosts();
    List<CommentDTO> commentsDTO = this.jphService.getComments();

    return usersDTO.stream()
        .map(e -> this.userMapper.map(e, postsDTO, commentsDTO))
        .collect(Collectors.toList());
  }

  @Override
  public CommentByUserDto commentByUser(@RequestParam Long id) {
    List<UserDTO> usersDTO = this.jphService.getUsers();
    List<PostDTO> postsDTO = this.jphService.getPosts();
    List<CommentDTO> commentsDTO = this.jphService.getComments();
    int idx = 0;
    for (int i = 0; i < usersDTO.size(); i++) {
      if (usersDTO.get(i).getId().equals(id)) {
        idx = i;
        break;
      }
    }
    UserDTO taUserDTO = usersDTO.get(idx);
    FullDataDto taPostByUserDTO =
        this.userMapper.map(taUserDTO, postsDTO, commentsDTO);
    List<CommentDto> allComments = taPostByUserDTO.getPosts().stream()//
        .flatMap(e -> e.getComments().stream())//
        .collect(Collectors.toList());
    List<CommentsNoId> allCommentsNoId = allComments.stream().map(e -> {//
      return CommentsNoId.builder()//
          .name(e.getName())//
          .email(e.getEmail())//
          .body(e.getBody()).build();
    }).collect(Collectors.toList());
    return CommentByUserDto.builder()//
        .id(taPostByUserDTO.getId())//
        .username(taPostByUserDTO.getUserName())//
        .comments(allCommentsNoId)//
        .build();
  }
}
