package com.bootcamp.demo.demo_thymeleaf.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloworldPageController {
  @GetMapping(value = "/greeting")
  public String getHelloworldPage(Model model) {
    model.addAttribute("message", "Leo");
      return "helloworld"; // html file name
  }
}
