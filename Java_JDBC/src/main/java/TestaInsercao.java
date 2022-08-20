import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao {

    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection conexao = factory.getConexao();

        Statement stmt = conexao.createStatement();
        String sql = " INSERT INTO produto (nome, descricao) VALUES ('mouse', 'mouse sem fio')";
        stmt.execute(sql, Statement.RETURN_GENERATED_KEYS);

        ResultSet resultado = stmt.getGeneratedKeys();

        while (resultado.next()){
            Integer id = resultado.getInt(1);
            System.out.println("O ID criado foi: " + id);
        }
    }
}
