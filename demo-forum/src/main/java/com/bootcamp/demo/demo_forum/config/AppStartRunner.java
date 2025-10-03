package com.bootcamp.demo.demo_forum.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_forum.entity.CommentEntity;
import com.bootcamp.demo.demo_forum.entity.PostEntity;
import com.bootcamp.demo.demo_forum.entity.UserEntity;
import com.bootcamp.demo.demo_forum.mapper.CommentMapper;
import com.bootcamp.demo.demo_forum.mapper.PostMapper;
import com.bootcamp.demo.demo_forum.mapper.UserMapper;
import com.bootcamp.demo.demo_forum.model.dto.CommentDTO;
import com.bootcamp.demo.demo_forum.model.dto.PostDTO;
import com.bootcamp.demo.demo_forum.model.dto.UserDTO;
import com.bootcamp.demo.demo_forum.repository.CommentRepository;
import com.bootcamp.demo.demo_forum.repository.PostRepository;
import com.bootcamp.demo.demo_forum.repository.UserRepository;
import com.bootcamp.demo.demo_forum.service.JPHService;

@Component
public class AppStartRunner implements CommandLineRunner{
  @Autowired
  private UserMapper userMapper;
  @Autowired
  private PostMapper postMapper;
  @Autowired
  private CommentMapper commentMapper;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private PostRepository postRepository;
  @Autowired
  private CommentRepository commentRepository;
  @Autowired
  private JPHService jphService;

  
  @Override
  public void run(String... args) throws Exception {
    this.commentRepository.deleteAll();
    this.postRepository.deleteAll();
    this.userRepository.deleteAll();

    List<UserDTO> usersDTO = this.jphService.getUsers();
    List<PostDTO> postsDTO = this.jphService.getPosts();
    List<CommentDTO> commentsDTO = this.jphService.getComments();
    List<UserEntity> userEntities = new ArrayList<>();
    List<PostEntity> postEntities = new ArrayList<>();
    List<CommentEntity> commentEntities = new ArrayList<>();

    for (UserDTO u : usersDTO) {
      UserEntity userEntity = this.userMapper.mapUserEntity(u);
      userEntities.add(userEntity);
      Long userId = u.getId();
      for(PostDTO p : postsDTO) {
        if (userId.equals(p.getUserId())) {
          PostEntity postEntity = this.postMapper.mapPostEntity(p, userEntity);
          postEntities.add(postEntity);
          Long postId = p.getId();
          for(CommentDTO c : commentsDTO) {
            if (postId.equals(c.getPostId())) {
              CommentEntity commentEntity = this.commentMapper.mapCommentEntity(c, postEntity);
              commentEntities.add(commentEntity);
            }
          }
        }
      }
    }
    this.userRepository.saveAll(userEntities);
    this.postRepository.saveAll(postEntities);
    this.commentRepository.saveAll(commentEntities);
  }
}
