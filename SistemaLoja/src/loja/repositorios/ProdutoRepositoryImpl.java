package loja.repositorios;

import loja.entidades.Produto;
import loja.interfaces.ProdutoRepository;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepositoryImpl implements ProdutoRepository {
	 private List<Produto> produtos = new ArrayList<>();

	    @Override
	    public void adicionarProduto(Produto produto) {
	        produtos.add(produto);
	    }

	    @Override
	    public Produto buscarProduto(int id) {
	        return produtos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
	    }
}
