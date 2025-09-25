package com.bootcamp.demo.demo_sb_calculator.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.demo.demo_sb_calculator.util.Calculators;
import com.bootcamp.demo.demo_sb_calculator.util.Convertor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



// ! broswer -> web request ->
@Controller
@ResponseBody
public class CalculatorController {
  @GetMapping("/sum/{x}/{y}")
  public Integer sum(@PathVariable Integer x, @PathVariable Integer y) {
    return x + y;
  }

  @GetMapping("/substract/{x}/{y}")
  public Integer substract(@PathVariable Integer x, @PathVariable Integer y) {
    return x - y;
  }

  @GetMapping("/multiply/{x}/{y}")
  public Double multiply(@PathVariable(value = "x") Double salary,
      @PathVariable(value = "y") Double months) {
    return BigDecimal.valueOf(salary).multiply(BigDecimal.valueOf(months))
        .setScale(2).doubleValue();
  }

  @GetMapping("/averagecandy/{x}/{y}")
  public Double divide(@PathVariable(value = "x") Integer candyCount,
      @PathVariable(value = "y") Integer personCount) {
    return BigDecimal.valueOf(candyCount)
        .divide(BigDecimal.valueOf(personCount), 2, RoundingMode.HALF_UP)
        .doubleValue();
  }

  @GetMapping("/stringsum/{x}/{y}")
  public Double stringsum(@PathVariable String x, @PathVariable String y) {
    // x can be anything
    // how to convert x to number?
    double x1, y1;
    try {
      x1 = Double.valueOf(x);
    } catch (NumberFormatException e) {
      return -1.0;
    }

    try {
      y1 = Double.valueOf(y);
    } catch (NumberFormatException e) {
      return -99.0;
    }
    return x1 + y1;
  }

  // Example: Combine sum/substract/multiply/divide into one API
  // User input: sum/substract/multiply/divide, x, y
  @GetMapping("/stringcalculator/{operaiotn}/{x}/{y}")
  public Double stringCalculator(@PathVariable String operation,
      @PathVariable String x, @PathVariable String y) {
    if (operation == null)
      return -999.0;
    Convertor c = new Convertor();
    return switch (operation) {
      case "sum" -> Calculators.sum(c.convert(x), c.convert(y));
      case "subtract" -> Calculators.subtract(c.convert(x), c.convert(y));
      case "multiply" -> Calculators.multiply(c.convert(x), c.convert(y));
      case "divide" -> Calculators.divide(c.convert(x), c.convert(y));
      default -> -999.0;
    };
  }
}
