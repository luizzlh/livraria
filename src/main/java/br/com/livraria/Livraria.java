package br.com.livraria;

import br.com.DAO.ClienteDAO;
import br.com.DAO.LivroDAO;
import br.com.DAO.PedidoDAO;
import br.com.entidades.Cliente;
import br.com.entidades.Livro;
import br.com.entidades.Pedido;

import java.util.Scanner;

public class Livraria {

    private static LivroDAO livroDAO;
    private static ClienteDAO clienteDAO;
    private static PedidoDAO pedidoDAO;
    private static Scanner scanner = new Scanner(System.in);

    public static void menuCadastroLivro(){
        Livro livro = new Livro();
        System.out.println("------------------");
        System.out.print("Digite o nome do livro: ");
        String tituloLivro = scanner.nextLine();
        System.out.print("Digite o nome do autor: ");
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

    public static void menuCadastroCliente(){
        Cliente cliente = new Cliente();

        System.out.println("------------------");
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();

        System.out.print("Digite a idade do cliente: ");
        int idadeCliente = Integer.parseInt(scanner.nextLine().trim());

        System.out.print("Digite o email do cliente: ");
        String emailCliente = scanner.nextLine();

        cliente.setNome(nomeCliente);
        cliente.setIdade(idadeCliente);
        cliente.setEmail(emailCliente);

        try{
            ClienteDAO.verificaClienteExistente(cliente);
            Main.menu();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void menuAlugaLivro(){

        System.out.println("------------------");
        System.out.print("Digite o ID do Livro a ser alugado: ");
        int idLivroAluguel = scanner.nextInt();
        System.out.println("Digite o ID do Cliente requerente: ");
        int idClienteRequerente = scanner.nextInt();

        if(PedidoDAO.verificaLivroDisponivel(idLivroAluguel)){
            PedidoDAO.criarPedidoAluguel(idClienteRequerente, idLivroAluguel);
        }else{
            menuAlugaLivro();
        }

    }





}
