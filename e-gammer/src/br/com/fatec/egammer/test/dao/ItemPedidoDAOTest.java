package br.com.fatec.egammer.test.dao;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

import br.com.fatec.egammer.api.dao.ItemPedidoDAO;
import br.com.fatec.egammer.api.entity.Cliente;
import br.com.fatec.egammer.api.entity.Desenvolvedora;
import br.com.fatec.egammer.api.entity.Game;
import br.com.fatec.egammer.api.entity.Genero;
import br.com.fatec.egammer.api.entity.ItemPedido;
import br.com.fatec.egammer.api.entity.Pedido;
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
		
		Cliente cliente = new Cliente();
		cliente.setCli_codigo((long) 1);
		cliente.setCli_email("eduardo@hotmail.com");
		cliente.setCli_nome("eduardo");
		cliente.setCli_senha("1234");
		
		Date date = new Date();
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setPed_codigo((long)1);
		pedido.setPed_data(new Date());
		pedido.setPed_valor_total(100.00);
		
		Desenvolvedora des = new Desenvolvedora();
		des.setDes_codigo((long) 1);
		des.setDes_distribuidora("EA Games");
		des.setDes_studio("Santa Monica");
		
		Genero genero = new Genero();
		genero.setGen_codigo((long)1);
		genero.setGen_nome("Ação");
		
		Game game = new Game();
		game.setDesenvolvedora(des);
		game.setGam_classificacao(8);
		game.setGam_codigo((long)1);
		game.setGam_data_lancamento(new Date());
		game.setGam_desccricao("Jogo de Guerra");
		game.setGam_imagem("C:\\TEMP\\battlefield");
		game.setGam_plataforma("PC");
		game.setGam_preco(99.00);
		game.setGam_quantidade(200);
		game.setGam_titulo("Battlefild 4");
		game.setGenero(genero);
		
		ItemPedido ItemPedidoDAO_salvar = new ItemPedido();
		ItemPedidoDAO_salvar.setIpt_preco_total(100.00);
		ItemPedidoDAO_salvar.setItp_preco_unitario(10.00);
		ItemPedidoDAO_salvar.setItp_quantidade(10);
		ItemPedidoDAO_salvar.setPedido(pedido);
		ItemPedidoDAO_salvar.setGame(game);
	
		
		Long id = this.dao.save(ItemPedidoDAO_salvar);

		ItemPedido ItemPedidoDAO_salvo = this.dao.buscaCodigoItemPedido(id);

		Assert.assertNotNull(ItemPedidoDAO_salvo);
		Assert.assertEquals("Battlefied 4", ItemPedidoDAO_salvo.getGame().getGam_titulo());
		Assert.assertEquals(100.00, ItemPedidoDAO_salvo.getIpt_preco_total().doubleValue());
		Assert.assertEquals(10.00, ItemPedidoDAO_salvo.getItp_preco_unitario().doubleValue());
		Assert.assertEquals(10, ItemPedidoDAO_salvo.getItp_quantidade().intValue());
		Assert.assertEquals(new Date(), ItemPedidoDAO_salvo.getPedido().getPed_data());
	}

	@Test
	public void testUpdate() {
		Cliente cliente = new Cliente();
		cliente.setCli_codigo((long) 1);
		cliente.setCli_email("eduardo@hotmail.com");
		cliente.setCli_nome("eduardo");
		cliente.setCli_senha("1234");
		
		Date date = new Date();
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setPed_codigo((long)1);
		pedido.setPed_data(new Date());
		pedido.setPed_valor_total(100.00);
		
		Desenvolvedora des = new Desenvolvedora();
		des.setDes_codigo((long) 1);
		des.setDes_distribuidora("EA Games");
		des.setDes_studio("Santa Monica");
		
		Genero genero = new Genero();
		genero.setGen_codigo((long)1);
		genero.setGen_nome("Ação");
		
		Game game = new Game();
		game.setDesenvolvedora(des);
		game.setGam_classificacao(8);
		game.setGam_codigo((long)1);
		game.setGam_data_lancamento(new Date());
		game.setGam_desccricao("Jogo de Guerra");
		game.setGam_imagem("C:\\TEMP\\battlefield");
		game.setGam_plataforma("PC");
		game.setGam_preco(99.00);
		game.setGam_quantidade(200);
		game.setGam_titulo("Battlefild 4");
		game.setGenero(genero);
		
		ItemPedido ItemPedidoDAO_salvar = new ItemPedido();
		ItemPedidoDAO_salvar.setIpt_preco_total(100.00);
		ItemPedidoDAO_salvar.setItp_preco_unitario(10.00);
		ItemPedidoDAO_salvar.setItp_quantidade(10);
		ItemPedidoDAO_salvar.setPedido(pedido);
		ItemPedidoDAO_salvar.setGame(game);
		Long id = this.dao.save(ItemPedidoDAO_salvar);
		
		ItemPedido ItemPedido_atualizar = this.dao.buscaCodigoItemPedido(id);
		ItemPedido_atualizar.setIpt_preco_total(89.90);

		boolean resultado = this.dao.update(ItemPedido_atualizar);
		ItemPedido ped_atualizado = this.dao.buscaCodigoItemPedido(id);

		Assert.assertEquals(true,resultado);
		Assert.assertNotNull(ped_atualizado);
		Assert.assertEquals(89.90, ped_atualizado.getIpt_preco_total().doubleValue());
	}
	
	@Test
	public void testDelete() {
		Cliente cliente = new Cliente();
		cliente.setCli_codigo((long) 1);
		cliente.setCli_email("eduardo@hotmail.com");
		cliente.setCli_nome("eduardo");
		cliente.setCli_senha("1234");
		
		Date date = new Date();
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setPed_codigo((long)1);
		pedido.setPed_data(new Date());
		pedido.setPed_valor_total(100.00);
		
		Desenvolvedora des = new Desenvolvedora();
		des.setDes_codigo((long) 1);
		des.setDes_distribuidora("EA Games");
		des.setDes_studio("Santa Monica");
		
		Genero genero = new Genero();
		genero.setGen_codigo((long)1);
		genero.setGen_nome("Ação");
		
		Game game = new Game();
		game.setDesenvolvedora(des);
		game.setGam_classificacao(8);
		game.setGam_codigo((long)1);
		game.setGam_data_lancamento(new Date());
		game.setGam_desccricao("Jogo de Guerra");
		game.setGam_imagem("C:\\TEMP\\battlefield");
		game.setGam_plataforma("PC");
		game.setGam_preco(99.00);
		game.setGam_quantidade(200);
		game.setGam_titulo("Battlefild 4");
		game.setGenero(genero);
		
		ItemPedido ItemPedidoDAO_salvar = new ItemPedido();
		ItemPedidoDAO_salvar.setIpt_preco_total(100.00);
		ItemPedidoDAO_salvar.setItp_preco_unitario(10.00);
		ItemPedidoDAO_salvar.setItp_quantidade(10);
		ItemPedidoDAO_salvar.setPedido(pedido);
		ItemPedidoDAO_salvar.setGame(game);

		Long id = this.dao.save(ItemPedidoDAO_salvar);
		boolean resultado = this.dao.delete(id);

		ItemPedido ItemPedido_deletado = this.dao.buscaCodigoItemPedido(id);
		Assert.assertEquals(true,resultado);
		Assert.assertNull(ItemPedido_deletado);
	}
	
	@Test
	public void testBuscarTodos() {
		Cliente cliente = new Cliente();
		cliente.setCli_codigo((long) 1);
		cliente.setCli_email("eduardo@hotmail.com");
		cliente.setCli_nome("eduardo");
		cliente.setCli_senha("1234");
		
		Date date = new Date();
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setPed_codigo((long)1);
		pedido.setPed_data(new Date());
		pedido.setPed_valor_total(100.00);
		
		Desenvolvedora des = new Desenvolvedora();
		des.setDes_codigo((long) 1);
		des.setDes_distribuidora("EA Games");
		des.setDes_studio("Santa Monica");
		
		Genero genero = new Genero();
		genero.setGen_codigo((long)1);
		genero.setGen_nome("Ação");
		
		Game game = new Game();
		game.setDesenvolvedora(des);
		game.setGam_classificacao(8);
		game.setGam_codigo((long)1);
		game.setGam_data_lancamento(new Date());
		game.setGam_desccricao("Jogo de Guerra");
		game.setGam_imagem("C:\\TEMP\\battlefield");
		game.setGam_plataforma("PC");
		game.setGam_preco(99.00);
		game.setGam_quantidade(200);
		game.setGam_titulo("Battlefild 4");
		game.setGenero(genero);
		
		ItemPedido ItemPedidoDAO_salvar = new ItemPedido();
		ItemPedidoDAO_salvar.setIpt_preco_total(100.00);
		ItemPedidoDAO_salvar.setItp_preco_unitario(10.00);
		ItemPedidoDAO_salvar.setItp_quantidade(10);
		ItemPedidoDAO_salvar.setPedido(pedido);
		ItemPedidoDAO_salvar.setGame(game);
		
		Cliente cliente2 = new Cliente();
		cliente2.setCli_codigo((long) 1);
		cliente2.setCli_email("marcelo@hotmail.com");
		cliente2.setCli_nome("eduardo");
		cliente2.setCli_senha("1234");
		
		Date date2 = new Date();
		Pedido pedido2 = new Pedido();
		pedido2.setCliente(cliente);
		pedido2.setPed_codigo((long)1);
		pedido2.setPed_data(new Date());
		pedido2.setPed_valor_total(150.00);
		
		Desenvolvedora des2 = new Desenvolvedora();
		des2.setDes_codigo((long) 1);
		des2.setDes_distribuidora("RockStar Games");
		des2.setDes_studio("Santa Monica");
		
		Genero genero2 = new Genero();
		genero2.setGen_codigo((long)1);
		genero2.setGen_nome("Aventura");
		
		Game game2 = new Game();
		game2.setDesenvolvedora(des);
		game2.setGam_classificacao(8);
		game2.setGam_codigo((long)1);
		game2.setGam_data_lancamento(new Date());
		game2.setGam_desccricao("Aventura");
		game2.setGam_imagem("C:\\TEMP\\Gta V");
		game2.setGam_plataforma("PC");
		game2.setGam_preco(99.00);
		game2.setGam_quantidade(200);
		game2.setGam_titulo("Gta V");
		game2.setGenero(genero);
		
		ItemPedido ItemPedidoDAO_salvar2 = new ItemPedido();
		ItemPedidoDAO_salvar2.setIpt_preco_total(100.00);
		ItemPedidoDAO_salvar2.setItp_preco_unitario(15.00);
		ItemPedidoDAO_salvar2.setItp_quantidade(10);
		ItemPedidoDAO_salvar2.setPedido(pedido);
		ItemPedidoDAO_salvar2.setGame(game);
		

		this.dao.save(ItemPedidoDAO_salvar);
		this.dao.save(ItemPedidoDAO_salvar2);

		List<ItemPedido> encontrados = this.dao.buscaTodosItemPedido();

		Assert.assertEquals(2, encontrados.size());
		Assert.assertEquals(100.00, encontrados.get(0).getIpt_preco_total().doubleValue());
		Assert.assertEquals("Gta V", encontrados.get(1).getGame().getGam_titulo());
	}
	
	@Test
	public void testBuscarTodosCodigo() {
		Cliente cliente = new Cliente();
		cliente.setCli_codigo((long) 1);
		cliente.setCli_email("eduardo@hotmail.com");
		cliente.setCli_nome("eduardo");
		cliente.setCli_senha("1234");
		
		Date date = new Date();
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setPed_codigo((long)1);
		pedido.setPed_data(new Date());
		pedido.setPed_valor_total(100.00);
		
		Desenvolvedora des = new Desenvolvedora();
		des.setDes_codigo((long) 1);
		des.setDes_distribuidora("EA Games");
		des.setDes_studio("Santa Monica");
		
		Genero genero = new Genero();
		genero.setGen_codigo((long)1);
		genero.setGen_nome("Ação");
		
		Game game = new Game();
		game.setDesenvolvedora(des);
		game.setGam_classificacao(8);
		game.setGam_codigo((long)1);
		game.setGam_data_lancamento(new Date());
		game.setGam_desccricao("Jogo de Guerra");
		game.setGam_imagem("C:\\TEMP\\battlefield");
		game.setGam_plataforma("PC");
		game.setGam_preco(99.00);
		game.setGam_quantidade(200);
		game.setGam_titulo("Battlefild 4");
		game.setGenero(genero);
		
		ItemPedido ItemPedidoDAO_salvar = new ItemPedido();
		ItemPedidoDAO_salvar.setIpt_preco_total(100.00);
		ItemPedidoDAO_salvar.setItp_preco_unitario(10.00);
		ItemPedidoDAO_salvar.setItp_quantidade(10);
		ItemPedidoDAO_salvar.setPedido(pedido);
		ItemPedidoDAO_salvar.setGame(game);

		Long id = this.dao.save(ItemPedidoDAO_salvar);
		
		ItemPedido encontrado = this.dao.buscaCodigoItemPedido(id);

		Assert.assertEquals(100.00, encontrado.getIpt_preco_total().doubleValue());
		Assert.assertEquals("Gta V", encontrado.getGame().getGam_titulo());
		Assert.assertEquals(10.00, encontrado.getItp_preco_unitario().doubleValue());
	}
	
	@Test
	public void testBuscarTodosListaCodigos() {
		Cliente cliente = new Cliente();
		cliente.setCli_codigo((long) 1);
		cliente.setCli_email("eduardo@hotmail.com");
		cliente.setCli_nome("eduardo");
		cliente.setCli_senha("1234");
		
		Date date = new Date();
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setPed_codigo((long)1);
		pedido.setPed_data(new Date());
		pedido.setPed_valor_total(100.00);
		
		Desenvolvedora des = new Desenvolvedora();
		des.setDes_codigo((long) 1);
		des.setDes_distribuidora("EA Games");
		des.setDes_studio("Santa Monica");
		
		Genero genero = new Genero();
		genero.setGen_codigo((long)1);
		genero.setGen_nome("Ação");
		
		Game game = new Game();
		game.setDesenvolvedora(des);
		game.setGam_classificacao(8);
		game.setGam_codigo((long)1);
		game.setGam_data_lancamento(new Date());
		game.setGam_desccricao("Jogo de Guerra");
		game.setGam_imagem("C:\\TEMP\\battlefield");
		game.setGam_plataforma("PC");
		game.setGam_preco(99.00);
		game.setGam_quantidade(200);
		game.setGam_titulo("Battlefild 4");
		game.setGenero(genero);
		
		ItemPedido ItemPedidoDAO_salvar = new ItemPedido();
		ItemPedidoDAO_salvar.setIpt_preco_total(100.00);
		ItemPedidoDAO_salvar.setItp_preco_unitario(10.00);
		ItemPedidoDAO_salvar.setItp_quantidade(10);
		ItemPedidoDAO_salvar.setPedido(pedido);
		ItemPedidoDAO_salvar.setGame(game);
		
		Cliente cliente2 = new Cliente();
		cliente2.setCli_codigo((long) 1);
		cliente2.setCli_email("marcelo@hotmail.com");
		cliente2.setCli_nome("eduardo");
		cliente2.setCli_senha("1234");
		
		Date date2 = new Date();
		Pedido pedido2 = new Pedido();
		pedido2.setCliente(cliente);
		pedido2.setPed_codigo((long)1);
		pedido2.setPed_data(new Date());
		pedido2.setPed_valor_total(150.00);
		
		Desenvolvedora des2 = new Desenvolvedora();
		des2.setDes_codigo((long) 1);
		des2.setDes_distribuidora("RockStar Games");
		des2.setDes_studio("Santa Monica");
		
		Genero genero2 = new Genero();
		genero2.setGen_codigo((long)1);
		genero2.setGen_nome("Aventura");
		
		Game game2 = new Game();
		game2.setDesenvolvedora(des);
		game2.setGam_classificacao(8);
		game2.setGam_codigo((long)1);
		game2.setGam_data_lancamento(new Date());
		game2.setGam_desccricao("Aventura");
		game2.setGam_imagem("C:\\TEMP\\Gta V");
		game2.setGam_plataforma("PC");
		game2.setGam_preco(99.00);
		game2.setGam_quantidade(200);
		game2.setGam_titulo("Gta V");
		game2.setGenero(genero);
		
		ItemPedido ItemPedidoDAO_salvar2 = new ItemPedido();
		ItemPedidoDAO_salvar2.setIpt_preco_total(100.00);
		ItemPedidoDAO_salvar2.setItp_preco_unitario(15.00);
		ItemPedidoDAO_salvar2.setItp_quantidade(10);
		ItemPedidoDAO_salvar2.setPedido(pedido);
		ItemPedidoDAO_salvar2.setGame(game);
	
		Long id1 = this.dao.save(ItemPedidoDAO_salvar);
		Long id2 = this.dao.save(ItemPedidoDAO_salvar2);
		List<Long> ids = Lists.newArrayList();
		ids.add(id1);
		ids.add(id2);
		List<ItemPedido> encontrados = this.dao.buscaTodosItensDoPedido(ids);

		Assert.assertEquals(2, encontrados.size());
		Assert.assertEquals(100.00, encontrados.get(0).getIpt_preco_total().doubleValue());
		Assert.assertEquals("Gta V", encontrados.get(1).getGame().getGam_titulo());
	}

}
