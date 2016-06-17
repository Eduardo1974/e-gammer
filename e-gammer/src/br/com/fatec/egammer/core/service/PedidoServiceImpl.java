package br.com.fatec.egammer.core.service;

import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import br.com.fatec.egammer.api.dao.ItemPedidoDAO;
import br.com.fatec.egammer.api.dao.PedidoDAO;
import br.com.fatec.egammer.api.dto.PedidoDTO;
import br.com.fatec.egammer.api.entity.ItemPedido;
import br.com.fatec.egammer.api.entity.Pedido;
import br.com.fatec.egammer.api.service.PedidoService;
import br.com.fatec.egammer.core.converter.PedidoDTOConverter;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class PedidoServiceImpl implements PedidoService{
	
	private PedidoDAO pedDao;
	private ItemPedidoDAO itensDao;
	private PedidoDTOConverter pedidoDtoConverter;
	
	public PedidoServiceImpl(){
		this.pedDao = ImplFinder.getImpl(PedidoDAO.class);
		this.itensDao = ImplFinder.getImpl(ItemPedidoDAO.class);
		this.pedidoDtoConverter = ImplFinder.getFinalImpl(PedidoDTOConverter.class);
	}
	
	@Override
	public PedidoDTO salvar(PedidoDTO pedidoDTO) {
		
		Pedido pedido = this.pedidoDtoConverter.toEntity(pedidoDTO);
		Long id = this.pedDao.save(pedido);
		for (ItemPedido it : pedidoDTO.getItensPedidos()) {
			ItemPedido itens = new ItemPedido();
			itens.setGam_codigo(it.getGam_codigo());
			itens.setIpt_preco_total(it.getIpt_preco_total());
			itens.setItp_preco_unitario(it.getItp_preco_unitario());
			itens.setItp_quantidade(it.getItp_quantidade());
			itens.setPed_codigo(id);
			this.itensDao.save(itens);
		}
		
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
