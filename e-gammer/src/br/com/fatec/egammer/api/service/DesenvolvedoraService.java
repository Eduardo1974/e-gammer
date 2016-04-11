package br.com.fatec.egammer.api.service;

import java.util.List;

import br.com.fatec.egammer.api.dto.DesenvolvedoraDTO;

public interface DesenvolvedoraService {
	
	DesenvolvedoraDTO salvar(DesenvolvedoraDTO dev);

	void atualizar(DesenvolvedoraDTO dev);

	void deletar(Long devId);

	List<DesenvolvedoraDTO> listar();

	DesenvolvedoraDTO buscarPorId(Long devId);

}
