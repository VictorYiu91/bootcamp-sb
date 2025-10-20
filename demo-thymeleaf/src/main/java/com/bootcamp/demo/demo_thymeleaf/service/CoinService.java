package com.bootcamp.demo.demo_thymeleaf.service;

import java.util.List;
import com.bootcamp.demo.demo_thymeleaf.model.dto.CoinDTO;

public interface CoinService {
  List<CoinDTO> getCoins();
}