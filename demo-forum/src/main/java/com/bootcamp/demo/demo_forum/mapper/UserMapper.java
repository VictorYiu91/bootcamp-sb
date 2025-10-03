package com.bootcamp.demo.demo_forum.mapper;

import java.util.List;
import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_forum.dto.FullDataDto;
import com.bootcamp.demo.demo_forum.dto.FullDataDto.AddressDto;
import com.bootcamp.demo.demo_forum.dto.FullDataDto.CompanyDto;
import com.bootcamp.demo.demo_forum.dto.FullDataDto.PostDto;
import com.bootcamp.demo.demo_forum.dto.FullDataDto.AddressDto.GeoDto;
import com.bootcamp.demo.demo_forum.entity.UserEntity;
import com.bootcamp.demo.demo_forum.model.dto.UserDTO;

@Component // ! create as Bean
public class UserMapper {

  //public static List<CommentDto> commentsByPostId(List<CommentDTO> comments,
      //Long postId) {
    //Long commentId = 0L;
    //List<CommentDTO> commentsFiltered = comments.stream()//
        //.filter(e -> e.getPostId().equals(postId))//
        //.collect(Collectors.toList());
    //List<CommentDto> commentsByPostId = new ArrayList<>();
    //for (int i = 0; i < commentsFiltered.size(); i++) {
      //CommentDTO commentDTO = commentsFiltered.get(i);
      //CommentDto comment = CommentDto.builder()//
      //.id(++commentId)//
      //.name(commentDTO.getName())//
      //.email(commentDTO.getEmail())//
      //.body(commentDTO.getBody())//
      //.build();
      //commentsByPostId.add(comment);
    //}
    //return commentsByPostId;
  //}

  //public static List<PostDto> postByUserId(List<PostDTO> posts, List<CommentDTO> comments,
      //Long userId) {
    //List<PostDTO> postsFiltered = posts.stream()//
        //.filter(e -> e.getUserId().equals(userId))//
        //.collect(Collectors.toList());
    //return postsFiltered.stream().map(e -> {
      //return PostDto.builder()//
          //.id(e.getId())//
          //.tittle(e.getTitle())//
          //.body(e.getBody())//
          //.comments(UserMapper.commentsByPostId(comments, e.getId()))
          //.build();
    //}).collect(Collectors.toList());
  //}

  public FullDataDto mapUser(UserDTO user, List<PostDto> postsDto) {
    GeoDto userGeo = GeoDto.builder()//
        .lat(user.getAddress().getGeo().getLat())//
        .lng(user.getAddress().getGeo().getLng())//
        .build();
    AddressDto userAddress = AddressDto.builder()//
        .street(user.getAddress().getStreet())//
        .suite(user.getAddress().getSuite())//
        .city(user.getAddress().getCity())//
        .zipcode(user.getAddress().getZipcode())//
        .geo(userGeo)//
        .build();
    CompanyDto userCompany = CompanyDto.builder()//
        .name(user.getCompany().getName())//
        .catchPhrase(user.getCompany().getCatchPhrase())//
        .bs(user.getCompany().getBs())//
        .build();

    return FullDataDto.builder()//
        .id(user.getId())//
        .name(user.getName())//
        .userName(user.getUsername())//
        .email(user.getEmail())//
        .address(userAddress)//
        .phone(user.getPhone())//
        .website(user.getWebsite())//
        .company(userCompany)//
        .posts(postsDto)//
        .build();
  }

    public UserEntity mapUserEntity(UserDTO userDTO) {
    return UserEntity.builder() //
      .name(userDTO.getName())
      .username(userDTO.getUsername())
      .email(userDTO.getEmail())
      .street(userDTO.getAddress().getStreet())
      .city(userDTO.getAddress().getCity())
      .zipcode(userDTO.getAddress().getZipcode())
      .suite(userDTO.getAddress().getSuite())
      .website(userDTO.getWebsite())
      .phone(userDTO.getPhone())
      .latitude(userDTO.getAddress().getGeo().getLat())
      .longitude(userDTO.getAddress().getGeo().getLng())
      .companyBs(userDTO.getCompany().getBs())
      .companyName(userDTO.getCompany().getName())
      .companyPhrase(userDTO.getCompany().getCatchPhrase())
      .build();
  }
}
