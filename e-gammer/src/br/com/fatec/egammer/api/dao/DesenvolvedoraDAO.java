package br.com.fatec.egammer.api.dao;

import java.util.List;

import br.com.fatec.egammer.api.entity.Desenvolvedora;

public interface DesenvolvedoraDAO {
	
	Long save(Desenvolvedora desenvolvedora);

	void update(Desenvolvedora desenvolvedora);

	void delete(Long codigo);

	Desenvolvedora buscarCodigo(Long codigo);

	List<Desenvolvedora> buscarTodasDesenvolvedoras();


}
