package br.com.fatec.egammer.api.entity;

import java.util.Date;
import java.util.List;

import com.google.common.collect.Lists;

public class Game {
	
	public static final String TABLE = "GAME";
	public static final String COL_CODIGO = "GAM_CODIGO";
	public static final String COL_TITULO = "GAM_TITULO";
	public static final String COL_DESCRICAO = "GAM_DESCRICAO";
	public static final String COL_PRECO = "GAM_PRECO";
	public static final String COL_QUANTIDADE = "GAM_QUANTIDADE";
	public static final String COL_IMAGEM = "GAM_IMAGEM";
	public static final String COL_CLASSIFICACAO = "GAM_CLASSIFICACAO";
	public static final String COL_DATA_LANCAMENTO = "GAM_DATA_LANCAMENTO";
	public static final String COL_PLATAFORMA = "GAM_PLATAFORMA";
	public static final String COL_GEN_CODIGO = "GEN_CODIGO";
	public static final String COL_DES_CODIGO = "DES_CODIGO";
	
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
	
	public static List<String> getColunas() {
		return Lists.newArrayList(COL_CODIGO, COL_TITULO, COL_DESCRICAO, COL_PRECO,
				COL_QUANTIDADE, COL_IMAGEM, COL_CLASSIFICACAO, COL_DATA_LANCAMENTO,
				COL_PLATAFORMA, COL_GEN_CODIGO, COL_DES_CODIGO);
	}

	public static String[] getColunasArray() {
		return new String[] { COL_CODIGO, COL_TITULO, COL_DESCRICAO, COL_PRECO,
				COL_QUANTIDADE, COL_IMAGEM, COL_CLASSIFICACAO, COL_DATA_LANCAMENTO,
				COL_PLATAFORMA, COL_GEN_CODIGO, COL_DES_CODIGO };
	}
	
}
