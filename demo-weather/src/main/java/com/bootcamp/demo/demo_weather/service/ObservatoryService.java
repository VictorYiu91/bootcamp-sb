package com.bootcamp.demo.demo_weather.service;

import java.util.List;
import com.bootcamp.demo.demo_weather.entity.WeatherForecastEntity;
import com.bootcamp.demo.demo_weather.model.dto.WeatherDTO;

public interface ObservatoryService {
  /**
   * Call external API
   * @return
   */
  WeatherDTO getNineDaysWeather();

  /**
   * Save into DB
   * @param weatherDTO
   * @return
   */
  List<WeatherForecastEntity> saveForecastWeather(WeatherDTO weatherDTO);

  /**
   * Find Latest Weater Forecast from Database
   * @return
   */
  List<WeatherForecastEntity> findLatestForecast();
}