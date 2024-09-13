package DAO;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author marcus
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    private Connection getConnection() throws SQLException {
        // Configuração da conexão com o banco de dados
        return DriverManager.getConnection("jdbc:mysql://localhost/seu_banco", "usuario", "senha");
    }

    public boolean cadastrarUsuario(String login, String senha, String usuario) {
        String sql = "INSERT INTO usuarios (login, senha, email) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, login);
            stmt.setString(2, senha); // Armazena a senha em texto claro (não recomendado para produção)
            stmt.setString(3, usuario);

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Método para verificar o login do usuário
    public boolean verificarLogin(String login, String senha) {
        String sql = "SELECT senha FROM usuarios WHERE login = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, login);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String senhaArmazenada = rs.getString("senha");
                return senhaArmazenada.equals(senha); // Compara a senha fornecida com a armazenada
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}