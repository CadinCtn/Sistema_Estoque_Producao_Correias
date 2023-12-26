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

/**
 *
 * @author aluno
 */
public class PedidoOpDAO {
    private Connection connection;
    
    public PedidoOpDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    // Último valor inserido na tabela
    public int lastId(String column,String table){
        String sql = "SELECT MAX(" + column + ") FROM " +  table;
        int lastId;
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            lastId = rs.getInt("max("+ column +")");
            
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        
        return lastId;
    }
    
     //Insert
    public void insertPedidoOp(PedidoOp pedidoop, boolean edit){
        String sql = "INSERT INTO pedidos_op (id_op,id,nome_cliente,largura,metragem) VALUES (?,?,?,?,?);";
        
        int id_op;
        if(edit){
            CUOrdemProducaoGUI cuopgui = ControllerOP.getCUOrdemProducao();
            id_op = cuopgui.id;
        } else {
            id_op = lastId("id","ordem_producao");
        }
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,id_op);
            stmt.setInt(2,pedidoop.getId());
            stmt.setString(3,pedidoop.getNome_cliente());
            stmt.setFloat(4,pedidoop.getLargura());
            stmt.setFloat(5,pedidoop.getMetragem());
            
            stmt.execute();
            stmt.close();
            
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        
        
    }
    
    //Delete
    public void deletePedidoOp(int cod){
        String sql = "DELETE FROM pedidos_op WHERE vinc = ?;";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, cod);
            
            stmt.execute();
            stmt.close();
            
        }
        catch(SQLException e){
            throw new  RuntimeException(e);
        }
        
    }
    
    public void deleteAllPedidosOfOp(int id_op){
        String sql = "DELETE FROM pedidos_op WHERE id_op = " + id_op;
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            
            stmt.execute();
            stmt.close();
            
        }
        catch(SQLException e){
            throw new  RuntimeException(e);
        }
        
    }
    
    
    //Select
    public List<PedidoOp> selectPedidoOp(int id_op){
        String sql = "SELECT * FROM pedidos_op WHERE id_op = " + id_op;
        
        List<PedidoOp> pedidoopList = new ArrayList();
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                PedidoOp pedidoop = new PedidoOp();
                pedidoop.setId_op(id_op);
                pedidoop.setId(rs.getInt("id"));
                pedidoop.setNome_cliente(rs.getString("nome_cliente"));
                pedidoop.setLargura(rs.getFloat("largura"));
                pedidoop.setMetragem(rs.getFloat("metragem"));
                pedidoop.setCod(rs.getInt("vinc"));
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
    
    public void updatePedidoOp(PedidoOp pedidoop, int cod){
        
        String sql = "UPDATE pedidos_op SET id = ?, nome_cliente = ?, largura = ?, metragem = ? WHERE vinc = " + cod;
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, pedidoop.getId());
            stmt.setString(2, pedidoop.getNome_cliente());
            stmt.setFloat(3,pedidoop.getLargura());
            stmt.setFloat(4, pedidoop.getMetragem());
            stmt.execute();
            stmt.close();
            
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
   
}
