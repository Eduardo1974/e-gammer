package br.com.fatec.egammer.test.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.fatec.egammer.api.dao.DesenvolvedoraDAO;
import br.com.fatec.egammer.api.entity.Desenvolvedora;
import br.com.fatec.egammer.test.comum.TestBase;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class DesenvolvedoraDAOTest extends TestBase {
	
	private DesenvolvedoraDAO dao;

	@Before
	public void config() {
		this.dao = ImplFinder.getImpl(DesenvolvedoraDAO.class);
	}

	@Test
	public void testSave() {
		Desenvolvedora des_salvar = new Desenvolvedora();
		des_salvar.setDes_distribuidora("EA_GAMES");
		des_salvar.setDes_studio("STUDIO_SA");

		Long codigo = this.dao.save(des_salvar);

		Desenvolvedora des_salvo = this.dao.buscarCodigo(codigo);

		Assert.assertNotNull(des_salvo);
		Assert.assertEquals("EA_GAMES", des_salvo.getDes_distribuidora());
		Assert.assertEquals("STUDIO_SA", des_salvo.getDes_studio());
	}

	@Test
	public void testUpdate() {
		Desenvolvedora des_salvar = new Desenvolvedora();
		des_salvar.setDes_distribuidora("EA_GAMES");
		des_salvar.setDes_studio("STUDIO_SA");

		Long codigo = this.dao.save(des_salvar);
		Desenvolvedora des_atualizar = this.dao.buscarCodigo(codigo);

		des_atualizar.setDes_distribuidora("ORIGIN");
		des_atualizar.setDes_studio("STUDIO_N/A");

		this.dao.update(des_atualizar);
		Desenvolvedora des_atualizado = this.dao.buscarCodigo(codigo);

		Assert.assertNotNull(des_atualizado);
		Assert.assertEquals("ORIGIN", des_atualizado.getDes_distribuidora());
		Assert.assertEquals("STUDIO_N/A", des_atualizado.getDes_studio());
	}

	@Test
	public void testDelete() {
		Desenvolvedora des_salvar = new Desenvolvedora();
		des_salvar.setDes_distribuidora("EA_GAMES");
		des_salvar.setDes_studio("STUDIO_SA");

		Long codigo = this.dao.save(des_salvar);
		this.dao.delete(codigo);

		Desenvolvedora des_deletado = this.dao.buscarCodigo(codigo);

		Assert.assertNull(des_deletado);
	}

	@Test
	public void testBuscarTodos() {
		Desenvolvedora des1 = new Desenvolvedora();
		des1.setDes_distribuidora("distribuidora 1");
		des1.setDes_studio("studio_1");
		Desenvolvedora des2 = new Desenvolvedora();
		des1.setDes_distribuidora("distribuidora 2");
		des1.setDes_studio("studio_2");

		this.dao.save(des1);
		this.dao.save(des2);

		List<Desenvolvedora> encontrados = this.dao.buscarTodasDesenvolvedoras();

		Assert.assertEquals(2, encontrados.size());
		Assert.assertEquals("distribuidora 1", encontrados.get(0).getDes_distribuidora());
		Assert.assertEquals("studio_2", encontrados.get(0).getDes_studio());
		Assert.assertEquals("distribuidora 2", encontrados.get(1).getDes_distribuidora());
		Assert.assertEquals("studio_2", encontrados.get(1).getDes_studio());
	}

}
