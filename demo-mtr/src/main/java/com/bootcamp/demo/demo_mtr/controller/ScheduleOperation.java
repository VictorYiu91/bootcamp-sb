package com.bootcamp.demo.demo_mtr.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo.demo_mtr.entity.LineEntity;
import com.bootcamp.demo.demo_mtr.model.dto.ScheduleDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface ScheduleOperation {
  @GetMapping(value = "/mtr/schedule")
  ScheduleDTO getSchedule(@RequestParam String line, @RequestParam String station);

  @GetMapping(value = "/mtr/lines")
  List<LineEntity> getAllLines() throws JsonProcessingException;
}