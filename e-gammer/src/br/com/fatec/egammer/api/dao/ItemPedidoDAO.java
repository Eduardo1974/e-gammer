package br.com.fatec.egammer.api.dao;

import java.util.List;

import br.com.fatec.egammer.api.entity.ItemPedido;

public interface ItemPedidoDAO {

	Long save(ItemPedido itemPedido);

	boolean update(ItemPedido itemPedido);

	boolean delete(Long codigo);

	ItemPedido buscaCodigoItemPedido(Long codigo);
	
	List<ItemPedido> buscaTodosItensDoPedido(Long codigo);
}
