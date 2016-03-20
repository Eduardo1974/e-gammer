package br.com.fatec.egammer.api.entity;

public class Genero {
	
	public static final String TABLE = "GENERO";
	public static final String COL_CODIGO = "GEN_CODIGO";
	public static final String COL_NOME = "GEN_NOME";
	
	private Long gen_codigo;
	private String gen_nome;
	
	public Long getGen_codigo() {
		return gen_codigo;
	}
	public void setGen_codigo(Long gen_codigo) {
		this.gen_codigo = gen_codigo;
	}
	public String getGen_nome() {
		return gen_nome;
	}
	public void setGen_nome(String gen_nome) {
		this.gen_nome = gen_nome;
	}
}