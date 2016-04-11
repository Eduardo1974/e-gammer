package br.com.fatec.egammer.api.service;

import java.util.List;

import br.com.fatec.egammer.api.dto.ClienteDTO;

public interface ClienteService {
	
	ClienteDTO salvar(ClienteDTO cliente);

	void atualizar(ClienteDTO cliente);

	void deletar(Long clienteId);

	List<ClienteDTO> listar();

	ClienteDTO buscarPorId(Long clienteId);

	ClienteDTO buscarPorLoginESenha(String login, String senha);

}
