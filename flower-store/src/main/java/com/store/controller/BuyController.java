package com.store.controller;

import com.store.dto.BuyDTO;
import com.store.model.Buy;
import com.store.service.BuyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "buy")
public class BuyController {


  @Autowired
  private BuyService service;


  @PostMapping
  public Buy buyStore(@RequestBody BuyDTO buy) {
    return service.sendBuy(buy);
  }
  
}