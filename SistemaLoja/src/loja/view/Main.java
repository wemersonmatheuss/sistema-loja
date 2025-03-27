package loja.view;


import loja.entidades.Cliente;
import loja.entidades.Funcionario;
import loja.entidades.Produto;
import loja.servicos.ClienteServico;
import loja.servicos.FuncionarioServico;
import loja.servicos.ProdutoServico;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ClienteServico clienteServico = new ClienteServico();
        FuncionarioServico funcionarioServico = new FuncionarioServico();
        ProdutoServico produtoServico = new ProdutoServico();

        while (true) {
            System.out.println("\n1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Funcionário");
            System.out.println("3 - Cadastrar Produto");
            System.out.println("4 - Sair");
            System.out.print("Escolha: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.print("Nome do Cliente: ");
                String nome = scanner.nextLine();
                System.out.print("CPF: ");
                String cpf = scanner.nextLine();
                System.out.print("Endereço: ");
                String endereco = scanner.nextLine();
                clienteServico.cadastrar(new Cliente(nome, cpf, endereco));
            } else if (opcao == 2) {
                System.out.print("Nome do Funcionário: ");
                String nome = scanner.nextLine();
                System.out.print("CPF: ");
                String cpf = scanner.nextLine();
                System.out.print("Salário: ");
                double salario = scanner.nextDouble();
                funcionarioServico.cadastrar(new Funcionario(nome, cpf, salario));
            } else if (opcao == 3) {
                System.out.print("Nome do Produto: ");
                String nome = scanner.nextLine();
                System.out.print("ID: ");
                int id = scanner.nextInt();
                System.out.print("Preço: ");
                double preco = scanner.nextDouble();
                produtoServico.cadastrar(new Produto(id, nome, preco));
            } else if (opcao == 4) {
                break;
            }
        }
        scanner.close();
    }
}
