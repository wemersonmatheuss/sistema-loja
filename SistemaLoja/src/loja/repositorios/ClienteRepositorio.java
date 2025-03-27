package loja.repositorios;

import loja.entidades.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepositorio {
	 private List<Cliente> clientes = new ArrayList<>();

	    public void salvar(Cliente cliente) {
	        clientes.add(cliente);
	    }

	    public Cliente buscarPorCpf(String cpf) {
	        return clientes.stream()
	                .filter(c -> c.getCpf().equals(cpf))
	                .findFirst()
	                .orElse(null);
	    }

	    public void remover(String cpf) {
	        clientes.removeIf(c -> c.getCpf().equals(cpf));
	    }

	    public List<Cliente> listar() {
	        return clientes;
	    }
}
