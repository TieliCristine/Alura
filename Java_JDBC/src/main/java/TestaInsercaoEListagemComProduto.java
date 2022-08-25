import dao.ProdutoDAO;
import model.Produto;

import java.sql.*;
import java.util.List;

public class TestaInsercaoEListagemComProduto {
    public static void main(String[] args) throws SQLException {

        ConnectionFactory factory = new ConnectionFactory();
        Connection conexao = factory.getConexao();


        Produto comoda = new Produto("comoda GHT", "comoda horizontal");

        try(conexao){
            ProdutoDAO produtoDao = new ProdutoDAO(conexao);
            produtoDao.salvar(comoda);
            List<Produto> listaDeProdutos = produtoDao.listar();
            listaDeProdutos.stream().forEach(lp -> System.out.println(lp));
        }
    }
}
