package br.com.fatec.egammer.core.dao;

import java.util.List;

import br.com.fatec.egammer.api.dao.PedidoDAO;
import br.com.fatec.egammer.api.entity.Pedido;

public class PedidoDTOImpl implements PedidoDAO{

	@Override
	public Long save(Pedido pedido) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Pedido pedido) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Long codigo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Pedido buscaPedidoCodigo(Long codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> buscarTodosPedidos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> buscaTodosPedidosCliente(Long codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> buscaTodosPedidosCodigos(List<Long> codigos) {
		// TODO Auto-generated method stub
		return null;
	}

}
