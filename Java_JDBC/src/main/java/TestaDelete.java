import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaDelete {

    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection conexao = factory.getConexao();

        Statement stmt = conexao.createStatement();
//        stmt.execute(" DELETE FROM produto WHERE id > 2; ");
        stmt.execute(" DELETE FROM produto WHERE id = 2; ");
        Integer linhasModificadas = stmt.getUpdateCount();

        System.out.println("Qtd. de linhas modificadas: " + linhasModificadas);
    }
}
