package com.bootcamp.demo.demo_mtr.service;

import java.util.List;
import com.bootcamp.demo.demo_mtr.entity.LineEntity;
import com.bootcamp.demo.demo_mtr.model.dto.ScheduleDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface ScheduleService {
  ScheduleDTO getSchedule(String line, String station);
  List<LineEntity> getAllLines() throws JsonProcessingException;
}
