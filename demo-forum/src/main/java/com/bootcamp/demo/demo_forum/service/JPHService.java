package com.bootcamp.demo.demo_forum.service;

import java.util.List;
import com.bootcamp.demo.demo_forum.model.dto.CommentDTO;
import com.bootcamp.demo.demo_forum.model.dto.PostDTO;
import com.bootcamp.demo.demo_forum.model.dto.UserDTO;

public interface JPHService {
  List<UserDTO> getUsers();
  List<PostDTO> getPosts();
  List<CommentDTO> getComments();
}
