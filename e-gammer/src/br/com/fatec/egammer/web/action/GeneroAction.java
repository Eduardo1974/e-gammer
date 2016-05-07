package br.com.fatec.egammer.web.action;

import br.com.fatec.egammer.api.service.GeneroService;
import br.com.fatec.egammer.web.context.ContextoGenero;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class GeneroAction extends ProjetoWebAction{
	private static final long serialVersionUID = 1071989853380980252L;
	private static final String SUCESS = "success";

	private ContextoGenero contexto = new ContextoGenero();
	private GeneroService service;

	public GeneroAction() {
		this.service = ImplFinder.getImpl(GeneroService.class);
	}
	

	public String listar() {
		
		this.contexto.setGeneros(this.service.listar());
		return SUCESS;
	}

	public String salvar() {
		if (this.contexto.getGenero().getGen_codigo()!= null) {
			this.service.atualizar(this.contexto.getGenero());
		} else {
			this.service.salvar(this.contexto.getGenero());
		}
		
		return this.listar();
	}

	public String editar() {
		this.service.atualizar(this.contexto.getGenero());
		//DesenvolvedoraDTO des = this.service.buscarPorId(this.contexto.getDesenvolvedora().getDes_codigo());
		//this.contexto.setDesenvolvedora(des);
		return this.listar();
	}

	public String deletar() {
		this.service.deletar(this.contexto.getGenero().getGen_codigo());
		return this.listar();
	}

	public ContextoGenero getContexto() {
		return this.contexto;
	}

	public void setContexto(ContextoGenero contexto) {
		this.contexto = contexto;
	}
}
