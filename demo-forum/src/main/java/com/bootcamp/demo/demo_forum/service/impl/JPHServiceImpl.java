package com.bootcamp.demo.demo_forum.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcamp.demo.demo_forum.codelib.NotFoundException;
import com.bootcamp.demo.demo_forum.codelib.SysCode;
import com.bootcamp.demo.demo_forum.entity.CommentEntity;
import com.bootcamp.demo.demo_forum.entity.PostEntity;
import com.bootcamp.demo.demo_forum.model.CommentDTO;
import com.bootcamp.demo.demo_forum.model.PostDTO;
import com.bootcamp.demo.demo_forum.model.UserDTO;
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
  @Value(value = "${jph-service.host}")
  private String jphHost;

  @Value(value = "${jph-service.endpoints.users}")
  private String usersEndpoint;

  @Value(value = "${jph-service.endpoints.posts}")
  private String postsEndpoint;

  @Value(value = "${jph-service.endpoints.comments}")
  private String commentsEndpoint;

  // ! Instance Variables (Bean)
  // private final String usersUrl =
  // UriComponentsBuilder.newInstance() //
  // .host(jphHost) //
  // .scheme("https") //
  // .path(usersEndpoint) //
  // .build() //
  // .toUriString();

  // private final String postsUrl =
  // UriComponentsBuilder.newInstance() //
  // .host(jphHost) //
  // .scheme("https") //
  // .path(postsEndpoint) //
  // .build() //
  // .toUriString();

  // private final String commentsUrl =
  // UriComponentsBuilder.newInstance().host(jphHost) //
  // .scheme("https") //
  // .path(commentsEndpoint) //
  // .build() //
  // .toUriString();

  @Override
  public List<UserDTO> getAllUsers() {
    UserDTO[] userDTOs = new UserDTO[0];
    try {

      String usersUrl = UriComponentsBuilder.newInstance() //
          .host(jphHost) //
          .scheme("https") //
          .path(usersEndpoint) //
          .build() //
          .toUriString();
      System.out.println("usersUrl=" + usersUrl);

      userDTOs = this.restTemplate.getForObject(usersUrl, UserDTO[].class);
    } catch (RestClientException e) {
      System.out.println("JsonPlaceHolder Users Endpoints Error.");
    }
    return Arrays.asList(userDTOs);
  }

  @Override
  public List<PostDTO> getAllPosts() {
    PostDTO[] postDTOs = new PostDTO[0];
    try {
      String postsUrl = UriComponentsBuilder.newInstance() //
          .host(jphHost) //
          .scheme("https") //
          .path(postsEndpoint) //
          .build() //
          .toUriString();
      System.out.println("postsUrl=" + postsUrl);
      postDTOs = this.restTemplate.getForObject(postsUrl, PostDTO[].class);
    } catch (RestClientException e) {
      System.out.println("JsonPlaceHolder Posts Endpoints Error.");
    }
    return Arrays.asList(postDTOs);
  }

  @Override
  public List<CommentDTO> getAllComments() {
    CommentDTO[] commentDTOs = new CommentDTO[0];
    String commentsUrl = UriComponentsBuilder.newInstance() //
        .host(jphHost) //
        .scheme("https") //
        .path(commentsEndpoint) //
        .build() //
        .toUriString();
    System.out.println("commentsUrl=" + commentsUrl);
    commentDTOs =
        this.restTemplate.getForObject(commentsUrl, CommentDTO[].class);

    return Arrays.asList(commentDTOs);
  }

  @Override
  public List<CommentEntity> getCommentsByPostId(Long postId) {
    PostEntity postEntity = this.postRepository.findById(postId)
        .orElseThrow(() -> new NotFoundException(SysCode.ID_NOT_FOUND));
    return this.commentRepository.findByPost(postEntity);
  }
}