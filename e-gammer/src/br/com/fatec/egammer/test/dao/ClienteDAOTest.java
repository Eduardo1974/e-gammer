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
	public void testSave() {
		Cliente cli_salvar = new Cliente();
		cli_salvar.setCli_nome("eduardo");
		cli_salvar.setCli_email("edu@fatec.com");
		cli_salvar.setCli_senha("1234");
		cli_salvar.setCli_tipo("cliente");
		Long codigo = this.dao.save(cli_salvar);

		Cliente cli_salvo = this.dao.buscarCodigo(codigo);

		Assert.assertNotNull(cli_salvo);
		Assert.assertEquals("eduardo", cli_salvo.getCli_nome());
		Assert.assertEquals("edu@fatec.com", cli_salvo.getCli_email());
		Assert.assertEquals("1234", cli_salvo.getCli_senha());
	}

	@Test
	public void testUpdate() {
		Cliente cli_salvar = new Cliente();
		cli_salvar.setCli_nome("carlos");
		cli_salvar.setCli_email("carlos@fatec.com");
		cli_salvar.setCli_senha("senha_carlos");

		Long codigo = this.dao.save(cli_salvar);
		Cliente cli_atualizar = this.dao.buscarCodigo(codigo);

		cli_atualizar.setCli_nome("carlos oliveira");
		cli_atualizar.setCli_email("augusto@fatec.com");
		cli_atualizar.setCli_senha("nova_senha");

		this.dao.update(cli_atualizar);
		Cliente usu_atualizado = this.dao.buscarCodigo(codigo);

		Assert.assertNotNull(usu_atualizado);
		Assert.assertEquals("carlos oliveira", usu_atualizado.getCli_nome());
		Assert.assertEquals("augusto@fatec.com", usu_atualizado.getCli_email());
		Assert.assertEquals("nova_senha", usu_atualizado.getCli_senha());
	}

	@Test
	public void testDelete() {
		Cliente cli_salvar = new Cliente();
		cli_salvar.setCli_nome("carlos");
		cli_salvar.setCli_email("augusto@fatec.com");
		cli_salvar.setCli_senha("senha_carlos");

		Long codigo = this.dao.save(cli_salvar);
		this.dao.delete(codigo);

		Cliente cli_deletado = this.dao.buscarCodigo(codigo);

		Assert.assertNull(cli_deletado);
	}

	@Test
	public void testBuscarTodos() {
		Cliente cli1 = new Cliente();
		cli1.setCli_nome("cliente 1");
		cli1.setCli_email("cliente1@fatec.com");
		cli1.setCli_senha("senha_1");
		Cliente cli2 = new Cliente();
		cli2.setCli_nome("cliente 2");
		cli2.setCli_email("cliente2@fatec.com");
		cli2.setCli_senha("senha_2");

		this.dao.save(cli1);
		this.dao.save(cli2);

		List<Cliente> encontrados = this.dao.buscarTodosClientes();

		Assert.assertEquals(2, encontrados.size());
		Assert.assertEquals("cliente 1", encontrados.get(0).getCli_nome());
		Assert.assertEquals("cliente1@fatec.com", encontrados.get(0).getCli_email());
		Assert.assertEquals("senha_1", encontrados.get(0).getCli_senha());
		Assert.assertEquals("cliente 2", encontrados.get(1).getCli_nome());
		Assert.assertEquals("cliente2@fatec.com", encontrados.get(0).getCli_email());
		Assert.assertEquals("senha_2", encontrados.get(1).getCli_senha());
	}
	
	@Test
	public void testLogin() {
		Cliente cli_salvar = new Cliente();
		cli_salvar.setCli_nome("carlos");
		cli_salvar.setCli_email("augusto@fatec.com");
		cli_salvar.setCli_senha("senha_carlos");

		Long codigo = this.dao.save(cli_salvar);

		Cliente cli_busca = this.dao.buscarCodigo(codigo);
		Cliente cli_logado = this.dao.buscarPorLoginESenha(cli_busca.getCli_email(), cli_busca.getCli_senha());

		Assert.assertNotNull(cli_logado);
	}
	
	

}
