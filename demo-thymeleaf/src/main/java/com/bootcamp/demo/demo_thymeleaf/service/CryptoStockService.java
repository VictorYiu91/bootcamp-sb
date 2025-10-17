package com.bootcamp.demo.demo_thymeleaf.service;

import java.util.List;
import com.bootcamp.demo.demo_thymeleaf.model.dto.CryptoDTO;

public interface CryptoStockService {
  List<CryptoDTO> getStockInfo();
}
