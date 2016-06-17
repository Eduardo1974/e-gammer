package br.com.fatec.egammer.web.context;

import java.io.Serializable;
import java.util.List;

import br.com.fatec.egammer.api.dto.PedidoDTO;

public class ContextoPedido implements Serializable{
	
	private static final long serialVersionUID = -4946584307036887149L;

	private PedidoDTO pedido;
	private List<PedidoDTO> pedidos;
	
	public PedidoDTO getPedido() {
		return pedido;
	}
	public void setPedido(PedidoDTO pedido) {
		this.pedido = pedido;
	}
	public List<PedidoDTO> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<PedidoDTO> pedidos) {
		this.pedidos = pedidos;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
