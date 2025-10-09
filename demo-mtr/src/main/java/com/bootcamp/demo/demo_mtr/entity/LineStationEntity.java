package com.bootcamp.demo.demo_mtr.entity;

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
@Table(name = "mtr_line_stations")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LineStationEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "prev_station_id")
  private StationEntity prevStationId;
  
  @ManyToOne
  @JoinColumn(name = "next_station_id")
  private StationEntity nextStationId;

  @ManyToOne
  @JoinColumn(name = "line_id", nullable = false)
  private LineEntity lineEntity;

  @ManyToOne
  @JoinColumn(name = "station_id", nullable = false)
  private StationEntity stationEntity;

}
