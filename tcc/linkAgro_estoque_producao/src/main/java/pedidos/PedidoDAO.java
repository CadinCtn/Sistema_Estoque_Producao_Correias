/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedidos;

import com.toedter.calendar.JDateChooser;
import factory.ConnectionFactory;
import java.awt.Dimension;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


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
    public Pedido paneJOP(String id, String nomeCliente, String fechamento, String embarque, String obs) {
        Pedido pedido = new Pedido();
        
        
        //Criando painel do JOptionPane
        JPanel paneJOP = new JPanel();

        //Campos para digitalizar o texto
        JTextField idField = new JTextField(5);
        JTextField nomeField = new JTextField(17);
        JDateChooser fechamentoDate = new JDateChooser();
        JDateChooser embarqueDate = new JDateChooser();
        fechamentoDate.setPreferredSize(new Dimension(150, 19));
        embarqueDate.setPreferredSize(new Dimension(150, 19));
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
        idField.setText(id);
        nomeField.setText(nomeCliente);
        
        
        //Formato da data
        SimpleDateFormat dateForm = new SimpleDateFormat("dd/MM/yyyy");
        
        try { //para setar nos campos de data a data anterior que for editada
            Date fech = dateForm.parse(fechamento);
            fechamentoDate.setDate(fech);
            
            Date emba = dateForm.parse(embarque);
            embarqueDate.setDate(emba);
            
        
        } catch (Exception ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.FINE, null, ex);
        }
        
        obsField.setText(obs);
        
       
        //switch para verificar se os campos estão vazios
        switch (JOptionPane.showConfirmDialog(null, paneJOP, "Adicionar Pedido", JOptionPane.OK_CANCEL_OPTION)) {
            case JOptionPane.OK_OPTION : 
                
                //if para impedir que seja cadastrado como null
                if (idField.getText().isEmpty() || nomeField.getText().isEmpty()) {
                    //JOptionPane de alerta
                    JOptionPane.showMessageDialog(paneJOP, "Preencha todos os campos de cadastro!", "ERRO!", JOptionPane.WARNING_MESSAGE);
                } else {    
                    
                    String fech = null;
                    String emba = null;
                    
                        try{
                            //Fechamento
                            java.util.Date fechUtil = fechamentoDate.getDate(); //Pegando o valor registrado no JDateChooser e colocando em uma variável String
                            fech = dateForm.format(fechUtil);                                

                            //Embarque
                            java.util.Date embaUtil = embarqueDate.getDate();
                            emba = dateForm.format(embaUtil);
                    
                        } catch(NullPointerException e){
                            JOptionPane.showMessageDialog(null, "Formato de data inserido não é válido","Formato de data Inválido",JOptionPane.WARNING_MESSAGE);
                            return null;
                        }
                        
                    //Criando objeto ana classe modelo
                    pedido.setId(Integer.valueOf(idField.getText()));
                    pedido.setNomeCliente(nomeField.getText());
                    pedido.setFechamento( fech);
                    pedido.setEmbarque( emba);
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
    
        String sql = "INSERT INTO pedidos(id,nome_cliente,data_fechamento,data_embarque,observacao,status)VALUES(?, ?, ?, ?, ?, 'produção')";


        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, pedido.getId());
            stmt.setString(2, pedido.getNomeCliente());
            stmt.setString(3,pedido.getFechamento());
            stmt.setString(4,pedido.getEmbarque());
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
            JOptionPane.showMessageDialog(null,"Não foi possivel deletar o pedido, existe uma ordem de produção para esse pedido!");
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
            stmt.setString(3,pedido.getFechamento());
            stmt.setString(4,pedido.getEmbarque());
            stmt.setString(5, pedido.getObservacao());
            
            stmt.execute();
            updateAllPedidoOp(pedido, id);
            
            stmt.close();
        }
        catch(SQLException e){
            insertPedido(pedido);
            updateAllPedidoOp(pedido, id);
            deletePedido(id);
            e.printStackTrace();
        }
        
    }
    
    //Método para atualizar pedidos na tabela pedidos_op
    public void updateAllPedidoOp(Pedido pedido, int id){
        String sql = "UPDATE pedidos_op SET id = ?, nome_cliente = ? WHERE id = " + id;
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, pedido.getId());
            stmt.setString(2,pedido.getNomeCliente());
            stmt.execute();
            stmt.close();
            
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    
    
    //Select Pedidos
    public List<Pedido> selectPedidos(){
        String sql = "SELECT * FROM pedidos WHERE status = 'produção'";
        
        List<Pedido> pedidoList = new ArrayList();
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Pedido pedido = new Pedido();
                pedido.setId(rs.getInt("id"));
                pedido.setNomeCliente(rs.getString("nome_cliente"));
                pedido.setFechamento(rs.getString("data_fechamento"));
                pedido.setEmbarque(rs.getString("data_embarque"));
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
    
    
    public List<Pedido> selectPedidosArquivados(){
        String sql = "SELECT * FROM pedidos WHERE status = 'arquivado'";
        
        List<Pedido> pedidoList = new ArrayList();
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Pedido pedido = new Pedido();
                pedido.setId(rs.getInt("id"));
                pedido.setNomeCliente(rs.getString("nome_cliente"));
                pedido.setFechamento(rs.getString("data_fechamento"));
                pedido.setEmbarque(rs.getString("data_embarque"));
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
