package br.com.fatec.egammer.core.service;

import java.util.List;

import br.com.fatec.egammer.api.dao.ItemPedidoDAO;
import br.com.fatec.egammer.api.dto.ItemPedidoDTO;
import br.com.fatec.egammer.api.entity.ItemPedido;
import br.com.fatec.egammer.api.service.ItemPedidoService;
import br.com.fatec.egammer.core.converter.ItemPedidoDTOConverter;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class ItemPedidoServiceImpl implements ItemPedidoService{
	
	private ItemPedidoDAO itemDao;
	private ItemPedidoDTOConverter itemPedidoConverter;
	
	public ItemPedidoServiceImpl(){
		this.itemDao = ImplFinder.getImpl(ItemPedidoDAO.class);
		this.itemPedidoConverter = ImplFinder.getImpl(ItemPedidoDTOConverter.class);
	}
	
	@Override
	public ItemPedidoDTO salvar(ItemPedidoDTO itemPedidoDTO) {
		ItemPedido itemPedido = this.itemPedidoConverter.toEntity(itemPedidoDTO);
		Long id = this.itemDao.save(itemPedido);
		itemPedidoDTO.setItp_codigo(id);
		return itemPedidoDTO;
	}

	@Override
	public void atualizar(ItemPedidoDTO itemPedidoDTO) {
		ItemPedido itemPedido = this.itemPedidoConverter.toEntity(itemPedidoDTO);
		this.itemDao.update(itemPedido);
	}

	@Override
	public void deletar(Long itemPedidoId) {
		this.itemDao.delete(itemPedidoId);
	}

	@Override
	public List<ItemPedidoDTO> listar(Long pedCodigo) {
		return this.itemPedidoConverter.toDTO(this.itemDao.buscaTodosItemPedido(pedCodigo));
	}

	@Override
	public ItemPedidoDTO buscarPorId(Long itemPedidoId) {
		return this.itemPedidoConverter.toDTO(this.itemDao.buscaCodigoItemPedido(itemPedidoId));
	}
}
