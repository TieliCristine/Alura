import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestaDelete {

    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection conexao = factory.getConexao();

        String sql = " DELETE FROM produto WHERE id > ?; ";
        PreparedStatement stmt = conexao.prepareStatement(sql);

        stmt.setInt(1, 2);
        stmt.execute();
        Integer linhasModificadas = stmt.getUpdateCount();

        System.out.println("Qtd. de linhas modificadas: " + linhasModificadas);
    }
}
