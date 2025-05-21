package loja.view;

import loja.entidades.Cliente;
import loja.entidades.Funcionario;
import loja.entidades.Produto;
import loja.servicos.ClienteServiceImpl;
import loja.servicos.FuncionarioServiceImpl;
import loja.servicos.ProdutoServiceImpl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static ProdutoServiceImpl produtoService = new ProdutoServiceImpl();
    private static ClienteServiceImpl clienteService = new ClienteServiceImpl();
    private static FuncionarioServiceImpl funcionarioService = new FuncionarioServiceImpl();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean sair = false;

        while (!sair) {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1. CRUD Produto");
            System.out.println("2. CRUD Cliente");
            System.out.println("3. CRUD Funcionario");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = Integer.parseInt(scanner.nextLine());

            try {
                switch (opcao) {
                    case 1 -> menuProduto();
                    case 2 -> menuCliente();
                    case 3 -> menuFuncionario();
                    case 0 -> sair = true;
                    default -> System.out.println("Opção inválida.");
                }
            } catch (SQLException e) {
                System.out.println("Erro no banco de dados: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite números.");
            }
        }

        System.out.println("Programa finalizado.");
    }

    // ------------------- MENU PRODUTO -------------------

    private static void menuProduto() throws SQLException {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n--- Menu Produto ---");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Buscar Produto por ID");
            System.out.println("3. Listar Todos os Produtos");
            System.out.println("4. Atualizar Produto");
            System.out.println("5. Deletar Produto");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> adicionarProduto();
                case 2 -> buscarProduto();
                case 3 -> listarProdutos();
                case 4 -> atualizarProduto();
                case 5 -> deletarProduto();
                case 0 -> voltar = true;
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private static void adicionarProduto() throws SQLException {
        System.out.print("ID do Produto: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Nome do Produto: ");
        String nome = scanner.nextLine();

        System.out.print("Preço do Produto: ");
        BigDecimal preco = new BigDecimal(scanner.nextLine());

        Produto produto = new Produto(id, nome, preco);
        produtoService.adicionarProduto(produto);
        System.out.println("Produto adicionado com sucesso!");
    }

    private static void buscarProduto() throws SQLException {
        System.out.print("ID do Produto: ");
        int id = Integer.parseInt(scanner.nextLine());

        Produto produto = produtoService.buscarPorId(id);
        if (produto != null) {
            produto.exibirInformacoes();
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private static void listarProdutos() throws SQLException {
        List<Produto> produtos = produtoService.listarProdutos();
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            produtos.forEach(Produto::exibirInformacoes);
        }
    }

    private static void atualizarProduto() throws SQLException {
        System.out.print("ID do Produto a atualizar: ");
        int id = Integer.parseInt(scanner.nextLine());

        Produto produto = produtoService.buscarPorId(id);
        if (produto == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        System.out.print("Novo nome do Produto: ");
        String nome = scanner.nextLine();

        System.out.print("Novo preço do Produto: ");
        BigDecimal preco = new BigDecimal(scanner.nextLine());

        produto.setNome(nome);
        produto.setPreco(preco);

        produtoService.atualizarProduto(produto);
        System.out.println("Produto atualizado com sucesso!");
    }

    private static void deletarProduto() throws SQLException {
        System.out.print("ID do Produto a deletar: ");
        int id = Integer.parseInt(scanner.nextLine());

        produtoService.deletarProduto(id);
        System.out.println("Produto deletado com sucesso!");
    }

    // ------------------- MENU CLIENTE -------------------

    private static void menuCliente() throws SQLException {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n--- Menu Cliente ---");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Buscar Cliente por CPF");
            System.out.println("3. Listar Todos os Clientes");
            System.out.println("4. Atualizar Cliente");
            System.out.println("5. Deletar Cliente");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> adicionarCliente();
                case 2 -> buscarCliente();
                case 3 -> listarClientes();
                case 4 -> atualizarCliente();
                case 5 -> deletarCliente();
                case 0 -> voltar = true;
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private static void adicionarCliente() throws SQLException {
        System.out.print("CPF do Cliente: ");
        String cpf = scanner.nextLine();

        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();

        System.out.print("Endereço do Cliente: ");
        String endereco = scanner.nextLine();

        Cliente cliente = new Cliente(nome, cpf, endereco);
        clienteService.adicionarCliente(cliente);
        System.out.println("Cliente adicionado com sucesso!");
    }

    private static void buscarCliente() throws SQLException {
        System.out.print("CPF do Cliente: ");
        String cpf = scanner.nextLine();

        Cliente cliente = clienteService.buscarPorCpf(cpf);
        if (cliente != null) {
            cliente.exibirInformacoes();
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static void listarClientes() throws SQLException {
        List<Cliente> clientes = clienteService.listarClientes();
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            clientes.forEach(Cliente::exibirInformacoes);
        }
    }

    private static void atualizarCliente() throws SQLException {
        System.out.print("CPF do Cliente a atualizar: ");
        String cpf = scanner.nextLine();

        Cliente cliente = clienteService.buscarPorCpf(cpf);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        System.out.print("Novo nome do Cliente: ");
        String nome = scanner.nextLine();

        System.out.print("Novo endereço do Cliente: ");
        String endereco = scanner.nextLine();

        cliente.setNome(nome);
        cliente.setEndereco(endereco);

        clienteService.atualizarCliente(cliente);
        System.out.println("Cliente atualizado com sucesso!");
    }

    private static void deletarCliente() throws SQLException {
        System.out.print("CPF do Cliente a deletar: ");
        String cpf = scanner.nextLine();

        clienteService.deletarCliente(cpf);
        System.out.println("Cliente deletado com sucesso!");
    }

    // ------------------- MENU FUNCIONARIO -------------------

    private static void menuFuncionario() throws SQLException {
        boolean voltar = false;
        while (!voltar) {
            System.out.println("\n--- Menu Funcionario ---");
            System.out.println("1. Adicionar Funcionario");
            System.out.println("2. Buscar Funcionario por CPF");
            System.out.println("3. Listar Todos os Funcionarios");
            System.out.println("4. Atualizar Funcionario");
            System.out.println("5. Deletar Funcionario");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> adicionarFuncionario();
                case 2 -> buscarFuncionario();
                case 3 -> listarFuncionarios();
                case 4 -> atualizarFuncionario();
                case 5 -> deletarFuncionario();
                case 0 -> voltar = true;
                default -> System.out.println("Opção inválida.");
            }
        }
    }

    private static void adicionarFuncionario() throws SQLException {
        System.out.print("CPF do Funcionario: ");
        String cpf = scanner.nextLine();

        System.out.print("Nome do Funcionario: ");
        String nome = scanner.nextLine();

        System.out.print("Salário do Funcionario: ");
        BigDecimal salario = new BigDecimal(scanner.nextLine());

        Funcionario funcionario = new Funcionario(nome, cpf, salario);
        funcionarioService.adicionarFuncionario(funcionario);
        System.out.println("Funcionario adicionado com sucesso!");
    }

    private static void buscarFuncionario() throws SQLException {
        System.out.print("CPF do Funcionario: ");
        String cpf = scanner.nextLine();

        Funcionario funcionario = funcionarioService.buscarPorCpf(cpf);
        if (funcionario != null) {
            funcionario.exibirInformacoes();
        } else {
            System.out.println("Funcionario não encontrado.");
        }
    }

    private static void listarFuncionarios() throws SQLException {
        List<Funcionario> funcionarios = funcionarioService.listarFuncionarios();
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionario cadastrado.");
        } else {
            funcionarios.forEach(Funcionario::exibirInformacoes);
        }
    }

    private static void atualizarFuncionario() throws SQLException {
        System.out.print("CPF do Funcionario a atualizar: ");
        String cpf = scanner.nextLine();

        Funcionario funcionario = funcionarioService.buscarPorCpf(cpf);
        if (funcionario == null) {
            System.out.println("Funcionario não encontrado.");
            return;
        }

        System.out.print("Novo nome do Funcionario: ");
        String nome = scanner.nextLine();

        System.out.print("Novo salário do Funcionario: ");
        BigDecimal salario = new BigDecimal(scanner.nextLine());

        funcionario.setNome(nome);
        funcionario.setSalario(salario);

        funcionarioService.atualizarFuncionario(funcionario);
        System.out.println("Funcionario atualizado com sucesso!");
    }

    private static void deletarFuncionario() throws SQLException {
        System.out.print("CPF do Funcionario a deletar: ");
        String cpf = scanner.nextLine();

        funcionarioService.deletarFuncionario(cpf);
        System.out.println("Funcionario deletado com sucesso!");
    }
}
