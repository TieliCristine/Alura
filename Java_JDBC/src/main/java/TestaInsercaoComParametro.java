import java.sql.*;

public class TestaInsercaoComParametro {

    public static void main(String[] args) throws SQLException {

        ConnectionFactory factory = new ConnectionFactory();

        try (Connection conexao = factory.getConexao()) {
            conexao.setAutoCommit(false);

            String sql = " INSERT INTO produto (nome, descricao) VALUES (?, ?); ";
            PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            try (stmt) {
                adicionarVariavel("Smart TV", "45 polegadas", stmt);
                adicionarVariavel("Radio", "Radio com bateria", stmt);
                conexao.commit();

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("ROLLBACK EXECUTADO");
                conexao.rollback();
            }
        }
    }

    private static void adicionarVariavel(String nome, String descricao, PreparedStatement stmt) throws SQLException {

        stmt.setString(1, nome);
        stmt.setString(2, descricao);

        if (nome.equals("Radio")) {
            throw new RuntimeException("Nao foi possivel adicionar o produto");
        }
        stmt.execute();

        ResultSet resultado = stmt.getGeneratedKeys();

        try(resultado){
            while (resultado.next()) {
                Integer id = resultado.getInt(1);
                System.out.println("O ID criado foi: " + id);
            }
        }
    }
}

