package br.com.microservice.fornecedor.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservice.fornecedor.dto.ItemDoPedidoDTO;
import br.com.microservice.fornecedor.model.Pedido;
import br.com.microservice.fornecedor.service.PedidoService;

@RestController
@RequestMapping(value = "pedido")
public class PedidoController {

	private static final Logger LOG = LoggerFactory.getLogger(PedidoController.class);
	
	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping
	public Pedido realizaPedido(@RequestBody List<ItemDoPedidoDTO> produtos) {
		LOG.info("ENVIANDO PEDIDO PARA {}", produtos);
		return pedidoService.realizaPedido(produtos);
	}
	
	@GetMapping(value = "/{id}")
	public Pedido getPedidoPorId(@PathVariable Long id) {
		LOG.info("RECEBDNO DE {}");
		return pedidoService.getPedidoPorId(id);
	}
}
