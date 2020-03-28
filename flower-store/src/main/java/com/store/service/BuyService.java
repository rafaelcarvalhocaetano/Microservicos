package com.store.service;

import com.store.dto.BuyDTO;
import com.store.dto.InfoProviderDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BuyService {

  @Autowired
  private RestTemplate client;
  
  @Autowired
  private DiscoveryClient eurekaClient;

	public void senBuy(BuyDTO buy) {

    // RestTemplate client = new RestTemplate();

    ResponseEntity<InfoProviderDTO> exchange = client.exchange(
      // "http://localhost:8081/info/" + buy.getAddress().getState(), 
      "http://flower-provider/info/" + buy.getAddress().getState(), 
      HttpMethod.GET, 
      null, 
      InfoProviderDTO.class);
    
	  eurekaClient.getInstances("flower-provider").stream().forEach(x -> {
	    System.out.println("FLOWER PROVIDER IN PORT " + x.getPort());
	    System.out.println("FLOWER PROVIDER IN HOST " + x.getHost());
	    System.out.println("FLOWER PROVIDER IN URI " + x.getUri());
	  });
    
    
      System.out.println(exchange.getBody().getAddress());
	}

  
}