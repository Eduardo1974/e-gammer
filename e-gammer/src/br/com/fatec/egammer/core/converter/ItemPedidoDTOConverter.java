package br.com.fatec.egammer.core.converter;

import java.util.List;

import com.google.common.collect.Lists;
import br.com.fatec.egammer.api.dto.ItemPedidoDTO;
import br.com.fatec.egammer.api.entity.ItemPedido;

import br.com.spektro.minispring.dto.DTOConverter;

public class ItemPedidoDTOConverter implements DTOConverter<ItemPedido, ItemPedidoDTO>{
	
	@Override
	public ItemPedidoDTO toDTO(ItemPedido entidade) {
		ItemPedidoDTO itemDTO = new ItemPedidoDTO();
		itemDTO.setGam_codigo(entidade.getGam_codigo());
		itemDTO.setIpt_preco_total(entidade.getIpt_preco_total());
		itemDTO.setItp_codigo(entidade.getItp_codigo());
		itemDTO.setItp_preco_unitario(entidade.getItp_preco_unitario());
		itemDTO.setItp_quantidade(entidade.getItp_quantidade());
		itemDTO.setPed_codigo(entidade.getPed_codigo());
		return itemDTO;
	}

	@Override
	public List<ItemPedidoDTO> toDTO(List<ItemPedido> entidades) {
		List<ItemPedidoDTO> dtos = Lists.newArrayList();
		for (ItemPedido entidade : entidades) {
			dtos.add(this.toDTO(entidade));
		}
		return dtos;
	}

	@Override
	public ItemPedido toEntity(ItemPedidoDTO entidade) {
		ItemPedido itemPedido = new ItemPedido();
		itemPedido.setGam_codigo(entidade.getGam_codigo());
		itemPedido.setIpt_preco_total(entidade.getIpt_preco_total());
		itemPedido.setItp_codigo(entidade.getItp_codigo());
		itemPedido.setItp_preco_unitario(entidade.getItp_preco_unitario());
		itemPedido.setItp_quantidade(entidade.getItp_quantidade());
		itemPedido.setPed_codigo(entidade.getPed_codigo());
		return itemPedido;
	}

	@Override
	public List<ItemPedido> toEntity(List<ItemPedidoDTO> dtos) {
		List<ItemPedido> entidades = Lists.newArrayList();
		for (ItemPedidoDTO dto : dtos) {
			entidades.add(this.toEntity(dto));
		}
		return entidades;
	}

}
