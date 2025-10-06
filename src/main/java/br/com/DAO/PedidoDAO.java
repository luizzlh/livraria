package br.com.DAO;

import br.com.Repositorio.Conexao;
import br.com.entidades.Pedido;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PedidoDAO {
    static Pedido pedido;

    private static void criarPedido(int idCliente, int idLivro){

        String queryInsertPedido = "INSERT INTO PEDIDOS (IDCLIENTE, IDLIVRO, DATAPEDIDO, STATUS) VALUES (?, ?, CURDATE(), ?)";

        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = Conexao.getConexao().prepareStatement(queryInsertPedido);
            preparedStatement.setInt(1, idCliente);
            preparedStatement.setInt(2, idLivro);
            preparedStatement.setInt(4, pedido.getStatus());

            preparedStatement.execute();

            preparedStatement.close();

            System.out.println("Pedido criado com sucesso!");

        } catch(SQLException e){
            System.out.println("Não foi possivel criar o pedido: ");
            e.printStackTrace();
        }
    }

}
