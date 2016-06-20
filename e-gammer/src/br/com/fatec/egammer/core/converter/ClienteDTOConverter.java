package br.com.fatec.egammer.core.converter;

import java.util.List;

import com.google.common.collect.Lists;

import br.com.fatec.egammer.api.dao.PedidoDAO;
import br.com.fatec.egammer.api.dto.ClienteDTO;
import br.com.fatec.egammer.api.entity.Cliente;
import br.com.spektro.minispring.core.implfinder.ImplFinder;
import br.com.spektro.minispring.dto.DTOConverter;

public class ClienteDTOConverter implements DTOConverter<Cliente, ClienteDTO>{
	
	private PedidoDAO pedDAO;
	
	public ClienteDTOConverter(){
		this.pedDAO = ImplFinder.getImpl(PedidoDAO.class);
	}
	
	@Override
	public ClienteDTO toDTO(Cliente entidade) {
		ClienteDTO dto = new ClienteDTO();
		dto.setCli_codigo(entidade.getCli_codigo());
		dto.setCli_email(entidade.getCli_email());
		dto.setCli_nome(entidade.getCli_nome());
		dto.setCli_senha(entidade.getCli_senha());
		dto.setCli_tipo(entidade.getCli_tipo());
		//dto.setPedidos(this.pedDAO.buscaTodosPedidosCliente(entidade.getCli_codigo()));
		return dto;
	}

	@Override
	public List<ClienteDTO> toDTO(List<Cliente> entidades) {
		List<ClienteDTO> dtos = Lists.newArrayList();
		for (Cliente entidade : entidades) {
			dtos.add(this.toDTO(entidade));
		}
		return dtos;
	}

	@Override
	public Cliente toEntity(ClienteDTO dto) {
		Cliente cliente = new Cliente();
		cliente.setCli_codigo(dto.getCli_codigo());
		cliente.setCli_email(dto.getCli_email());
		cliente.setCli_nome(dto.getCli_nome());
		cliente.setCli_senha(dto.getCli_senha());
		cliente.setCli_tipo(dto.getCli_tipo());
		return cliente;
	}

	@Override
	public List<Cliente> toEntity(List<ClienteDTO> dtos) {
		List<Cliente> entidades = Lists.newArrayList();
		for (ClienteDTO dto : dtos) {
			entidades.add(this.toEntity(dto));
		}
		return entidades;
	}
	
}
