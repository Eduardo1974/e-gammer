package br.com.fatec.egammer.test.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.fatec.egammer.api.dao.GeneroDAO;
import br.com.fatec.egammer.api.entity.Genero;
import br.com.fatec.egammer.test.comum.TestBase;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class GeneroDAOTest extends TestBase{
	private GeneroDAO dao;

	@Before
	public void config() {
		this.dao = ImplFinder.getImpl(GeneroDAO.class);
	}

	@Test
	public void testSave() {
		Genero genero_salvar = new Genero();
		genero_salvar.setGen_nome("Ação");
	
		Long id = this.dao.save(genero_salvar);

		Genero genero_salvo = this.dao.buscaCodigo(id);

		Assert.assertNotNull(genero_salvo);
		Assert.assertEquals("Ação", genero_salvo.getGen_nome());
	}

	/*@Test
	public void testUpdate() {
		Grupo grupo_salvar = new Grupo();
		grupo_salvar.setNome("grupo 1");
		grupo_salvar.setDescricao("grupo de teste");

		Long id = this.dao.save(grupo_salvar);
		Grupo grupo_atualizar = this.dao.findById(id);

		grupo_atualizar.setNome("grupo 1 modificado");
		grupo_atualizar.setDescricao("grupo de teste modificado");

		this.dao.update(grupo_atualizar);
		Grupo grupo_atualizado = this.dao.findById(id);

		Assert.assertNotNull(grupo_atualizado);
		Assert.assertEquals("grupo 1 modificado", grupo_atualizado.getNome());
		Assert.assertEquals("grupo de teste modificado", grupo_atualizado.getDescricao());
	}

	@Test
	public void testDelete() {
		Grupo grupo_salvar = new Grupo();
		grupo_salvar.setNome("grupo");
		grupo_salvar.setDescricao("grupo de teste");

		Long id = this.dao.save(grupo_salvar);
		this.dao.delete(id);

		Grupo grupo_deletado = this.dao.findById(id);

		Assert.assertNull(grupo_deletado);
	}

	@Test
	public void testFindAll() {
		Grupo grupo1 = new Grupo();
		grupo1.setNome("grupo 1");
		grupo1.setDescricao("grupo de teste 1");
		Grupo grupo2 = new Grupo();
		grupo2.setNome("grupo 2");
		grupo2.setDescricao("grupo de teste 2");

		this.dao.save(grupo1);
		this.dao.save(grupo2);

		List<Grupo> encontrados = this.dao.findAll();

		Assert.assertEquals(2, encontrados.size());
		Assert.assertEquals("grupo 1", encontrados.get(0).getNome());
		Assert.assertEquals("grupo de teste 1", encontrados.get(0).getDescricao());
		Assert.assertEquals("grupo 2", encontrados.get(1).getNome());
		Assert.assertEquals("grupo de teste 2", encontrados.get(1).getDescricao());
	}*/
}
