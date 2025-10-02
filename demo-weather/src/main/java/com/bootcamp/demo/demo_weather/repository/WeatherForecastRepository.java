package com.bootcamp.demo.demo_weather.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.demo_weather.entity.WeatherForecastEntity;

@Repository
public interface WeatherForecastRepository
    extends JpaRepository<WeatherForecastEntity, Long> {
  // ! Hibernate (Generate Class implementing this interface)
  // Class:
  // method findByRequestId(): login DB (you provided id/pw), 
  // execute this SQL, put SQL result into your target list
  @Query(
      value = "select w.* from weather_forecasts w where w.request_id = :request_id",
      nativeQuery = true)
  List<WeatherForecastEntity> findByRequestId(
      @Param("request_id") Long request_id);
}
