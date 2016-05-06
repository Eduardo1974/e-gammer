package br.com.fatec.egammer.web.context;

import java.io.Serializable;
import java.util.List;

import br.com.fatec.egammer.api.dto.DesenvolvedoraDTO;


public class ContextoDesenvolvedora implements Serializable{
	private static final long serialVersionUID = -4946584307036887149L;

	private DesenvolvedoraDTO desenvolvedora;
	private List<DesenvolvedoraDTO> desenvolvedoras;
	
	public DesenvolvedoraDTO getDesenvolvedora() {
		return desenvolvedora;
	}
	public void setDesenvolvedora(DesenvolvedoraDTO desenvolvedora) {
		this.desenvolvedora = desenvolvedora;
	}
	public List<DesenvolvedoraDTO> getDesenvolvedoras() {
		return desenvolvedoras;
	}
	public void setDesenvolvedoras(List<DesenvolvedoraDTO> desenvolvedoras) {
		this.desenvolvedoras = desenvolvedoras;
	}
	
	
}
