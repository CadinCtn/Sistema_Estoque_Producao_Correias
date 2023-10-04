/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedidos;

import com.toedter.calendar.JDateChooser;
import estoque.Estoque;
import factory.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
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
public class PedidoDAO {
    
    private Connection connection;
    
    
    public PedidoDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    
    
    //Método que cria JOptionPane para adicionar um estoque
    public Pedido paneJOP(String id, String nomeCliente, Date fechamento, Date embarque, String obs){
        Pedido pedido = new Pedido();
        
        
        //Criando painel do JOptionPane
        JPanel paneJOP = new JPanel();

        //Campos para digitalizar o texto
        JTextField idField = new JTextField(7);
        JTextField nomeField = new JTextField(10);
        JDateChooser fechamentoDate = new JDateChooser();
        JDateChooser embarqueDate = new JDateChooser();
        JTextField obsField = new JTextField(20);
        
        
        //Adicionando elementos ao painel
        paneJOP.add(new JLabel("ID: "));
        paneJOP.add(idField);
        paneJOP.add(new JLabel("Nome Cliente: "));
        paneJOP.add(nomeField);
        paneJOP.add(new JLabel("Data Fechamento: "));
        paneJOP.add(fechamentoDate);
        paneJOP.add(new JLabel("Data Embarque: "));
        paneJOP.add(embarqueDate);
        paneJOP.add(new JLabel("OBS: "));
        paneJOP.add(obsField);
        
        
         //Setando valores iniciais do Field
        idField.setText(String.valueOf(id));
        nomeField.setText(nomeCliente);
        fechamentoDate.setDate(fechamento);
        embarqueDate.setDate(embarque);
        obsField.setText(obs);
        
       
        //switch para verificar se os campos estão vazios
        switch (JOptionPane.showConfirmDialog(null, paneJOP, "Adicionar Pedido", JOptionPane.OK_CANCEL_OPTION)) {
            case JOptionPane.OK_OPTION : 
                
                //if para impedir que seja cadastrado como null
                if (idField.getText().isEmpty() || nomeField.getText().isEmpty() || fechamentoDate.getDate() == null || embarqueDate.getDate() == null || obsField.getText().isEmpty()) {
                    //JOptionPane de alerta
                    JOptionPane.showMessageDialog(paneJOP, "Preencha todos os campos de cadastro!", "ERRO!", JOptionPane.WARNING_MESSAGE);
                } else {      

                    //Criando objeto ana classe modelo
                    pedido.setId(Integer.valueOf(idField.getText()));
                    pedido.setNomeCliente(nomeField.getText());
                    pedido.setFechamento((Date) fechamentoDate.getDate());
                    pedido.setEmbarque((Date) embarqueDate.getDate());
                    pedido.setObservacao(obsField.getText());
                    
                    
                    //retornando objeto a ser inserido na tabela
                    return pedido;
                   
                }

                break;
            
        }
        
        return null;
            
    }
    
    
    
    
    //Adicionando pedido
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
    
    
    //Deletando pedido
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
    
    
    //Atualizando Pedido
    public void updatePedido(Pedido pedido, int id){
        
        String sql = "UPDATE pedidos SET id = ?, nome_cliente = ?, data_fechamento = ?, data_embarque = ?, observacao = ? WHERE id = " + id;
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, pedido.getId());
            stmt.setString(2,pedido.getNomeCliente());
            stmt.setDate(3,pedido.getFechamento());
            stmt.setDate(4,pedido.getEmbarque());
            stmt.setString(5, pedido.getObservacao());
            
            stmt.execute();
            stmt.close();
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        
    }
    
    
    
    
    //Select Pedidos
    public List<Pedido> selectEstoque(){
        String sql = "SELECT * FROM pedidos";
        
        List<Pedido> pedidoList = new ArrayList();
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Pedido pedido = new Pedido();
                pedido.setId(rs.getInt("id"));
                pedido.setNomeCliente(rs.getString("nome_cliente"));
                pedido.setFechamento(rs.getDate("data_fechamento"));
                pedido.setEmbarque(rs.getDate("data_embarque"));
                pedido.setObservacao(rs.getString("observacao"));
                
                pedidoList.add(pedido);
            }
            
            stmt.close();
            rs.close();
                    
            
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        
        
        return pedidoList;
    }
    
    
    
}
