package br.com.fatec.egammer.test.comum;

import org.junit.After;
import org.junit.BeforeClass;

import br.com.fatec.egammer.api.entity.Cliente;
import br.com.fatec.egammer.api.entity.Desenvolvedora;
import br.com.fatec.egammer.api.entity.Game;
import br.com.fatec.egammer.api.entity.Genero;
import br.com.fatec.egammer.api.entity.ItemPedido;
import br.com.fatec.egammer.api.entity.Pedido;
import br.com.spektro.minispring.core.dbmapper.ConfigDBMapper;
import br.com.spektro.minispring.core.implfinder.ContextSpecifier;
import br.com.spektro.minispring.core.liquibaseRunner.LiquibaseRunnerService;
import br.com.spektro.minispring.core.query.QueryExecutorService;

public class TestBase {

	@BeforeClass
	public static void setUp() {
		ContextSpecifier.setContext("br.com.fatec.egammer");
		ConfigDBMapper.setDefaultConnectionName("test");
		LiquibaseRunnerService.run();
	}

	@After
	public void setDown() {
		QueryExecutorService.executeQuery("DELETE FROM " + ItemPedido.TABLE);
		QueryExecutorService.executeQuery("DELETE FROM " + Pedido.TABLE);
		QueryExecutorService.executeQuery("DELETE FROM " + Game.TABLE);
		QueryExecutorService.executeQuery("DELETE FROM " + Genero.TABLE);
		QueryExecutorService.executeQuery("DELETE FROM " + Desenvolvedora.TABLE);
		QueryExecutorService.executeQuery("DELETE FROM " + Cliente.TABLE);
		
		//QueryExecutorService.executeQuery("call reset_seq(SEQ_GENERO)");
		
		/*
		 * QueryExecutorService .executeQuery(
		 * "ALTER SEQUENCE SEQ_GENERO RESTART WITH 1"); QueryExecutorService
		 * .executeQuery("ALTER SEQUENCE SEQ_DESENVOLVEDORA RESTART WITH 1");
		 * QueryExecutorService .executeQuery(
		 * "ALTER SEQUENCE SEQ_CLIENTE RESTART WITH 1"); QueryExecutorService
		 * .executeQuery("ALTER SEQUENCE SEQ_PEDIDO RESTART WITH 1");
		 * QueryExecutorService .executeQuery(
		 * "ALTER SEQUENCE SEQ_ITEM_DO_PEDIDO RESTART WITH 1");
		 */

	}

}
