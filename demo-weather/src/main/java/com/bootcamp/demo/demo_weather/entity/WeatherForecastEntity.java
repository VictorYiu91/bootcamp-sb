package com.bootcamp.demo.demo_weather.entity;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "weather_forecasts")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeatherForecastEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private LocalDate date;
  private String week;
  private String wind;
  private String description;
  @Column(name = "max_temp")
  private Double maxTemp;
  @Column(name = "min_temp")
  private Double minTemp;
  @Column(name = "max_rh")
  private Double maxRh;
  @Column(name = "min_rh")
  private Double minRh;

  @ManyToOne
  @JoinColumn(name = "request_id")
  private WeatherRequestEntity weatherRequestEntity;
}