package loja.interfaces;

import loja.entidades.Produto;
import java.sql.SQLException;
import java.util.List;

public interface ProdutoService {
	void adicionarProduto(Produto produto) throws SQLException;
	Produto buscarPorId(int id) throws SQLException;
	List<Produto> listarProdutos() throws SQLException;
	void atualizarProduto(Produto produto) throws SQLException;
	void deletarProduto(int id) throws SQLException;
}
