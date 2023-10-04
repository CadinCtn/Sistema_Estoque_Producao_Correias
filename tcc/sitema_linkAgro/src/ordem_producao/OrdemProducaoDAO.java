/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordem_producao;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import produtos.Produto;
import produtos.ProdutoDAO;



/**
 *
 * @author senai
 */
public class OrdemProducaoDAO {
    
    
    private Connection connection;
    
    public OrdemProducaoDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    
     //Insert
    public void insertOrdemProducao(OrdemProducao op){
        String sql = "INSERT INTO ordem_producao (categoria,EE,largura_tecido,metragem_tecido,lonas,setor,observacao) VALUES (?,?,?,?,?,?,?);";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,op.getCategoria());
            stmt.setInt(2,op.getEe());
            stmt.setFloat(3,op.getLarguraTecido());
            stmt.setFloat(4,op.getMetragemTecido());
            stmt.setFloat(5,op.getLonas());
            stmt.setString(6,op.getSetor());
            stmt.setString(7,op.getObservacao());
            
            stmt.execute();
            stmt.close();
            
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        
        
    }
    
    //Delete
    public void deleteOrdemProducao(int id){
        String sql = "DELETE FROM ordem_producao WHERE id = ?";
        
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
    
    
    //Select
    public List<PedidoOp> selectOrdemProcucao(){
        String sql = "SELECT * FROM ordem_producao";
        
        List<PedidoOp> pedidoopList = new ArrayList();
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                PedidoOp pedidoop = new PedidoOp();
                pedidoop.setId(rs.getInt("id"));
                pedidoop.setNome_cliente(rs.getString("categoria"));
                pedidoop.setLargura(rs.getFloat("largura"));
                pedidoop.setMetragem(rs.getFloat("metragem"));
                
                pedidoopList.add(pedidoop);
            }
            
            stmt.close();
            rs.close();
                    
            
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        
        
        return pedidoopList;
    }
    
    
    
    public void updadePedidoOp(PedidoOp pedidoop, int id){
        String sql = "UPDATE pedidos_op SET id = ?, nome_cliente = ?, largura = ?, metragem = ? WHERE id = " + id;
        
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,pedidoop.getId());
            stmt.setString(1,pedidoop.getNome_cliente());
            stmt.setFloat(3,pedidoop.getLargura());
            stmt.setFloat(4,pedidoop.getMetragem());
            stmt.execute();
            stmt.close();
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        
    }
}
