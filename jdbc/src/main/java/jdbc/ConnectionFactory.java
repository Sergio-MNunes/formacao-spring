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
		
//		O dataSource � respons�vel por fazer a intermedia��o entre o pool de conex�es e a nossa aplica��o.
//		Desta forma, caso a lib de pool de conex�es seja alterada, nossa aplica��o n�o precisar� de muita manuten��o.
		this.dataSource = comboPooledDataSource;
	}
	
	public Connection criaConexao() throws SQLException {
		return dataSource.getConnection();
	}
}