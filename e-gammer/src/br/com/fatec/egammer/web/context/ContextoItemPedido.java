package br.com.fatec.egammer.web.context;

import java.io.Serializable;
import java.util.List;

import br.com.fatec.egammer.api.dto.ItemPedidoDTO;

public class ContextoItemPedido implements Serializable{
	private static final long serialVersionUID = -4946584307036887149L;

	private ItemPedidoDTO itemPedido;
	private List<ItemPedidoDTO> itensPedido;
	
	public ItemPedidoDTO getItemPedido() {
		return itemPedido;
	}
	public void setItemPedido(ItemPedidoDTO itemPedido) {
		this.itemPedido = itemPedido;
	}
	public List<ItemPedidoDTO> getItensPedido() {
		return itensPedido;
	}
	public void setItensPedido(List<ItemPedidoDTO> itensPedido) {
		this.itensPedido = itensPedido;
	}
}
