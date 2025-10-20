package com.bootcamp.demo.demo_thymeleaf.view;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.demo.demo_thymeleaf.model.dto.CoinDTO;
import com.bootcamp.demo.demo_thymeleaf.service.CoinService;

@Controller
public class CoinPage {
  @Autowired
  private CoinService coinService;

  @GetMapping("/coinpage")
  public String getCoinPage(Model model) {
    List<CoinDTO> coinDTOs = this.coinService.getCoins();
    System.out.println(coinDTOs);
    model.addAttribute("coins", coinDTOs);
    return "coinpage";
  }
}