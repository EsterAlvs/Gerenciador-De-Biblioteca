/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Classes.Livros;
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
public class LivrosDAO {
    
public void insert(Livros livro) {
        String sql = "INSERT INTO livros(titulo, id_autor, id_categoria, ano) VALUES(?, ?, ?, ?)";

        try (Connection conn = Conexao.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, livro.getTitulo());
            pstmt.setInt(2, livro.getIdAutor());
            pstmt.setInt(3, livro.getIdCategoria());
            pstmt.setInt(4, livro.getAno());
            pstmt.executeUpdate();
            System.out.println("Livro inserido com sucesso.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Livros getById(int id) {
        String sql = "SELECT * FROM livros WHERE id_livro = ?";
        Livros livro = null;

        try (Connection conn = Conexao.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                livro = new Livros(
                        rs.getInt("id_livro"),
                        rs.getString("titulo"),
                        rs.getInt("id_autor"),
                        rs.getInt("id_categoria"),
                        rs.getInt("ano")
                );
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return livro;
    }

    public List<Livros> getAll() {
        String sql = "SELECT * FROM livros";
        List<Livros> livros = new ArrayList<>();

        try (Connection conn = Conexao.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Livros livro = new Livros(
                        rs.getInt("id_livro"),
                        rs.getString("titulo"),
                        rs.getInt("id_autor"),
                        rs.getInt("id_categoria"),
                        rs.getInt("ano")
                );
                livros.add(livro);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return livros;
    }

    public void update(Livros livro) {
        String sql = "UPDATE livros SET titulo = ?, id_autor = ?, id_categoria = ?, ano = ? WHERE id_livro = ?";

        try (Connection conn = Conexao.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, livro.getTitulo());
            pstmt.setInt(2, livro.getIdAutor());
            pstmt.setInt(3, livro.getIdCategoria());
            pstmt.setInt(4, livro.getAno());
            pstmt.setInt(5, livro.getId());
            pstmt.executeUpdate();
            System.out.println("Livro atualizado com sucesso.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM livros WHERE id_livro = ?";

        try (Connection conn = Conexao.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Livro deletado com sucesso.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
      public List<Livros> getAllLivros() {
        List<Livros> livros = new ArrayList<>();
        String sql = "SELECT * FROM livros";

        try (Connection conn = Conexao.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Livros livro = new Livros();
                livro.setIdLivro(rs.getInt("id_livro"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setIdAutor(rs.getInt("id_autor"));
                livro.setIdCategoria(rs.getInt("id_categoria"));
                livro.setAno(rs.getInt("ano"));
                livros.add(livro);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return livros;
    }
}

