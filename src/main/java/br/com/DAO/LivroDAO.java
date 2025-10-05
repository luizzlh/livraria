package br.com.DAO;

import br.com.Repositorio.Conexao;
import br.com.entidades.Livro;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LivroDAO {

    private void cadastrarLivro(Livro livro){

        String cadastrarLivro = "INSERT INTO LIVROS (AUTOR, NOME, STATUS) VALUES (?, ?, ?)";

        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = Conexao.getConexao().prepareStatement(cadastrarLivro);
            preparedStatement.setString(1, livro.getAutor());
            preparedStatement.setString(2, livro.getNome());
            preparedStatement.setInt(3, 0);

            preparedStatement.execute();

            preparedStatement.close();

            System.out.println("Livro cadastrado com sucesso!");

        }catch (SQLException e){
            System.out.println("Não foi possivel cadastrar este livro: ");
            e.printStackTrace();
        }

    }



}
