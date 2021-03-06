package br.com.fatec.egammer.api.entity;

import java.util.Date;
import java.util.List;

import com.google.common.collect.Lists;

public class Pedido {
	
	public static final String TABLE = "PEDIDO";
	public static final String COL_CODIGO = "PED_CODIGO";
	public static final String COL_DATA = "PED_DATA";
	public static final String COL_PED_VALOR_TOTAL = "PED_VALOR_TOTAL";
	public static final String COL_CLI_CODIGO = "CLI_CODIGO";
	
	private Long ped_codigo;
	private Date ped_data;
	private Double ped_valor_total;
	private Cliente cliente;
	private List<ItemPedido> itensPedido;
	
	
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
	
	public List<ItemPedido> getItensPedido() {
		return itensPedido;
	}
	public void setItensPedido(List<ItemPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}
	
	public static List<String> getColunas() {
		return Lists.newArrayList(COL_CODIGO,COL_DATA, COL_PED_VALOR_TOTAL,COL_CLI_CODIGO);
	}

	public static String[] getColunasArray() {
		return new String[] {COL_CODIGO,COL_DATA, COL_PED_VALOR_TOTAL,COL_CLI_CODIGO};
	}
	
}
