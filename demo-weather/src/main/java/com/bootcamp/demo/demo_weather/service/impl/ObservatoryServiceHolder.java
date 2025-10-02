package com.bootcamp.demo.demo_weather.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcamp.demo.demo_weather.entity.WeatherForecastEntity;
import com.bootcamp.demo.demo_weather.entity.WeatherRequestEntity;
import com.bootcamp.demo.demo_weather.model.dto.WeatherDTO;
import com.bootcamp.demo.demo_weather.repository.WeatherForecastRepository;
import com.bootcamp.demo.demo_weather.repository.WeatherRequestRepository;
import com.bootcamp.demo.demo_weather.service.ObservatoryService;

@Service
public class ObservatoryServiceHolder implements ObservatoryService {
  private static final String nineDaysWeatherUrl =
      UriComponentsBuilder.newInstance() //
          .scheme("https") //
          .host("data.weather.gov.hk") //
          .pathSegment("weatherAPI/opendata") //
          .path("/weather.php") //
          .queryParam("dataType", "fnd") //
          .queryParam("lang", "tc") //
          .build().toUriString();

  @Autowired
  private WeatherRequestRepository weatherRequestRepository;
  @Autowired
  private WeatherForecastRepository weatherForecastRepository;
  @Autowired
  private RestTemplate restTemplate;

  // ! Call External API
  @Override
  public WeatherDTO getNineDaysWeather() {
    return this.restTemplate.getForObject(nineDaysWeatherUrl,
        WeatherDTO.class);
  }

  @Override
  public List<WeatherForecastEntity> saveForecastWeather(
      WeatherDTO weatherDTO) {
    WeatherRequestEntity weatherRequestEntity = WeatherRequestEntity.builder() //
        .dataType("fnd") //
        .build(); //
    this.weatherRequestRepository.save(weatherRequestEntity);

    List<WeatherForecastEntity> weatherForecastEntities =
        weatherDTO.getForecasts().stream() //
            .map(e -> {
              return WeatherForecastEntity.builder() //
                  .date(LocalDate.parse(e.getDate(),
                      DateTimeFormatter.ofPattern("yyyyMMdd"))) //
                  .description(e.getDescription()) //
                  .maxRh(e.getMaxRh().getValue()) //
                  .minRh(e.getMinRh().getValue()) //
                  .maxTemp(e.getMaxtemp().getValue()) //
                  .minTemp(e.getMintemp().getValue()) //
                  .wind(e.getWind()) //
                  .week(e.getWeek()) //
                  .weatherRequestEntity(weatherRequestEntity) // ! FK
                  .build();
            }).collect(Collectors.toList());
    return this.weatherForecastRepository.saveAll(weatherForecastEntities);
  }
  @Override
  public List<WeatherForecastEntity> findLatestForecast() {
    Long maxReqId = this.weatherRequestRepository.findMaxRequestId();
    return this.weatherForecastRepository.findByRequestId(maxReqId);
  }
}
