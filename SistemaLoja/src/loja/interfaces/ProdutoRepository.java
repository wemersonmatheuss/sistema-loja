package loja.interfaces;
import loja.entidades.Produto;

public interface ProdutoRepository {
	void adicionarProduto(Produto produto);
    Produto buscarProduto(int id);
}
