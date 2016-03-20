package br.com.fatec.egammer.api.dao;

import java.util.List;
import br.com.fatec.egammer.api.entity.Pedido;

public interface PedidoDAO {

	Long save(Pedido pedido);

	boolean update(Pedido pedido);

	boolean delete(Long codigo);

	Pedido buscaPedidoCodigo(Long codigo);

	List<Pedido> buscarTodosPedidos();

	List<Pedido> buscaTodosPedidosCliente(Long codigo);
}
