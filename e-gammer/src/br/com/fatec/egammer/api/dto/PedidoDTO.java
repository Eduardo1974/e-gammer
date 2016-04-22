package br.com.fatec.egammer.api.dto;

import java.util.Date;
import java.util.List;

import com.google.common.collect.Lists;

import br.com.fatec.egammer.api.entity.Cliente;
import br.com.fatec.egammer.api.entity.ItemPedido;

public class PedidoDTO {
	
	private Long ped_codigo;
	private Date ped_data;
	private Double ped_valor_total;
	private Cliente cliente;
	private List<ItemPedido> itensPedidos = Lists.newArrayList();
	
	public Long getPed_codigo() {
		return ped_codigo;
	}

	public void setPed_codigo(Long ped_codigo) {
		this.ped_codigo = ped_codigo;
	}

	public Date getPed_data() {
		return ped_data;
	}

	public void setPed_data(Date ped_data) {
		this.ped_data = ped_data;
	}

	public Double getPed_valor_total() {
		return ped_valor_total;
	}

	public void setPed_valor_total(Double ped_valor_total) {
		this.ped_valor_total = ped_valor_total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@Override
	public String toString(){
		return "Pedido[" + this.ped_codigo + " - " + this.ped_valor_total + "]";
	}


	public List<ItemPedido> getItensPedidos() {
		return itensPedidos;
	}

	public void setItensPedidos(List<ItemPedido> itensPedidos) {
		this.itensPedidos = itensPedidos;
	}
	
	

}
