package com.bootcamp.demo.demo_sb_calculator.model;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
public class ShoppingMall {
  private String name;
  private Integer area;
  private Cinema cinema;
  private List<String> shopCategory;

  @Getter
  @Builder
  public static class Cinema {
    private String name;
    private LocalDate openedDate;
    private List<Film> releasedFilm;

    @Getter
    @Builder
    @EqualsAndHashCode
    @AllArgsConstructor
    public static class Film {
      private String name;
      private LocalDate releasedDate;
    }
  }
}

