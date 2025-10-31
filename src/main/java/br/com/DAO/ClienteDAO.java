package br.com.DAO;

import br.com.Exceptions.ClienteException;
import br.com.Repositorio.Conexao;
import br.com.entidades.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {

    public static void verificaClienteExistente(Cliente cliente){
        String queryVerificaClienteExistente = "SELECT * FROM CLIENTES WHERE EMAIL = ?";
        PreparedStatement preparedStatementSelect = null;
        ResultSet resultSet = null;

        try{
            preparedStatementSelect = Conexao.getConexao().prepareStatement(queryVerificaClienteExistente);
            preparedStatementSelect.setString(1, cliente.getEmail());
            resultSet = preparedStatementSelect.executeQuery();

            if(resultSet.next()){
                throw new ClienteException("Cliente existente!");
            }else{
                cadastrarCliente(cliente);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatementSelect != null) {
                    preparedStatementSelect.close();
                }
            } catch (java.sql.SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void cadastrarCliente(Cliente cliente){

        String queryInsertCliente = "INSERT INTO CLIENTES (NOME, IDADE, EMAIL, DEVEDOR) VALUES (?, ?, ?, ?)";

        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = Conexao.getConexao().prepareStatement(queryInsertCliente);
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setInt(2, cliente.getIdade());
            preparedStatement.setString(3, cliente.getEmail());
            preparedStatement.setInt(4, cliente.getDevedor());

            preparedStatement.execute();

            preparedStatement.close();

            System.out.println("Cliente cadastrado com sucessO!");
        } catch(SQLException e){
            System.out.println("Não foi possivel cadastrar esse usuário: ");
            e.printStackTrace();
        }
    }

    public static void atualizarStatusClienteParaDevedor(int idCliente){

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