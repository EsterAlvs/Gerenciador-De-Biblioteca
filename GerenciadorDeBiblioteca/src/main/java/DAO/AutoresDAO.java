/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Classes.Autores;
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
public class AutoresDAO {
    
  public void insert(Autores autor) {
        String sql = "INSERT INTO autores(nome, biografia) VALUES(?, ?)";

        try (Connection conn = Conexao.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, autor.getNome());
            pstmt.setString(2, autor.getBiografia());
            pstmt.executeUpdate();
            System.out.println("Autor inserido com sucesso.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Autores getById(int id) {
        String sql = "SELECT * FROM autores WHERE id_autor = ?";
        Autores autor = null;

        try (Connection conn = Conexao.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                autor = new Autores(
                        rs.getInt("id_autor"),
                        rs.getString("nome"),
                        rs.getString("biografia")
                );
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return autor;
    }

    public List<Autores> getAll() {
        String sql = "SELECT * FROM autores";
        List<Autores> autores = new ArrayList<>();

        try (Connection conn = Conexao.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Autores autor = new Autores(
                        rs.getInt("id_autor"),
                        rs.getString("nome"),
                        rs.getString("biografia")
                );
                autores.add(autor);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return autores;
    }

    public void update(Autores autor) {
        String sql = "UPDATE autores SET nome = ?, biografia = ? WHERE id_autor = ?";

        try (Connection conn = Conexao.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, autor.getNome());
            pstmt.setString(2, autor.getBiografia());
            pstmt.setInt(3, autor.getId());
            pstmt.executeUpdate();
            System.out.println("Autor atualizado com sucesso.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM autores WHERE id_autor = ?";

        try (Connection conn = Conexao.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Autor deletado com sucesso.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
