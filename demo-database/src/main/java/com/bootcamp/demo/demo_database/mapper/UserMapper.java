package com.bootcamp.demo.demo_database.mapper;

import com.bootcamp.demo.demo_database.entity.UserEntity;
import com.bootcamp.demo.demo_database.model.User;

public class UserMapper {
  public UserEntity map(User user) {
    return UserEntity.builder() //
      .origUserId(user.getId())
      .name(user.getName())
      .username(user.getUsername())
      .email(user.getEmail())
      .street(user.getAddress().getStreet())
      .city(user.getAddress().getCity())
      .zipcode(user.getAddress().getZipcode())
      .suite(user.getAddress().getSuite())
      .website(user.getWebsite())
      .phone(user.getPhone())
      .latitude(user.getAddress().getGeo().getLat())
      .longitude(user.getAddress().getGeo().getLng())
      .companyBs(user.getCompany().getBs())
      .companyName(user.getCompany().getName())
      .companyPhrase(user.getCompany().getCatchPhrase())
      .build();
  }

  public User map(UserEntity user) {
    return null;
  }
}