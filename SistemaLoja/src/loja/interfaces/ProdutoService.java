package loja.interfaces;

import loja.entidades.Produto;

public interface ProdutoService {
	 void cadastrarProduto(int id, String nome, double preco);
	    Produto obterProduto(int id);

}
