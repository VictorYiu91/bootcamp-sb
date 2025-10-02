package com.bootcamp.demo.demo_weather.model.dto;

import java.time.LocalDateTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class WeatherDTO {
  private String generalSituation;
  @JsonProperty(value = "weatherForecast")
  private List<Forecast> forecasts;
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
  private LocalDateTime updateTime;
  @JsonProperty(value = "soilTemp")
  private List<SoilTemp> soilTemps;
  private SeaTemp seaTemp;
  
  @Getter
  public static class SeaTemp {
    private String place;
    private Double value;
    private String unit;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private LocalDateTime recordTime;
  }

  @Getter
  public static class SoilTemp {
    private String place;
    private Double value;
    private String unit;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private LocalDateTime recordTime;
    private Depth depth;

    @Getter
    public static class Depth {
      private String unit;
      private Double value;
    }
  }

  @Getter
  public static class Forecast {
    @JsonProperty(value = "forecastDate")
    private String date;
    private String week;
    @JsonProperty(value = "forecastWind")
    private String wind;
    @JsonProperty(value = "forecastWeather")
    private String description;
    @JsonProperty(value = "forecastMaxtemp")
    private Value maxtemp;
    @JsonProperty(value = "forecastMintemp")
    private Value mintemp;
    @JsonProperty(value = "forecastMaxrh")
    private Value maxRh;
    @JsonProperty(value = "forecastMinrh")
    private Value minRh;
    @JsonProperty(value = "forecastIcon")
    private Long icon;
    @JsonProperty(value = "PSR")
    private String psr;

    @Getter
    public static class Value {
      private Double value;
      private String unit;
    }
  }
}