package br.com.fatec.egammer.test.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.fatec.egammer.api.dao.GameDAO;
import br.com.fatec.egammer.api.entity.Game;
import br.com.fatec.egammer.test.comum.TestBase;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class GameDAOTest extends TestBase{
	private GameDAO dao;

	@Before
	public void config() {
		this.dao = ImplFinder.getImpl(GameDAO.class);
	}

	@Test
	public void testSave() {
		Game game_salvar = new Game();
		game_salvar.setGam_titulo("FARCRY_4");
		game_salvar.setGam_desccricao("FARCRY 4 é um jogo de tiro em primeira pessoa");

		Long codigo = this.dao.save(game_salvar);

		Game game_salvo = this.dao.buscarCodigo(codigo);

		Assert.assertNotNull(game_salvo);
		Assert.assertEquals("FARCRY_4", game_salvo.getGam_titulo());
		Assert.assertEquals("FARCRY 4 é um jogo de tiro em primeira pessoa", game_salvo.getGam_desccricao());
	}

	@Test
	public void testUpdate() {
		Game game_salvar = new Game();
		game_salvar.setGam_titulo("FARCRY_4");
		game_salvar.setGam_desccricao("farcry 4 é um jogo de tiro em primeira pessoa");

		Long codigo = this.dao.save(game_salvar);
		Game game_atualizar = this.dao.buscarCodigo(codigo);

		game_atualizar.setGam_titulo("FARCRY 4");
		game_atualizar.setGam_desccricao("FARCRY 4 é um jogo de tiro em primeira pessoa");

		this.dao.update(game_atualizar);
		Game des_atualizado = this.dao.buscarCodigo(codigo);

		Assert.assertNotNull(des_atualizado);
		Assert.assertEquals("FARCRY 4", des_atualizado.getGam_titulo());
		Assert.assertEquals("FARCRY 4 é um jogo de tiro em primeira pessoa", des_atualizado.getGam_desccricao());
	}

	@Test
	public void testDelete() {
		Game game_salvar = new Game();
		game_salvar.setGam_titulo("FARCRY_4");
		game_salvar.setGam_desccricao("farcry 4 é um jogo de tiro em primeira pessoa");

		Long codigo = this.dao.save(game_salvar);
		this.dao.delete(codigo);

		Game des_deletado = this.dao.buscarCodigo(codigo);

		Assert.assertNull(des_deletado);
	}

	@Test
	public void testBuscarTodos() {
		Game game_salvar1 = new Game();
		game_salvar1.setGam_titulo("FARCRY_4");
		game_salvar1.setGam_desccricao("farcry 4 é um jogo de tiro em primeira pessoa");
		Game game_salvar2 = new Game();
		game_salvar2.setGam_titulo("Battlefield 4");
		game_salvar2.setGam_desccricao("Neste título, o usuário comanda os soldados");

		this.dao.save(game_salvar1);
		this.dao.save(game_salvar2);

		List<Game> encontrados = this.dao.buscarTodosGames();

		Assert.assertEquals(2, encontrados.size());
		Assert.assertEquals("FARCRY_4", encontrados.get(0).getGam_titulo());
		Assert.assertEquals("farcry 4 é um jogo de tiro em primeira pessoa", encontrados.get(0).getGam_desccricao());
		Assert.assertEquals("Battlefield 4", encontrados.get(1).getGam_titulo());
		Assert.assertEquals("Neste título, o usuário comanda os soldados", encontrados.get(1).getGam_desccricao());
	}

}
