package br.com.fatec.egammer.core.dao;

import static br.com.spektro.minispring.core.dbmapper.ConfigDBMapper.getDefaultConnectionType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.google.common.collect.Lists;

import br.com.fatec.egammer.api.dao.DesenvolvedoraDAO;
import br.com.fatec.egammer.api.dao.GameDAO;
import br.com.fatec.egammer.api.dao.GeneroDAO;
import br.com.fatec.egammer.api.entity.Game;
import br.com.spektro.minispring.core.dbmapper.ConfigDBMapper;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class GameDAOImpl implements GameDAO {

	private GeneroDAO generoDao;
	private DesenvolvedoraDAO desenvolvedoraDao;
	
	public GameDAOImpl() {
		this.generoDao = ImplFinder.getImpl(GeneroDAO.class);
		this.desenvolvedoraDao = ImplFinder.getImpl(DesenvolvedoraDAO.class);
	}
	
	@Override
	public Long save(Game game) {
		Connection conn = null;
		PreparedStatement insert = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();

			String colunas = DAOUtils.getColunas(getDefaultConnectionType(),
					Game.getColunas());

			String values = DAOUtils.completarClausulaValues(getDefaultConnectionType(),
					13, "SEQ_GAME");

			String sql = "INSERT INTO " + Game.TABLE + colunas + " VALUES " + values;

			insert = DAOUtils.criarStatment(sql, conn, getDefaultConnectionType(),
					Game.getColunasArray());

			insert.setString(1, game.getGam_titulo());
			insert.setString(2, game.getGam_descricao());
			insert.setDouble(3, game.getGam_preco());
			insert.setInt(4, game.getGam_quantidade());
			insert.setString(5, game.getGam_imagem());
			insert.setString(6, game.getGam_imagem2());
			insert.setString(7, game.getGam_imagem3());
			insert.setString(8, game.getGam_imagem4());
			insert.setString(9, game.getGam_classificacao());
			insert.setDate(10, (Date)game.getGam_data_lancamento());
			insert.setString(11, game.getGam_plataforma());
			insert.setLong(12, game.getGenero().getGen_codigo());
			insert.setLong(13, game.getDesenvolvedora().getDes_codigo());
			insert.execute();

			ResultSet generatedKeys = insert.getGeneratedKeys();
			if (generatedKeys.next()) {
				return generatedKeys.getLong(1);
			}

			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(insert);
			DbUtils.closeQuietly(conn);
		}
	}

	@Override
	public void update(Game game) {
		Connection conn = null;
		PreparedStatement update = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			update = conn.prepareStatement("UPDATE " + Game.TABLE + " SET "
					+ Game.COL_TITULO + " = ?, " + Game.COL_DESCRICAO + " = ?, "
					+ Game.COL_PRECO + " = ?, " + Game.COL_QUANTIDADE + " = ?, "
					+ Game.COL_IMAGEM + " = ?, " + Game.COL_IMAGEM2 + " = ?, "
					+ Game.COL_IMAGEM3 + " = ?, " + Game.COL_IMAGEM4 + " = ?, "
					+ Game.COL_CLASSIFICACAO + " = ?, " + Game.COL_DATA_LANCAMENTO 
					+ " = ?, " + Game.COL_PLATAFORMA + " = ?, " + Game.COL_GEN_CODIGO + " = ?, " 
					+ Game.COL_DES_CODIGO + " = ? " + " WHERE " + Game.COL_CODIGO + " = ?;");
			update.setString(1, game.getGam_titulo());
			update.setString(2, game.getGam_descricao());
			update.setDouble(3, game.getGam_preco());
			update.setInt(4, game.getGam_quantidade());
			update.setString(5, game.getGam_imagem());
			update.setString(6, game.getGam_imagem2());
			update.setString(7, game.getGam_imagem3());
			update.setString(8, game.getGam_imagem4());
			update.setString(9, game.getGam_classificacao());
			update.setDate(10, (Date)game.getGam_data_lancamento());
			update.setString(11, game.getGam_plataforma());
			update.setLong(12, game.getGenero().getGen_codigo());
			update.setLong(13, game.getDesenvolvedora().getDes_codigo());
			update.setLong(14, game.getGam_codigo());
			update.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(update);
		}
		
	}

	@Override
	public void delete(Long codigo) {
		Connection conn = null;
		PreparedStatement delete = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			String sql = "DELETE FROM " + Game.TABLE + " WHERE gam_codigo = ?;";
			delete = conn.prepareStatement(sql);
			delete.setLong(1, codigo);
			delete.execute();
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(delete);
			DbUtils.closeQuietly(conn);
		}
	}

	@Override
	public Game buscarCodigo(Long codigo) {
		Connection conn = null;
		PreparedStatement find = null;
		Game game = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			String sql = "SELECT * FROM " + Game.TABLE + " WHERE " + Game.COL_CODIGO + " = ?;";
			find = conn.prepareStatement(sql);
			find.setLong(1, codigo);
			ResultSet rs = find.executeQuery();
			if (rs.next()) {
				game = this.criarGame(rs);
			}
			return game;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(find);
		}
	}

	@Override
	public List<Game> buscarTodosGames() {
		Connection conn = null;
		PreparedStatement buscarTodos = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			buscarTodos = conn.prepareStatement("SELECT * FROM " + Game.TABLE);
			ResultSet rs = buscarTodos.executeQuery();
			if(rs.next()){
				return this.criarGames(rs);
			}else return null;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(buscarTodos);
		}
	}
	
	private List<Game> criarGames(ResultSet rs) throws SQLException {
		List<Game> games = Lists.newArrayList();
		do {
			games.add(this.criarGame(rs));
		}while (rs.next());
		return games;
	}
	
	private Game criarGame(ResultSet rs) throws SQLException {
		Game game = new Game();
		game.setGam_codigo(rs.getLong(Game.COL_CODIGO));
		game.setGam_titulo(rs.getString(Game.COL_TITULO));
		game.setGam_descricao(rs.getString(Game.COL_DESCRICAO));
		game.setGam_preco(rs.getDouble(Game.COL_PRECO));
		game.setGam_quantidade(rs.getInt(Game.COL_QUANTIDADE));
		game.setGam_imagem(rs.getString(Game.COL_IMAGEM));
		game.setGam_imagem2(rs.getString(Game.COL_IMAGEM2));
		game.setGam_imagem3(rs.getString(Game.COL_IMAGEM3));
		game.setGam_imagem4(rs.getString(Game.COL_IMAGEM4));
		game.setGam_classificacao(rs.getString(Game.COL_CLASSIFICACAO));
		game.setGam_data_lancamento(rs.getDate(Game.COL_DATA_LANCAMENTO));
		game.setGam_plataforma(rs.getString(Game.COL_PLATAFORMA));
		game.setGenero( this.generoDao.buscaCodigo(rs.getLong(Game.COL_GEN_CODIGO) ));
		game.setDesenvolvedora( this.desenvolvedoraDao.buscarCodigo(rs.getLong(Game.COL_DES_CODIGO) ));
		return game;
	}

	@Override
	public List<Game> buscaPorGenero(Long codigo) {
		Connection conn = null;
		PreparedStatement find = null;
		List<Game> game = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			String sql = "SELECT * FROM " + Game.TABLE + " WHERE " +Game.COL_GEN_CODIGO+ " = ? ORDER BY rand() LIMIT 4;";
			find = conn.prepareStatement(sql);
			find.setLong(1, codigo);
			ResultSet rs = find.executeQuery();
			if (rs.next()) {
				game = this.criarGames(rs);
			}
			return game;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(find);
		}
	}

}
