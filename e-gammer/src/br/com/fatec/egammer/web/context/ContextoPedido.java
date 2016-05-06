package br.com.fatec.egammer.web.context;

import java.io.Serializable;
import java.util.List;

import br.com.fatec.egammer.api.dto.PedidoDTO;

public class ContextoPedido implements Serializable{
	
	private static final long serialVersionUID = -4946584307036887149L;

	private PedidoDTO itemPedido;
	private List<PedidoDTO> itensPedido;
	
	public PedidoDTO getItemPedido() {
		return itemPedido;
	}
	public void setItemPedido(PedidoDTO itemPedido) {
		this.itemPedido = itemPedido;
	}
	public List<PedidoDTO> getItensPedido() {
		return itensPedido;
	}
	public void setItensPedido(List<PedidoDTO> itensPedido) {
		this.itensPedido = itensPedido;
	}
}
