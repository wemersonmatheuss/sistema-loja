package loja.servicos;

import loja.entidades.Produto;
import loja.interfaces.ProdutoService;
import loja.interfaces.ProdutoRepository;
import loja.repositorios.ProdutoRepositorioImpl;

import java.sql.SQLException;
import java.util.List;

public class ProdutoServiceImpl implements ProdutoService {

    private ProdutoRepository produtoRepositorio = new ProdutoRepositorioImpl();


    public void adicionarProduto(Produto produto) throws SQLException {
        produtoRepositorio.inserir(produto);
    }


    public Produto buscarPorId(int id) throws SQLException {
        return produtoRepositorio.buscarPorId(id);
    }


    public List<Produto> listarProdutos() throws SQLException {
        return produtoRepositorio.listarTodos();
    }


    public void atualizarProduto(Produto produto) throws SQLException {
        produtoRepositorio.atualizar(produto);
    }


    public void deletarProduto(int id) throws SQLException {
        produtoRepositorio.deletar(id);
    }
}
