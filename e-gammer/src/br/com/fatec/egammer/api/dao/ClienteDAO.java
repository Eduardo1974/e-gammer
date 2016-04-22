package br.com.fatec.egammer.api.dao;

import java.util.List;

import br.com.fatec.egammer.api.dto.ClienteDTO;
import br.com.fatec.egammer.api.entity.Cliente;

public interface ClienteDAO {
	
	Long save(Cliente cliente);

	void update(Cliente cliente);

	void delete(Long codigo);

	Cliente buscarCodigo(Long codigo);

	List<Cliente> buscarTodosClientes();
	
	Cliente buscarPorLoginESenha(String login, String senha);
}
