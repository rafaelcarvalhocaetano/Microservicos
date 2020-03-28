package com.flower.provider.controller;

import com.flower.provider.model.InfoProvider;
import com.flower.provider.service.InfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * InfoController
 */
@RestController
@RequestMapping(value = "info")
public class InfoController {


  @Autowired
  private InfoService service;

  @GetMapping(value = "/{state}")
  public InfoProvider getInfoState(@PathVariable("state") String state) {
    return service.getInfoForState(state);
  }
}