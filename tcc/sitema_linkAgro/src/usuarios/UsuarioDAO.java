/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuarios;

import factory.ConnectionFactory;
import usuarios.CadastroUsuarioGUI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import usuarios.Usuario;


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
    public void criarUsuario(Usuario usuario, boolean permissao){     
        String sql;
        
        if(permissao){
            sql = "INSERT INTO usuarios (login,senha,permissao) VALUES (?,?,'ADM')";
            
        } else {
            sql = "INSERT INTO usuarios (login,senha) VALUES (?,?)";
        }
        
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
    
    //Metodo para deletar usuário
    public void deleteUsuario(int id){
        
        String sql = "DELETE from usuarios  WHERE id = ?";        
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setLong(1,id);
            
            stmt.execute();
            stmt.close();
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Não foi possivel Deletar o usuário" + e.getMessage(),"ERRO",JOptionPane.WARNING_MESSAGE);
        }
        
        
    }
    
    //Método para gerar a tabela para visualizar usuários cadastrados
    public List<Usuario> selectUsuario() throws SQLException{
        String sql = "Select * FROM usuarios;";
        
         List<Usuario> usuarioList = new ArrayList<>();
        
        
        try(PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();){
            
            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setPermissao(rs.getString("permissao"));
                usuarioList.add(usuario);
                
            }
            
            stmt.close();
            rs.close();
        }
        
        catch (SQLException u) {
        throw new RuntimeException(u);
        }
        
        return usuarioList;
        
    }
    
}
