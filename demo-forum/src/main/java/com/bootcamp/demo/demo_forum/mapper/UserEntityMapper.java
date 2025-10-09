package com.bootcamp.demo.demo_forum.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_forum.entity.UserEntity;
import com.bootcamp.demo.demo_forum.model.UserDTO;

@Component
public class UserEntityMapper {
  public UserEntity map(UserDTO dto) {
    return UserEntity.builder() //
      .origUserId(dto.getId())
      .name(dto.getName())
      .username(dto.getUsername())
      .email(dto.getEmail())
      .street(dto.getAddress().getStreet())
      .city(dto.getAddress().getCity())
      .zipcode(dto.getAddress().getZipcode())
      .suite(dto.getAddress().getSuite())
      .website(dto.getWebsite())
      .phone(dto.getPhone())
      .latitude(dto.getAddress().getGeo().getLat())
      .longitude(dto.getAddress().getGeo().getLng())
      .companyBs(dto.getCompany().getBs())
      .companyName(dto.getCompany().getName())
      .companyPhrase(dto.getCompany().getCatchPhrase())
      .build();
  }
}