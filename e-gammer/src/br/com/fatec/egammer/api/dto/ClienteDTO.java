package br.com.fatec.egammer.api.dto;

import java.util.List;

import com.google.common.collect.Lists;

import br.com.fatec.egammer.api.entity.Pedido;

public class ClienteDTO {
	
	private Long cli_codigo;
	private String cli_nome;
	private String cli_email;
	private String cli_senha;
	private List<Pedido> pedidos = Lists.newArrayList();
	
	
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
	
	@Override
	public String toString(){
		return "Cliente[" + this.cli_codigo + " - " + this.cli_nome + "]";
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}


}
