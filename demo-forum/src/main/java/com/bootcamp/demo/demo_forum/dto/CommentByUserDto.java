package com.bootcamp.demo.demo_forum.dto;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentByUserDto {
  private Long id;
  private String username;
  private List<CommentsNoId> comments;

  @Getter
  @Builder
  public static class CommentsNoId {
    private String name;
    private String email;
    private String body;
  }
}
