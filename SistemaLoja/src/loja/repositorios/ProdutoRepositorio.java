package loja.repositorios;

import loja.entidades.Produto;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepositorio {
	private List<Produto> produtos = new ArrayList<>();

    public void salvar(Produto produto) {
        produtos.add(produto);
    }

    public Produto buscarPorId(int id) {
        return produtos.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void remover(int id) {
        produtos.removeIf(p -> p.getId() == id);
    }

    public List<Produto> listar() {
        return produtos;
    }
}
