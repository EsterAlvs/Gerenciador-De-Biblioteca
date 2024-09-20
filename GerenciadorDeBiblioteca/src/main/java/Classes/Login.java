/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import Conexao.Conexao;
import DAO.LoginDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ester
 */
public class Login {
    
 private int idLogin;
    private int idCadastro;
    private LoginDAO loginDAO;

    // Construtor
    public Login() {
        this.loginDAO = new LoginDAO(); // Inicializa o DAO
    }

    // Método de autenticação que usa o LoginDAO
    public boolean authenticate(String usernameOrEmail, String senha) {
        return loginDAO.authenticate(usernameOrEmail, senha);
    }

    // Método para registrar login usando o LoginDAO
    public void registrarLogin(int idCadastro) {
        loginDAO.registrarLogin(idCadastro);
    }

    // Método para verificar se o login já está registrado
    public boolean isLoginRegistered(int idCadastro) {
        return loginDAO.isLoginRegistered(idCadastro);
    }

    // Getters e Setters para idLogin e idCadastro
    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    public int getIdCadastro() {
        return idCadastro;
    }

    public void setIdCadastro(int idCadastro) {
        this.idCadastro = idCadastro;
    }
}


