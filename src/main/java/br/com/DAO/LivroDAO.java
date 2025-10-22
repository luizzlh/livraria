package br.com.DAO;

import br.com.Exceptions.LivroExistenteException;
import br.com.Repositorio.Conexao;
import br.com.entidades.Livro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;

public class LivroDAO {

    public static void verificaLivroExistente(Livro livro){

        String queryVerificaLivroExistente = "SELECT * FROM LIVROS WHERE NOME = ?";
        PreparedStatement preparedStatementSelect = null;
        ResultSet resultSet = null;

        try{
            preparedStatementSelect = Conexao.getConexao().prepareStatement(queryVerificaLivroExistente);
            preparedStatementSelect.setString(1, livro.getNome());
            resultSet = preparedStatementSelect.executeQuery();

            if(resultSet.next()){
                throw new LivroExistenteException("Livro existente!");
            }else{
                cadastrarLivro(livro);
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

    public static void cadastrarLivro(Livro livro){

        String queryCadastraLivro = "INSERT INTO LIVROS (AUTOR, NOME, STATUS) VALUES (?, ?, ?)";
        PreparedStatement preparedStatementInsert = null;

        try{
            preparedStatementInsert = Conexao.getConexao().prepareStatement(queryCadastraLivro);
            preparedStatementInsert.setString(1, livro.getAutor());
            preparedStatementInsert.setString(2, livro.getNome());
            preparedStatementInsert.setInt(3, livro.getStatus());

            preparedStatementInsert.execute();

            preparedStatementInsert.close();

            System.out.println("Livro cadastrado com sucesso!");

        }catch (SQLException e){
            System.out.println("Não foi possivel cadastrar este livro: ");
            e.printStackTrace();
        }

    }

    public static void atualizarStatusLivroParaAlugado(int idLivro){

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

    public static void atualizarStatusLivroParaDisponivel(int idLivro){

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