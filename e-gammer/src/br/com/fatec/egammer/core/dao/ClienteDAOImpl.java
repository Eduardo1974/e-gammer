package br.com.fatec.egammer.core.dao;

import static br.com.spektro.minispring.core.dbmapper.ConfigDBMapper.getDefaultConnectionType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.google.common.collect.Lists;

import br.com.fatec.egammer.api.dao.ClienteDAO;
import br.com.fatec.egammer.api.entity.Cliente;
import br.com.spektro.minispring.core.dbmapper.ConfigDBMapper;

public class ClienteDAOImpl implements ClienteDAO{

	@Override
	public Long save(Cliente cliente) {
		Connection conn = null;
		PreparedStatement insert = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();

			String colunas = DAOUtils.getColunas(getDefaultConnectionType(),
					Cliente.getColunas());

			String values = DAOUtils.completarClausulaValues(getDefaultConnectionType(),
					2, "SEQ_CLIENTE");

			String sql = "INSERT INTO " + Cliente.TABLE + colunas + " VALUES " + values;

			insert = DAOUtils.criarStatment(sql, conn, getDefaultConnectionType(),
					Cliente.getColunasArray());

			insert.setString(1, cliente.getCli_nome());
			insert.setString(2, cliente.getCli_email());
			insert.setString(3, cliente.getCli_senha());
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
	public void update(Cliente cliente) {
		Connection conn = null;
		PreparedStatement update = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			update = conn.prepareStatement("UPDATE " + Cliente.TABLE + " SET "
					+ Cliente.COL_NOME + " = ?, " + Cliente.COL_SENHA + " = ? "
					+ " WHERE " + Cliente.COL_CODIGO + " = ?");
			update.setString(1, cliente.getCli_nome());
			update.setString(2, cliente.getCli_senha());
			update.setLong(3, cliente.getCli_codigo());
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
			String sql = "DELETE FROM " + Cliente.TABLE + " WHERE cli_codigo = ?;";
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
	public Cliente buscarCodigo(Long codigo) {
		Connection conn = null;
		PreparedStatement find = null;
		Cliente user = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			String sql = "SELECT * FROM " + Cliente.TABLE + " WHERE " + Cliente.COL_CODIGO
					+ " = ?;";
			find = conn.prepareStatement(sql);
			find.setLong(1, codigo);
			ResultSet rs = find.executeQuery();
			if (rs.next()) {
				user = this.criarCliente(rs);
			}
			return user;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(find);
		}

	}

	@Override
	public List<Cliente> buscarTodosClientes() {
		Connection conn = null;
		PreparedStatement buscarTodos = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			buscarTodos = conn.prepareStatement("SELECT * FROM " + Cliente.TABLE);
			ResultSet rs = buscarTodos.executeQuery();
			return this.criarClientes(rs);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(buscarTodos);
		}
	}
	
	private List<Cliente> criarClientes(ResultSet rs) throws SQLException {
		List<Cliente> clientes = Lists.newArrayList();
		while (rs.next()) {
			clientes.add(this.criarCliente(rs));
		}
		return clientes;
	}
	
	private Cliente criarCliente(ResultSet rs) throws SQLException {
		Cliente usuario = new Cliente();
		usuario.setCli_codigo(rs.getLong(Cliente.COL_CODIGO));
		usuario.setCli_nome(rs.getString(Cliente.COL_NOME));
		usuario.setCli_senha(rs.getString(Cliente.COL_SENHA));
		return usuario;
	}

}
