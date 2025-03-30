package loja.servicos;

import loja.entidades.Funcionario;
import loja.interfaces.FuncionarioService;
import loja.repositorios.FuncionarioRepositorio;

public class FuncionarioServico implements FuncionarioService {
    private FuncionarioRepositorio repositorio = new FuncionarioRepositorio();

    public void cadastrar(Funcionario funcionario) {
        repositorio.salvar(funcionario);
    }

    public Funcionario buscarPorCpf(String cpf) {
        return repositorio.buscarPorCpf(cpf);
    }

    public void atualizar(Funcionario funcionario) {
        Funcionario existente = repositorio.buscarPorCpf(funcionario.getCpf());
        if (existente != null) {
            existente.setNome(funcionario.getNome());
            existente.setSalario(funcionario.getSalario());
        }
    }

    public void remover(String cpf) {
        repositorio.remover(cpf);
    }
}
