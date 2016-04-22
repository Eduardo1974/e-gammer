package br.com.fatec.egammer.web.context;

import java.io.Serializable;
import java.util.List;

import br.com.fatec.egammer.api.dto.ClienteDTO;

public class ContextoCliente implements Serializable{
	
	private static final long serialVersionUID = -4946584307036887149L;

	private ClienteDTO cliente;
	private List<ClienteDTO> clientes;
	
	public ClienteDTO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	public List<ClienteDTO> getClientes() {
		return clientes;
	}
	public void setClientes(List<ClienteDTO> clientes) {
		this.clientes = clientes;
	}
}
