package com.bootcamp.demo.demo_weather.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_weather.controller.WeatherOperation;
import com.bootcamp.demo.demo_weather.dto.DayForecastDTO;
import com.bootcamp.demo.demo_weather.entity.WeatherForecastEntity;
import com.bootcamp.demo.demo_weather.mapper.ForecastMapper;
import com.bootcamp.demo.demo_weather.model.dto.WeatherDTO;
import com.bootcamp.demo.demo_weather.service.ObservatoryService;

@RestController
public class WeatherController implements WeatherOperation {
  @Autowired
  private ObservatoryService observatoryService;
  @Autowired
  private ForecastMapper forecastMapper;

  @Override
  public List<DayForecastDTO> getNineDaysWeather() {
    return this.observatoryService.findLatestForecast().stream() //
        .map(e -> this.forecastMapper.map(e)).collect(Collectors.toList());
  }

  @Override
  public List<DayForecastDTO> saveWeatherForecasts() {
    // Call External API
    WeatherDTO weatherDTO = this.observatoryService.getNineDaysWeather();
    // Save to DB
    List<WeatherForecastEntity> weatherForecastEntities =
        this.observatoryService.saveForecastWeather(weatherDTO);
    // Convert DTO for response
    return weatherForecastEntities.stream() //
        .map(e -> this.forecastMapper.map(e)).collect(Collectors.toList());
  }
}
