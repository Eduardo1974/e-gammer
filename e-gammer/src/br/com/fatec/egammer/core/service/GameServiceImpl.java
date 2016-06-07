package br.com.fatec.egammer.core.service;

import java.util.List;

import br.com.fatec.egammer.api.dao.GameDAO;
import br.com.fatec.egammer.api.dto.GameDTO;
import br.com.fatec.egammer.api.entity.Game;
import br.com.fatec.egammer.api.service.GameService;
import br.com.fatec.egammer.core.converter.GameDTOConverter;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class GameServiceImpl implements GameService{

	private GameDAO dao;
	private GameDTOConverter converter;
	
	public GameServiceImpl() {
		 this.dao = ImplFinder.getImpl(GameDAO.class);
		 this.converter = ImplFinder.getFinalImpl(GameDTOConverter.class);
	}
	
	@Override
	public GameDTO salvar(GameDTO gameDto) {
		Game game = this.converter.toEntity(gameDto);
		Long id = this.dao.save(game);
		gameDto.setGam_codigo(id); 
		return gameDto;
	}

	@Override
	public void atualizar(GameDTO gameDto) {
		Game game = this.converter.toEntity(gameDto);
		this.dao.update(game);
	}

	@Override
	public void deletar(Long gameId) {
		this.dao.delete(gameId);
	}

	@Override
	public List<GameDTO> listar() {
		return this.converter.toDTO(this.dao.buscarTodosGames());
	}

	@Override
	public GameDTO buscarPorId(Long gameId) {
		return this.converter.toDTO(this.dao.buscarCodigo(gameId));
	}

	@Override
	public List<GameDTO> buscaGamesPorGenero(Long codigo) {
		return this.converter.toDTO(this.dao.buscaPorGenero(codigo));
	}

}
