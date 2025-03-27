package loja.servicos;

import loja.entidades.Produto;
import loja.interfaces.ProdutoService;
import loja.repositorios.ProdutoRepositorio;

public class ProdutoServico implements ProdutoService {
    private ProdutoRepositorio repositorio = new ProdutoRepositorio();

    @Override
    public void cadastrar(Produto produto) {
        repositorio.salvar(produto);
    }

    @Override
    public Produto buscarPorId(int id) {
        return repositorio.buscarPorId(id);
    }

    @Override
    public void atualizar(Produto produto) {
        Produto existente = repositorio.buscarPorId(produto.getId());
        if (existente != null) {
            existente.setNome(produto.getNome());
            existente.setPreco(produto.getPreco());
        }
    }

    @Override
    public void remover(int id) {
        repositorio.remover(id);
    }
}