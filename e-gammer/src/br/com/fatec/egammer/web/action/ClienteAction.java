package br.com.fatec.egammer.web.action;

import java.util.Date;

import br.com.fatec.egammer.api.dto.ClienteDTO;
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
	
	public String login() {
		ClienteDTO usuario = this.contexto.getCliente();
		ClienteDTO usuarioEncontrado = this.cliService.buscarPorLoginESenha(usuario.getCli_email(),usuario.getCli_senha());
		if (usuarioEncontrado != null) {
			usuarioEncontrado.setStartSession(new Date().getTime());
			this.getSession().put("usuario", usuarioEncontrado);
		}
		
		this.contexto.setCliente(usuarioEncontrado);
		return SUCCESS;
	}
	
	public String salvar() {
		if (this.contexto.getCliente().getCli_codigo() != null) {
			this.cliService.atualizar(this.contexto.getCliente());
		} else {
			this.cliService.salvar(this.contexto.getCliente());
		}
		
		return SUCCESS;
	}
	
	public String logout() {
		this.contexto.setCliente(null);
		this.getSession().remove("usuario");
		return SUCCESS;
	}

	public ContextoCliente getContexto() {
		return this.contexto;
	}

	public void setContexto(ContextoCliente contexto) {
		this.contexto = contexto;
	}

}
