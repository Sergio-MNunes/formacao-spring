package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Categoria;
import modelo.Produto;

public class CategoriaDAO {

	Connection con;

	public CategoriaDAO(Connection con) {
		this.con = con;
	}

	public List<Categoria> listar() throws SQLException {
		List<Categoria> categorias = new ArrayList<Categoria>();

		try (PreparedStatement ps = con.prepareStatement("SELECT * FROM CATEGORIA")) {
			ps.execute();

			try(ResultSet rs = ps.getResultSet()){
				while(rs.next()) {
					Categoria categoria = new Categoria(rs.getInt("ID"), rs.getString("NOME"));
					categorias.add(categoria);
				}
			}
		}
		return categorias;		
	}

	public List<Categoria> pesquisaProdutoPorCategoria() throws SQLException {
		List<Categoria> categorias = new ArrayList<Categoria>();
		
		try (PreparedStatement ps = con.prepareStatement("SELECT C.ID AS ID_CATEGORIA, C.NOME AS NOME_CATEGORIA, "
				+ "P.ID AS ID_PRODUTO, P.NOME AS NOME_PRODUTO, P.DESCRICAO AS DESCRICAO_PRODUTO "
				+ "FROM LOJA.CATEGORIA C INNER JOIN LOJA.PRODUTO P ON C.ID = P.ID_CATEGORIA ORDER BY P.ID_CATEGORIA")) {
			ps.execute();

			try(ResultSet rs = ps.getResultSet()){
				
				Categoria ultimaCategoria = null;
				while(rs.next()) {
					Categoria categoria = new Categoria(rs.getInt(1), rs.getString(2));
					boolean novaCategoria = !categoria.equals(ultimaCategoria);
					
					if (novaCategoria) {
						ultimaCategoria = categoria;
						categorias.add(ultimaCategoria);
					}
					
					Produto produto = new Produto(rs.getInt("ID_PRODUTO"), rs.getString("NOME_PRODUTO"),  rs.getString("DESCRICAO_PRODUTO"), rs.getInt("ID_CATEGORIA"));
					ultimaCategoria.adicionarProduto(produto);
				}
			}
		}
		return categorias;
	}
}
