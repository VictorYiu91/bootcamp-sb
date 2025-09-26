package com.bootcamp.demo.demo_database.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="employees")
@Getter
@Setter
public class EmployeeEntity {
  @Id // ! Primary Key
  @GeneratedValue(strategy = GenerationType.IDENTITY) // ! mySQL: auto_increment
  private Long id;
  @Column(name="e_name", length = 20) // length by default 255
  private String name;
  @Column(name="e_age")
  private Integer age;
  @Column(name="e_salary", precision = 10, scale = 2) // ! mySQL: numeric(10,2)
  private BigDecimal salary;
  @Column(name="e_join_date")
  private LocalDate joinDate;
}
