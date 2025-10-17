package com.bootcamp.demo.demo_thymeleaf.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_thymeleaf.model.dto.CryptoDTO;
import com.bootcamp.demo.demo_thymeleaf.service.CryptoStockService;

@Service
public class CryptoStockServiceImpl implements CryptoStockService {
  @Autowired
  private RestTemplate restTemplate;

  private static final String url =
      "https://api.coingecko.com/api/v3/coins/markets?ids=bitcoin,ethereum,tether&vs_currency=usd";

  @Override
  public List<CryptoDTO> getStockInfo() {
    return Arrays.asList(this.restTemplate.getForObject(url, CryptoDTO[].class));
  }
}
