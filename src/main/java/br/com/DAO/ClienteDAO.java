package br.com.DAO;

import br.com.Repositorio.Conexao;
import br.com.entidades.Cliente;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {

    public void cadastrarCliente(Cliente cliente){

        String queryInsertCliente = "INSERT INTO CLIENTES (NOME, IDADE, EMAIL, DEVEDOR) VALUES (?, ?, ?, ?)";

        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = Conexao.getConexao().prepareStatement(queryInsertCliente);
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setInt(2, cliente.getIdade());
            preparedStatement.setString(3, cliente.getEmail());
            preparedStatement.setInt(4, 0);

            preparedStatement.execute();

            preparedStatement.close();

            System.out.println("Cliente cadastrado com sucessO!");
        } catch(SQLException e){
            System.out.println("Não foi possivel cadastrar esse usuário: ");
            e.printStackTrace();
        }
    }

    public void atualizarStatusClienteParaDevedor(int idCliente){

        String  queryUpdateCliente = "UPDATE CLIENTES SET DEVEDOR = 1 WHERE ID = ?";

        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = Conexao.getConexao().prepareStatement(queryUpdateCliente);
            preparedStatement.setInt(1, idCliente);

            preparedStatement.execute();

            preparedStatement.close();

            System.out.println("Status cliente atualizado com sucesso!");
        }catch (SQLException e){
            System.out.println("Não foi possivel atualizar o status: ");
            e.printStackTrace();
        }
    }

    public static void atualizarStatusClienteParaDisponivel(int idCliente){

        String  queryUpdateCliente = "UPDATE CLIENTES SET DEVEDOR = 0 WHERE ID = ?";

        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = Conexao.getConexao().prepareStatement(queryUpdateCliente);
            preparedStatement.setInt(1, idCliente);

            preparedStatement.execute();

            preparedStatement.close();

            System.out.println("Status cliente atualizado com sucesso!");
        }catch (SQLException e){
            System.out.println("Não foi possivel atualizar o status: ");
            e.printStackTrace();
        }
    }

}