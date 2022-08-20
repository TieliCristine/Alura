import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem {

    public static void main(String[] args) throws SQLException {

        ConnectionFactory factory = new ConnectionFactory();
        Connection conexao = factory.getConexao();

        Statement stmt = conexao.createStatement();
        stmt.execute(" SELECT * FROM produto; ");

        ResultSet resultado = stmt.getResultSet();

        while (resultado.next()){
            Integer id = resultado.getInt("id");
            System.out.println(id);

            String nome = resultado.getString("nome");
            System.out.println(nome);

            String descricao = resultado.getString("descricao");
            System.out.println(descricao);
        }

        conexao.close();
    }
}
