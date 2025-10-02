package com.bootcamp.demo.demo_weather.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "weather_requests")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeatherRequestEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Builder.Default
  @Column(name = "request_datetime")
  private LocalDateTime requestDateTime = LocalDateTime.now();
  private String dataType; // fnd
}