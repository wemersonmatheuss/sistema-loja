package loja.servicos;

import loja.entidades.Produto;
import loja.interfaces.ProdutoRepository;
import loja.interfaces.ProdutoService;

public class ProdutoServiceImpl implements ProdutoService {
    private ProdutoRepository repository;

    public ProdutoServiceImpl(ProdutoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void cadastrarProduto(int id, String nome, double preco) {
        Produto produto = new Produto(id, nome, preco);
        repository.adicionarProduto(produto);
    }

    @Override
    public Produto obterProduto(int id) {
        return repository.buscarProduto(id);
    }
}
