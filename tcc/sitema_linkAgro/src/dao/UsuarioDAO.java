/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.ConnectionFactory;
import gui.MenuGUI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author Senai
 */
public class UsuarioDAO {
    
    private Connection connection;
    
    String login;
    int senha;
    
    public UsuarioDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void validarLogin(String login,int senha) throws SQLException{
        
        String sql = "SELECT login,senha FROM usuarios WHERE login = ? and senha = ?;";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,login);
            stmt.setInt(2,senha);
            ResultSet resultado = stmt.executeQuery();
            
            if(resultado.next()){
                JFrame window = new MenuGUI();
                window.setVisible(true);
                window.setExtendedState(JFrame.MAXIMIZED_BOTH);
            }else{
                JOptionPane.showMessageDialog(null, "Acesso negado: login ou senha incorretos. ","Incorreto",JOptionPane.WARNING_MESSAGE);
            }
            
            stmt.execute();
            stmt.close();
        }
        catch (SQLException u) {
            throw new RuntimeException(u);
        }
        
        
    }
        
}
