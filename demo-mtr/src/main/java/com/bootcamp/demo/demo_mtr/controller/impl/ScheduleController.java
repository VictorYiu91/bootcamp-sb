package com.bootcamp.demo.demo_mtr.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_mtr.controller.ScheduleOperation;
import com.bootcamp.demo.demo_mtr.entity.LineEntity;
import com.bootcamp.demo.demo_mtr.model.dto.ScheduleDTO;
import com.bootcamp.demo.demo_mtr.service.ScheduleService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class ScheduleController implements ScheduleOperation {
  @Autowired
  private ScheduleService scheduleService; // Polymorphism

  @Override
  public ScheduleDTO getSchedule(String line, String station) {
    return this.scheduleService.getSchedule(line, station);
  }

  @Override
  public List<LineEntity> getAllLines() throws JsonProcessingException{
    return this.scheduleService.getAllLines();
  }
}