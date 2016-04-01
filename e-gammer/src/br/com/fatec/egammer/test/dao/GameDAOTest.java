package br.com.fatec.egammer.test.dao;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.fatec.egammer.api.dao.DesenvolvedoraDAO;
import br.com.fatec.egammer.api.dao.GameDAO;
import br.com.fatec.egammer.api.dao.GeneroDAO;
import br.com.fatec.egammer.api.entity.Desenvolvedora;
import br.com.fatec.egammer.api.entity.Game;
import br.com.fatec.egammer.api.entity.Genero;
import br.com.fatec.egammer.test.comum.TestBase;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class GameDAOTest extends TestBase{
	private GameDAO dao;
	private GeneroDAO daoGenero;
	private DesenvolvedoraDAO daoDesenvolvedora;

	@Before
	public void config() {
		this.dao = ImplFinder.getImpl(GameDAO.class);
		this.daoGenero = ImplFinder.getImpl(GeneroDAO.class);
		this.daoDesenvolvedora = ImplFinder.getImpl(DesenvolvedoraDAO.class);
	}

	@Test
	public void testSave() throws ParseException {
		Desenvolvedora des = new Desenvolvedora();
		//des.setDes_codigo((long) 1);
		des.setDes_distribuidora("EA Games");
		des.setDes_studio("Santa Monica");
		
		Long id_desenv = daoDesenvolvedora.save(des);
		
		Genero genero = new Genero();
		//genero.setGen_codigo((long)1);
		genero.setGen_nome("Ação");
		
		Long id_genero = daoGenero.save(genero);
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date(format.parse("28/03/2012").getTime());
		
		Game game = new Game();
		game.setGam_classificacao(8);
		game.setGam_data_lancamento(data);
		game.setGam_descricao("Jogo de Guerra");
		game.setGam_imagem("C:\\TEMP\\battlefield");
		game.setGam_plataforma("PC");
		game.setGam_preco(4000.00);
		game.setGam_quantidade(200);
		game.setGam_titulo("Battlefild 4");
		game.setDesenvolvedora(this.daoDesenvolvedora.buscarCodigo(id_desenv));
		game.setGenero(this.daoGenero.buscaCodigo(id_genero));

		Long codigo = this.dao.save(game);

		Game game_salvo = this.dao.buscarCodigo(codigo);

		Assert.assertNotNull(game_salvo);
		Assert.assertEquals("Battlefild 4", game_salvo.getGam_titulo());
		Assert.assertEquals("Jogo de Guerra", game_salvo.getGam_descricao());
	}

	@Test
	public void testUpdate() throws ParseException {
		Desenvolvedora des = new Desenvolvedora();
		//des.setDes_codigo((long) 1);
		des.setDes_distribuidora("EA Games");
		des.setDes_studio("Santa Monica");
		
		Long id_desenv = daoDesenvolvedora.save(des);
		
		Genero genero = new Genero();
		//genero.setGen_codigo((long)1);
		genero.setGen_nome("Ação");
		
		Long id_genero = daoGenero.save(genero);
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date(format.parse("28/03/2016").getTime());
		
		Game game = new Game();
		game.setGam_classificacao(8);
		game.setGam_data_lancamento(data);
		game.setGam_descricao("Jogo de Guerra");
		game.setGam_imagem("C:\\TEMP\\battlefield");
		game.setGam_plataforma("PC");
		game.setGam_preco(188.88); //DEBUGAR AQUI 188.88
		game.setGam_quantidade(200);
		game.setGam_titulo("nfs ++");
		game.setDesenvolvedora(this.daoDesenvolvedora.buscarCodigo(id_desenv));
		game.setGenero(this.daoGenero.buscaCodigo(id_genero));

		Long codigo = this.dao.save(game);
		
		Game game_atualizar = this.dao.buscarCodigo(codigo);
		game_atualizar.setGam_titulo("Need for Speed No Limits");
		game_atualizar.setGam_descricao("É um jogo de corrida frenetica nos USA");
		game.setGam_preco(99.00);

		this.dao.update(game_atualizar);
		Game gam_atualizado = this.dao.buscarCodigo(codigo);

		Assert.assertNotNull(gam_atualizado);
		Assert.assertEquals("Need for Speed No Limits", gam_atualizado.getGam_titulo());
		Assert.assertEquals("É um jogo de corrida frenetica nos USA", gam_atualizado.getGam_descricao());
	}

	@Test
	public void testDelete() throws ParseException {
		Desenvolvedora des = new Desenvolvedora();
		//des.setDes_codigo((long) 1);
		des.setDes_distribuidora("EA Games");
		des.setDes_studio("Santa Monica");
		
		Long id_desenv = daoDesenvolvedora.save(des);
		
		Genero genero = new Genero();
		//genero.setGen_codigo((long)1);
		genero.setGen_nome("Ação");
		
		Long id_genero = daoGenero.save(genero);
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date(format.parse("28/03/2016").getTime());
		
		Game game = new Game();
		game.setGam_classificacao(8);
		game.setGam_data_lancamento(data);
		game.setGam_descricao("Jogo de Guerra");
		game.setGam_imagem("C:\\TEMP\\battlefield");
		game.setGam_plataforma("PC");
		game.setGam_preco(188.88); //DEBUGAR AQUI 188.88
		game.setGam_quantidade(200);
		game.setGam_titulo("nfs ++");
		game.setDesenvolvedora(this.daoDesenvolvedora.buscarCodigo(id_desenv));
		game.setGenero(this.daoGenero.buscaCodigo(id_genero));

		Long codigo = this.dao.save(game);
		
		this.dao.delete(codigo);

		Game des_deletado = this.dao.buscarCodigo(codigo);

		Assert.assertNull(des_deletado);
	}

	@Test
	public void testBuscarTodos() throws ParseException {
		Desenvolvedora des = new Desenvolvedora();
		//des.setDes_codigo((long) 1);
		des.setDes_distribuidora("EA Games");
		des.setDes_studio("Santa Monica");
		
		Long id_desenv = daoDesenvolvedora.save(des);
		
		Genero genero = new Genero();
		//genero.setGen_codigo((long)1);
		genero.setGen_nome("Ação");
		
		Long id_genero = daoGenero.save(genero);
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date data = new Date(format.parse("28/03/2016").getTime());
		
		Game game1 = new Game();
		game1.setGam_classificacao(8);
		game1.setGam_data_lancamento(data);
		game1.setGam_descricao("Jogo de Guerra Moderna");
		game1.setGam_imagem("C:\\TEMP\\battlefield");
		game1.setGam_plataforma("PC");
		game1.setGam_preco(230.98);
		game1.setGam_quantidade(200);
		game1.setGam_titulo("Battle Field");
		game1.setDesenvolvedora(this.daoDesenvolvedora.buscarCodigo(id_desenv));
		game1.setGenero(this.daoGenero.buscaCodigo(id_genero));

		Game game2 = new Game();
		game2.setGam_classificacao(8);
		game2.setGam_data_lancamento(data);
		game2.setGam_descricao("Jogo de Corrida");
		game2.setGam_imagem("C:\\TEMP\\Need FS");
		game2.setGam_plataforma("PC");
		game2.setGam_preco(100.10);
		game2.setGam_quantidade(30);
		game2.setGam_titulo("nfs 2016");
		game2.setDesenvolvedora(this.daoDesenvolvedora.buscarCodigo(id_desenv));
		game2.setGenero(this.daoGenero.buscaCodigo(id_genero));
		
		this.dao.save(game1);
		this.dao.save(game2);

		List<Game> encontrados = this.dao.buscarTodosGames();

		Assert.assertEquals(2, encontrados.size());
		Assert.assertEquals("Battle Field", encontrados.get(0).getGam_titulo());
		Assert.assertEquals("Jogo de Guerra Moderna", encontrados.get(0).getGam_descricao());
		Assert.assertEquals("nfs 2016", encontrados.get(1).getGam_titulo());
		Assert.assertEquals("Jogo de Corrida", encontrados.get(1).getGam_descricao());
	}

}
