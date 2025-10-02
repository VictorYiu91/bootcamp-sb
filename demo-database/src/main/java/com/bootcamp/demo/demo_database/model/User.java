package com.bootcamp.demo.demo_database.model;

import lombok.Getter;

@Getter
public class User {
  private Long id;
  private String name;
  private String username;
  private String email;
  private String phone;
  private String website;
  private Address address;
  private Company company;

  @Getter
  public static class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    @Getter
    public static class Geo {
      private String lat;
      private String lng;
    }
  }

  @Getter
  public static class Company {
    private String name;
    private String catchPhrase;
    private String bs;
  }
}