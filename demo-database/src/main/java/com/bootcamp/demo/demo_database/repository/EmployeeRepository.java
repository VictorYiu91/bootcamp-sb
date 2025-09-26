package com.bootcamp.demo.demo_database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.demo_database.entity.EmployeeEntity;

// Step 1: ! interface, extends JpaRepository
// Step 2: @Repository

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
  
}
