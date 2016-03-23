package br.com.fatec.egammer.api.entity;

import java.util.Date;

public class Game {
	
	public static final String TABLE = "GAME";
	public static final String COL_CODIGO = "GAM_CODIGO";
	public static final String COL_TITULO = "GAM_TITULO";
	public static final String COL_DESCRICAO = "GAM_DESCRICAO";
	public static final String COL_PRECO = "GAM_PRECO";
	public static final String COL_QUANTIDADE = "GAM_QUANTIDADE";
	public static final String COL_IMAGEM = "GAM_IMAGEM";
	public static final String COL_CLASSIFICACAO = "GAM_CLASSIFICACAO";
	public static final String COL_DATA_LANCAMENTO = "GAM_FATA_LANCAMENTO";
	public static final String COL_PLATAFORMA = "GAM_PLATAFORMA";
	public static final String COL_GEN_CODIGO = "GEN_CODIGO";
	public static final String COL_DES_CODIGO = "DES_CODIGO";
	
	private Long gam_codigo;
	private String gam_titulo;
	private String gam_desccricao;
	private Double gam_preco;
	private Integer gam_quantidade;
	private String gam_imagem;
	private Integer gam_classificacao;
	private Date gam_data_lancamento;
	private String gam_plataforma;
	private Genero genero;
	private Desenvolvedora desenvolvedora;
	
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
	public String getGam_desccricao() {
		return gam_desccricao;
	}
	public void setGam_desccricao(String gam_desccricao) {
		this.gam_desccricao = gam_desccricao;
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
	public static String getTable() {
		return TABLE;
	}
	public static String getColCodigo() {
		return COL_CODIGO;
	}
	public static String getColTitulo() {
		return COL_TITULO;
	}
	public static String getColDescricao() {
		return COL_DESCRICAO;
	}
	public static String getColPreco() {
		return COL_PRECO;
	}
	public static String getColQuantidade() {
		return COL_QUANTIDADE;
	}
	public static String getColImagem() {
		return COL_IMAGEM;
	}
	public static String getColClassificacao() {
		return COL_CLASSIFICACAO;
	}
	public static String getColDataLancamento() {
		return COL_DATA_LANCAMENTO;
	}
	public static String getColPlataforma() {
		return COL_PLATAFORMA;
	}
	public static String getColGenCodigo() {
		return COL_GEN_CODIGO;
	}
	public static String getColDesCodigo() {
		return COL_DES_CODIGO;
	}
}
