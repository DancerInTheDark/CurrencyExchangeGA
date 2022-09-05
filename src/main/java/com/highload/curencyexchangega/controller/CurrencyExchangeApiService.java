package com.highload.curencyexchangega.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyExchangeApiService {

  @Value( "${ga.property-id}" )
  private String gaPropertyId;

  @Value( "${ga.rate-metric}" )
  private String gaRateMetric;

  public void sendExchangeRateToAnalytics(String rate, String date) {
    RestTemplate restTemplate = new RestTemplate();
    String baseUrl = "https://www.google-analytics.com/collect";
    String url_params = "?v=1&tid=" + gaPropertyId +
            "&cid=5555&t=event&ec=cr&ea=usd-uah&el=" + date +
            "&" + gaRateMetric + "=" + rate;

    String url = baseUrl + url_params;
    final HttpHeaders headers = new HttpHeaders();
    headers.set("User-Agent", "Chrome");
    final HttpEntity<String> entity = new HttpEntity<>(headers);
    restTemplate.postForObject(url, entity, String.class);
  }

}
