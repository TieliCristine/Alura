package dao;

import model.Categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    private Connection conexao;

    public CategoriaDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public List<Categoria> listar() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();

        String sql = " SELECT ID, NOME FROM CATEGORIA ";
        PreparedStatement stmt = conexao.prepareStatement(sql);

        try(stmt){
            stmt.execute();

            ResultSet resultado = stmt.getResultSet();
            while(resultado.next()){
                Categoria categoria = new Categoria(resultado.getInt(1), resultado.getString("nome"));
                categorias.add(categoria);
            }

        }

        return categorias;
    }
}
