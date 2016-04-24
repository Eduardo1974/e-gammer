package br.com.fatec.egammer.core.converter;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

import br.com.fatec.egammer.api.dto.DesenvolvedoraDTO;
import br.com.fatec.egammer.api.entity.Desenvolvedora;
import br.com.spektro.minispring.dto.DTOConverter;

public class DesenvolvedoraDTOConverter implements DTOConverter<Desenvolvedora, DesenvolvedoraDTO>{
	
	@Override
	public DesenvolvedoraDTO toDTO(Desenvolvedora entidade) {
		DesenvolvedoraDTO dto = new DesenvolvedoraDTO();
		dto.setDes_codigo(entidade.getDes_codigo());
		dto.setDes_distribuidora(entidade.getDes_distribuidora());
		dto.setDes_studio(entidade.getDes_studio());
		return dto;
	}

	@Override
	public List<DesenvolvedoraDTO> toDTO(List<Desenvolvedora> entidades) {
		List<DesenvolvedoraDTO> dtos = Lists.newArrayList();
		for (Desenvolvedora entidade : entidades) {
			dtos.add(this.toDTO(entidade));
		}
		return dtos;
	}

	@Override
	public Desenvolvedora toEntity(DesenvolvedoraDTO dto) {
		Desenvolvedora desenv = new Desenvolvedora();
		desenv.setDes_codigo(dto.getDes_codigo());
		desenv.setDes_distribuidora(dto.getDes_distribuidora());
		desenv.setDes_studio(dto.getDes_studio());
		return desenv;
	}

	@Override
	public List<Desenvolvedora> toEntity(List<DesenvolvedoraDTO> dtos) {
		 List<Desenvolvedora> entidades = new ArrayList<>();
		 for (DesenvolvedoraDTO dto : dtos){
			 entidades.add(this.toEntity(dto));
		 }
		return entidades;
	}

}
