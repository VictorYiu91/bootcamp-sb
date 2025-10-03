package com.bootcamp.demo.demo_forum.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_forum.codelib.NotFoundException;
import com.bootcamp.demo.demo_forum.codelib.SysCode;
import com.bootcamp.demo.demo_forum.entity.CommentEntity;
import com.bootcamp.demo.demo_forum.entity.PostEntity;
import com.bootcamp.demo.demo_forum.model.dto.CommentDTO;
import com.bootcamp.demo.demo_forum.model.dto.PostDTO;
import com.bootcamp.demo.demo_forum.model.dto.UserDTO;
import com.bootcamp.demo.demo_forum.repository.CommentRepository;
import com.bootcamp.demo.demo_forum.repository.PostRepository;
import com.bootcamp.demo.demo_forum.service.JPHService;

@Service
public class JPHServiceImpl implements JPHService {
  @Autowired
  private RestTemplate restTemplate;
  @Autowired
  private PostRepository postRepository;
  @Autowired
  private CommentRepository commentRepository;

  // ! @Value -> Check Dependency during Server Starts (~Component Scan)
  // @Value(value = "${jph-service.host}")
  // private String jphHost;

  // @Value(value = "${jph-service.endpoints.users}")
  // private String usersEndpoint;

  // @Value(value = "${jph-service.endpoints.posts}")
  // private String postsEndpoint;

  // @Value(value = "${jph-service.endpoints.comments}")
  // private String commentsEndpoint;

  // Instance Variables (Bean)
  // private final String usersUrl = UriComponentsBuilder.newInstance()//
  // .host(jphHost)//
  // .scheme("https")//
  // .path(usersEndpoint)//
  // .build()//
  // .toUriString();

  // private final String postsUrl = UriComponentsBuilder.newInstance()//
  // .host(jphHost)//
  // .scheme("https")//
  // .path(postsEndpoint)//
  // .build()//
  // .toUriString();

  // private final String commentsUrl = UriComponentsBuilder.newInstance()//
  // .host(jphHost)//
  // .scheme("https")//
  // .path(commentsEndpoint)//
  // .build()//
  // .toUriString();

  private static final String usersUrl =
      "https://jsonplaceholder.typicode.com/users";
  private static final String postsUrl =
      "https://jsonplaceholder.typicode.com/posts";
  private static final String commentsUrl =
      "https://jsonplaceholder.typicode.com/comments";

  @Override
  public List<UserDTO> getUsers() {
    UserDTO[] usersDTO = new UserDTO[0];
    try {
      usersDTO = this.restTemplate.getForObject(usersUrl, UserDTO[].class);
    } catch (RestClientException e) {
      System.out.println("JsonPlaceHolde Users Endpoints Error");
    }
    return Arrays.asList(usersDTO);
  }

  @Override
  public List<PostDTO> getPosts() {
    PostDTO[] postsDTO = new PostDTO[0];
    try {
      postsDTO = this.restTemplate.getForObject(postsUrl, PostDTO[].class);
    } catch (RestClientException e) {
      System.out.println("JsonPlaceHolde Posts Endpoints Error");
    }
    return Arrays.asList(postsDTO);
  }

  @Override
  public List<CommentDTO> getComments() {
    CommentDTO[] commentsDTO = new CommentDTO[0];
    try {
      commentsDTO =
          this.restTemplate.getForObject(commentsUrl, CommentDTO[].class);
    } catch (RestClientException e) {
      System.out.println("JsonPlaceHolde Comments Endpoints Error");
    }
    return Arrays.asList(commentsDTO);
  }

  @Override
  public List<CommentEntity> getCommentsByPostId(Long postId) {
    PostEntity postEntity = this.postRepository.findById(postId)
        .orElseThrow(() -> new NotFoundException(SysCode.ID_NOT_FOUND));
    return this.commentRepository.findByPost(postEntity);
  }
}
