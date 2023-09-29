/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prototypes;

import prototypes.COrdemProducaoGUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Metodos {

    /////Ação do Botão de Busca do estoque
    public void act_btnBusca() {
        //Criando painel do JOptionPane
        JPanel paneJOP = new JPanel();

        //Campos para digitalizar o texto
        JTextField lonaField = new JTextField(7);
        JTextField largField = new JTextField(7);
        JTextField metField = new JTextField(7);
        String[] boxElements = {"Agrothor", "Primethor", "Agropem"};
        JComboBox<String> catBox = new JComboBox<>(boxElements);

        //Adicionando elementos ao painel
        paneJOP.add(new JLabel("Lona"));
        paneJOP.add(lonaField);
        paneJOP.add(new JLabel("Largura"));
        paneJOP.add(largField);
        paneJOP.add(new JLabel("Metragem"));
        paneJOP.add(metField);
        paneJOP.add(new JLabel("Categoria"));
        paneJOP.add(catBox);

        //Switch de confirmação de busca
        switch (JOptionPane.showConfirmDialog(null, paneJOP, "Busca Estoque", JOptionPane.OK_CANCEL_OPTION)) {
            case JOptionPane.OK_OPTION : {
                
                        //Colocando em variáveis do tipo String os elementos digitados para a busca
                        String lona = lonaField.getText();
                        String largura = largField.getText();
                        String metragem = metField.getText();
                        String categoria = (String) catBox.getSelectedItem();
                
                    if("".equals(lona) || "".equals(largura) || "".equals(metragem)){
                       //Mensagem de erro
                        JOptionPane.showMessageDialog(paneJOP, "Informações de busca inválidas!", "ERRO!", JOptionPane.WARNING_MESSAGE);
                    } else{
                     
                        //Imprimindo as variáveis no terminal
                        System.out.println(lona);
                        System.out.println(largura);
                        System.out.println(metragem);
                        System.out.println(categoria);
                        
                    }
            }
        }

    }

    /////Ação do Botão de adicionar pedidos
    public void act_addPedido() {
        
        //Criando painel do JOptionPane
        JPanel paneJOP = new JPanel();

        //Campos para digitalizar o texto
        JTextField idField = new JTextField(5);
        JTextField fecField = new JTextField(7);
        JTextField nomeField = new JTextField(50);
        JTextField prazField = new JTextField(7);

        //Adicionando elementos ao painel
        paneJOP.add(new JLabel("Id Pedido: "));
        paneJOP.add(idField);
        paneJOP.add(new JLabel("Data Fechamento: "));
        paneJOP.add(fecField);
        paneJOP.add(new JLabel("Nome Cliente: "));
        paneJOP.add(nomeField);
        paneJOP.add(new JLabel("Prazo Embarque: "));
        paneJOP.add(prazField);
   
        switch (JOptionPane.showConfirmDialog(null, paneJOP, "Adicionar Pedido", JOptionPane.OK_CANCEL_OPTION)) {
            case JOptionPane.OK_OPTION : {
                //Colocando em variáveis do tipo String os elementos digitados para a busca
                String idPedido = idField.getText();
                String dataFechamento = fecField.getText();
                String nomeCliente = nomeField.getText();
                String prazoEmbarque = prazField.getText();

                //if para impedir que haja algum pedido cadastrado como null
                if ("".equals(idPedido) || "".equals(dataFechamento) || "".equals(nomeCliente) || "".equals(prazoEmbarque)) {
                    //JOptionPane de alerta
                    JOptionPane.showMessageDialog(paneJOP, "Preencha todos os campos de cadastro!", "ERRO!", JOptionPane.WARNING_MESSAGE);
                } else {      

                    //Retornando para o usuário o pedido adicionado
                    JOptionPane.showMessageDialog(null, "Pedido adicionado com sucesso!Id Pedido: " + idPedido + "\nData Fechamento: " + dataFechamento + "\nNome Cliente: " + nomeCliente + "\nPrazo Embarque: " + prazoEmbarque);
                }

                break;
            }
        }

    }

    
    /////Ação do botão de adicionar pedidos para a ordem de produção
    public void act_addPedidoOP() {
        
        JPanel paneJOP = new JPanel();

        //Elementos do painel
        JTextField idPed = new JTextField(5);
        JTextField nomePed = new JTextField(50);
        JTextField largPed = new JTextField(5);
        JTextField metPed = new JTextField(5);

        //Adicionando elementos ao painel
        paneJOP.add(new JLabel("ID Pedido:"));
        paneJOP.add(idPed);
        paneJOP.add(new JLabel("Nome Cliente:"));
        paneJOP.add(nomePed);
        paneJOP.add(new JLabel("Largura do pedido:"));
        paneJOP.add(largPed);
        paneJOP.add(new JLabel("Metragem do Pedido:"));
        paneJOP.add(metPed);

        switch (JOptionPane.showConfirmDialog(null, paneJOP, "Adicionar Pedido", JOptionPane.OK_CANCEL_OPTION)) {
            case JOptionPane.OK_OPTION :{
                
                //transformando as especificações em variáveis do tipo String
                String idPedido = idPed.getText();
                String nomePedido = nomePed.getText();
                String larguraPedido = largPed.getText();
                String metragemPedido = metPed.getText();
                
                
                if("".equals(idPedido) || "".equals(nomePedido) || "".equals(larguraPedido) || "".equals(metragemPedido)){
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos de especificações!","ERRO!",JOptionPane.WARNING_MESSAGE);
                } else {
                    
                    
                    
                    
                    
                    
                    
                    
                //imprimindo valores
                System.out.print("ID: " + idPedido + "Nome cliente: "  + nomePedido + "Largura: " + larguraPedido + "Metragem: " + metragemPedido);
                
                //Mensagem de retorno
                JOptionPane.showMessageDialog(null,"Pedido adicionado com Sucesso!");
                
                }
                break;
            }
        }

    }
    
}
