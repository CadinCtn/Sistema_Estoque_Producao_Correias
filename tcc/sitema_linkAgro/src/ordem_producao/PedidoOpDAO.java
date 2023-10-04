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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author aluno
 */
public class PedidoOpDAO {
    private Connection connection;
    
    public PedidoOpDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    //Método que cria JOptionPane para adicionar um pedido a op
    public PedidoOp pane(String id, String nome_cliente, String largura, String metragem){
        PedidoOp pedidoop = new PedidoOp();
        
        
        //Criando painel do JOptionPane
        JPanel paneJOP = new JPanel();

        //Campos para digitar o texto
        JTextField idField = new JTextField(3);
        JTextField clienteField = new JTextField(10);
        JTextField larguraField = new JTextField(7);
        JTextField metragemField = new JTextField(7);

        
        //Adicionando elementos ao painel
        paneJOP.add(new JLabel("Id: "));
        paneJOP.add(idField);
        paneJOP.add(new JLabel("Nome Cliente: "));
        paneJOP.add(clienteField);
        paneJOP.add(new JLabel("Largura: "));
        paneJOP.add(larguraField);
        paneJOP.add(new JLabel("Metragem: "));
        paneJOP.add(metragemField);
        
        
         //Setando valores iniciais do Field
        idField.setText(String.valueOf(id));
        clienteField.setText(nome_cliente);
        larguraField.setText(largura);
        metragemField.setText(metragem);
        
        
   
        switch (JOptionPane.showConfirmDialog(null, paneJOP, "Adicionar Pedido", JOptionPane.OK_CANCEL_OPTION)) {
            case JOptionPane.OK_OPTION : 
                
                //if para impedir que seja cadastrado como null
                if (idField.getText().isEmpty() || clienteField.getText().isEmpty() || larguraField.getText().isEmpty() || metragemField.getText().isEmpty()) {
                    //JOptionPane de alerta
                    JOptionPane.showMessageDialog(paneJOP, "Preencha todos os campos!", "ERRO!", JOptionPane.WARNING_MESSAGE);
                } else {      

                    //Criando objeto ana classe modelo
                    pedidoop.setId(Integer.valueOf(idField.getText()));
                    pedidoop.setNome_cliente(clienteField.getText());
                    pedidoop.setLargura(Float.valueOf(larguraField.getText()));
                    pedidoop.setMetragem(Float.valueOf(metragemField.getText()));
                    
                    //retornando objeto a ser inserido na tabela
                    return pedidoop;
                   
                }

                break;
            
        }
        
        return null;
            
    }
    
    
     //Insert
    public void insertPedidoOp(PedidoOp pedidoop){
        String sql = "INSERT INTO pedidoop (id,nome_cliente,largura,metragem) VALUES (?,?,?,?);";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(2,pedidoop.getNome_cliente());
            stmt.setInt(1,pedidoop.getId());
            stmt.setFloat(3,pedidoop.getLargura());
            stmt.setFloat(4,pedidoop.getMetragem());
            
            stmt.execute();
            stmt.close();
            
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        
        
    }
    
    //Delete
    public void deletePedidoOp(int id){
        String sql = "DELETE FROM pedidoop WHERE id = ?";
        
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
    public List<PedidoOp> selectPedidoOp(){
        String sql = "SELECT * FROM pedidos_op";
        
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
            stmt.setString(2,pedidoop.getNome_cliente());
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
