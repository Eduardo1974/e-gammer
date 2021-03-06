package br.com.fatec.egammer.api.dao;

import java.util.List;

import br.com.fatec.egammer.api.entity.Genero;

public interface GeneroDAO {

	Long save(Genero genero);

	boolean update(Genero genero);

	boolean delete(Long codigo);

	Genero buscaCodigo(Long codigo);

	List<Genero> buscarTodosGeneros();

	List<Genero> buscarTodosPorCodigo(List<Long> codigos);
}
