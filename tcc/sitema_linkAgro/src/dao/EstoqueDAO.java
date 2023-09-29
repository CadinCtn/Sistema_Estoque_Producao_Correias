/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Estoque;

/**
 *
 * @author Lenovo
 */
public class EstoqueDAO {
    
    private Connection connection;
    
    public EstoqueDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    //Insert
    public void insertEstoque(Estoque estoque){
        String sql = "INSERT INTO estoque (categoria,lonas,largura,metragem) VALUES (?,?,?,?);";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,estoque.getCategoria());
            stmt.setInt(2,estoque.getLonas());
            stmt.setFloat(3,estoque.getLargura());
            stmt.setFloat(4,estoque.getMetragem());
            
            stmt.execute();
            stmt.close();
            
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        
        
    }
    
    //Delete
    public void deleteEstoque(int id){
        String sql = "DELETE FROM estoque WHERE id = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            
            stmt.execute();
            stmt.close();
            
        }
        catch(SQLException e){
            throw new  RuntimeException(e);
        }
        
    }
    
    
    
    
    
}
