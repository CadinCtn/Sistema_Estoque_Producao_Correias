/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Produto;

/**
 *
 * @author Lenovo
 */
public class OrdemProducaoDAO {
    
    private Connection connection;
    
    public OrdemProducaoDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    
    public void adicionaProduto(String produto){
        String sql = "INSERT INTO produtos (produto) VALUES (?);";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,produto);
            JOptionPane.showMessageDialog(null,"Produto " + produto + " adicionado com sucesso.");
            stmt.execute();
            stmt.close();
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        
    }
    
    
    public List<Produto> categoriaBox() throws SQLException{
        String sql = "Select * FROM produtos;";
        
         List<Produto> produtoList = new ArrayList<>();
        
        
        try(PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();){
            
            while(rs.next()){
                Produto produto = new Produto();
                produto.setProduto(rs.getString("Produto"));
                produtoList.add(produto);
                
            }
            
            stmt.close();
            rs.close();
        }
        
        catch (SQLException u) {
        throw new RuntimeException(u);
        }
        
        return produtoList;
        
    }
    
    
}
