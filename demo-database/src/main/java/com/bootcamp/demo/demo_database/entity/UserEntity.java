package com.bootcamp.demo.demo_database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
  @Id // ! Primary Key
  @GeneratedValue(strategy = GenerationType.IDENTITY) // ! auto_increment
  private Long id;
  private Long origUserId; // ! Original user id
  private String name;
  private String username;
  private String email;
  private String street;
  private String suite;
  private String city;
  private String zipcode;
  private String latitude;
  private String longitude;
  private String phone;
  private String website;
  @Column(name = "com_name")
  private String companyName;
  @Column(name = "com_phrase")
  private String companyPhrase;
  @Column(name = "com_bs")
  private String companyBs;
}