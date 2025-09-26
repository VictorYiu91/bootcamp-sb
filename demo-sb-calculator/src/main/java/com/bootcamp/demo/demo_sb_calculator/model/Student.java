package com.bootcamp.demo.demo_sb_calculator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@AllArgsConstructor
public class Student {
  private static long counter = 0;
  private Long id;
  @Setter
  private String name;
  private Integer age;

  public Student() {
    this.id = ++counter;
  }
}
