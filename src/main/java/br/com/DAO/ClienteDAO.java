package br.com.DAO;

import br.com.Repositorio.Conexao;
import br.com.entidades.Cliente;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {

    public void cadastrarCliente(Cliente cliente){

        String cadastrarUsuario = "INSERT INTO CLIENTES (NOME, IDADE, EMAIL, DEVEDOR) VALUES (?, ?, ?, ?)";

        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = Conexao.getConexao().prepareStatement(cadastrarUsuario);
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setInt(2, cliente.getIdade());
            preparedStatement.setString(3, cliente.getEmail());
            preparedStatement.setInt(4, 0);

            preparedStatement.execute();

            preparedStatement.close();

            System.out.println("Cliente cadastrado com sucessO!");
        } catch(SQLException e){
            e.printStackTrace();
        }

    }

}
