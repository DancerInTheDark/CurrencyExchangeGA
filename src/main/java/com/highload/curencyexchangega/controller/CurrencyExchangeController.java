package com.highload.curencyexchangega.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/currency/exchange")
public class CurrencyExchangeController {

  private final CurrencyExchangeApiService currencyExchangeApiService;
  private final NbuApiService nbuApiService;

  @GetMapping("/rate")
  @Scheduled(fixedRateString = "2000")
  public void sendExchangeRateData() {
    Date currentDate = new Date();
    DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
    String date = formatter.format(currentDate);

    String rate = nbuApiService.getUsdToUahRate(date);
    System.out.println("Rate: " + rate);
    currencyExchangeApiService.sendExchangeRateToAnalytics(rate, date);
  }
}
