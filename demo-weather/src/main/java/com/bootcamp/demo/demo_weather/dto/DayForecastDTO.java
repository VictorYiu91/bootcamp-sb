package com.bootcamp.demo.demo_weather.dto;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DayForecastDTO {
  private LocalDate date;
  private String week;
  private String wind;
  private String description;
  private Double maxTemp;
  private Double minTemp;
}