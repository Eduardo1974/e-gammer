package br.com.fatec.egammer.core.dao;

import static br.com.spektro.minispring.core.dbmapper.ConfigDBMapper.getDefaultConnectionType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import br.com.fatec.egammer.api.dao.ItemPedidoDAO;
import br.com.fatec.egammer.api.entity.Game;
import br.com.fatec.egammer.api.entity.Genero;
import br.com.fatec.egammer.api.entity.ItemPedido;
import br.com.fatec.egammer.api.entity.Pedido;
import br.com.spektro.minispring.core.dbmapper.ConfigDBMapper;

public class ItemPedidoDAOImpl implements ItemPedidoDAO{

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
			insert.setLong(4, itemPedido.getPedido().getPed_codigo());
			insert.setLong(5, itemPedido.getGame().getGam_codigo());
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Long codigo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ItemPedido buscaCodigoItemPedido(Long codigo) {
		Connection conn = null;
		PreparedStatement find = null;
		ItemPedido itemPedido = null;
		try {
			conn = ConfigDBMapper.getDefaultConnection();
			String sql = "SELECT IT.IPT_CODIGO, IT.ITP_PRECO_UNITARIO, IT.ITP_QUANTIDADE, IT.ITP_PRECO_TOTAL, "
					+ "G.GAM_TITULO, P.PED_DATA FROM " + ItemPedido.TABLE + " IT INNER JOIN "+Game.TABLE+" G ON"
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
			throw new RuntimeException(e);
		} finally {
			DbUtils.closeQuietly(conn);
			DbUtils.closeQuietly(find);
		}
	}


	
	private ItemPedido criarItemPedido(ResultSet rs) throws SQLException {
		ItemPedido itemPedido = new ItemPedido();
		itemPedido.setItp_codigo(rs.getLong(ItemPedido.COL_CODIGO));
		itemPedido.setIpt_preco_total(rs.getDouble(ItemPedido.COL_PRECO_TOTAL));
		itemPedido.setItp_preco_unitario(rs.getDouble(ItemPedido.COL_PRECO_UNITARIO));
		itemPedido.setItp_quantidade(rs.getInt(ItemPedido.COL_QUANTIDADE));
		itemPedido.getGame().setGam_titulo(rs.getString(Game.COL_TITULO));
		itemPedido.getPedido().setPed_data(rs.getDate(Pedido.COL_DATA));
		return itemPedido;
	}

	@Override
	public List<ItemPedido> buscaTodosItemPedido() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ItemPedido> buscaTodosItensDoPedido(List<Long> codigo) {
		// TODO Auto-generated method stub
		return null;
	}

}
