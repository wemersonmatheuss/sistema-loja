package loja.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:mysql://localhost:3306/loja_db"; // troque "seubanco" pelo nome do seu banco
    private static final String USER = "root";       // seu usuário do banco
    private static final String PASSWORD = "admin123"; // sua senha do banco

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

