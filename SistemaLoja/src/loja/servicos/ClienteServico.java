package loja.servicos;

import loja.entidades.Cliente;
import loja.interfaces.ClienteService;
import loja.repositorios.ClienteRepositorio;

public class ClienteServico implements ClienteService {
    private ClienteRepositorio repositorio = new ClienteRepositorio();

    @Override
    public void cadastrar(Cliente cliente) {
        repositorio.salvar(cliente);
    }

    @Override
    public Cliente buscarPorCpf(String cpf) {
        return repositorio.buscarPorCpf(cpf);
    }

    @Override
    public void atualizar(Cliente cliente) {
        Cliente existente = repositorio.buscarPorCpf(cliente.getCpf());
        if (existente != null) {
            existente.setNome(cliente.getNome());
            existente.setEndereco(cliente.getEndereco());
        }
    }

    @Override
    public void remover(String cpf) {
        repositorio.remover(cpf);
    }
}