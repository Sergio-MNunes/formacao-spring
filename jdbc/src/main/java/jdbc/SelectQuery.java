package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.CategoriaDAO;
import dao.ProdutoDAO;
import modelo.Categoria;
import modelo.Produto;

public class SelectQuery {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();

		// O try com um parenteses depois eh chamado de try with resources.
		// Ele eh responsavel por fechar o recurso que eh inserido dentro dos parenteses. 
		// Por conta disso, o recurso precisa obrigatoriamente herdar a classe AutoCloseable para que possa ser utilizado dentro do try with resources.
		try(Connection con = connectionFactory.criaConexao()) {

			System.out.println("Produtos existentes: ");
			ProdutoDAO produtoDao = new ProdutoDAO(con);
			List<Produto> produtos = produtoDao.listar();
			produtos.forEach(p -> System.out.println(p));

			CategoriaDAO categoriaDao = new CategoriaDAO(con);
			List<Categoria> categorias = categoriaDao.pesquisaProdutoPorCategoria();

			System.out.println();
			System.out.println("Produtos por categoria: ");
			categorias.forEach(c -> {
				System.out.println(c);
				c.getProdutos().forEach(p -> System.out.println(p));
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

