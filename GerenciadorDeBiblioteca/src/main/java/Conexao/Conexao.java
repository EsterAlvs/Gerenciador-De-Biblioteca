/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ester
 */
public class Conexao {
    private static final String url = "jdbc:sqlite:bancoBiblioteca.db";
    public static Connection getConnection(){
    try {
        return DriverManager.getConnection(url);
    } catch (SQLException ex) {
        Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
    }
    
    public void closeConnection(Connection con){
        try{
            con.close();
        } catch (SQLException ex){
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public void closeConnection(Connection con, PreparedStatement stmt){
          closeConnection(con);
        try {
            
           stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        closeConnection(con, stmt);
        try {
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
   }

