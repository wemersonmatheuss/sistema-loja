package loja.interfaces;

import loja.entidades.Funcionario;
import java.sql.SQLException;
import java.util.List;

public interface FuncionarioService {
	void adicionarFuncionario(Funcionario funcionario) throws SQLException;
	Funcionario buscarPorCpf(String cpf) throws SQLException;
	List<Funcionario> listarFuncionarios() throws SQLException;
	void atualizarFuncionario(Funcionario funcionario) throws SQLException;
	void deletarFuncionario(String cpf) throws SQLException;
}
