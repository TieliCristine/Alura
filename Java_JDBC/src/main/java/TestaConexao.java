import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection conexao = factory.getConexao();

        System.out.println("Teste conexao");
        conexao.close();
    }
}
