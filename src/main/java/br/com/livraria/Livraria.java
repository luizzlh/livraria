package br.com.livraria;

import br.com.DAO.ClienteDAO;
import br.com.DAO.LivroDAO;
import br.com.DAO.PedidoDAO;
import br.com.entidades.Cliente;
import br.com.entidades.Livro;
import br.com.entidades.Pedido;

import java.util.Scanner;

public class Livraria {

    private static Cliente cliente;
    private static Pedido pedido;
    private static LivroDAO livroDAO;
    private static ClienteDAO clienteDAO;
    private static PedidoDAO pedidoDAO;
    private static Scanner scanner = new Scanner(System.in);

    public static void menuCadastro(){
        Livro livro = new Livro();
        System.out.println("------------------");
        System.out.println("Digite o nome do livro: ");
        String tituloLivro = scanner.nextLine();
        System.out.println("Digite o nome do autor: ");
        String nomeAutorLivro = scanner.nextLine();

        livro.setNome(tituloLivro);
        livro.setAutor(nomeAutorLivro);

        try{
            LivroDAO.verificaLivroExistente(livro);
            Main.menu();
        } catch (Exception e){
            e.printStackTrace();
        }
    }





}
