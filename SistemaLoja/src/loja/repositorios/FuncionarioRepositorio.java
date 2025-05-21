package loja.repositorios;

import loja.conexao.Conexao;
import loja.entidades.Funcionario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepositorio {

    public void inserir(Funcionario funcionario) throws SQLException {
        String sql = "INSERT INTO funcionario (cpf, nome, salario) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, funcionario.getCpf());
            ps.setString(2, funcionario.getNome());
            ps.setBigDecimal(3, funcionario.getSalario());
            ps.executeUpdate();
        }
    }

    public Funcionario buscarPorCpf(String cpf) throws SQLException {
        String sql = "SELECT * FROM funcionario WHERE cpf = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cpf);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Funcionario(
                            rs.getString("nome"),
                            rs.getString("cpf"),
                            rs.getBigDecimal("salario")
                    );
                }
            }
        }
        return null;
    }

    public List<Funcionario> listarTodos() throws SQLException {
        String sql = "SELECT * FROM funcionario";
        List<Funcionario> funcionarios = new ArrayList<>();
        try (Connection conn = Conexao.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                funcionarios.add(new Funcionario(
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getBigDecimal("salario")
                ));
            }
        }
        return funcionarios;
    }

    public void atualizar(Funcionario funcionario) throws SQLException {
        String sql = "UPDATE funcionario SET nome = ?, salario = ? WHERE cpf = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, funcionario.getNome());
            ps.setBigDecimal(2, funcionario.getSalario());
            ps.setString(3, funcionario.getCpf());
            ps.executeUpdate();
        }
    }

    public void deletar(String cpf) throws SQLException {
        String sql = "DELETE FROM funcionario WHERE cpf = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cpf);
            ps.executeUpdate();
        }
    }
}
