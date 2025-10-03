package com.bootcamp.demo.demo_forum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo.demo_forum.codelib.GResponse;
import com.bootcamp.demo.demo_forum.dto.CommentByUserDto;
import com.bootcamp.demo.demo_forum.dto.FullDataDto;
import com.bootcamp.demo.demo_forum.entity.CommentEntity;
import com.bootcamp.demo.demo_forum.entity.UserEntity;

public interface ForumAppOperation {
  @GetMapping(value = "/fulldata")
  List<FullDataDto> getFullData();

  @GetMapping(value = "/commentbyuserid")
  GResponse<CommentByUserDto> commentByUser(@RequestParam String id);

  @GetMapping(value = "/getallusers")
  List<UserEntity> getAllUsers();

  @GetMapping(value = "/getusers")
  UserEntity getUser(@RequestParam String id);

  @PutMapping(value = "/updateusers")
  UserEntity updateUser(@RequestParam String id, @RequestBody UserEntity userEntity);

  @GetMapping(value = "/getcommentsbypostid")
  GResponse<List<CommentEntity>> getCommentsByPostId(@RequestParam(value = "postid") String id);
}