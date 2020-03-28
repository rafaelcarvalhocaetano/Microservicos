package com.store.service;

import com.store.client.FlowerproviderClient;
import com.store.dto.BuyDTO;
import com.store.dto.InfoProviderDTO;
import com.store.dto.InfoRequestDTO;
import com.store.model.Buy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class BuyService {

	/*
	 * @Autowired private RestTemplate client;
	 * 
	 * @Autowired private DiscoveryClient eurekaClient;
	 */
	private static final Logger LOG = LoggerFactory.getLogger(BuyService.class);
	
	@Autowired
	private FlowerproviderClient client;

	public Buy sendBuy(BuyDTO buy) {

		final String state = buy.getAddress().getState();
		
		LOG.info("SEARCH INFO 00001 ::::: ", state);
		InfoProviderDTO info = client.getInfoState(buy.getAddress().getState());
		
		LOG.info("REQ KJU765FGHT5Yu898 ::::: ");
		InfoRequestDTO req = client.sendProvider(buy);
		
		Buy buyModel = new Buy();
		buyModel.setPedidoId(req.getId());
		buyModel.setTempoDePreparo(req.getTimePreparation());
		buyModel.setEnderecoDestino(buy.getAddress().toString());
		LOG.info("INFO :::::::::::::::::::: ", info);
		return buyModel;
	}
	
	
	// RestTemplate client = new RestTemplate();
	/*
	 * ResponseEntity<InfoProviderDTO> exchange = client.exchange( //
	 * "http://localhost:8081/info/" + buy.getAddress().getState(),
	 * "http://flower-provider/info/" + buy.getAddress().getState(), HttpMethod.GET,
	 * null, InfoProviderDTO.class);

	 * eurekaClient.getInstances("flower-provider").stream().forEach(x -> {
	 * System.out.println("FLOWER PROVIDER IN PORT " + x.getPort());
	 * System.out.println("FLOWER PROVIDER IN HOST " + x.getHost());
	 * System.out.println("FLOWER PROVIDER IN URI " + x.getUri()); });

	 * System.out.println(exchange.getBody().getAddress());
	 */

}
