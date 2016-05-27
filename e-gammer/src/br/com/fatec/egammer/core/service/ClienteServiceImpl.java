package br.com.fatec.egammer.core.service;

import java.util.List;

import br.com.fatec.egammer.api.dao.ClienteDAO;
import br.com.fatec.egammer.api.dto.ClienteDTO;
import br.com.fatec.egammer.api.entity.Cliente;
import br.com.fatec.egammer.api.service.ClienteService;
import br.com.fatec.egammer.core.converter.ClienteDTOConverter;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class ClienteServiceImpl implements ClienteService{
	
	private ClienteDAO cliDao;
	private ClienteDTOConverter cliDtoConverter;
	
	public ClienteServiceImpl(){
		this.cliDao = ImplFinder.getImpl(ClienteDAO.class);
		this.cliDtoConverter = ImplFinder.getFinalImpl(ClienteDTOConverter.class);
	}
	
	@Override
	public ClienteDTO salvar(ClienteDTO clienteDTO) {
		Cliente cliente = this.cliDtoConverter.toEntity(clienteDTO);
		cliente.setCli_tipo("cliente");
		Long id = this.cliDao.save(cliente);
		clienteDTO.setCli_codigo(id);
		return clienteDTO;
	}

	@Override
	public void atualizar(ClienteDTO clienteDTO) {
		Cliente cliente = this.cliDtoConverter.toEntity(clienteDTO);
		this.cliDao.update(cliente);
	}

	@Override
	public void deletar(Long clienteId) {
		this.cliDao.delete(clienteId);
	}

	@Override
	public List<ClienteDTO> listar() {
		return this.cliDtoConverter.toDTO(this.cliDao.buscarTodosClientes());
	}

	@Override
	public ClienteDTO buscarPorId(Long clienteId) {
		return this.cliDtoConverter.toDTO(this.cliDao.buscarCodigo(clienteId));
	}

	@Override
	public ClienteDTO buscarPorLoginESenha(String login, String senha) {
		return this.cliDtoConverter.toDTO(this.cliDao.buscarPorLoginESenha(login, senha));
	}

}
