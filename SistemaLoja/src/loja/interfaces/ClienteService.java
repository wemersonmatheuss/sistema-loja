package loja.interfaces;

import loja.entidades.Cliente;
import java.sql.SQLException;
import java.util.List;

public interface ClienteService {
	void adicionarCliente(Cliente cliente) throws SQLException;
	Cliente buscarPorCpf(String cpf) throws SQLException;
	List<Cliente> listarClientes() throws SQLException;
	void atualizarCliente(Cliente cliente) throws SQLException;
	void deletarCliente(String cpf) throws SQLException;
}
