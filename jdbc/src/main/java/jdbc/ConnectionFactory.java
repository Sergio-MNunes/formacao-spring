package jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	private ComboPooledDataSource dataSource;

	public ConnectionFactory() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/loja?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("root");
		
		comboPooledDataSource.setMaxPoolSize(15);
		
//		O dataSource é responsável por fazer a intermediação entre o pool de conexões e a nossa aplicação.
//		Desta forma, caso a lib de pool de conexões seja alterada, nossa aplicação não precisará de muita manutenção.
		this.dataSource = comboPooledDataSource;
	}
	
	public Connection criaConexao() throws SQLException {
		return dataSource.getConnection();
	}
}