package com.bootcamp.demo.demo_sb_helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HelloworldController {
  @GetMapping(value = "/helloworld")
  public String greeting() {
      return "hello world! welcome to bootcamp!!!";
  }
  @GetMapping(value = "/sum/{x}/{y}")
  public Integer sum (@PathVariable Integer x,@PathVariable Integer y) {
    return x + y;
  }

  // Integer, Double, String, Boolean
  // BigDecimal, LocalDate

  // input String name, int age -> return Person Object
  @GetMapping(value = "/createPerson/{x}/{y}")
  public Person createPerson (@PathVariable(value = "x") String name, @PathVariable(value = "y") Integer age) {
    return new Person(name, age);
  }
}
