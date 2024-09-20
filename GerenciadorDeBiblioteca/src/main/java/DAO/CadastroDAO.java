/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Classes.Cadastro;
import Conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ester
 */
public class CadastroDAO {
    
 public void insert(Cadastro cadastro) {
        String sql = "INSERT INTO cadastro(nome, email, senha) VALUES(?, ?, ?)";

        try (Connection conn = Conexao.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cadastro.getNome());
            pstmt.setString(2, cadastro.getEmail());
            pstmt.setString(3, cadastro.getSenha());
            pstmt.executeUpdate();
            System.out.println("Cadastro inserido com sucesso.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Cadastro getById(int id) {
        String sql = "SELECT * FROM cadastro WHERE id_cadastro = ?";
        Cadastro cadastro = null;

        try (Connection conn = Conexao.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                cadastro = new Cadastro(
                        rs.getInt("id_cadastro"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha")
                );
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return cadastro;
    }

    public List<Cadastro> getAll() {
        String sql = "SELECT * FROM cadastro";
        List<Cadastro> cadastros = new ArrayList<>();

        try (Connection conn = Conexao.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Cadastro cadastro = new Cadastro(
                        rs.getInt("id_cadastro"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("senha")
                );
                cadastros.add(cadastro);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return cadastros;
    }

    public void update(Cadastro cadastro) {
        String sql = "UPDATE cadastro SET nome = ?, email = ?, senha = ? WHERE id_cadastro = ?";

        try (Connection conn = Conexao.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cadastro.getNome());
            pstmt.setString(2, cadastro.getEmail());
            pstmt.setString(3, cadastro.getSenha());
            pstmt.setInt(4, cadastro.getId());
            pstmt.executeUpdate();
            System.out.println("Cadastro atualizado com sucesso.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM cadastro WHERE id_cadastro = ?";

        try (Connection conn = Conexao.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Cadastro deletado com sucesso.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
     public void inserirCadastro(Cadastro cadastro) {
        String sql = "INSERT INTO cadastro(nome, email, senha) VALUES(?, ?, ?)";

        try (Connection conn = Conexao.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

           
            pstmt.setString(1, cadastro.getNome());
            pstmt.setString(2, cadastro.getEmail());
            pstmt.setString(3, cadastro.getSenha());

   
            pstmt.executeUpdate();
            System.out.println("Cadastro inserido com sucesso!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
