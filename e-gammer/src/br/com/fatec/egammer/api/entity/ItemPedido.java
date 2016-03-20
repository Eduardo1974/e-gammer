package br.com.fatec.egammer.api.entity;

public class ItemPedido {
	
	public static final String TABLE = "ITEM_DO_PEDIDO";
	public static final String COL_CODIGO = "ITP_CODIGO";
	public static final String COL_TITULO = "ITP_PRECO_UNITARIO";
	public static final String COL_QUANTIDADE = "ITP_QUANTIDADE";
	public static final String COL_PRECO_TATAL = "ITP_PRECO_TOTAL";
	public static final String COL_GAM_CODIGO = "GAM_CODIGO";
	public static final String COL_PED_CODIGO = "PED_CODIGO";
	
	private Long itp_codigo;
	private Double itp_preco_unitario;
	private Integer itp_quantidade;
	private  Double ipt_preco_total;
	private Game game;
	private Pedido pedido;
	
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
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
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
	public static String getColQuantidade() {
		return COL_QUANTIDADE;
	}
	public static String getColPrecoTatal() {
		return COL_PRECO_TATAL;
	}
	public static String getColGamCodigo() {
		return COL_GAM_CODIGO;
	}
	public static String getColPedCodigo() {
		return COL_PED_CODIGO;
	}
}