package com.highload.curencyexchangega.controller;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NbuApiService {

  public String getUsdToUahRate(String date) {
    String currencyExchangeUrl =
            "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=USD&date=" + date + "&json";
    RestTemplate restTemplate = new RestTemplate();
    CurrencyExchangeRateDto[] exchangeRate =
            restTemplate.getForObject(
                    currencyExchangeUrl,
                    CurrencyExchangeRateDto[].class
            );
    return exchangeRate[0].getRate();
  }
}
