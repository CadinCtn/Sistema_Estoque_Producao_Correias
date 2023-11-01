/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package produtos;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class ProdutoDAO {
    
    private Connection connection;
    
    public ProdutoDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    
    public void adicionaProduto(String produto){
        String sql = "INSERT INTO produtos (produto) VALUES (?);";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,produto);
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null,"Produto " + produto + " ADICIONADO com sucesso.");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Não é possivel adicionar um produto igual a um que ja existe!\n"+e.getMessage());
        }
        
    }
    
    public void deleteProdutos(String produto){
        String sql = "DELETE FROM produtos WHERE produto = ?;";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,produto);
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null,"Produto " + produto + " DELETADO com sucesso.");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Não foi possivel deletar o produto, existem itens cadastrados com esse produdo!\n" + e.getMessage());
        }
        
    }
    
    
    //Update
    public void updadeProduto(String produto, String newProduto){
        String sqlIns = "INSERT INTO produtos (produto) VALUES (?)";
        String sqlDel = "DELETE FROM produtos WHERE produto = ?;";
        try{
            PreparedStatement stmt = connection.prepareStatement(sqlIns);
            stmt.setString(1,newProduto);
            stmt.execute();
            stmt.close();
            
            updateItens(produto, newProduto);
            
            stmt = connection.prepareStatement(sqlDel);
            stmt.setString(1,produto);
            stmt.execute();
            stmt.close();
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        
    }
    
    //Alterando todos os itens cadastrados nas tabelas com o antigo produto para o novo produto
    public void updateItens(String produto, String newProduto){
         String sqlEst = "UPDATE estoque SET categoria = '" + newProduto + "' WHERE categoria = '" + produto + "';";
         String sqlOp = "UPDATE ordem_producao SET categoria = '" + newProduto + "' WHERE categoria = '" + produto + "';";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sqlEst);
            stmt.execute();
            stmt.close();
            
            stmt = connection.prepareStatement(sqlOp);
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
