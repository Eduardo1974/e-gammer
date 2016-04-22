package br.com.fatec.egammer.core.converter;

import java.util.List;

import com.google.common.collect.Lists;
import br.com.fatec.egammer.api.dto.PedidoDTO;
import br.com.fatec.egammer.api.entity.Pedido;
import br.com.spektro.minispring.dto.DTOConverter;

public class PedidoDTOConverter implements DTOConverter<Pedido, PedidoDTO>{

	@Override
	public PedidoDTO toDTO(Pedido entidade) {
		PedidoDTO pedidoDTO = new PedidoDTO();
		pedidoDTO.setCliente(entidade.getCliente());
		pedidoDTO.setItensPedidos(entidade.getItensPedido());
		pedidoDTO.setPed_codigo(entidade.getPed_codigo());
		pedidoDTO.setPed_data(entidade.getPed_data());
		pedidoDTO.setPed_valor_total(entidade.getPed_valor_total());
		return pedidoDTO;
	}

	@Override
	public List<PedidoDTO> toDTO(List<Pedido> entidades) {
		List<PedidoDTO> dtos = Lists.newArrayList();
		for (Pedido entidade : entidades) {
			dtos.add(this.toDTO(entidade));
		}
		return dtos;
	}

	@Override
	public Pedido toEntity(PedidoDTO dto) {
		Pedido pedido = new Pedido();
		pedido.setCliente(dto.getCliente());
		pedido.setItensPedido(dto.getItensPedidos());
		pedido.setPed_codigo(dto.getPed_codigo());
		pedido.setPed_data(dto.getPed_data());
		pedido.setPed_valor_total(dto.getPed_valor_total());
		return pedido;
	}

	@Override
	public List<Pedido> toEntity(List<PedidoDTO> dtos) {
		List<Pedido> entidades = Lists.newArrayList();
		for (PedidoDTO entidade : dtos) {
			entidades.add(this.toEntity(entidade));
		}
		return entidades;
	}

}
