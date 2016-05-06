package br.com.fatec.egammer.web.action;

import java.util.List;

import br.com.fatec.egammer.api.dto.DesenvolvedoraDTO;
import br.com.fatec.egammer.api.service.DesenvolvedoraService;
import br.com.fatec.egammer.core.dao.DesenvolvedoraDAOImpl;
import br.com.fatec.egammer.web.context.ContextoDesenvolvedora;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class DesenvolvedoraAction extends ProjetoWebAction{

	private static final long serialVersionUID = 1071989853380980252L;
	private static final String SUCESS = "success";

	private ContextoDesenvolvedora contexto = new ContextoDesenvolvedora();
	private DesenvolvedoraService service;

	public DesenvolvedoraAction() {
		this.service = ImplFinder.getImpl(DesenvolvedoraService.class);
	}
	

	public String listar() {
		
		this.contexto.setDesenvolvedoras(this.service.listar());
		return SUCESS;
	}

	public String salvar() {
		if (this.contexto.getDesenvolvedora().getDes_codigo() != null) {
			this.service.atualizar(this.contexto.getDesenvolvedora());
		} else {
			this.service.salvar(this.contexto.getDesenvolvedora());
		}
		
		return this.listar();
	}

	public String editar() {
		DesenvolvedoraDTO des = this.service.buscarPorId(this.contexto.getDesenvolvedora().getDes_codigo());
		this.contexto.setDesenvolvedora(des);
		return this.listar();
	}

	public String deletar() {
		this.service.deletar(this.contexto.getDesenvolvedora().getDes_codigo());
		return this.listar();
	}

	public ContextoDesenvolvedora getContexto() {
		return this.contexto;
	}

	public void setContexto(ContextoDesenvolvedora contexto) {
		this.contexto = contexto;
	}

}
