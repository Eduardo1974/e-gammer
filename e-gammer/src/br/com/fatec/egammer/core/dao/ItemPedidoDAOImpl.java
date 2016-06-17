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
import br.com.fatec.egammer.api.dao.GameDAO;
import br.com.fatec.egammer.api.dao.GeneroDAO;
import br.com.fatec.egammer.api.dao.ItemPedidoDAO;
import br.com.fatec.egammer.api.dao.PedidoDAO;
import br.com.fatec.egammer.api.entity.Game;
import br.com.fatec.egammer.api.entity.Genero;
import br.com.fatec.egammer.api.entity.ItemPedido;
import br.com.fatec.egammer.api.entity.Pedido;
import br.com.spektro.minispring.core.dbmapper.ConfigDBMapper;
import br.com.spektro.minispring.core.implfinder.ImplFinder;

public class ItemPedidoDAOImpl implements ItemPedidoDAO{
	
	
	private GameDAO gameDao;
	
	
	public ItemPedidoDAOImpl(){
		this.gameDao = ImplFinder.getImpl(GameDAO.class);
	}
	
	@Override
	public Long save(ItemPedido itemPedido) {
		Connection conn = null;
		PreparedStatement insert = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();

			String colunas = DAOUtils.getColunas(getDefaultConnectionType(),
					ItemPedido.getColunas());

			String values = DAOUtils.completarClausulaValues(getDefaultConnectionType(),
					5, "SEQ_ITEM_DO_PEDIDO");

			String sql = "INSERT INTO " + ItemPedido.TABLE + colunas + " VALUES " + values;

			insert = DAOUtils.criarStatment(sql, conn, getDefaultConnectionType(),
					ItemPedido.getColunasArray());
			
			insert.setDouble(1, itemPedido.getItp_preco_unitario());
			insert.setInt(2, itemPedido.getItp_quantidade());
			insert.setDouble(3, itemPedido.getIpt_preco_total());
			insert.setLong(4, itemPedido.getPed_codigo());
			insert.setLong(5, itemPedido.getGam_codigo());
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
	public boolean update(ItemPedido itemPedido) {
		Connection conn = null;
		boolean resultado = false;
		PreparedStatement update = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			update = conn.prepareStatement("UPDATE " + ItemPedido.TABLE + " SET "
					+ ItemPedido.COL_QUANTIDADE + " = ? ,"
					+ ItemPedido.COL_PRECO_TOTAL + " = ?"
					+ "WHERE " + ItemPedido.COL_PED_CODIGO + " = ?");
			
			update.setInt(1, itemPedido.getItp_quantidade());
			update.setDouble(2, itemPedido.getIpt_preco_total());
			update.setLong(3, itemPedido.getPed_codigo());
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
			String sql = "DELETE FROM " + ItemPedido.TABLE + " WHERE "+ItemPedido.COL_CODIGO +" = ?";
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
	public ItemPedido buscaCodigoItemPedido(Long codigo) {
		Connection conn = null;
		PreparedStatement find = null;
		ItemPedido itemPedido = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			String sql = "SELECT IT.ITP_CODIGO, IT.ITP_PRECO_UNITARIO, IT.ITP_QUANTIDADE, IT.ITP_PRECO_TOTAL, "
					+ "G.GAM_TITULO, P.PED_CODIGO AS P_COD, P.PED_DATA, G.GAM_CODIGO as GAM_COD FROM " + ItemPedido.TABLE + " IT INNER JOIN "+Game.TABLE+" G ON"
					+ " G.GAM_CODIGO = IT.GAM_CODIGO INNER JOIN PEDIDO P ON IT.PED_CODIGO = P.PED_CODIGO WHERE "
					+ ItemPedido.COL_CODIGO+" = ?;";
			find = conn.prepareStatement(sql);
			find.setLong(1, codigo);
			ResultSet rs = find.executeQuery();
			if (rs.next()) {
				itemPedido = this.criarItemPedido(rs);
			}
			return itemPedido;
		} catch (Exception e) {
			System.out.println("erro: "+e);
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(find);
		}
	}


	@Override
	public List<ItemPedido> buscaTodosItemPedido(Long pedido) {
		Connection conn = null;
		PreparedStatement todosItensPedido = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			todosItensPedido = conn.prepareStatement("SELECT * FROM " + ItemPedido.TABLE +" WHERE PED_CODIGO = ?");
			todosItensPedido.setLong(1, pedido);
			ResultSet rs = todosItensPedido.executeQuery();
			return this.criarItensPedido(rs);
		} catch (Exception e) {
			System.out.println("erro: "+e);
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(todosItensPedido);
		}
	}

	@Override
	public List<ItemPedido> buscaTodosItensDoPedido(List<Long> codigos) {
		List<ItemPedido> itensPedido = Lists.newArrayList();
		if (codigos.size() > 0) {
			Connection conn = null;
			PreparedStatement stmt = null;
			try {
				conn = ConfigDBMapper.getDefaultConnection();
				String args = DAOUtils.preparePlaceHolders(codigos.size());
				String sql = "SELECT * FROM " + ItemPedido.TABLE + " WHERE "
						+ ItemPedido.COL_CODIGO + " IN (" + args + ")";
				stmt = conn.prepareStatement(sql);
				DAOUtils.setValues(stmt, codigos);
				ResultSet rs = stmt.executeQuery();
				itensPedido = this.criarItensPedido(rs);
			} catch (Exception e) {
				throw new RuntimeException(e);
			} finally {
				DbUtils.closeQuietly(conn);
				DbUtils.closeQuietly(stmt);
			}
		}
		return itensPedido;
	}
	
	private List<ItemPedido> criarItensPedido(ResultSet rs) throws SQLException {
		List<ItemPedido> itensPedido = Lists.newArrayList();
		while (rs.next()) {
			itensPedido.add(this.criarItemPedido(rs));
		}
		return itensPedido;
	}
	
	private ItemPedido criarItemPedido(ResultSet rs) throws SQLException {
		ItemPedido itemPedido = new ItemPedido();
		itemPedido.setItp_codigo(rs.getLong(ItemPedido.COL_CODIGO));
		itemPedido.setIpt_preco_total(rs.getDouble(ItemPedido.COL_PRECO_TOTAL));
		itemPedido.setItp_preco_unitario(rs.getDouble(ItemPedido.COL_PRECO_UNITARIO));
		itemPedido.setItp_quantidade(rs.getInt(ItemPedido.COL_QUANTIDADE));
		itemPedido.setGam_codigo((rs.getLong("GAM_COD")));
		itemPedido.setPed_codigo(rs.getLong("P_COD"));
		return itemPedido;
	}
}
