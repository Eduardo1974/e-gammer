package br.com.fatec.egammer.web.context;

import java.io.Serializable;
import java.util.List;

import br.com.fatec.egammer.api.dto.GameDTO;

public class ContextoGame implements Serializable{
	private static final long serialVersionUID = -4946584307036887149L;

	private GameDTO game;
	private List<GameDTO> games;
	
	public GameDTO getGame() {
		return game;
	}
	public void setGame(GameDTO game) {
		this.game = game;
	}
	public List<GameDTO> getGames() {
		return games;
	}
	public void setGames(List<GameDTO> games) {
		this.games = games;
	}
}
