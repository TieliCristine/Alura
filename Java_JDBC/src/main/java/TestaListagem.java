import java.sql.*;

public class TestaListagem {

    public static void main(String[] args) throws SQLException {

        ConnectionFactory factory = new ConnectionFactory();
        Connection conexao = factory.getConexao();

        String sql = " SELECT * FROM produto; ";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.execute();

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
