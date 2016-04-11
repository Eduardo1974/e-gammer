package br.com.fatec.egammer.api.service;

import java.util.List;

import br.com.fatec.egammer.api.dto.GeneroDTO;

public interface GeneroService {
	
	GeneroDTO salvar(GeneroDTO genero);

	void atualizar(GeneroDTO genero);

	void deletar(Long generoId);

	List<GeneroDTO> listar();

	GeneroDTO buscarPorId(Long generoId);

}
