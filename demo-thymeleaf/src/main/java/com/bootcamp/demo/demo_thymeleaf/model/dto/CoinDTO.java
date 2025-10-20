package com.bootcamp.demo.demo_thymeleaf.model.dto;

import java.time.LocalDateTime;
import com.bootcamp.demo.demo_thymeleaf.util.HKTimestampDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CoinDTO {
  private String id;
  private String symbol;
  private String name;
  private String image;
  @JsonProperty("current_price")
  private Double currentPrice;
  @JsonProperty("market_cap")
  private Long marketCap;
  @JsonProperty("price_change_percentage_24h")
  private Double priceChangePercent24h;
  @JsonProperty("last_updated")
  // ! From UTC to UTC+8
  @JsonDeserialize(using = HKTimestampDeserializer.class)
  private LocalDateTime lastUpdated;
}