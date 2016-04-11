package br.com.fatec.egammer.api.dto;

public class GeneroDTO {
	
	private Long gen_codigo;
	private String gen_nome;
	
	public GeneroDTO(){
		
	}

	public GeneroDTO(Long gen_codigo, String gen_nome) {
		super();
		this.gen_codigo = gen_codigo;
		this.gen_nome = gen_nome;
	}

	public Long getGen_codigo() {
		return gen_codigo;
	}

	public void setGen_codigo(Long gen_codigo) {
		this.gen_codigo = gen_codigo;
	}

	public String getGen_nome() {
		return gen_nome;
	}

	public void setGen_nome(String gen_nome) {
		this.gen_nome = gen_nome;
	}
	
	@Override
	public String toString(){
		return "Genero[" + this.gen_codigo + " - " + this.gen_nome + "]";
	}

}
