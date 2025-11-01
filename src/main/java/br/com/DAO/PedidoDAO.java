package br.com.DAO;

import br.com.Exceptions.LivroException;
import br.com.Repositorio.Conexao;
import br.com.entidades.Livro;
import br.com.entidades.Pedido;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PedidoDAO {

    public static Pedido getClienteDevedor(){

    }

    public static boolean verificaLivroDisponivel(int idLivro){

        String queryVerificaLivro = "SELECT STATUS FROM LIVROS WHERE ID = ?";
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int statusLivro = 0;

        try{

            preparedStatement = Conexao.getConexao().prepareStatement(queryVerificaLivro);
            preparedStatement.setInt(1, idLivro);
            resultSet = preparedStatement.executeQuery();


            if (resultSet.next()){
                statusLivro = resultSet.getInt("STATUS");
                if(statusLivro > 0){
                    throw new LivroException("Livro indisponível!");
                }
                return true;
            }
            preparedStatement.close();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        return false;
    }

    public static void criarPedidoAluguel(int idCliente, int idLivro){
        Pedido pedido = new Pedido();

        String queryInsertPedido = "INSERT INTO PEDIDOS (IDCLIENTE, IDLIVRO, DATAPEDIDO, STATUS)" +
                " VALUES (?, ?, CURDATE(), ?)";
        String querySelectIdPedido = "SELECT PEDIDO FROM PEDIDOS ORDER BY PEDIDO DESC LIMIT 1;";

        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = Conexao.getConexao().prepareStatement(queryInsertPedido);
            preparedStatement.setInt(1, idCliente);
            preparedStatement.setInt(2, idLivro);
            preparedStatement.setInt(3, pedido.getStatus());

            preparedStatement.execute();

            preparedStatement.close();

            LivroDAO.atualizarStatusLivroParaAlugado(idLivro);


            System.out.println("Pedido criado com sucesso!");

        } catch(SQLException e){
            System.out.println("Não foi possivel criar o pedido: ");
            System.out.println(e.getMessage());
        }
    }

    public static void criarPedidoDevolucao(int idCliente, int idLivro){
        String queryInsertPedido = "INSERT INTO PEDIDOS (IDCLIENTE, IDLIVRO, DATAPEDIDO, STATUS)" +
                " VALUES (?, ?, CURDATE(), ?)";

        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = Conexao.getConexao().prepareStatement(queryInsertPedido);
            preparedStatement.setInt(1, idCliente);
            preparedStatement.setInt(2, idLivro);
            preparedStatement.setInt(3, 0);

            preparedStatement.execute();

            preparedStatement.close();

            System.out.println("Pedido de devolução feito com sucesso!");

        } catch(SQLException e){
            System.out.println("Não foi possivel fazer o pedido de devolução: ");
            System.out.println(e.getMessage());
        }
    }

}