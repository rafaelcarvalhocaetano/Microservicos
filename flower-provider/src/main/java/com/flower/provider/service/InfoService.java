package com.flower.provider.service;

import com.flower.provider.model.InfoProvider;
import com.flower.provider.repository.InfoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * InfoService
 */
@Service
public class InfoService {

  @Autowired
  private InfoRepository repository;

	public InfoProvider getInfoForState(String state) {
    return repository.findByState(state);
	}

  
}