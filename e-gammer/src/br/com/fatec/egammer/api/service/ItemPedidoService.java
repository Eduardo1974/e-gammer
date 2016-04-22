package br.com.fatec.egammer.api.service;

import java.util.List;

import br.com.fatec.egammer.api.dto.ItemPedidoDTO;

public interface ItemPedidoService {
	
	ItemPedidoDTO salvar(ItemPedidoDTO itemPedido);

	void atualizar(ItemPedidoDTO itemPedido);

	void deletar(Long itemPedidoId);

	ItemPedidoDTO buscarPorId(Long itemPedidoId);

	List<ItemPedidoDTO> listar(Long pedCodigo);

}
