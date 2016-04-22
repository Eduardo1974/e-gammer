package br.com.fatec.egammer.web.action;

import br.com.fatec.egammer.api.service.ClienteService;
import br.com.fatec.egammer.web.context.ContextoCliente;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class ClienteAction extends ProjetoWebAction{
	
	private static final long serialVersionUID = 1071989853380980252L;
	private static final String SUCCESS = "success";
	
	private ContextoCliente contexto = new ContextoCliente();
	private ClienteService cliService;
	
	public ClienteAction(){
		this.cliService = ImplFinder.getImpl(ClienteService.class);
	}
	
	
}
