/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Usuario;


public class UsuarioDAO {
   
    private Connection connection;
    
    public UsuarioDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    //Método para validar login
    public boolean validarLogin(String login,String senha) throws SQLException{
        
        String sql = "SELECT login,senha FROM usuarios WHERE login = ? and senha = ?;";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,login);
            stmt.setString(2,senha);
            ResultSet resultado = stmt.executeQuery();
            
            //Se encontrar login correspondente banco de dados, retorna true
            if(resultado.next()){
                return true;
                   
            }else{
                JOptionPane.showMessageDialog(null, "Acesso negado: login ou senha incorretos. ","Incorreto",JOptionPane.WARNING_MESSAGE);
            }
            
            stmt.execute();
            stmt.close();
        }
        catch (SQLException u) {
            throw new RuntimeException(u);
        }
        
        return false;
    }
    

    
    
    public boolean permissao(String login, String senha) throws SQLException{
        
        String sql = "SELECT login,senha,permissao FROM usuarios WHERE login = ? and senha = ? and permissao = 'ADM';";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,login);
            stmt.setString(2,senha);
                System.out.println("Login: " + login);
                System.out.println("Senha: " + senha);
            ResultSet resultado = stmt.executeQuery();
            
            //Se encontrar login correspondente banco de dados, retorna true
            if(resultado.next()){
               return true;
            }
            
            stmt.execute();
            stmt.close();
        }
        catch (SQLException u) {
            throw new RuntimeException(u);
        }
        return false;
                
    }
 
    
        //metodo para cadastrar novo usuário
    public void criarUsuario(Usuario usuario){
        
        String sql = "INSERT INTO usuarios (login,senha) VALUES (?,?)";
      
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,usuario.getLogin());
            stmt.setString(2,usuario.getSenha());
            stmt.execute();
            stmt.close();
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        
        
    }
    
}
