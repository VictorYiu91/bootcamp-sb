package com.bootcamp.demo.demo_forum.entity;

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
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String username;
  private String email;
  @Column(name = "address_street")
  private String street;
  @Column(name = "address_suite")
  private String suite;
  @Column(name = "address_city")
  private String city;
  @Column(name = "address_zipcode")
  private String zipcode;
  @Column(name = "address_geo_lat")
  private String latitude;
  @Column(name = "address_geo_lng")
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
