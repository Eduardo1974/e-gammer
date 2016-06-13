package br.com.fatec.egammer.web.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fatec.egammer.api.service.GameService;
import br.com.fatec.egammer.web.context.ContextoGame;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class GameAction extends ProjetoWebAction{
	
	private static final long serialVersionUID = 1071989853380980252L;
	private static final String SUCESS = "success";

	private ContextoGame contexto = new ContextoGame();
	private GameService service;

	public GameAction() {
		this.service = ImplFinder.getImpl(GameService.class);
	}
	

	public String buscaPorGenero() {
	
		this.contexto.setGames(this.service.buscaGamesPorGenero(this.contexto.getGame().getGenero().getGen_codigo()));

		return SUCESS;
	}
	
	public String buscaPorTitulo() {
		
		this.contexto.setGames(this.service.buscaPorTitulo(this.contexto.getGame().getGam_titulo()));

		return SUCESS;
	}
	
	public String buscaDestaques() {
		
		this.contexto.setGames(this.service.buscaDestaques());

		return SUCESS;
	}
	public String listar() {
		
		this.contexto.setGames(this.service.listar());
		return SUCESS;
	}

	public String salvar() {
		if (this.contexto.getGame().getGam_codigo() != null) {
			this.service.atualizar(this.contexto.getGame());
		} else {
			this.service.salvar(this.contexto.getGame());
		}
		
		return this.listar();
	}

	public String editar() {
		this.service.atualizar(this.contexto.getGame());
		//DesenvolvedoraDTO des = this.service.buscarPorId(this.contexto.getDesenvolvedora().getDes_codigo());
		//this.contexto.setDesenvolvedora(des);
		return this.listar();
	}

	public String deletar() {
		this.service.deletar(this.contexto.getGame().getGam_codigo());
		return this.listar();
	}

	public ContextoGame getContexto() {
		return this.contexto;
	}

	public void setContexto(ContextoGame contexto) {
		this.contexto = contexto;
	}

}
