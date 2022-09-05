package com.highload.curencyexchangega;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class CurrencyExchangeGaApplication {

  public static void main(String[] args) {
    SpringApplication.run(CurrencyExchangeGaApplication.class, args);
  }

}
