package com.bootcamp.demo.demo_sb_calculator.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculators {
  public static Double sum(Double x, Double y) {
    return BigDecimal.valueOf(x).add(BigDecimal.valueOf(y)).doubleValue();
  }

  public static Double subtract(Double x, Double y) {
    return BigDecimal.valueOf(x).subtract(BigDecimal.valueOf(y)).doubleValue();
  }

  public static Double multiply(Double x, Double y) {
    return BigDecimal.valueOf(x).multiply(BigDecimal.valueOf(y)).doubleValue();
  }

  public static Double divide(Double x, Double y) {
    return BigDecimal.valueOf(x)
        .divide(BigDecimal.valueOf(y), 2, RoundingMode.HALF_UP).doubleValue();
  }
}