package br.com.fatec.egammer.api.dto;

import br.com.fatec.egammer.api.entity.Game;
import br.com.fatec.egammer.api.entity.Pedido;

public class ItemPedidoDTO {
	
	private Long itp_codigo;
	private Double itp_preco_unitario;
	private Integer itp_quantidade;
	private  Double ipt_preco_total;
	private Game game;
	private Pedido pedido;
	
	public ItemPedidoDTO(){
		
	}

	public ItemPedidoDTO(Long itp_codigo, Double itp_preco_unitario, Integer itp_quantidade, Double ipt_preco_total,
			Game game, Pedido pedido) {
		super();
		this.itp_codigo = itp_codigo;
		this.itp_preco_unitario = itp_preco_unitario;
		this.itp_quantidade = itp_quantidade;
		this.ipt_preco_total = ipt_preco_total;
		this.game = game;
		this.pedido = pedido;
	}

	public Long getItp_codigo() {
		return itp_codigo;
	}

	public void setItp_codigo(Long itp_codigo) {
		this.itp_codigo = itp_codigo;
	}

	public Double getItp_preco_unitario() {
		return itp_preco_unitario;
	}

	public void setItp_preco_unitario(Double itp_preco_unitario) {
		this.itp_preco_unitario = itp_preco_unitario;
	}

	public Integer getItp_quantidade() {
		return itp_quantidade;
	}

	public void setItp_quantidade(Integer itp_quantidade) {
		this.itp_quantidade = itp_quantidade;
	}

	public Double getIpt_preco_total() {
		return ipt_preco_total;
	}

	public void setIpt_preco_total(Double ipt_preco_total) {
		this.ipt_preco_total = ipt_preco_total;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	@Override
	public String toString(){
		return "ItemPedido" + this.itp_codigo + " - " + this.ipt_preco_total + "]";
	}

}
