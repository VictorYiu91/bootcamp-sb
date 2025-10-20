package com.bootcamp.demo.demo_thymeleaf.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_thymeleaf.model.dto.CoinDTO;
import com.bootcamp.demo.demo_thymeleaf.service.CoinService;


@Service
public class CoinServiceImpl implements CoinService {
  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<CoinDTO> getCoins() {
    String url =
        "https://api.coingecko.com/api/v3/coins/markets?ids=bitcoin,ethereum,tether&vs_currency=usd";
    return Arrays.asList(this.restTemplate.getForObject(url, CoinDTO[].class));
  }
}
