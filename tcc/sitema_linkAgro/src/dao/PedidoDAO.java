/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import gui.PedidoGUI;
import modelo.Pedido;
import java.sql.Connection;

/**
 *
 * @author senai
 */
public class PedidoDAO {
    
    private Connection connection;
    PedidoGUI pedidogui = new PedidoGUI();
    int id;
    // data fechamento
    // data embarque
    String nomeCliente;
    String observacao;
    
    
    public PedidoDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adiciona(Pedido pedido){
    
        String sql = "INSERT INTO pedidos(id,nome_cliente,data_fechamento,data_embarque,observacao)VALUES(?,?,"+pedidogui.field_dateclose.getDate()+",?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, 1);
            stmt.setString(2, "teste");
            stmt.execute();
            stmt.close();
        }
        catch (SQLException u) {
            throw new RuntimeException(u);
        }

    }
}
