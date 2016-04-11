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
	private Integer gam_classificacao;
	private Date gam_data_lancamento;
	private String gam_plataforma;
	private Genero genero;
	private Desenvolvedora desenvolvedora;
	
	public GameDTO(){
		
	}

	public GameDTO(Long gam_codigo, String gam_titulo, String gam_descricao, Double gam_preco, Integer gam_quantidade,
			String gam_imagem, Integer gam_classificacao, Date gam_data_lancamento, String gam_plataforma,
			Genero genero, Desenvolvedora desenvolvedora) {
		super();
		this.gam_codigo = gam_codigo;
		this.gam_titulo = gam_titulo;
		this.gam_descricao = gam_descricao;
		this.gam_preco = gam_preco;
		this.gam_quantidade = gam_quantidade;
		this.gam_imagem = gam_imagem;
		this.gam_classificacao = gam_classificacao;
		this.gam_data_lancamento = gam_data_lancamento;
		this.gam_plataforma = gam_plataforma;
		this.genero = genero;
		this.desenvolvedora = desenvolvedora;
	}

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

	public Integer getGam_classificacao() {
		return gam_classificacao;
	}

	public void setGam_classificacao(Integer gam_classificacao) {
		this.gam_classificacao = gam_classificacao;
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
	
	@Override
	public String toString(){
		return "Game[" + this.gam_codigo + " - " + this.gam_titulo + "]";
	}

}
