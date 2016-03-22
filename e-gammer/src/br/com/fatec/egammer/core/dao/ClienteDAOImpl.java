package br.com.fatec.egammer.core.dao;

import static br.com.spektro.minispring.core.dbmapper.ConfigDBMapper.getDefaultConnectionType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import br.com.fatec.egammer.api.dao.ClienteDAO;
import br.com.fatec.egammer.api.entity.Cliente;
import br.com.spektro.minispring.core.dbmapper.ConfigDBMapper;

public class ClienteDAOImpl implements ClienteDAO{

	@Override
	public Long save(Cliente cliente) {
		// TODO Auto-generated method stub
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
			insert.setString(2, cliente.getCli_senha());
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long codigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente buscarCodigo(Long codigo) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return null;
	}
	
	private Cliente criarCliente(ResultSet rs) throws SQLException {
		Cliente usuario = new Cliente();
		usuario.setCli_codigo(rs.getLong(Cliente.COL_CODIGO));
		usuario.setCli_nome(rs.getString(Cliente.COL_NOME));
		usuario.setCli_senha(rs.getString(Cliente.COL_SENHA));
		return usuario;
	}

}
