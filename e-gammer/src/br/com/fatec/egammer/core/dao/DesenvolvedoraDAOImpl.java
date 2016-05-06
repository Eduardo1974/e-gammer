package br.com.fatec.egammer.core.dao;

import static br.com.spektro.minispring.core.dbmapper.ConfigDBMapper.getDefaultConnectionType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.google.common.collect.Lists;

import br.com.fatec.egammer.api.dao.DesenvolvedoraDAO;
import br.com.fatec.egammer.api.entity.Desenvolvedora;
import br.com.spektro.minispring.core.dbmapper.ConfigDBMapper;

public class DesenvolvedoraDAOImpl implements DesenvolvedoraDAO{

	@Override
	public Long save(Desenvolvedora desenvolvedora) {
		
		Connection conn = null;
		PreparedStatement insert = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();

			String colunas = DAOUtils.getColunas(getDefaultConnectionType(),
					Desenvolvedora.getColunas());

			String values = DAOUtils.completarClausulaValues(getDefaultConnectionType(),
					2, "SEQ_DESENVOLVEDORA");

			String sql = "INSERT INTO " + Desenvolvedora.TABLE + colunas + " VALUES " + values;

			insert = DAOUtils.criarStatment(sql, conn, getDefaultConnectionType(),
					Desenvolvedora.getColunasArray());

			insert.setString(1, desenvolvedora.getDes_studio());
			insert.setString(2, desenvolvedora.getDes_distribuidora());
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
	public void update(Desenvolvedora desenvolvedora) {
		Connection conn = null;
		PreparedStatement update = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			update = conn.prepareStatement("UPDATE " + Desenvolvedora.TABLE + " SET "
					+ Desenvolvedora.COL_DISTRIBUIDORA + " = ?, " + Desenvolvedora.COL_STUDIO + " = ? "
					+ " WHERE " + Desenvolvedora.COL_CODIGO + " = ?");
			update.setString(1, desenvolvedora.getDes_distribuidora());
			update.setString(2, desenvolvedora.getDes_studio());
			update.setLong(3, desenvolvedora.getDes_codigo());
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
			String sql = "DELETE FROM " + Desenvolvedora.TABLE + " WHERE des_codigo = ?;";
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
	public Desenvolvedora buscarCodigo(Long codigo) {
		Connection conn = null;
		PreparedStatement find = null;
		Desenvolvedora desenvolvedora = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			String sql = "SELECT * FROM " + Desenvolvedora.TABLE + " WHERE " + Desenvolvedora.COL_CODIGO
					+ " = ?;";
			find = conn.prepareStatement(sql);
			find.setLong(1, codigo);
			ResultSet rs = find.executeQuery();
			if (rs.next()) {
				desenvolvedora = this.criarDesenvolvedora(rs);
			}
			return desenvolvedora;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(find);
		}
	}

	@Override
	public List<Desenvolvedora> buscarTodasDesenvolvedoras() {
		Connection conn = null;
		PreparedStatement buscarTodos = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			buscarTodos = conn.prepareStatement("SELECT * FROM " + Desenvolvedora.TABLE);
			ResultSet rs = buscarTodos.executeQuery();
			return this.criarDesenvolvedoras(rs);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(buscarTodos);
		}
	}
	
	private List<Desenvolvedora> criarDesenvolvedoras(ResultSet rs) throws SQLException {
		List<Desenvolvedora> desenvolvedoras = Lists.newArrayList();
		while (rs.next()) {
			desenvolvedoras.add(this.criarDesenvolvedora(rs));
		}
		return desenvolvedoras;
	}
	
	private Desenvolvedora criarDesenvolvedora(ResultSet rs) throws SQLException {
		Desenvolvedora desenvolvedora = new Desenvolvedora();
		desenvolvedora.setDes_codigo(rs.getLong(Desenvolvedora.COL_CODIGO));
		desenvolvedora.setDes_distribuidora(rs.getString(Desenvolvedora.COL_DISTRIBUIDORA));
		desenvolvedora.setDes_studio(rs.getString(Desenvolvedora.COL_STUDIO));
		return desenvolvedora;
	}

}
