package com.bootcamp.demo.demo_mtr.entity;

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
@Table(name = "mtr_lines")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LineEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(unique = true)
  private String code;
  private String description;

  public LineEntity(String code, String description) {
    this.code = code;
    this.description = description;
  }
}
