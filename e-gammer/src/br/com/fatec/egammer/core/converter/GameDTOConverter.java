package br.com.fatec.egammer.core.converter;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import br.com.fatec.egammer.api.dto.GameDTO;
import br.com.fatec.egammer.api.entity.Game;
import br.com.spektro.minispring.dto.DTOConverter;

public class GameDTOConverter implements DTOConverter<Game, GameDTO>{
	
	@Override
	public GameDTO toDTO(Game game) {
		GameDTO dto = new GameDTO();
		dto.setDesenvolvedora(game.getDesenvolvedora());
		dto.setGam_classificacao(game.getGam_classificacao());
		dto.setGam_codigo(game.getGam_codigo());
		dto.setGam_data_lancamento(game.getGam_data_lancamento());
		dto.setGam_descricao(game.getGam_descricao());
		dto.setGam_imagem(game.getGam_imagem());
		dto.setGam_imagem2(game.getGam_imagem2());
		dto.setGam_imagem3(game.getGam_imagem3());
		dto.setGam_imagem4(game.getGam_imagem4());
		dto.setGam_plataforma(game.getGam_plataforma());
		dto.setGam_preco(game.getGam_preco());
		dto.setGam_quantidade(game.getGam_quantidade());
		dto.setGam_titulo(game.getGam_titulo());
		dto.setGenero(game.getGenero());
		return dto;
	}

	@Override
	public List<GameDTO> toDTO(List<Game> games) {
		 List<GameDTO> dtos = new ArrayList<>();
		 for(Game gam : games){
			 dtos.add(this.toDTO(gam));
		 }
		return dtos;
	}

	@Override
	public Game toEntity(GameDTO dto) {
		 Game entidade = new Game();
		 entidade.setDesenvolvedora(dto.getDesenvolvedora());
		 entidade.setGam_classificacao(dto.getGam_classificacao());
		 entidade.setGam_codigo(dto.getGam_codigo());
		 java.util.Date dataUtil = new java.util.Date();
		 java.sql.Date dataSql = new java.sql.Date(dto.getGam_data_lancamento().getTime());
		 entidade.setGam_data_lancamento(dataSql );
		 entidade.setGam_descricao(dto.getGam_descricao());
		 entidade.setGam_imagem(dto.getGam_imagem());
		 entidade.setGam_imagem2(dto.getGam_imagem2());
		 entidade.setGam_imagem3(dto.getGam_imagem3());
		 entidade.setGam_imagem4(dto.getGam_imagem4());
		 entidade.setGam_plataforma(dto.getGam_plataforma());
		 entidade.setGam_preco(dto.getGam_preco());
		 entidade.setGam_quantidade(dto.getGam_quantidade());
		 entidade.setGam_titulo(dto.getGam_titulo());
		 entidade.setGenero(dto.getGenero());
		return entidade;
	}

	@Override
	public List<Game> toEntity(List<GameDTO> gamesDTO) {
		 List<Game> games = new ArrayList<>();
		 for( GameDTO dto : gamesDTO){
			 games.add(this.toEntity(dto));
		 }
		return games;
	}

}
