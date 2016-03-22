package br.com.fatec.egammer.test.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.fatec.egammer.api.dao.ClienteDAO;
import br.com.fatec.egammer.api.entity.Cliente;
import br.com.fatec.egammer.test.comum.TestBase;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class ClienteDAOTest extends TestBase{
	private ClienteDAO dao;

	@Before
	public void config() {
		this.dao = ImplFinder.getImpl(ClienteDAO.class);
	}

	@Test
	public void testSave1() {

	}

	@Test
	public void testSave() {
		Cliente usu_salvar = new Cliente();
		usu_salvar.setCli_nome("carlos");
		usu_salvar.setCli_senha("senha_carlos");

		Long codigo = this.dao.save(usu_salvar);

		Cliente usu_salvo = this.dao.buscarCodigo(codigo);

		Assert.assertNotNull(usu_salvo);
		Assert.assertEquals("carlos", usu_salvo.getCli_nome());
		Assert.assertEquals("senha_carlos", usu_salvo.getCli_senha());
	}
/*
	@Test
	public void testUpdate() {
		Cliente usu_salvar = new Cliente();
		usu_salvar.setCli_nome("carlos");
		usu_salvar.setCli_senha("senha_carlos");

		Long codigo = this.dao.save(usu_salvar);
		Cliente usu_atualizar = this.dao.buscarCodigo(codigo);

		usu_atualizar.setCli_nome("carlos oliveira");
		usu_atualizar.setCli_senha("nova_senha");

		this.dao.update(usu_atualizar);
		Cliente usu_atualizado = this.dao.buscarCodigo(codigo);

		Assert.assertNotNull(usu_atualizado);
		Assert.assertEquals("carlos oliveira", usu_atualizado.getCli_nome());
		Assert.assertEquals("nova_senha", usu_atualizado.getCli_senha());
	}

	@Test
	public void testDelete() {
		Cliente usu_salvar = new Cliente();
		usu_salvar.setCli_nome("carlos");
		usu_salvar.setCli_senha("senha_carlos");

		Long id = this.dao.save(usu_salvar);
		this.dao.delete(id);

		Cliente usu_deletado = this.dao.buscarCodigo(id);

		Assert.assertNull(usu_deletado);
	}

	@Test
	public void testFindAll() {
		Cliente cli1 = new Cliente();
		cli1.setCli_nome("cliente 1");
		cli1.setCli_senha("senha_1");
		Cliente cli2 = new Cliente();
		cli2.setCli_nome("cliente 2");
		cli2.setCli_senha("senha_2");

		this.dao.save(cli1);
		this.dao.save(cli2);

		List<Cliente> encontrados = this.dao.buscarTodosClientes();

		Assert.assertEquals(2, encontrados.size());
		Assert.assertEquals("usuario 1", encontrados.get(0).getCli_nome());
		Assert.assertEquals("senha_1", encontrados.get(0).getCli_senha());
		Assert.assertEquals("usuario 2", encontrados.get(1).getCli_nome());
		Assert.assertEquals("senha_2", encontrados.get(1).getCli_senha());
	}
	
	/*public void runTests() {
		this.setDown();
		this.config();
		this.testSave();
		this.setDown();
		this.config();
		this.testUpdate();
		this.setDown();
		this.config();
		this.testFindAll();
		this.setDown();
		this.config();
		this.testDelete();
		this.setDown();
	}
*/
}
