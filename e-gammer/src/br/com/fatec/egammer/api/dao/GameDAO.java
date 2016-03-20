package br.com.fatec.egammer.api.dao;

import java.util.List;

import br.com.fatec.egammer.api.entity.Game;

public interface GameDAO {
	
	Long save(Game game);

	void update(Game game);

	void delete(Long id);

	Game findById(Long id);

	List<Game> findAll();


}
