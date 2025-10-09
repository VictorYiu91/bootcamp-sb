package com.bootcamp.demo.demo_mtr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.demo_mtr.entity.LineStationEntity;

@Repository
public interface LineStationRepository extends JpaRepository<LineStationEntity, Long>{
  
}
