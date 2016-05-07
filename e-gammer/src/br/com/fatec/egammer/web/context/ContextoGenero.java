package br.com.fatec.egammer.web.context;

import java.io.Serializable;
import java.util.List;

import br.com.fatec.egammer.api.dto.GeneroDTO;

public class ContextoGenero implements Serializable{
	private static final long serialVersionUID = -4946584307036887149L;

	private GeneroDTO genero;
	private List<GeneroDTO> generos;
	
	public List<GeneroDTO> getGeneros() {
		return generos;
	}
	public void setGeneros(List<GeneroDTO> generos) {
		this.generos = generos;
	}
	public GeneroDTO getGenero() {
		return genero;
	}
	public void setGenero(GeneroDTO genero) {
		this.genero = genero;
	}
}
