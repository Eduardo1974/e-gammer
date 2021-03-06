package br.com.fatec.egammer.api.entity;

import java.util.List;

import com.google.common.collect.Lists;

public class ItemPedido {
	
	public static final String TABLE = "ITEM_DO_PEDIDO";
	public static final String COL_CODIGO = "ITP_CODIGO";
	public static final String COL_PRECO_UNITARIO = "ITP_PRECO_UNITARIO";
	public static final String COL_QUANTIDADE = "ITP_QUANTIDADE";
	public static final String COL_PRECO_TOTAL = "ITP_PRECO_TOTAL";
	public static final String COL_GAM_CODIGO = "GAM_CODIGO";
	public static final String COL_PED_CODIGO = "PED_CODIGO";
	
	private Long itp_codigo;
	private Double itp_preco_unitario;
	private Integer itp_quantidade;
	private  Double ipt_preco_total;
	private Long ped_codigo;
	private Long gam_codigo;
	
	
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
	public Long getGam_codigo() {
		return gam_codigo;
	}
	public void setGam_codigo(Long gam_codigo) {
		this.gam_codigo = gam_codigo;
	}
	public static List<String> getColunas() {
		return Lists.newArrayList(COL_CODIGO,COL_PRECO_UNITARIO, COL_QUANTIDADE,COL_PRECO_TOTAL,COL_PED_CODIGO,COL_GAM_CODIGO );
	}

	public static String[] getColunasArray() {
		return new String[] {COL_CODIGO,COL_PRECO_UNITARIO,COL_QUANTIDADE,COL_PRECO_TOTAL,COL_PED_CODIGO,COL_GAM_CODIGO};
	}
}
