package loja.servicos;

import loja.entidades.Cliente;
import loja.interfaces.ClienteService;
import loja.repositorios.ClienteRepositorio;

import java.sql.SQLException;
import java.util.List;

public class ClienteServiceImpl implements ClienteService {

    private ClienteRepositorio clienteRepositorio = new ClienteRepositorio();


    public void adicionarCliente(Cliente cliente) throws SQLException {
        clienteRepositorio.inserir(cliente);
    }


    public Cliente buscarPorCpf(String cpf) throws SQLException {
        return clienteRepositorio.buscarPorCpf(cpf);
    }


    public List<Cliente> listarClientes() throws SQLException {
        return clienteRepositorio.listarTodos();
    }


    public void atualizarCliente(Cliente cliente) throws SQLException {
        clienteRepositorio.atualizar(cliente);
    }


    public void deletarCliente(String cpf) throws SQLException {
        clienteRepositorio.deletar(cpf);
    }
}
