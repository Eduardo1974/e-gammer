package br.com.fatec.egammer.test.dao;

import java.sql.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

import br.com.fatec.egammer.api.dao.ItemPedidoDAO;
import br.com.fatec.egammer.api.dao.PedidoDAO;
import br.com.fatec.egammer.api.entity.Cliente;
import br.com.fatec.egammer.api.entity.Desenvolvedora;
import br.com.fatec.egammer.api.entity.Game;
import br.com.fatec.egammer.api.entity.Genero;
import br.com.fatec.egammer.api.entity.ItemPedido;
import br.com.fatec.egammer.api.entity.Pedido;
import br.com.fatec.egammer.core.dao.ClienteDAOImpl;
import br.com.fatec.egammer.core.dao.DesenvolvedoraDAOImpl;
import br.com.fatec.egammer.core.dao.GameDAOImpl;
import br.com.fatec.egammer.core.dao.GeneroDAOImpl;
import br.com.fatec.egammer.core.dao.PedidoDAOImpl;
import br.com.fatec.egammer.test.comum.TestBase;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class ItemPedidoDAOTest extends TestBase {
	private ItemPedidoDAO dao;

	@Before
	public void config() {
		this.dao = ImplFinder.getImpl(ItemPedidoDAO.class);
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
		
		PedidoDAOImpl pedDao = new PedidoDAOImpl();
		java.util.Date dataUtil = new java.util.Date();
		Date date = new java.sql.Date(dataUtil.getTime());
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setPed_data(new java.sql.Date(dataUtil.getTime()));
		pedido.setPed_valor_total(100.00);
		Long pedCodigo = pedDao.save(pedido);
		pedido.setPed_codigo(pedCodigo);
		
		DesenvolvedoraDAOImpl desDao = new DesenvolvedoraDAOImpl();
		Desenvolvedora des = new Desenvolvedora();
		des.setDes_distribuidora("EA Games");
		des.setDes_studio("Santa Monica");
		Long desCodigo = desDao.save(des);
		des.setDes_codigo(desCodigo);
		
		GeneroDAOImpl genDao = new GeneroDAOImpl();
		Genero genero = new Genero();
		genero.setGen_nome("Ação");
		Long genCodigo = genDao.save(genero);
		genero.setGen_codigo(genCodigo);
		
		
		GameDAOImpl gameDao = new GameDAOImpl();
		Game game = new Game();
		game.setDesenvolvedora(des);
		game.setGam_classificacao("8");
		game.setGam_data_lancamento(new java.sql.Date(dataUtil.getTime()));
		game.setGam_descricao("Jogo de Guerra");
		game.setGam_imagem("C:\\TEMP\\battlefield");
		game.setGam_plataforma("PC");
		game.setGam_preco(99.00);
		game.setGam_quantidade(200);
		game.setGam_titulo("Battlefied 4");
		game.setGenero(genero);
		Long gameCodigo = gameDao.save(game);
		game.setGam_codigo(gameCodigo);
		
		ItemPedido ItemPedidoDAO_salvar = new ItemPedido();
		ItemPedidoDAO_salvar.setIpt_preco_total(100.00);
		ItemPedidoDAO_salvar.setItp_preco_unitario(10.00);
		ItemPedidoDAO_salvar.setItp_quantidade(10);
		ItemPedidoDAO_salvar.setPed_codigo(pedCodigo);
		ItemPedidoDAO_salvar.setGam_codigo(game.getGam_codigo());
	
		
		Long id = this.dao.save(ItemPedidoDAO_salvar);

		ItemPedido itemPedidoDAO_salvo = this.dao.buscaCodigoItemPedido(id);
		
		Assert.assertNotNull(itemPedidoDAO_salvo);
		Assert.assertEquals(100.00, itemPedidoDAO_salvo.getIpt_preco_total(), 0.001);
		Assert.assertEquals(10.00, itemPedidoDAO_salvo.getItp_preco_unitario(), 0.001);
		Assert.assertEquals(10, itemPedidoDAO_salvo.getItp_quantidade(), 1);
		
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
		
		PedidoDAOImpl pedDao = new PedidoDAOImpl();
		java.util.Date dataUtil = new java.util.Date();
		Date date = new java.sql.Date(dataUtil.getTime());
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setPed_data(new java.sql.Date(dataUtil.getTime()));
		pedido.setPed_valor_total(100.00);
		Long pedCodigo = pedDao.save(pedido);
		pedido.setPed_codigo(pedCodigo);
		
		DesenvolvedoraDAOImpl desDao = new DesenvolvedoraDAOImpl();
		Desenvolvedora des = new Desenvolvedora();
		des.setDes_distribuidora("EA Games");
		des.setDes_studio("Santa Monica");
		Long desCodigo = desDao.save(des);
		des.setDes_codigo(desCodigo);
		
		GeneroDAOImpl genDao = new GeneroDAOImpl();
		Genero genero = new Genero();
		genero.setGen_nome("Ação");
		Long genCodigo = genDao.save(genero);
		genero.setGen_codigo(genCodigo);
		
		
		GameDAOImpl gameDao = new GameDAOImpl();
		Game game = new Game();
		game.setDesenvolvedora(des);
		game.setGam_classificacao("8");
		game.setGam_data_lancamento(new java.sql.Date(dataUtil.getTime()));
		game.setGam_descricao("Jogo de Guerra");
		game.setGam_imagem("C:\\TEMP\\battlefield");
		game.setGam_plataforma("PC");
		game.setGam_preco(99.00);
		game.setGam_quantidade(200);
		game.setGam_titulo("Battlefied 4");
		game.setGenero(genero);
		Long gameCodigo = gameDao.save(game);
		game.setGam_codigo(gameCodigo);
		
		ItemPedido ItemPedidoDAO_salvar = new ItemPedido();
		ItemPedidoDAO_salvar.setIpt_preco_total(100.00);
		ItemPedidoDAO_salvar.setItp_preco_unitario(10.00);
		ItemPedidoDAO_salvar.setItp_quantidade(10);
		ItemPedidoDAO_salvar.setPed_codigo(pedCodigo);
		ItemPedidoDAO_salvar.setGam_codigo(game.getGam_codigo());
	
		
		Long id = this.dao.save(ItemPedidoDAO_salvar);
		
		ItemPedido itemPedido_atualizar = this.dao.buscaCodigoItemPedido(id);
		itemPedido_atualizar.setItp_quantidade(5);
		itemPedido_atualizar.setIpt_preco_total(150.00);
		

		boolean resultado = this.dao.update(itemPedido_atualizar);
		ItemPedido ped_atualizado = this.dao.buscaCodigoItemPedido(id);

		Assert.assertEquals(true,resultado);
		Assert.assertNotNull(ped_atualizado);
		Assert.assertEquals(5, ped_atualizado.getItp_quantidade(),1);
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
		
		PedidoDAOImpl pedDao = new PedidoDAOImpl();
		java.util.Date dataUtil = new java.util.Date();
		Date date = new java.sql.Date(dataUtil.getTime());
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setPed_data(new java.sql.Date(dataUtil.getTime()));
		pedido.setPed_valor_total(100.00);
		Long pedCodigo = pedDao.save(pedido);
		pedido.setPed_codigo(pedCodigo);
		
		DesenvolvedoraDAOImpl desDao = new DesenvolvedoraDAOImpl();
		Desenvolvedora des = new Desenvolvedora();
		des.setDes_distribuidora("EA Games");
		des.setDes_studio("Santa Monica");
		Long desCodigo = desDao.save(des);
		des.setDes_codigo(desCodigo);
		
		GeneroDAOImpl genDao = new GeneroDAOImpl();
		Genero genero = new Genero();
		genero.setGen_nome("Ação");
		Long genCodigo = genDao.save(genero);
		genero.setGen_codigo(genCodigo);
		
		
		GameDAOImpl gameDao = new GameDAOImpl();
		Game game = new Game();
		game.setDesenvolvedora(des);
		game.setGam_classificacao("8");
		game.setGam_data_lancamento(new java.sql.Date(dataUtil.getTime()));
		game.setGam_descricao("Jogo de Guerra");
		game.setGam_imagem("C:\\TEMP\\battlefield");
		game.setGam_plataforma("PC");
		game.setGam_preco(99.00);
		game.setGam_quantidade(200);
		game.setGam_titulo("Battlefied 4");
		game.setGenero(genero);
		Long gameCodigo = gameDao.save(game);
		game.setGam_codigo(gameCodigo);
		
		ItemPedido itemPedidoDAO_salvar = new ItemPedido();
		itemPedidoDAO_salvar.setIpt_preco_total(100.00);
		itemPedidoDAO_salvar.setItp_preco_unitario(10.00);
		itemPedidoDAO_salvar.setItp_quantidade(10);
		itemPedidoDAO_salvar.setPed_codigo(pedCodigo);
		itemPedidoDAO_salvar.setGam_codigo(game.getGam_codigo());
	
		
		Long id = this.dao.save(itemPedidoDAO_salvar);
		boolean resultado = this.dao.delete(id);

		ItemPedido ItemPedido_deletado = this.dao.buscaCodigoItemPedido(id);
		Assert.assertEquals(true,resultado);
		Assert.assertNull(ItemPedido_deletado);
	}
	
	@Test
	public void testBuscarTodos() {
		ClienteDAOImpl cliDao = new ClienteDAOImpl();
		Cliente cliente = new Cliente();
		cliente.setCli_email("eduardo@hotmail.com");
		cliente.setCli_nome("eduardo");
		cliente.setCli_senha("1234");
		Long cliCoodigo = cliDao.save(cliente);
		cliente.setCli_codigo(cliCoodigo);
		
		PedidoDAOImpl pedDao = new PedidoDAOImpl();
		java.util.Date dataUtil = new java.util.Date();
		Date date = new java.sql.Date(dataUtil.getTime());
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setPed_data(new java.sql.Date(dataUtil.getTime()));
		pedido.setPed_valor_total(100.00);
		Long pedCodigo = pedDao.save(pedido);
		pedido.setPed_codigo(pedCodigo);
		
		DesenvolvedoraDAOImpl desDao = new DesenvolvedoraDAOImpl();
		Desenvolvedora des = new Desenvolvedora();
		des.setDes_distribuidora("EA Games");
		des.setDes_studio("Santa Monica");
		Long desCodigo = desDao.save(des);
		des.setDes_codigo(desCodigo);
		
		GeneroDAOImpl genDao = new GeneroDAOImpl();
		Genero genero = new Genero();
		genero.setGen_nome("Ação");
		Long genCodigo = genDao.save(genero);
		genero.setGen_codigo(genCodigo);
		
		
		GameDAOImpl gameDao = new GameDAOImpl();
		Game game = new Game();
		game.setDesenvolvedora(des);
		game.setGam_classificacao("8");
		game.setGam_data_lancamento(new java.sql.Date(dataUtil.getTime()));
		game.setGam_descricao("Jogo de Guerra");
		game.setGam_imagem("C:\\TEMP\\battlefield");
		game.setGam_plataforma("PC");
		game.setGam_preco(99.00);
		game.setGam_quantidade(200);
		game.setGam_titulo("Battlefied 4");
		game.setGenero(genero);
		Long gameCodigo = gameDao.save(game);
		game.setGam_codigo(gameCodigo);
		
		ItemPedido itemPedidoDAO_salvar = new ItemPedido();
		itemPedidoDAO_salvar.setIpt_preco_total(100.00);
		itemPedidoDAO_salvar.setItp_preco_unitario(10.00);
		itemPedidoDAO_salvar.setItp_quantidade(10);
		itemPedidoDAO_salvar.setPed_codigo(pedCodigo);
		itemPedidoDAO_salvar.setGam_codigo(game.getGam_codigo());
		Long id = this.dao.save(itemPedidoDAO_salvar);
		
		ItemPedido itemPedidoDAO_salvar2 = new ItemPedido();
		itemPedidoDAO_salvar2.setIpt_preco_total(100.00);
		itemPedidoDAO_salvar2.setItp_preco_unitario(10.00);
		itemPedidoDAO_salvar2.setItp_quantidade(10);
		itemPedidoDAO_salvar2.setPed_codigo(pedCodigo);
		itemPedidoDAO_salvar2.setGam_codigo(game.getGam_codigo());
		Long id2 = this.dao.save(itemPedidoDAO_salvar2);
		
		List<ItemPedido> encontrados = this.dao.buscaTodosItemPedido(pedCodigo);

		Assert.assertEquals(2, encontrados.size());
		Assert.assertEquals(100.00, encontrados.get(0).getIpt_preco_total(), 0.001);
	}
	
	@Test
	public void testBuscarPorCodigo() {
		ClienteDAOImpl cliDao = new ClienteDAOImpl();
		Cliente cliente = new Cliente();
		cliente.setCli_email("eduardo@hotmail.com");
		cliente.setCli_nome("eduardo");
		cliente.setCli_senha("1234");
		Long cliCoodigo = cliDao.save(cliente);
		cliente.setCli_codigo(cliCoodigo);
		
		PedidoDAOImpl pedDao = new PedidoDAOImpl();
		java.util.Date dataUtil = new java.util.Date();
		Date date = new java.sql.Date(dataUtil.getTime());
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setPed_data(new java.sql.Date(dataUtil.getTime()));
		pedido.setPed_valor_total(100.00);
		Long pedCodigo = pedDao.save(pedido);
		pedido.setPed_codigo(pedCodigo);
		
		DesenvolvedoraDAOImpl desDao = new DesenvolvedoraDAOImpl();
		Desenvolvedora des = new Desenvolvedora();
		des.setDes_distribuidora("EA Games");
		des.setDes_studio("Santa Monica");
		Long desCodigo = desDao.save(des);
		des.setDes_codigo(desCodigo);
		
		GeneroDAOImpl genDao = new GeneroDAOImpl();
		Genero genero = new Genero();
		genero.setGen_nome("Ação");
		Long genCodigo = genDao.save(genero);
		genero.setGen_codigo(genCodigo);
		
		
		GameDAOImpl gameDao = new GameDAOImpl();
		Game game = new Game();
		game.setDesenvolvedora(des);
		game.setGam_classificacao("8");
		game.setGam_data_lancamento(new java.sql.Date(dataUtil.getTime()));
		game.setGam_descricao("Jogo de Guerra");
		game.setGam_imagem("C:\\TEMP\\battlefield");
		game.setGam_plataforma("PC");
		game.setGam_preco(99.00);
		game.setGam_quantidade(200);
		game.setGam_titulo("Battlefied 4");
		game.setGenero(genero);
		Long gameCodigo = gameDao.save(game);
		game.setGam_codigo(gameCodigo);
		
		ItemPedido itemPedidoDAO_salvar = new ItemPedido();
		itemPedidoDAO_salvar.setIpt_preco_total(100.00);
		itemPedidoDAO_salvar.setItp_preco_unitario(10.00);
		itemPedidoDAO_salvar.setItp_quantidade(10);
		itemPedidoDAO_salvar.setPed_codigo(pedCodigo);
		itemPedidoDAO_salvar.setGam_codigo(game.getGam_codigo());
	
		
		Long id = this.dao.save(itemPedidoDAO_salvar);
		
		ItemPedido encontrado = this.dao.buscaCodigoItemPedido(id);

		Assert.assertEquals(100.00, encontrado.getIpt_preco_total(), 0.001);
		Assert.assertEquals(10.00, encontrado.getItp_preco_unitario(), 0.001);
	}
	
	@Test
	public void testBuscarTodosListaCodigos() {
		ClienteDAOImpl cliDao = new ClienteDAOImpl();
		Cliente cliente = new Cliente();
		cliente.setCli_email("eduardo@hotmail.com");
		cliente.setCli_nome("eduardo");
		cliente.setCli_senha("1234");
		Long cliCoodigo = cliDao.save(cliente);
		cliente.setCli_codigo(cliCoodigo);
		
		PedidoDAOImpl pedDao = new PedidoDAOImpl();
		java.util.Date dataUtil = new java.util.Date();
		Date date = new java.sql.Date(dataUtil.getTime());
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setPed_data(new java.sql.Date(dataUtil.getTime()));
		pedido.setPed_valor_total(100.00);
		Long pedCodigo = pedDao.save(pedido);
		pedido.setPed_codigo(pedCodigo);
		
		DesenvolvedoraDAOImpl desDao = new DesenvolvedoraDAOImpl();
		Desenvolvedora des = new Desenvolvedora();
		des.setDes_distribuidora("EA Games");
		des.setDes_studio("Santa Monica");
		Long desCodigo = desDao.save(des);
		des.setDes_codigo(desCodigo);
		
		GeneroDAOImpl genDao = new GeneroDAOImpl();
		Genero genero = new Genero();
		genero.setGen_nome("Ação");
		Long genCodigo = genDao.save(genero);
		genero.setGen_codigo(genCodigo);
		
		
		GameDAOImpl gameDao = new GameDAOImpl();
		Game game = new Game();
		game.setDesenvolvedora(des);
		game.setGam_classificacao("8");
		game.setGam_data_lancamento(new java.sql.Date(dataUtil.getTime()));
		game.setGam_descricao("Jogo de Guerra");
		game.setGam_imagem("C:\\TEMP\\battlefield");
		game.setGam_plataforma("PC");
		game.setGam_preco(99.00);
		game.setGam_quantidade(200);
		game.setGam_titulo("Battlefied 4");
		game.setGenero(genero);
		Long gameCodigo = gameDao.save(game);
		game.setGam_codigo(gameCodigo);
		
		ItemPedido itemPedidoDAO_salvar = new ItemPedido();
		itemPedidoDAO_salvar.setIpt_preco_total(100.00);
		itemPedidoDAO_salvar.setItp_preco_unitario(10.00);
		itemPedidoDAO_salvar.setItp_quantidade(10);
		itemPedidoDAO_salvar.setPed_codigo(pedCodigo);
		itemPedidoDAO_salvar.setGam_codigo(game.getGam_codigo());
	
		
		Long id1 = this.dao.save(itemPedidoDAO_salvar);
		
		ClienteDAOImpl cliDao2 = new ClienteDAOImpl();
		Cliente cliente2 = new Cliente();
		cliente2.setCli_email("eduardo@hotmail.com");
		cliente2.setCli_nome("eduardo");
		cliente2.setCli_senha("1234");
		Long cliCoodigo2 = cliDao2.save(cliente2);
		cliente2.setCli_codigo(cliCoodigo2);
		
		PedidoDAOImpl pedDao2 = new PedidoDAOImpl();
		Pedido pedido2 = new Pedido();
		pedido2.setCliente(cliente);
		pedido2.setPed_data(new java.sql.Date(dataUtil.getTime()));
		pedido2.setPed_valor_total(100.00);
		Long pedCodigo2 = pedDao2.save(pedido2);
		pedido2.setPed_codigo(pedCodigo2);
		
		DesenvolvedoraDAOImpl desDao2 = new DesenvolvedoraDAOImpl();
		Desenvolvedora des2 = new Desenvolvedora();
		des.setDes_distribuidora("EA Games");
		des2.setDes_studio("Santa Monica");
		Long desCodigo2 = desDao2.save(des2);
		des.setDes_codigo(desCodigo2);
		
		GeneroDAOImpl genDao2 = new GeneroDAOImpl();
		Genero genero2 = new Genero();
		genero2.setGen_nome("Ação");
		Long genCodigo2 = genDao2.save(genero2);
		genero.setGen_codigo(genCodigo2);
		
		
		GameDAOImpl gameDao2 = new GameDAOImpl();
		Game game2 = new Game();
		game2.setDesenvolvedora(des);
		game2.setGam_classificacao("8");
		game2.setGam_data_lancamento(new java.sql.Date(dataUtil.getTime()));
		game2.setGam_descricao("Jogo de Guerra");
		game2.setGam_imagem("C:\\TEMP\\battlefield");
		game2.setGam_plataforma("PC");
		game2.setGam_preco(99.00);
		game2.setGam_quantidade(200);
		game2.setGam_titulo("Gta V");
		game2.setGenero(genero);
		Long gameCodigo2 = gameDao2.save(game2);
		game2.setGam_codigo(gameCodigo2);
		
		ItemPedido itemPedidoDAO_salvar2 = new ItemPedido();
		itemPedidoDAO_salvar2.setIpt_preco_total(100.00);
		itemPedidoDAO_salvar2.setItp_preco_unitario(10.00);
		itemPedidoDAO_salvar2.setItp_quantidade(10);
		itemPedidoDAO_salvar2.setPed_codigo(pedCodigo2);
		itemPedidoDAO_salvar2.setGam_codigo(game.getGam_codigo());
	
		Long id2 = this.dao.save(itemPedidoDAO_salvar2);
		List<Long> ids = Lists.newArrayList();
		ids.add(id1);
		ids.add(id2);
		List<ItemPedido> encontrados = this.dao.buscaTodosItensDoPedido(ids);

		Assert.assertEquals(2, encontrados.size());
		Assert.assertEquals(100.00, encontrados.get(0).getIpt_preco_total(), 0.001);
	}
}
