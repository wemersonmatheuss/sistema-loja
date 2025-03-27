package loja.interfaces;

import loja.entidades.Produto;
import java.util.List;

public interface ProdutoService {
	  void cadastrar(Produto produto);
	    Produto buscarPorId(int id);
	    void atualizar(Produto produto);
	    void remover(int id);

}
