package br.com.fatec.egammer.core.converter;

import java.util.ArrayList;
import java.util.List;

import br.com.fatec.egammer.api.dto.GeneroDTO;
import br.com.fatec.egammer.api.entity.Genero;
import br.com.spektro.minispring.dto.DTOConverter;

public class GeneroDTOConverter implements DTOConverter<Genero, GeneroDTO> {

	@Override
	public GeneroDTO toDTO(Genero gen) {
		GeneroDTO dto = new GeneroDTO();
		dto.setGen_codigo(gen.getGen_codigo());
		dto.setGen_nome(gen.getGen_nome());
		return dto;
	}

	@Override
	public List<GeneroDTO> toDTO(List<Genero> listGeneros) {
		 List<GeneroDTO> dtos = new ArrayList<>();
		 for(Genero genero : listGeneros){
			 dtos.add(this.toDTO(genero));
		 }
		return dtos;
	}

	@Override
	public Genero toEntity(GeneroDTO dto) {
		Genero gen = new Genero();
		gen.setGen_codigo(dto.getGen_codigo());
		gen.setGen_nome(dto.getGen_nome());
		return gen;
	}

	@Override
	public List<Genero> toEntity(List<GeneroDTO> listGenerosDTO) {
		 List<Genero> generos = new ArrayList<>();
		 for(GeneroDTO dto : listGenerosDTO){
			 generos.add(this.toEntity(dto));
		 }
		return generos;
	}

}
