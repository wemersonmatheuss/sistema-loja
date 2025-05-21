package loja.interfaces;

import loja.entidades.Produto;
import java.sql.SQLException;
import java.util.List;

public interface ProdutoRepository {

    void inserir(Produto produto) throws SQLException;

    Produto buscarPorId(int id) throws SQLException;

    List<Produto> listarTodos() throws SQLException;

    void atualizar(Produto produto) throws SQLException;

    void deletar(int id) throws SQLException;
}
