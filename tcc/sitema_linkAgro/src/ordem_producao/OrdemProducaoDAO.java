/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordem_producao;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
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
    
    //Método que cria JOptionPane para adicionar um pedido a op
    public PedidoOp pane(int id, String nome_cliente, float largura, float metragem){
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
        larguraField.setText(String.valueOf(largura));
        metragemField.setText(String.valueOf(metragem));
        
        
   
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
}
