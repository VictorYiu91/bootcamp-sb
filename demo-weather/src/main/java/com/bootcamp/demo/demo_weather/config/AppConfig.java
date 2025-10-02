package com.bootcamp.demo.demo_weather.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_weather.mapper.ForecastMapper;

@Configuration // ! Component Scan
public class AppConfig {
  @Bean
  ForecastMapper forecastMapper() {
    return new ForecastMapper();
  }

  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
