package br.com.fatec.egammer.web.action;

import br.com.fatec.egammer.api.service.GameService;
import br.com.fatec.egammer.api.service.PedidoService;
import br.com.fatec.egammer.web.context.ContextoGame;
import br.com.fatec.egammer.web.context.ContextoPedido;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class PedidoAction extends ProjetoWebAction{
	
	private static final long serialVersionUID = 1071989853380980252L;
	private static final String SUCESS = "success";

	private ContextoPedido contexto = new ContextoPedido();
	private PedidoService service;

	public PedidoAction() {
		this.service = ImplFinder.getImpl(PedidoService.class);
	}
	
	public String listar() {
		
		this.contexto.setPedidos(this.service.listar(this.contexto.getPedido().getCliente().getCli_codigo()));
		return SUCESS;
	}

	public String salvar() {
		if (this.contexto.getPedido().getPed_codigo() != null) {
			this.service.atualizar(this.contexto.getPedido());
		} else {
			this.service.salvar(this.contexto.getPedido());
		}
		return SUCESS;
		//return this.listar();
	}

	public ContextoPedido getContexto() {
		return this.contexto;
	}

	public void setContexto(ContextoPedido contexto) {
		this.contexto = contexto;
	}
}
