package com.bootcamp.bc_forum.yahoo;

import java.net.URI;
import java.net.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FinanceService {

  @Autowired
  private RestTemplate restTemplate;

  private String cookies;

  // @Cacheable("crumb")
  public synchronized String getCrumb() {
    log.info("CrumbManager.getCrumb() : {}", CrumbManager.getCrumb());
    log.info("CrumbManager.getCookie() : {}", CrumbManager.getCookie());
    return CrumbManager.getCrumb();
  }

  public String fetchDataWithCrumb(String crumb) {
    String url =
        "https://query1.finance.yahoo.com/v7/finance/quote?symbols=0005.HK&crumb="
            + this.getCrumb();
    HttpHeaders headers = new HttpHeaders();
    headers.add("Cookie", CrumbManager.getCookie()); // reuse cookies from the first request
    HttpEntity<String> entity = new HttpEntity<>(headers);
    ResponseEntity<String> response =
        restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    return response.getBody(); // returns the response body
  }

}
