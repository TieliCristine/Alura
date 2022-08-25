package dao;

import model.Categoria;
import model.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private Connection conexao;

    public ProdutoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void salvar(Produto produto) throws SQLException {

        String sql = " INSERT INTO PRODUTO (NOME, DESCRICAO) VALUES (?, ?) ";
        PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        try (stmt) {
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());

            stmt.execute();

            ResultSet resultado = stmt.getGeneratedKeys();

            try (resultado) {
                while (resultado.next()) {
                    produto.setId(resultado.getInt(1));
                }
            }
        }
    }

    public List<Produto> listar() throws SQLException {
        List<Produto> produtos = new ArrayList<>();

        String sql = " SELECT ID, NOME, DESCRICAO FROM PRODUTO ";
        PreparedStatement stmt = conexao.prepareStatement(sql);

        try (stmt) {
            stmt.execute();
            ResultSet resultado = stmt.getResultSet();
            try (resultado) {
                while (resultado.next()) {
                    Produto produto =
                            new Produto(resultado.getInt(1), resultado.getString("nome"), resultado.getString("descricao"));

                    produtos.add(produto);
                }
            }
        }
        return produtos;
    }

    public List<Produto> buscar(Categoria ct) throws SQLException {
        List<Produto> produtos = new ArrayList<Produto>();

        String sql = " SELECT ID, NOME, DESCRICAO FROM PRODUTO WHERE ID_CATEGORIA = ?  ";
        PreparedStatement stmt = conexao.prepareStatement(sql);

        try (stmt) {
            stmt.setInt(1, ct.getId());
            stmt.execute();
            ResultSet resultado = stmt.getResultSet();
            try (resultado) {
                while (resultado.next()) {
                    Produto produto =
                            new Produto(resultado.getInt(1), resultado.getString("nome"), resultado.getString("descricao"));

                    produtos.add(produto);
                }
            }
        }
        return produtos;
    }
}

