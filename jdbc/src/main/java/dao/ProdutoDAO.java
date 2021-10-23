package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Produto;

public class ProdutoDAO {

	private Connection con;

	//	DAO é a abreviação de Data Access Object. Se trata de uma boa prática da programação com jdbc.
	//	A classe ProdutoDAO será responsável por fazer toda a comunicação da nossa aplicação com o banco de dados.
	public ProdutoDAO(Connection con) {
		this.con = con;
	}

	public void salvar(Produto prod) throws SQLException {
		try(PreparedStatement ps = con.prepareStatement("insert into loja.produto (nome, descricao, id_categoria) values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
			con.setAutoCommit(false);

			ps.setString(1, prod.getNome());
			ps.setString(2, prod.getDescricao());
			ps.setInt(3, prod.getIdCategoria());
			ps.execute();

			con.commit();

			try(ResultSet generatedKeys = ps.getGeneratedKeys()){
				while (generatedKeys.next()) {
					System.out.println("Id adicionado: " + generatedKeys.getInt(1));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao incluir produtos. Efetuando rollback no banco...");
			con.rollback();
		}
	}

	public List<Produto> listar() {

		List<Produto> produtos = new ArrayList<Produto>();

		try(PreparedStatement stm = con.prepareStatement("select * from loja.produto")) {

			stm.execute();

			try(ResultSet rs = stm.getResultSet()) {				
				while (rs.next()) {
					produtos.add(new Produto(rs.getInt("ID"), rs.getString("nome"), rs.getString("descricao"), rs.getInt("id_categoria")));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return produtos;
	}
}

