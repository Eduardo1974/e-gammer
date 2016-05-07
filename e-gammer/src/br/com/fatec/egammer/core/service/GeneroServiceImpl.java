package br.com.fatec.egammer.core.service;

import java.util.List;

import br.com.fatec.egammer.api.dao.GeneroDAO;
import br.com.fatec.egammer.api.dto.GeneroDTO;
import br.com.fatec.egammer.api.entity.Genero;
import br.com.fatec.egammer.api.service.GeneroService;
import br.com.fatec.egammer.core.converter.GeneroDTOConverter;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class GeneroServiceImpl implements GeneroService{

	private GeneroDAO genDAO;
	private GeneroDTOConverter genConverter;
	
	public GeneroServiceImpl() {
		this.genDAO = ImplFinder.getImpl(GeneroDAO.class);
		this.genConverter = ImplFinder.getFinalImpl(GeneroDTOConverter.class);
	}
	
	@Override
	public GeneroDTO salvar(GeneroDTO generoDto) {
		Genero genero = this.genConverter.toEntity(generoDto);
		Long id = genDAO.save(genero);
		generoDto.setGen_codigo(id);
		return generoDto;
	}

	@Override
	public void atualizar(GeneroDTO generoDto) {
		Genero genero = this.genConverter.toEntity(generoDto);
		this.genDAO.update(genero);
	}

	@Override
	public void deletar(Long generoId) {
		this.genDAO.delete(generoId);
	}

	@Override
	public List<GeneroDTO> listar() {
		return this.genConverter.toDTO(this.genDAO.buscarTodosGeneros());
	}

	@Override
	public GeneroDTO buscarPorId(Long generoId) {
		return this.genConverter.toDTO(this.genDAO.buscaCodigo(generoId));
	}

}
