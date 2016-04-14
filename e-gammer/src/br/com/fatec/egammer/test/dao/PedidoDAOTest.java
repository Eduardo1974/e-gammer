package br.com.fatec.egammer.test.dao;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import br.com.fatec.egammer.api.dao.PedidoDAO;
import br.com.fatec.egammer.api.entity.Cliente;
import br.com.fatec.egammer.api.entity.Pedido;
import br.com.fatec.egammer.core.dao.ClienteDAOImpl;
import br.com.fatec.egammer.test.comum.TestBase;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class PedidoDAOTest extends TestBase{
	private PedidoDAO dao;

	@Before
	public void config() {
		this.dao = ImplFinder.getImpl(PedidoDAO.class);
	}

	@Test
	public void testSave() {
		ClienteDAOImpl cliDao = new ClienteDAOImpl();
		Cliente cliente = new Cliente();
		cliente.setCli_email("eduardo@hotmail.com");
		cliente.setCli_nome("eduardo");
		cliente.setCli_senha("1234");
		Long cliCoodigo = cliDao.save(cliente);
		cliente.setCli_codigo(cliCoodigo);
		
		Pedido pedido_salvar = new Pedido();
		pedido_salvar.setCliente(cliente);
		pedido_salvar.setPed_data(new Date());
		pedido_salvar.setPed_valor_total(100.00);
	
		Long id = this.dao.save(pedido_salvar);

		Pedido pedido_salvo = this.dao.buscaPedidoCodigo(id);

		Assert.assertNotNull(pedido_salvo);
       //Assert.assertEquals(new Date(), pedido_salvo.getPed_data());
		Assert.assertEquals(100.00, pedido_salvo.getPed_valor_total(), 0.001);
	}

	@Test
	public void testUpdate() {
		ClienteDAOImpl cliDao = new ClienteDAOImpl();
		Cliente cliente = new Cliente();
		cliente.setCli_email("eduardo@hotmail.com");
		cliente.setCli_nome("eduardo");
		cliente.setCli_senha("1234");
		Long cliCoodigo = cliDao.save(cliente);
		cliente.setCli_codigo(cliCoodigo);
		
		Pedido pedido_salvar = new Pedido();
		pedido_salvar.setCliente(cliente);
		pedido_salvar.setPed_data(new Date());
		pedido_salvar.setPed_valor_total(100.00);
		Long id = this.dao.save(pedido_salvar);

		Pedido pedido_atualizar = this.dao.buscaPedidoCodigo(id);
		pedido_atualizar.setPed_valor_total(200.00);

		boolean resultado = this.dao.update(pedido_atualizar);
		Pedido grupo_atualizado = this.dao.buscaPedidoCodigo(id);

		Assert.assertEquals(true,resultado);
		Assert.assertEquals(200.00, grupo_atualizado.getPed_valor_total(), 0.001);
	}

	@Test
	public void testDelete() {
		ClienteDAOImpl cliDao = new ClienteDAOImpl();
		Cliente cliente = new Cliente();
		cliente.setCli_email("eduardo@hotmail.com");
		cliente.setCli_nome("eduardo");
		cliente.setCli_senha("1234");
		Long cliCoodigo = cliDao.save(cliente);
		cliente.setCli_codigo(cliCoodigo);
		
		Pedido pedido_salvar = new Pedido();
		pedido_salvar.setCliente(cliente);
		pedido_salvar.setPed_data(new Date());
		pedido_salvar.setPed_valor_total(100.00);
	
		Long id = this.dao.save(pedido_salvar);
		
		boolean resultado = this.dao.delete(id);

		Pedido pedido_deletado = this.dao.buscaPedidoCodigo(id);
		Assert.assertEquals(true,resultado);
		Assert.assertNull(pedido_deletado);
	}

		
	@Test
	public void testBuscarTodosCodigos() {
		ClienteDAOImpl cliDao = new ClienteDAOImpl();
		Cliente cliente = new Cliente();
		cliente.setCli_email("eduardo@hotmail.com");
		cliente.setCli_nome("eduardo");
		cliente.setCli_senha("1234");
		Long cliCoodigo = cliDao.save(cliente);
		cliente.setCli_codigo(cliCoodigo);
		
		Pedido pedido_salvar = new Pedido();
		pedido_salvar.setCliente(cliente);
		pedido_salvar.setPed_data(new Date());
		pedido_salvar.setPed_valor_total(100.00);
	
		Long id1 = this.dao.save(pedido_salvar);
		
		Pedido pedido_salvar2 = new Pedido();
		pedido_salvar2.setCliente(cliente);
		pedido_salvar2.setPed_data(new Date());
		pedido_salvar2.setPed_valor_total(100.00);
	
		Long id2 = this.dao.save(pedido_salvar2);
		
		List<Long> ids = Lists.newArrayList();
		ids.add(id1);
		ids.add(id2);
		List<Pedido> encontrados = this.dao.buscaTodosPedidosCodigos(ids);

		Assert.assertEquals(2, encontrados.size());
		Assert.assertEquals(100.00, encontrados.get(0).getPed_valor_total(), 0.001);
		Assert.assertEquals(100.00, encontrados.get(1).getPed_valor_total(), 0.001);
	}
	
	@Test
	public void testBuscarTodosCliente() {
		ClienteDAOImpl cliDao = new ClienteDAOImpl();
		Cliente cliente = new Cliente();
		cliente.setCli_email("eduardo@hotmail.com");
		cliente.setCli_nome("eduardo");
		cliente.setCli_senha("1234");
		Long cliCoodigo = cliDao.save(cliente);
		cliente.setCli_codigo(cliCoodigo);
		
		Pedido pedido_salvar = new Pedido();
		pedido_salvar.setCliente(cliente);
		pedido_salvar.setPed_data(new Date());
		pedido_salvar.setPed_valor_total(100.00);
	
		Long id1 = this.dao.save(pedido_salvar);
		
		Pedido pedido_salvar2 = new Pedido();
		pedido_salvar2.setCliente(cliente);
		pedido_salvar2.setPed_data(new Date());
		pedido_salvar2.setPed_valor_total(100.00);
	
		Long id2 = this.dao.save(pedido_salvar2);
		

		List<Pedido> encontrados = this.dao.buscaTodosPedidosCliente(cliCoodigo);

		Assert.assertEquals(2, encontrados.size());
		Assert.assertEquals(100.00, encontrados.get(0).getPed_valor_total(), 0.001);
		Assert.assertEquals(100.00, encontrados.get(1).getPed_valor_total(), 0.001);
	}
}
