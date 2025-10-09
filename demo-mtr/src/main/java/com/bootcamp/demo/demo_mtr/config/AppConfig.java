package com.bootcamp.demo.demo_mtr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_mtr.codelib.RedisManager;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class AppConfig {
  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }

  // ! pom.xml -> class
  // RedisTemplate<String, String> -> key (String), value (String)
  // ! Redis is something like HashMap
  
  //@Bean
  //RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
    //RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
    //redisTemplate.setConnectionFactory(factory);
    //redisTemplate.setKeySerializer(RedisSerializer.string());
    //redisTemplate.setValueSerializer(RedisSerializer.json());
    //redisTemplate.afterPropertiesSet();
    //return redisTemplate;
  //}

  @Bean
  RedisManager redisManager(RedisConnectionFactory factory,
      ObjectMapper objectMapper) {
    return new RedisManager(factory, objectMapper);
  }

  // ObjectMapper object is stateless?
  // f(x) = y
  @Bean
  ObjectMapper objectMapper() {
    return new ObjectMapper();
  }

}
