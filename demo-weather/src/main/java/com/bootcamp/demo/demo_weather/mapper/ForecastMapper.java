package com.bootcamp.demo.demo_weather.mapper;

import com.bootcamp.demo.demo_weather.dto.DayForecastDTO;
import com.bootcamp.demo.demo_weather.entity.WeatherForecastEntity;

public class ForecastMapper {
  public DayForecastDTO map(WeatherForecastEntity weatherForecastEntity) {
    return DayForecastDTO.builder()//
              .date(weatherForecastEntity.getDate())//
              .description(weatherForecastEntity.getDescription())//
              .week(weatherForecastEntity.getWeek())//
              .wind(weatherForecastEntity.getWind())//
              .maxTemp(weatherForecastEntity.getMaxTemp())//
              .minTemp(weatherForecastEntity.getMinTemp())//
              .build();
  }
}
