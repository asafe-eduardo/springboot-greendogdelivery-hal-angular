package com.boaglio.casadocodigo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.boaglio.casadocodigo.dto.RespostaDTO;
import com.boaglio.casadocodigo.model.Cliente;
import com.boaglio.casadocodigo.model.Item;
import com.boaglio.casadocodigo.model.Pedido;
import com.boaglio.casadocodigo.repositories.ClienteRepository;
import com.boaglio.casadocodigo.repositories.ItemRepository;

@RestController
public class NovoPedidoController {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ItemRepository itemRepository;
	
	@GetMapping("/rest/pedido/novo/{clienteId}/{listaDeItens}")
	public RespostaDTO novo(@PathVariable("clienteId") Long clienteId,
			@PathVariable("listaDeItens") String listaDeItens) {
		RespostaDTO dto = new RespostaDTO();
		
		try {
			Cliente c = clienteRepository.findById(clienteId).get();
			String[] listaDeItensID = listaDeItens.split(",");
			Pedido pedido = new Pedido();
			double valorTotal = 0;
			List<Item> itensPedidos = new ArrayList<Item>();
			for (String itemID : listaDeItensID) {
				Item item = itemRepository.findById(Long.parseLong(itemID)).get();
				itensPedidos.add(item);
				valorTotal += item.getPreco();
			}
			pedido.setItens(itensPedidos);
			pedido.setValorTotal(valorTotal);
			pedido.setData(new Date());
			pedido.setCliente(c);
			c.getPedidos().add(pedido);
			this.clienteRepository.saveAndFlush(c);
			List<Long> pedidosID = new ArrayList<Long>();
			for (Pedido p : c.getPedidos()) {
				pedidosID.add(p.getId());
			}
			Long ultimoPedido = Collections.max(pedidosID);
			dto = new RespostaDTO(valorTotal, ultimoPedido, "Pedido efetuado com suceso");
		} catch (Exception e ) {
			dto.setMensagem("Erro: " + e.getMessage());
		}
		
		return dto;
	}
	
}
