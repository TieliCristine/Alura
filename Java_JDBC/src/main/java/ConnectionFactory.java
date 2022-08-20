import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {

    public DataSource dataSource;

    public ConnectionFactory(){
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/loja_virtual");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("");

        comboPooledDataSource.setMaxPoolSize(15);

        this.dataSource = comboPooledDataSource;
    }

    public Connection getConexao() throws SQLException {
        return this.dataSource.getConnection();
    }
}
