package com.bootcamp.demo.demo_forum.config;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import com.bootcamp.demo.demo_forum.entity.CommentEntity;
import com.bootcamp.demo.demo_forum.entity.PostEntity;
import com.bootcamp.demo.demo_forum.entity.UserEntity;
import com.bootcamp.demo.demo_forum.mapper.CommentEntityMapper;
import com.bootcamp.demo.demo_forum.mapper.PostEntityMapper;
import com.bootcamp.demo.demo_forum.mapper.UserEntityMapper;
import com.bootcamp.demo.demo_forum.repository.CommentRepository;
import com.bootcamp.demo.demo_forum.repository.PostRepository;
import com.bootcamp.demo.demo_forum.repository.UserRepository;
import com.bootcamp.demo.demo_forum.service.JPHService;

// ! Exercise 3 Task 2 - CommandLineRunner
// @Component
public class AppStartRunner implements CommandLineRunner {

  @Autowired
  private JPHService jphService;
  @Autowired
  private UserEntityMapper userEntityMapper;
  @Autowired
  private PostEntityMapper postEntityMapper;
  @Autowired
  private CommentEntityMapper commentEntityMapper;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private PostRepository postRepository;
  @Autowired
  private CommentRepository commentRepository;

  @Override
  public void run(String... args) throws Exception {
    this.commentRepository.deleteAll();
    this.postRepository.deleteAll();
    this.userRepository.deleteAll();
    
    // call api, save users, posts, comments into DB
    List<UserEntity> userEntities = this.jphService.getAllUsers().stream() //
        .map(e -> this.userEntityMapper.map(e)) //
        .collect(Collectors.toList());
    
    // ! Convert from List<PostDTO> to List<PostEntity>
    List<PostEntity> postEntities = this.jphService.getAllPosts().stream() //
        .map(p -> {
          PostEntity postEntity = this.postEntityMapper.map(p);
          UserEntity userEntity = userEntities.stream() //
              .filter(u -> u.getOrigUserId().equals(p.getUserId())) //
              .findAny() //
              .orElse(null);
          postEntity.setUserEntity(userEntity);
          return postEntity;
        }).collect(Collectors.toList());
    
    List<CommentEntity> commentEntities =
        this.jphService.getAllComments().stream() //
            .map(c -> {
              CommentEntity commentEntity = this.commentEntityMapper.map(c);
              PostEntity postEntity = postEntities.stream() //
                  .filter(p -> p.getOrigPostId().equals(c.getPostId())).findAny() //
                  .orElse(null);
              commentEntity.setPostEntity(postEntity);
              return commentEntity;
            }).collect(Collectors.toList());

    this.userRepository.saveAll(userEntities);
    this.postRepository.saveAll(postEntities);
    this.commentRepository.saveAll(commentEntities);
  }
}