import dao.CategoriaDAO;
import model.Categoria;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TestaListagemDeCategorias {
    public static void main(String[] args) throws SQLException {

        ConnectionFactory factory = new ConnectionFactory();
        Connection conexao = factory.getConexao();

        try(conexao){
            CategoriaDAO categoriaDAO = new CategoriaDAO(conexao);
            List<Categoria> listaCategorias = categoriaDAO.listar();
            listaCategorias.stream().forEach(ct -> {
                System.out.println(ct.getNome());
            });
        }
    }
}
