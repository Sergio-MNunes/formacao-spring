package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteQuery {

	public static void main(String[] args) throws SQLException {
		ConnectionFactory cf = new ConnectionFactory();
		try(Connection con = cf.criaConexao()) {
			con.setAutoCommit(false);
			
			try(PreparedStatement ps = con.prepareStatement("DELETE FROM loja.produto WHERE id > ?")) {

				ps.setInt(1, 32);
				ps.execute();
				con.commit();
				
				int linhasModificadas = 0;
				linhasModificadas += ps.getUpdateCount();
				System.out.println("Quantidade de produtos deletados: " + linhasModificadas);
						
			}
		}
	}
}
