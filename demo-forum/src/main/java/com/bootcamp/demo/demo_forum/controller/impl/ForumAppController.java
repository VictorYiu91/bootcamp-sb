package com.bootcamp.demo.demo_forum.controller.impl;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_forum.codelib.GResponse;
import com.bootcamp.demo.demo_forum.codelib.NotFoundException;
import com.bootcamp.demo.demo_forum.codelib.SysCode;
import com.bootcamp.demo.demo_forum.controller.ForumAppOperation;
import com.bootcamp.demo.demo_forum.dto.CommentByUserDto;
import com.bootcamp.demo.demo_forum.dto.FullDataDto;
import com.bootcamp.demo.demo_forum.dto.CommentByUserDto.CommentsNoId;
import com.bootcamp.demo.demo_forum.dto.FullDataDto.PostDto;
import com.bootcamp.demo.demo_forum.dto.FullDataDto.PostDto.CommentDto;
import com.bootcamp.demo.demo_forum.entity.CommentEntity;
import com.bootcamp.demo.demo_forum.entity.PostEntity;
import com.bootcamp.demo.demo_forum.entity.UserEntity;
import com.bootcamp.demo.demo_forum.mapper.CommentMapper;
import com.bootcamp.demo.demo_forum.mapper.PostMapper;
import com.bootcamp.demo.demo_forum.mapper.UserMapper;
import com.bootcamp.demo.demo_forum.model.dto.CommentDTO;
import com.bootcamp.demo.demo_forum.model.dto.PostDTO;
import com.bootcamp.demo.demo_forum.model.dto.UserDTO;
import com.bootcamp.demo.demo_forum.repository.UserRepository;
import com.bootcamp.demo.demo_forum.service.JPHService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class ForumAppController implements ForumAppOperation {
  @Autowired
  private JPHService jphService;
  @Autowired
  private UserMapper userMapper;
  @Autowired
  private PostMapper postMapper;
  @Autowired
  private CommentMapper commentMapper;
  @Autowired
  private UserRepository userRepository;


  @Override
  public List<FullDataDto> getFullData() {
    List<UserDTO> usersDTO = this.jphService.getUsers();
    List<PostDTO> postsDTO = this.jphService.getPosts();
    List<CommentDTO> commentsDTO = this.jphService.getComments();
    List<FullDataDto> fullDatasDto = new ArrayList<>();
    List<PostDto> postsDto = new ArrayList<>();
    List<CommentDto> commentsDto = new ArrayList<>();

    for (UserDTO u : usersDTO) {
      List<PostDTO> postsFiltered = this.findPostsByUserId(postsDTO, u.getId());
      for (PostDTO p : postsFiltered) {
        List<CommentDTO> commentsFiltered =
            this.findCommentsByPostId(commentsDTO, p.getId());
        Long commentId = 0L;
        for (CommentDTO c : commentsFiltered) {
          CommentDto commentDto = this.commentMapper.mapComment(c);
          commentId++;
          commentDto.setId(commentId);
          commentsDto.add(commentDto);
        }
        PostDto postDto = this.postMapper.mapPost(p, commentsDto);
        postsDto.add(postDto);
      }
      FullDataDto fullDataDto = this.userMapper.mapUser(u, postsDto);
      fullDatasDto.add(fullDataDto);
    }
    return fullDatasDto;

    // return usersDTO.stream()
    // .map(e -> this.userMapper.mapUser(e, postsDTO, commentsDTO))
    // .collect(Collectors.toList());
  }

  @Override
  public GResponse<CommentByUserDto> commentByUser(String id) {
    // ! happy flow (try-catch is not required)
    Long userId = Long.valueOf(id); // throw NumberFormatException

    List<UserDTO> usersDTO = this.jphService.getUsers();
    List<PostDTO> postsDTO = this.jphService.getPosts();
    List<CommentDTO> commentsDTO = this.jphService.getComments();
    List<PostDto> postsDto = new ArrayList<>();
    List<CommentDto> commentsDto = new ArrayList<>();
    int idx = 0;
    for (int i = 0; i < usersDTO.size(); i++) {
      if (usersDTO.get(i).getId().equals(userId)) {
        idx = i;
        break;
      } else {
        throw new NotFoundException(SysCode.ID_NOT_FOUND);
      }
    }
    UserDTO taUserDTO = usersDTO.get(idx);
    List<PostDTO> taPostsDTO = this.findPostsByUserId(postsDTO, userId);
    for (PostDTO p : taPostsDTO) {
      List<CommentDTO> commentsFiltered =
          this.findCommentsByPostId(commentsDTO, p.getId());
      Long commentId = 0L;
      for (CommentDTO c : commentsFiltered) {
        CommentDto commentDto = this.commentMapper.mapComment(c);
        commentId++;
        commentDto.setId(commentId);
        commentsDto.add(commentDto);
      }
      PostDto postDto = this.postMapper.mapPost(p, commentsDto);
      postsDto.add(postDto);
    }

    FullDataDto taFullDataDto = this.userMapper.mapUser(taUserDTO, postsDto);
    List<CommentDto> allComments = taFullDataDto.getPosts().stream()//
        .flatMap(e -> e.getComments().stream())//
        .collect(Collectors.toList());
    List<CommentsNoId> allCommentsNoId = allComments.stream().map(e -> {//
      return CommentsNoId.builder()//
          .name(e.getName())//
          .email(e.getEmail())//
          .body(e.getBody()).build();
    }).collect(Collectors.toList());
    CommentByUserDto result = CommentByUserDto.builder()//
        .id(taFullDataDto.getId())//
        .username(taFullDataDto.getUserName())//
        .comments(allCommentsNoId)//
        .build();
    return GResponse.<CommentByUserDto>builder()//
        .config(SysCode.SUCCESS)//
        .data(List.of(result))//
        .build();
  }

  public List<CommentDTO> findCommentsByPostId(List<CommentDTO> comments,
      Long id) {
    return comments.stream().filter(e -> id.equals(e.getPostId()))
        .collect(Collectors.toList());
  }

  public List<PostDTO> findPostsByUserId(List<PostDTO> posts, Long id) {
    return posts.stream().filter(e -> id.equals(e.getUserId()))
        .collect(Collectors.toList());
  }

  @Override
  public List<UserEntity> getAllUsers() {
    return this.userRepository.findAll();
  }

  @Override
  public UserEntity getUser(String id) {
    Long userId = Long.valueOf(id);
    Optional<UserEntity> userEntity = this.userRepository.findById(userId);
    if (userEntity.isPresent())
      return userEntity.get();
    else
      throw new NotFoundException(SysCode.ID_NOT_FOUND);
  }

   @Override
   public UserEntity updateUser(String id, UserEntity userEntity) {
    Long userId = Long.valueOf(id);
    if (userId == null || !userId.equals(userEntity.getId()))
      throw new NotFoundException(SysCode.ID_NOT_FOUND);

    return this.userRepository.findById(userId).map(e -> {
      e.setName(userEntity.getName());
      e.setUsername(userEntity.getUsername());
      e.setEmail(userEntity.getEmail());
      e.setStreet(userEntity.getStreet());
      e.setSuite(userEntity.getSuite());
      e.setCity(userEntity.getCity());
      e.setZipcode(userEntity.getZipcode());
      e.setLatitude(userEntity.getLatitude());
      e.setLongitude(userEntity.getLongitude());
      e.setPhone(userEntity.getPhone());
      e.setWebsite(userEntity.getWebsite());
      e.setCompanyName(userEntity.getCompanyName());
      e.setCompanyPhrase(userEntity.getCompanyPhrase());
      e.setCompanyBs(userEntity.getCompanyBs());
      UserEntity saved = this.userRepository.save(e);
      return saved;
    }).orElse(null);
  }

  @Override
  public GResponse<List<CommentEntity>> getCommentsByPostId(@RequestParam String id) {
    Long userId = Long.valueOf(id);
    List<CommentEntity> commentEntities = this.jphService.getCommentsByPostId(userId);
    return GResponse.<List<CommentEntity>>builder()//
    .config(SysCode.SUCCESS)//
    .data(List.of(commentEntities))//
    .build();
  }
}