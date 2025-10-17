package com.bootcamp.demo.demo_thymeleaf.view;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.demo.demo_thymeleaf.model.dto.CryptoDTO;
import com.bootcamp.demo.demo_thymeleaf.service.CryptoStockService;

@Controller
public class CryptoStockPageController {
  @Autowired
  private CryptoStockService cryptoStockService;

  @GetMapping(value = "/cryptostock")
  public String getCyrptoStockPage(Model model) {
    List<CryptoDTO> cryptoStock = this.cryptoStockService.getStockInfo();
    model.addAttribute("cryptoStock", cryptoStock);
    return "cryptostock";
  }
}
