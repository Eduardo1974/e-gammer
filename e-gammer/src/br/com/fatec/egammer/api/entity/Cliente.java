package br.com.fatec.egammer.api.entity;

import java.util.List;

import com.google.common.collect.Lists;

public class Cliente {
	
	public static final String TABLE = "CLIENTE";
	public static final String COL_CODIGO = "CLI_CODIGO";
	public static final String COL_NOME = "CLI_NOME";
	public static final String COL_EMAIL = "CLI_EMAIL";
	public static final String COL_SENHA = "CLI_SENHA";
	
	private Long cli_codigo;
	private String cli_nome;
	private String cli_email;
	private String cli_senha;
	
	public Long getCli_codigo() {
		return cli_codigo;
	}
	public void setCli_codigo(Long cli_codigo) {
		this.cli_codigo = cli_codigo;
	}
	public String getCli_nome() {
		return cli_nome;
	}
	public void setCli_nome(String cli_nome) {
		this.cli_nome = cli_nome;
	}
	public String getCli_email() {
		return cli_email;
	}
	public void setCli_email(String cli_email) {
		this.cli_email = cli_email;
	}
	public String getCli_senha() {
		return cli_senha;
	}
	public void setCli_senha(String cli_senha) {
		this.cli_senha = cli_senha;
	}
	public static List<String> getColunas() {
		return Lists.newArrayList(COL_CODIGO, COL_NOME, COL_EMAIL, COL_SENHA);
	}

	public static String[] getColunasArray() {
		return new String[] { COL_CODIGO, COL_NOME, COL_EMAIL, COL_SENHA };
	}
}
