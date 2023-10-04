/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Pedido;
import java.sql.Connection;

/**
 *
 * @author senai
 */
public class PedidoDAO {
    
    private Connection connection;
    
    
    public PedidoDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    //Metodo para adicionar pedidos
    public void insertPedido(Pedido pedido){
    
        String sql = "INSERT INTO pedidos(id,nome_cliente,data_fechamento,data_embarque,observacao)VALUES(?, ?, ?, ?, ?)";


        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, pedido.getId());
            stmt.setString(2, pedido.getNomeCliente());
            stmt.setDate(3,pedido.getFechamento());
            stmt.setDate(4,pedido.getEmbarque());
            stmt.setString(5, pedido.getObservacao());
            stmt.execute();
            stmt.close();
        }
        catch (SQLException u) {
            throw new RuntimeException(u);
        }

    }
    
    //Mtedo para deletar pedidos
    public void deletePedido(int id){
        
        String sql = "DELETE FROM pedidos WHERE id = " + id;
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
            stmt.close();
            
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    //Metodo para atualizar pedido
    public void updatePedido(Pedido pedido, int id){
        
        String sql = "UPDATE pedidos SET id = ?, nome_cliente = ?,  data_fechamento = ?, data_embarque = ?, observacao = ? WHERE id = " + id;
    
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, pedido.getId());
            stmt.setString(2,pedido.getNomeCliente());
            stmt.setDate(3, pedido.getFechamento());
            stmt.setDate(4,pedido.getEmbarque());
            stmt.setString(5,pedido.getObservacao());
            
            stmt.execute();
            stmt.close();
            
            
        }
        catch(SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
    
}
