package br.com.fatec.egammer.api.dto;

import br.com.fatec.egammer.api.entity.Game;

public class ItemPedidoDTO {
	
	private Long itp_codigo;
	private Double itp_preco_unitario;
	private Integer itp_quantidade;
	private  Double ipt_preco_total;
	private Long gam_codigo;
	private Long ped_codigo;
	
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

	public Long getPed_codigo() {
		return ped_codigo;
	}

	public void setPed_codigo(Long ped_codigo) {
		this.ped_codigo = ped_codigo;
	}
	
	@Override
	public String toString(){
		return "ItemPedido" + this.itp_codigo + " - " + this.ipt_preco_total + "]";
	}

	public Long getGam_codigo() {
		return gam_codigo;
	}

	public void setGam_codigo(Long gam_codigo) {
		this.gam_codigo = gam_codigo;
	}
}
