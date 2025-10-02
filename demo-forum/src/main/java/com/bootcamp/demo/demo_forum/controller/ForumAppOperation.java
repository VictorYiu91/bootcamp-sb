package com.bootcamp.demo.demo_forum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo.demo_forum.dto.CommentByUserDto;
import com.bootcamp.demo.demo_forum.dto.FullDataDto;

public interface ForumAppOperation {
  @GetMapping(value = "/fulldata")
  List<FullDataDto> getFullData();

  @GetMapping(value = "/commentbyuserid")
  CommentByUserDto commentByUser(@RequestParam Long id);
}
