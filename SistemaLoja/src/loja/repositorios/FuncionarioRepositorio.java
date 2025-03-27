package loja.repositorios;

import loja.entidades.Funcionario;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepositorio {
	  private List<Funcionario> funcionarios = new ArrayList<>();

	    public void salvar(Funcionario funcionario) {
	        funcionarios.add(funcionario);
	    }

	    public Funcionario buscarPorCpf(String cpf) {
	        return funcionarios.stream()
	                .filter(f -> f.getCpf().equals(cpf))
	                .findFirst()
	                .orElse(null);
	    }

	    public void remover(String cpf) {
	        funcionarios.removeIf(f -> f.getCpf().equals(cpf));
	    }

	    public List<Funcionario> listar() {
	        return funcionarios;
	    }
}
