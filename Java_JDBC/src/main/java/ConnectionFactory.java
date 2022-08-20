import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConexao() throws SQLException {

        String urlConexao = "jdbc:mysql://localhost:3306";
        String usuario = "root";
        String senha = "";
        return DriverManager.getConnection(urlConexao, usuario, senha);
    }
}
