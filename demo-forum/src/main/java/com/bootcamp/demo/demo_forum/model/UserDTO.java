package com.bootcamp.demo.demo_forum.model;

import lombok.Getter;

@Getter
public class UserDTO {
  private Long id;
  private String name;
  private String username;
  private String email;
  private String phone;
  private String website;
  private AddressDTO address;
  private CompanyDTO company;

  @Getter
  public static class AddressDTO {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private GeoDTO geo;

    @Getter
    public static class GeoDTO {
      private String lat;
      private String lng;
    }
  }

  @Getter
  public static class CompanyDTO {
    private String name;
    private String catchPhrase;
    private String bs;
  }
}