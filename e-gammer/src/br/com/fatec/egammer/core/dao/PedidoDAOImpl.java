package br.com.fatec.egammer.core.dao;

import static br.com.spektro.minispring.core.dbmapper.ConfigDBMapper.getDefaultConnectionType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.google.common.collect.Lists;

import br.com.fatec.egammer.api.dao.ClienteDAO;
import br.com.fatec.egammer.api.dao.GameDAO;
import br.com.fatec.egammer.api.dao.ItemPedidoDAO;
import br.com.fatec.egammer.api.dao.PedidoDAO;
import br.com.fatec.egammer.api.entity.Game;
import br.com.fatec.egammer.api.entity.ItemPedido;
import br.com.fatec.egammer.api.entity.Pedido;
import br.com.spektro.minispring.core.dbmapper.ConfigDBMapper;
import br.com.spektro.minispring.core.implfinder.ImplFinder;
import javassist.compiler.Javac;

public class PedidoDAOImpl implements PedidoDAO{
	
	private ClienteDAO cliDao;
	private ItemPedidoDAO itemDao;
	
	public PedidoDAOImpl(){
		this.cliDao = ImplFinder.getImpl(ClienteDAO.class);
		this.itemDao = ImplFinder.getImpl(ItemPedidoDAO.class);
	}
	
	@Override
	public Long save(Pedido pedido) {
		Connection conn = null;
		PreparedStatement insert = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();

			String colunas = DAOUtils.getColunas(getDefaultConnectionType(),
					Pedido.getColunas());

			String values = DAOUtils.completarClausulaValues(getDefaultConnectionType(),
					3, "SEQ_PEDIDO");

			String sql = "INSERT INTO " + Pedido.TABLE + colunas + " VALUES " + values;

			insert = DAOUtils.criarStatment(sql, conn, getDefaultConnectionType(),
					Pedido.getColunasArray());
			
			insert.setDate(1, new java.sql.Date(pedido.getPed_data().getDate()));
			insert.setDouble(2, pedido.getPed_valor_total());
			insert.setLong(3, pedido.getCliente().getCli_codigo());
			
			insert.execute();

			ResultSet generatedKeys = insert.getGeneratedKeys();
			if (generatedKeys.next()) {
				return generatedKeys.getLong(1);
			}

			return null;
		} catch (Exception e) {
			System.out.println("erro: "+e);
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(insert);
			DbUtils.closeQuietly(conn);
		}
	}

	@Override
	public boolean update(Pedido pedido) {
		Connection conn = null;
		boolean resultado = false;
		PreparedStatement update = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			update = conn.prepareStatement("UPDATE " + Pedido.TABLE + " SET "
					+ Pedido.COL_PED_VALOR_TOTAL + " = ? "
					+ "WHERE " + Pedido.COL_CODIGO + " = ?");
			
			update.setDouble(1, pedido.getPed_valor_total());
			update.setLong(2, pedido.getPed_codigo());
			if(update.execute()== false){
				resultado = true;
			}
			return resultado;
		} catch (Exception e) {
			System.out.println("erro: "+e);
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
			String sql = "DELETE FROM " + Pedido.TABLE + " WHERE "+Pedido.COL_CODIGO +" = ?";
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
	public Pedido buscaPedidoCodigo(Long codigo) {
		Connection conn = null;
		PreparedStatement find = null;
		Pedido pedido = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			String sql = "SELECT P.PED_CODIGO, P.PED_DATA, P.PED_VALOR_TOTAL, P.CLI_CODIGO FROM PEDIDO P WHERE PED_CODIGO = ?;";
			find = conn.prepareStatement(sql);
			find.setLong(1, codigo);
			ResultSet rs = find.executeQuery();
			if (rs.next()) {
				pedido = this.criarPedido(rs);
			}
			return pedido;
		} catch (Exception e) {
			System.out.println("erro: "+e);
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(find);
		}
		
	}


	@Override
	public List<Pedido> buscaTodosPedidosCliente(Long cliente) {
		Connection conn = null;
		PreparedStatement todosItensPedido = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			todosItensPedido = conn.prepareStatement("SELECT * FROM " + Pedido.TABLE +" WHERE CLI_CODIGO = ?");
			todosItensPedido.setLong(1, cliente);
			ResultSet rs = todosItensPedido.executeQuery();
			return this.criarPedidos(rs);
		} catch (Exception e) {
			System.out.println("erro: "+e);
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(todosItensPedido);
		}
	}

	@Override
	public List<Pedido> buscaTodosPedidosCodigos(List<Long> codigos) {
		List<Pedido> pedidos = Lists.newArrayList();
		if (codigos.size() > 0) {
			Connection conn = null;
			PreparedStatement stmt = null;
			try {
				conn = ConfigDBMapper.getDefaultConnection();
				String args = DAOUtils.preparePlaceHolders(codigos.size());
				String sql = "SELECT * FROM " + Pedido.TABLE + " WHERE "
						+ Pedido.COL_CODIGO + " IN (" + args + ")";
				stmt = conn.prepareStatement(sql);
				DAOUtils.setValues(stmt, codigos);
				ResultSet rs = stmt.executeQuery();
				pedidos = this.criarPedidos(rs);
			} catch (Exception e) {
				throw new RuntimeException(e);
			} finally {
				DbUtils.closeQuietly(conn);
				DbUtils.closeQuietly(stmt);
			}
		}
		return pedidos;
	}
	
	
	private List<Pedido> criarPedidos(ResultSet rs) throws SQLException {
		List<Pedido> pedidos = Lists.newArrayList();
		while (rs.next()) {
			pedidos.add(this.criarPedido(rs));
		}
		return pedidos;
	}
	
	private Pedido criarPedido(ResultSet rs) throws SQLException {
		Pedido pedido = new Pedido();
		pedido.setPed_codigo(rs.getLong("PED_CODIGO"));
		//pedido.setPed_data(rs.getDate("PED_DATA"));
		pedido.setPed_valor_total(rs.getDouble("PED_VALOR_TOTAL"));
		pedido.setCliente(this.cliDao.buscarCodigo(rs.getLong("CLI_CODIGO")));
		pedido.setItensPedido(this.itemDao.buscaTodosItemPedido(rs.getLong("PED_CODIGO")));
		return pedido;
	}
}
