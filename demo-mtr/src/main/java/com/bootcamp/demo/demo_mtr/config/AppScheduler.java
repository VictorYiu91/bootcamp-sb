package com.bootcamp.demo.demo_mtr.config;

import java.time.Duration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AppScheduler {

  // @Scheduled(fixedDelay = 5000) // 5000ms
  public void sayHi() throws InterruptedException {
    Thread.sleep(Duration.ofSeconds(6));
    System.out.println("hello" + System.currentTimeMillis());
  }

  // @Scheduled(fixedRate = 3000)
  public void sayBye() throws InterruptedException{
    Thread.sleep(Duration.ofSeconds(4));
    System.out.println("Goodbye" + System.currentTimeMillis());
  }

  // @Scheduled(cron = "0 17 16 * * THU")
  public void testCronJob() {
    System.out.println("test cron job");
  }
}
