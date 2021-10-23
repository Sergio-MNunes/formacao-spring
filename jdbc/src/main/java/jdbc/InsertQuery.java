package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.ProdutoDAO;
import modelo.Produto;

public class InsertQuery {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Produto mesa = new Produto("Teclado", "Keychron K8", 1);
		
		try(Connection con = connectionFactory.criaConexao()) {
			ProdutoDAO produtoDao = new ProdutoDAO(con);
			produtoDao.salvar(mesa);
			
			List<Produto> produtos = produtoDao.listar();

			produtos.forEach(p -> System.out.println(p));
		}
	}
}
