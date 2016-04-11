package br.com.fatec.egammer.api.dto;

public class DesenvolvedoraDTO {
	
	private Long des_codigo;
	private String des_studio;
	private String des_distribuidora;
	
	public DesenvolvedoraDTO(){
		
	}
	
	public DesenvolvedoraDTO(Long des_codigo, String des_studio, String des_distribuidora) {
		super();
		this.des_codigo = des_codigo;
		this.des_studio = des_studio;
		this.des_distribuidora = des_distribuidora;
	}

	public Long getDes_codigo() {
		return des_codigo;
	}

	public void setDes_codigo(Long des_codigo) {
		this.des_codigo = des_codigo;
	}

	public String getDes_studio() {
		return des_studio;
	}

	public void setDes_studio(String des_studio) {
		this.des_studio = des_studio;
	}

	public String getDes_distribuidora() {
		return des_distribuidora;
	}

	public void setDes_distribuidora(String des_distribuidora) {
		this.des_distribuidora = des_distribuidora;
	}
	
	@Override
	public String toString(){
		return "Desenvolvedora[" + this.des_codigo + " - " + this.des_studio + "]";
	}
	
}
