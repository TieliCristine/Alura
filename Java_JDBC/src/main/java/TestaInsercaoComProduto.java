import dao.ProdutoDAO;
import model.Produto;

import java.sql.*;

public class TestaInsercaoComProduto {
    public static void main(String[] args) throws SQLException {

        ConnectionFactory factory = new ConnectionFactory();
        Connection conexao = factory.getConexao();


        Produto comoda = new Produto("comoda", "comoda vertical");

        try(conexao){
            ProdutoDAO produtoDao = new ProdutoDAO(conexao);
            produtoDao.salvar(comoda);
        }
        System.out.println(comoda);
    }
}
