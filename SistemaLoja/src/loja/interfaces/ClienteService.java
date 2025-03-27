package loja.interfaces;

import loja.entidades.Cliente;
import java.util.List;

public interface ClienteService {
	
	    void cadastrar(Cliente cliente);
	    Cliente buscarPorCpf(String cpf);
	    void atualizar(Cliente cliente);
	    void remover(String cpf);
	
}
