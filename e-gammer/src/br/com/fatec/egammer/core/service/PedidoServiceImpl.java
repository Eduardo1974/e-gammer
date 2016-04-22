package br.com.fatec.egammer.core.service;

import java.util.List;

import br.com.fatec.egammer.api.dao.PedidoDAO;
import br.com.fatec.egammer.api.dto.PedidoDTO;
import br.com.fatec.egammer.api.entity.Pedido;
import br.com.fatec.egammer.api.service.PedidoService;
import br.com.fatec.egammer.core.converter.PedidoDTOConverter;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class PedidoServiceImpl implements PedidoService{
	
	private PedidoDAO pedDao;
	private PedidoDTOConverter pedidoDtoConverter;
	
	public PedidoServiceImpl(){
		this.pedDao = ImplFinder.getImpl(PedidoDAO.class);
		this.pedidoDtoConverter = ImplFinder.getImpl(PedidoDTOConverter.class);
	}
	
	@Override
	public PedidoDTO salvar(PedidoDTO pedidoDTO) {
		Pedido pedido = this.pedidoDtoConverter.toEntity(pedidoDTO);
		Long id = this.pedDao.save(pedido);
		pedidoDTO.setPed_codigo(id);
		return pedidoDTO;
	}

	@Override
	public void atualizar(PedidoDTO pedidoDTO) {
		Pedido pedido = this.pedidoDtoConverter.toEntity(pedidoDTO);
		this.pedDao.update(pedido);
	}

	@Override
	public void deletar(Long pedidoId) {
		this.pedDao.delete(pedidoId);
	}

	@Override
	public List<PedidoDTO> listar(Long cliCodigo) {
		return this.pedidoDtoConverter.toDTO(this.pedDao.buscaTodosPedidosCliente(cliCodigo));
	}

	@Override
	public PedidoDTO buscarPorId(Long pedidoId) {
		return this.pedidoDtoConverter.toDTO(this.pedDao.buscaPedidoCodigo(pedidoId));
	}

}
