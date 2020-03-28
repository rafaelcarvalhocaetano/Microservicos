package com.store.service;

import com.store.dto.BuyDTO;
import com.store.dto.InfoProviderDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BuyService {

  @Autowired
  private RestTemplate client;

	public void senBuy(BuyDTO buy) {

    // RestTemplate client = new RestTemplate();

    ResponseEntity<InfoProviderDTO> exchange = client.exchange(
      // "http://localhost:8081/info/" + buy.getAddress().getState(), 
      "http://flower-provider/info/" + buy.getAddress().getState(), 
      HttpMethod.GET, 
      null, 
      InfoProviderDTO.class);

      System.out.println(exchange.getBody().getAddress());
	}

  
}