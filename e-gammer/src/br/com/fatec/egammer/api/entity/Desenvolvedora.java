package br.com.fatec.egammer.api.entity;

import java.util.List;

import com.google.common.collect.Lists;

public class Desenvolvedora {
	
	public static final String TABLE = "DESENVOLVEDORA";
	public static final String COL_CODIGO = "DES_CODIGO";
	public static final String COL_STUDIO = "DES_STUDIO";
	public static final String COL_DISTRIBUIDORA = "DES_DISTRIBUIDORA";
	
	private Long des_codigo;
	private String des_studio;
	private String des_distribuidora;
	
	public Long getDes_codigo() {
		return des_codigo;
	}
	public void setDes_codigo(Long des_codigo) {
		this.des_codigo = des_codigo;
	}
	public String getDes_studio() {
		return des_studio;
	}
	public void setDes_studio(String des_studio) {
		this.des_studio = des_studio;
	}
	public String getDes_distribuidora() {
		return des_distribuidora;
	}
	public void setDes_distribuidora(String des_distribuidora) {
		this.des_distribuidora = des_distribuidora;
	}
	
	public static List<String> getColunas() {
		return Lists.newArrayList(COL_CODIGO, COL_STUDIO, COL_DISTRIBUIDORA);
	}

	public static String[] getColunasArray() {
		return new String[] { COL_CODIGO, COL_STUDIO, COL_DISTRIBUIDORA };
	}
}
