package br.com.fatec.egammer.core.service;

import java.util.List;

import br.com.fatec.egammer.api.dao.DesenvolvedoraDAO;
import br.com.fatec.egammer.api.dto.DesenvolvedoraDTO;
import br.com.fatec.egammer.api.entity.Desenvolvedora;
import br.com.fatec.egammer.api.service.DesenvolvedoraService;
import br.com.fatec.egammer.core.converter.DesenvolvedoraDTOConverter;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class DesenvolvedoraServiceImpl implements DesenvolvedoraService{

	private DesenvolvedoraDAO desDAO;
	private DesenvolvedoraDTOConverter desDtoCon;
	
	public DesenvolvedoraServiceImpl (){
		this.desDAO = ImplFinder.getImpl(DesenvolvedoraDAO.class);
		this.desDtoCon = ImplFinder.getFinalImpl(DesenvolvedoraDTOConverter.class);
	}
	
	@Override
	public DesenvolvedoraDTO salvar(DesenvolvedoraDTO desenvDTO) {
		Desenvolvedora desenv = this.desDtoCon.toEntity(desenvDTO);
		Long id = this.desDAO.save(desenv);
		desenvDTO.setDes_codigo(id);
		return desenvDTO;
	}

	@Override
	public void atualizar(DesenvolvedoraDTO desenv) {
		 Desenvolvedora desenvolvedora = this.desDtoCon.toEntity(desenv);
		 this.desDAO.update(desenvolvedora);
	}

	@Override
	public void deletar(Long desId) {
		 this.desDAO.delete(desId);
		
	}

	@Override
	public List<DesenvolvedoraDTO> listar() {
		return this.desDtoCon.toDTO(this.desDAO.buscarTodasDesenvolvedoras());
	}

	@Override
	public DesenvolvedoraDTO buscarPorId(Long id) {
		return this.desDtoCon.toDTO(this.desDAO.buscarCodigo(id));
	}
	
}
