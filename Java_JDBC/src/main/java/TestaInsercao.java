import java.sql.*;

public class TestaInsercao {

    public static void main(String[] args) throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        Connection conexao = factory.getConexao();

        String sql = " INSERT INTO produto (nome, descricao) VALUES ('mouse', 'mouse sem fio')";

        PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.execute();

        ResultSet resultado = stmt.getGeneratedKeys();

        while (resultado.next()){
            Integer id = resultado.getInt(1);
            System.out.println("O ID criado foi: " + id);
        }
    }
}
