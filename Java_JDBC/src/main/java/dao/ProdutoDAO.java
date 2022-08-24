package dao;

import model.Produto;

import java.sql.*;

public class ProdutoDAO {

    private Connection conexao;

    public ProdutoDAO(Connection conexao){
        this.conexao = conexao;
    }

    public void salvar(Produto produto) throws SQLException {

        String sql = " INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?) ";
        PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        try (stmt) {
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());

            stmt.execute();

            ResultSet resultado =  stmt.getGeneratedKeys();

            try(resultado){
                while (resultado.next()){
                    produto.setId(resultado.getInt(1));
                }
            }
        }
    }

}
