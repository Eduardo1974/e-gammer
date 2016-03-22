package br.com.fatec.egammer.test.dao;

import java.util.List;

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

	@Test
	public void testUpdate() {
		Genero genero_salvar = new Genero();
		genero_salvar.setGen_nome("Aventura");
		Long id = this.dao.save(genero_salvar);
		
		Genero genero_atualizar = this.dao.buscaCodigo(id);
		genero_atualizar.setGen_nome("Guerra");

		boolean resultado = this.dao.update(genero_atualizar);
		Genero grupo_atualizado = this.dao.buscaCodigo(id);

		Assert.assertEquals(true,resultado);
		Assert.assertNotNull(grupo_atualizado);
		Assert.assertEquals("Guerra", grupo_atualizado.getGen_nome());
	}

	@Test
	public void testDelete() {
		Genero genero_salvar = new Genero();
		genero_salvar.setGen_nome("RPG");

		Long id = this.dao.save(genero_salvar);
		boolean resultado = this.dao.delete(id);

		Genero genero_deletado = this.dao.buscaCodigo(id);
		Assert.assertEquals(true,resultado);
		Assert.assertNull(genero_deletado);
	}

	@Test
	public void testFindAll() {
		Genero genero1 = new Genero();
		genero1.setGen_nome("Ação");
		
		Genero genero2 = new Genero();
		genero2.setGen_nome("Terror");
	

		this.dao.save(genero1);
		this.dao.save(genero2);

		List<Genero> encontrados = this.dao.buscarTodosGeneros();

		Assert.assertEquals(2, encontrados.size());
		Assert.assertEquals("Ação", encontrados.get(0).getGen_nome());
		Assert.assertEquals("Terror", encontrados.get(1).getGen_nome());
	
	}
}
