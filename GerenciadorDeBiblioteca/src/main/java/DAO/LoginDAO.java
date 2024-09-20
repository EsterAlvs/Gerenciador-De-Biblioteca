/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ester
 */
public class LoginDAO {
     // Método para autenticar o usuário no banco de dados
    public boolean authenticate(String usernameOrEmail, String senha) {
        String sql = "SELECT * FROM cadastro WHERE (nome = ? OR email = ?) AND senha = ?";
        boolean isAuthenticated = false;

        try (Connection conn = Conexao.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, usernameOrEmail);
            pstmt.setString(2, usernameOrEmail);
            pstmt.setString(3, senha);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
               
                isAuthenticated = true;

      
                String loginSql = "SELECT * FROM login WHERE id_cadastro = ?";
                PreparedStatement loginStmt = conn.prepareStatement(loginSql);
                loginStmt.setInt(1, rs.getInt("id_cadastro"));
                ResultSet loginRs = loginStmt.executeQuery();

                if (!loginRs.next()) {
                    // O usuário não tem um login registrado
                    isAuthenticated = false;
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return isAuthenticated;
    }

    
    public void registrarLogin(int idCadastro) {
        String sql = "INSERT INTO login (id_cadastro) VALUES (?)";

        try (Connection conn = Conexao.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idCadastro);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
    public boolean isLoginRegistered(int idCadastro) {
        String sql = "SELECT * FROM login WHERE id_cadastro = ?";
        boolean isRegistered = false;

        try (Connection conn = Conexao.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idCadastro);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                isRegistered = true;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return isRegistered;
    }
    
}
