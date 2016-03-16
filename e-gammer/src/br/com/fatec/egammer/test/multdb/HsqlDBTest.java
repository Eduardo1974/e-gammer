package br.com.fatec.egammer.test.multdb;


import org.junit.BeforeClass;
import org.junit.Test;


import br.com.spektro.minispring.core.dbmapper.ConfigDBMapper;
import br.com.spektro.minispring.core.implfinder.ContextSpecifier;
import br.com.spektro.minispring.core.liquibaseRunner.LiquibaseRunnerService;

public class HsqlDBTest {

	@BeforeClass
	public static void setUp() {
		ContextSpecifier.setContext("br.com.fatec.projetoweb");
		ConfigDBMapper.setDefaultConnectionName("test");
		LiquibaseRunnerService.run();
	}

	@Test
	public void blah() {
		//new PapelDAOTest().runTests();
	}
}
