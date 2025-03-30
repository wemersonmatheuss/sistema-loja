package loja.servicos;

import loja.entidades.Cliente;
import loja.interfaces.ClienteService;
import loja.repositorios.ClienteRepositorio;

public class ClienteServico implements ClienteService {
    private ClienteRepositorio repositorio = new ClienteRepositorio();

    public void cadastrar(Cliente cliente) {
        repositorio.salvar(cliente);
    }

    public Cliente buscarPorCpf(String cpf) {
        return repositorio.buscarPorCpf(cpf);
    }

    public void atualizar(Cliente cliente) {
        Cliente existente = repositorio.buscarPorCpf(cliente.getCpf());
        if (existente != null) {
            existente.setNome(cliente.getNome());
            existente.setEndereco(cliente.getEndereco());
        }
    }

    public void remover(String cpf) {
        repositorio.remover(cpf);
    }
}
