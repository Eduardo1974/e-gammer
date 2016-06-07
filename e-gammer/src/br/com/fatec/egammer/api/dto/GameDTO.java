package br.com.fatec.egammer.api.dto;

import java.util.Date;

import br.com.fatec.egammer.api.entity.Desenvolvedora;
import br.com.fatec.egammer.api.entity.Genero;

public class GameDTO {
	
	private Long gam_codigo;
	private String gam_titulo;
	private String gam_descricao;
	private Double gam_preco;
	private Integer gam_quantidade;
	private String gam_imagem;
	private String gam_imagem2;
	private String gam_imagem3;
	private String gam_imagem4;
	private String gam_classificacao;
	private Date gam_data_lancamento;
	private String gam_plataforma;
	private Genero genero;
	private Desenvolvedora desenvolvedora;
	private Long codigo;
	

	public Long getGam_codigo() {
		return gam_codigo;
	}

	public void setGam_codigo(Long gam_codigo) {
		this.gam_codigo = gam_codigo;
	}

	public String getGam_titulo() {
		return gam_titulo;
	}

	public void setGam_titulo(String gam_titulo) {
		this.gam_titulo = gam_titulo;
	}

	public String getGam_descricao() {
		return gam_descricao;
	}

	public void setGam_descricao(String gam_descricao) {
		this.gam_descricao = gam_descricao;
	}

	public Double getGam_preco() {
		return gam_preco;
	}

	public void setGam_preco(Double gam_preco) {
		this.gam_preco = gam_preco;
	}

	public Integer getGam_quantidade() {
		return gam_quantidade;
	}

	public void setGam_quantidade(Integer gam_quantidade) {
		this.gam_quantidade = gam_quantidade;
	}

	public String getGam_imagem() {
		return gam_imagem;
	}

	public void setGam_imagem(String gam_imagem) {
		this.gam_imagem = gam_imagem;
	}

	

	public Date getGam_data_lancamento() {
		return gam_data_lancamento;
	}

	public void setGam_data_lancamento(Date gam_data_lancamento) {
		this.gam_data_lancamento = gam_data_lancamento;
	}

	public String getGam_plataforma() {
		return gam_plataforma;
	}

	public void setGam_plataforma(String gam_plataforma) {
		this.gam_plataforma = gam_plataforma;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Desenvolvedora getDesenvolvedora() {
		return desenvolvedora;
	}

	public void setDesenvolvedora(Desenvolvedora desenvolvedora) {
		this.desenvolvedora = desenvolvedora;
	}

	public String getGam_classificacao() {
		return gam_classificacao;
	}

	public void setGam_classificacao(String gam_classificacao) {
		this.gam_classificacao = gam_classificacao;
	}

	public String getGam_imagem2() {
		return gam_imagem2;
	}

	public void setGam_imagem2(String gam_imagem2) {
		this.gam_imagem2 = gam_imagem2;
	}

	public String getGam_imagem3() {
		return gam_imagem3;
	}

	public void setGam_imagem3(String gam_imagem3) {
		this.gam_imagem3 = gam_imagem3;
	}

	public String getGam_imagem4() {
		return gam_imagem4;
	}

	public void setGam_imagem4(String gam_imagem4) {
		this.gam_imagem4 = gam_imagem4;
	}
	
	@Override
	public String toString(){
		return "Game[" + this.gam_codigo + " - " + this.gam_titulo + "]";
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

}
