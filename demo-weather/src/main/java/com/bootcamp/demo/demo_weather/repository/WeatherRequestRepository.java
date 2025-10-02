package com.bootcamp.demo.demo_weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.demo_weather.entity.WeatherRequestEntity;

@Repository
public interface WeatherRequestRepository
    extends JpaRepository<WeatherRequestEntity, Long> {
  // ! Native in JPA
  @Query(value = "select max(id) from weather_requests", nativeQuery = true)
  Long findMaxRequestId();

}
