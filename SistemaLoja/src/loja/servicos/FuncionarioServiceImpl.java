package loja.servicos;

import loja.entidades.Funcionario;
import loja.interfaces.FuncionarioService;
import loja.repositorios.FuncionarioRepositorio;

import java.sql.SQLException;
import java.util.List;

public class FuncionarioServiceImpl implements FuncionarioService {

    private FuncionarioRepositorio funcionarioRepositorio = new FuncionarioRepositorio();


    public void adicionarFuncionario(Funcionario funcionario) throws SQLException {
        funcionarioRepositorio.inserir(funcionario);
    }


    public Funcionario buscarPorCpf(String cpf) throws SQLException {
        return funcionarioRepositorio.buscarPorCpf(cpf);
    }


    public List<Funcionario> listarFuncionarios() throws SQLException {
        return funcionarioRepositorio.listarTodos();
    }


    public void atualizarFuncionario(Funcionario funcionario) throws SQLException {
        funcionarioRepositorio.atualizar(funcionario);
    }


    public void deletarFuncionario(String cpf) throws SQLException {
        funcionarioRepositorio.deletar(cpf);
    }
}
