/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Classes.Categorias;
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
public class CategoriasDAO {
    
 public void insert(Categorias categoria) {
        String sql = "INSERT INTO categoria(nome, descricao) VALUES(?, ?)";

        try (Connection conn = Conexao.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, categoria.getNome());
            pstmt.setString(2, categoria.getDescricao());
            pstmt.executeUpdate();
            System.out.println("Categoria inserida com sucesso.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Categorias getById(int id) {
        String sql = "SELECT * FROM categoria WHERE id_categoria = ?";
        Categorias categoria = null;

        try (Connection conn = Conexao.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                categoria = new Categorias(
                        rs.getInt("id_categoria"),
                        rs.getString("nome"),
                        rs.getString("descricao")
                );
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return categoria;
    }

    public List<Categorias> getAll() {
        String sql = "SELECT * FROM categoria";
        List<Categorias> categorias = new ArrayList<>();

        try (Connection conn = Conexao.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Categorias categoria = new Categorias(
                        rs.getInt("id_categoria"),
                        rs.getString("nome"),
                        rs.getString("descricao")
                );
                categorias.add(categoria);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return categorias;
    }

    public void update(Categorias categoria) {
        String sql = "UPDATE categoria SET nome = ?, descricao = ? WHERE id_categoria = ?";

        try (Connection conn = Conexao.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, categoria.getNome());
            pstmt.setString(2, categoria.getDescricao());
            pstmt.setInt(3, categoria.getId());
            pstmt.executeUpdate();
            System.out.println("Categoria atualizada com sucesso.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM categoria WHERE id_categoria = ?";

        try (Connection conn = Conexao.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Categoria deletada com sucesso.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public List<Categorias> getAllCategorias() {
        List<Categorias> categorias = new ArrayList<>();
        String sql = "SELECT * FROM categorias";

        try (Connection conn = Conexao.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Categorias categoria = new Categorias();
                categoria.setIdCategoria(rs.getInt("id_categoria"));
                categoria.setNome(rs.getString("nome"));
                categoria.setDescricao(rs.getString("descricao"));
                categorias.add(categoria);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return categorias;
    }
}
