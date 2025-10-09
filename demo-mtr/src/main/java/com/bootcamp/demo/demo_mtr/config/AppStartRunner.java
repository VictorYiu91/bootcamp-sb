package com.bootcamp.demo.demo_mtr.config;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_mtr.entity.LineEntity;
import com.bootcamp.demo.demo_mtr.repository.LineRepository;
import com.bootcamp.demo.demo_mtr.repository.LineStationRepository;
import com.bootcamp.demo.demo_mtr.repository.StationRepository;

@Component
public class AppStartRunner implements CommandLineRunner {
  @Autowired
  private RestTemplate restTemplate;
  @Autowired
  private LineRepository lineRepository;
  @Autowired
  private StationRepository stationRepository;
  @Autowired
  private LineStationRepository lineStationRepository;


  @Override
  public void run(String... args) throws Exception {
    this.lineRepository.deleteAll();
    List<LineEntity> lineEntities = List.of(//
        new LineEntity("TWL", "Tsuen Wan Line"), //
        new LineEntity("KTL", "Kwun Tong Line"));

    this.lineRepository.saveAll(lineEntities);
  }
}
