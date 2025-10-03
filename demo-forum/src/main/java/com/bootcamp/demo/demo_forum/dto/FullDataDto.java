package com.bootcamp.demo.demo_forum.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class FullDataDto {
  private Long id;
  private String name;
  private String userName;
  private String email;
  private AddressDto address;
  private String phone;
  private String website;
  private CompanyDto company;
  private List<PostDto> posts;

  @Getter
  @Builder
  public static class AddressDto {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private GeoDto geo;

    @Getter
    @Builder
    public static class GeoDto {
      private String lat;
      private String lng;
    }
  }

  @Getter
  @Builder
  public static class CompanyDto{
    private String name;
    private String catchPhrase;
    private String bs;
  }

  @Getter
  @Builder
  public static class PostDto {
    private Long id;
    private String tittle;
    private String body;
    private List<CommentDto> comments;

    @Getter
    @Builder
    public static class CommentDto {
      @Setter
      private Long id;
      private String name;
      private String email;
      private String body;
    }
  }
}
