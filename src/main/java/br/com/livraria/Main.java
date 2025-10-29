package br.com.livraria;

import br.com.DAO.ClienteDAO;
import br.com.DAO.LivroDAO;
import br.com.DAO.PedidoDAO;
import br.com.Repositorio.Conexao;
import br.com.entidades.Cliente;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void menu(){
        System.out.println("-------------Livraria--------------");
        System.out.println("1 - Cadastrar livro");
        System.out.println("2 - Cadastrar cliente");
        System.out.println("3 - Alugar livro");
        System.out.println("4 - Devolver livro");
        System.out.println("5 - Sair");
        System.out.println("-----------------------------------");
        System.out.print("Sua escolha: ");
        int escolha = scanner.nextInt();

        switch (escolha){
            case 1:
                Livraria.menuCadastroLivro();
                break;
            case 2:
                Livraria.menuCadastroCliente();
                break;
            case 3:
                Livraria.menuAlugaLivro();
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                menu();
                break;
        }


    }

    public static void main(String[] args) {
        menu();

    }
}