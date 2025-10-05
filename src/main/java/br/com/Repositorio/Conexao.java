package br.com.Repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String url = "jdbc:mysql://localhost:3306/db_livraria";
    private static final String user = "root";
    private static final String password = "luiz1402";

    private static Connection conn;

    public static Connection getConexao() {

        try{
            if(conn == null){
                conn = DriverManager.getConnection(url, user, password);
                return conn;
            }else{
                return conn;
            }
        } catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
