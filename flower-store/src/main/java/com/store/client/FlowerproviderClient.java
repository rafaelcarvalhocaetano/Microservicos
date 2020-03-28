package com.store.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.store.dto.InfoProviderDTO;
import com.store.dto.InfoRequestDTO;
import com.store.dto.ItemBuyDTO;

@FeignClient("flower-provider")
public interface FlowerproviderClient {

	@GetMapping(value = "/info/{state}")
	InfoProviderDTO getInfoState(@PathVariable("state") String state);

//	@PostMapping(value = "/pedido")
	@RequestMapping(method=RequestMethod.POST, value="/pedido")
	InfoRequestDTO sendProvider(List<ItemBuyDTO> items);
}
