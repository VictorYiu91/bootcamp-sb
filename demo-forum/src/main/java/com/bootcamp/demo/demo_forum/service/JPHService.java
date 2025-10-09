package com.bootcamp.demo.demo_forum.service;

import java.util.List;
import com.bootcamp.demo.demo_forum.entity.CommentEntity;
import com.bootcamp.demo.demo_forum.model.CommentDTO;
import com.bootcamp.demo.demo_forum.model.PostDTO;
import com.bootcamp.demo.demo_forum.model.UserDTO;

public interface JPHService {
  List<UserDTO> getAllUsers();
  List<PostDTO> getAllPosts();
  List<CommentDTO> getAllComments();

  // ! Exercise 3 Task 3 - Get Comments By Post Id
  List<CommentEntity> getCommentsByPostId(Long postId);
  
}