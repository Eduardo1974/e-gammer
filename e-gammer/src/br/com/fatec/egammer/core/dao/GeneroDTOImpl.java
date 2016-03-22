package br.com.fatec.egammer.core.dao;

import static br.com.spektro.minispring.core.dbmapper.ConfigDBMapper.getDefaultConnectionType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.google.common.collect.Lists;

import br.com.fatec.egammer.api.dao.GeneroDAO;
import br.com.fatec.egammer.api.entity.Genero;
import br.com.spektro.minispring.core.dbmapper.ConfigDBMapper;

public class GeneroDTOImpl implements GeneroDAO{

	@Override
	public Long save(Genero genero) {
		Connection conn = null;
		PreparedStatement insert = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();

			String colunas = DAOUtils.getColunas(getDefaultConnectionType(),
					Genero.getColunas());

			String values = DAOUtils.completarClausulaValues(getDefaultConnectionType(),
					1, "SEQ_GENERO");

			String sql = "INSERT INTO " + Genero.TABLE + colunas + " VALUES " + values;

			insert = DAOUtils.criarStatment(sql, conn, getDefaultConnectionType(),
					Genero.getColunasArray());

			insert.setString(1, genero.getGen_nome());
			insert.execute();

			ResultSet generatedKeys = insert.getGeneratedKeys();
			if (generatedKeys.next()) {
				return generatedKeys.getLong(1);
			}

			return null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(insert);
			DbUtils.closeQuietly(conn);
		}
	}

	@Override
	public boolean update(Genero genero) {
		Connection conn = null;
		boolean resultado = false;
		PreparedStatement update = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			update = conn.prepareStatement("UPDATE " + Genero.TABLE + " SET "
					+ Genero.COL_NOME + " = ?  WHERE " + Genero.COL_CODIGO + " = ?");
			update.setString(1, genero.getGen_nome());
			update.setLong(2, genero.getGen_codigo());
			if(update.execute()== false){
				resultado = true;
			}
			return resultado;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(update);
		}
	}

	@Override
	public boolean delete(Long codigo) {
		Connection conn = null;
		boolean resultado = false;
		PreparedStatement delete = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			String sql = "DELETE FROM " + Genero.TABLE + " WHERE "+Genero.COL_CODIGO +" = ?";
			delete = conn.prepareStatement(sql);
			delete.setLong(1, codigo);
			if(delete.execute() == false){
				resultado = true;
			}
			return resultado;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(delete);
			DbUtils.closeQuietly(conn);
		}
	}

	@Override
	public Genero buscaCodigo(Long codigo) {
		Connection conn = null;
		PreparedStatement find = null;
		Genero genero = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			String sql = "SELECT * FROM " + Genero.TABLE + " WHERE " + Genero.COL_CODIGO
					+ " = ?;";
			find = conn.prepareStatement(sql);
			find.setLong(1, codigo);
			ResultSet rs = find.executeQuery();
			if (rs.next()) {
				genero = this.criarGenero(rs);
			}
			return genero;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(find);
		}
	}

	@Override
	public List<Genero> buscarTodosGeneros() {
		Connection conn = null;
		PreparedStatement todosGeneros = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			todosGeneros = conn.prepareStatement("SELECT * FROM " + Genero.TABLE);
			ResultSet rs = todosGeneros.executeQuery();
			return this.criarGeneros(rs);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(todosGeneros);
		}
	}

	@Override
	public List<Genero> buscarTodosPorCodigo(List<Long> codigos) {
		// TODO Auto-generated method stub
		return null;
	}
	private List<Genero> criarGeneros(ResultSet rs) throws SQLException {
		List<Genero> generos = Lists.newArrayList();
		while (rs.next()) {
			generos.add(this.criarGenero(rs));
		}
		return generos;
	}
	
	private Genero criarGenero(ResultSet rs) throws SQLException {
		Genero genero = new Genero();
		genero.setGen_codigo(rs.getLong(Genero.COL_CODIGO));
		genero.setGen_nome(rs.getString(Genero.COL_NOME));
		return genero;
	}


}
