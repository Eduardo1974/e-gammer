package br.com.fatec.egammer.api.service;

import java.util.List;

import br.com.fatec.egammer.api.dto.GameDTO;

public interface GameService {
	
	GameDTO salvar(GameDTO game);

	void atualizar(GameDTO game);

	void deletar(Long gameId);

	List<GameDTO> listar();

	GameDTO buscarPorId(Long gameId);
	
	List<GameDTO>  buscaGamesPorGenero(Long codigo);
	
	List<GameDTO>  buscaDestaques();

}
