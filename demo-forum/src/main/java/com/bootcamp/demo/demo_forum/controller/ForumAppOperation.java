package com.bootcamp.demo.demo_forum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo.demo_forum.codelib.GResponse;
import com.bootcamp.demo.demo_forum.dto.FullDataDto;
import com.bootcamp.demo.demo_forum.dto.FullDataDto2;
import com.bootcamp.demo.demo_forum.entity.CommentEntity;
import com.bootcamp.demo.demo_forum.entity.UserEntity;

public interface ForumAppOperation {
  // ! Exercise 2: Task 3a
  @GetMapping(value = "/fulldata")
  List<FullDataDto> getFullData();

  // ! Exercise 2: Task 3b
  @GetMapping(value = "/fulldata2")
  GResponse<FullDataDto2> getFullData2(
      @RequestParam(value = "userid") String uid);

  // ! Exercise 3: Task 3
  @GetMapping(value = "/comments")
  GResponse<List<CommentEntity>> getCommentsByPostId(
      @RequestParam(value = "postid") Long id);

  // ! Test SQL Exception
  @GetMapping(value = "/users")
  List<UserEntity> getUsersByName(@RequestParam String name);
}