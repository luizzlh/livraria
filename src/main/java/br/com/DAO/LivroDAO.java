package br.com.DAO;

import br.com.Repositorio.Conexao;
import br.com.entidades.Livro;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LivroDAO {

    private void cadastrarLivro(Livro livro){

        String queryCadastraLivro = "INSERT INTO LIVROS (AUTOR, NOME, STATUS) VALUES (?, ?, ?)";

        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = Conexao.getConexao().prepareStatement(queryCadastraLivro);
            preparedStatement.setString(1, livro.getAutor());
            preparedStatement.setString(2, livro.getNome());
            preparedStatement.setInt(3, livro.getStatus());

            preparedStatement.execute();

            preparedStatement.close();

            System.out.println("Livro cadastrado com sucesso!");

        }catch (SQLException e){
            System.out.println("Não foi possivel cadastrar este livro: ");
            e.printStackTrace();
        }

    }

    private static void atualizarStatusLivroParaAlugado(int idLivro){

        String queryUpdateStatusLivro = "UPDATE LIVROS SET STATUS = 1 WHERE ID = ?";

        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = Conexao.getConexao().prepareStatement(queryUpdateStatusLivro);
            preparedStatement.setInt(1, idLivro);

            preparedStatement.execute();

            preparedStatement.close();

            System.out.println("Status do livro atualizado com sucesso!");
        } catch(SQLException e){
            System.out.println("Não foi possível atualizar o status do livro: ");
            e.printStackTrace();
        }
    }

    private static void atualizarStatusLivroParaDisponivel(int idLivro){

        String queryUpdateStatusLivro = "UPDATE LIVROS SET STATUS = 0 WHERE ID = ?";

        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = Conexao.getConexao().prepareStatement(queryUpdateStatusLivro);
            preparedStatement.setInt(1, idLivro);

            preparedStatement.execute();

            preparedStatement.close();

            System.out.println("Status do livro atualizado com sucesso!");
        } catch(SQLException e){
            System.out.println("Não foi possível atualizar o status do livro: ");
            e.printStackTrace();
        }
    }
}