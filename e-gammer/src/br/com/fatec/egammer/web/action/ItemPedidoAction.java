package br.com.fatec.egammer.web.action;

import java.util.List;

import br.com.fatec.egammer.api.dto.ItemPedidoDTO;

public class ItemPedidoAction extends ProjetoWebAction{
	
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
