package loja.interfaces;

import loja.entidades.Funcionario;
import java.util.List;

public interface FuncionarioService {
	 void cadastrar(Funcionario funcionario);
	    Funcionario buscarPorCpf(String cpf);
	    void atualizar(Funcionario funcionario);
	    void remover(String cpf);
}
