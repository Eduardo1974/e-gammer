package br.com.fatec.egammer.api.dao;

import java.util.List;

import br.com.fatec.egammer.api.entity.Game;

public interface GameDAO {
	
	Long save(Game game);

	void update(Game game);

	void delete(Long codigo);

	Game buscarCodigo(Long codigo);

	List<Game> buscarTodosGames();

	List<Game> buscaPorGenero(Long codigo);
}
