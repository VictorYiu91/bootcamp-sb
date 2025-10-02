package com.bootcamp.demo.demo_weather.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.bootcamp.demo.demo_weather.dto.DayForecastDTO;

public interface WeatherOperation {
  /**
   * Get the latest Nine Days Weather Predication from Database.
   * 
   * @return List<DayForecast>
   */
  @GetMapping(value = "/ninedaysweather")
  List<DayForecastDTO> getNineDaysWeather();

  /**
   * Get weather forecasts from external API, and save into database
   * 
   * @return
   */
  @PostMapping(value = "/weatherforecast")
  List<DayForecastDTO> saveWeatherForecasts();

}