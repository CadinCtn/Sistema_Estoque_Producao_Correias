/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estoque;

import produtos.ProdutoDAO;
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


public class EstoqueDAO {
    
    private Connection connection;
    
    public EstoqueDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    
    //Método que cria JOptionPane para adicionar um estoque
    public Estoque pane(String categoria, String lonas, String largura, String metragem){
        Estoque estoque = new Estoque();
        
        
        //Criando painel do JOptionPane
        JPanel paneJOP = new JPanel();

        //Campos para digitalizar o texto
        JComboBox categoriaBox = new JComboBox();
        JTextField lonasField = new JTextField(7);
        JTextField larguraField = new JTextField(7);
        JTextField metragemField = new JTextField(7);

        
        //Adicionando elementos ao painel
        paneJOP.add(new JLabel("Categoria: "));
        paneJOP.add(categoriaBox);
        paneJOP.add(new JLabel("Lonas: "));
        paneJOP.add(lonasField);
        paneJOP.add(new JLabel("Largura: "));
        paneJOP.add(larguraField);
        paneJOP.add(new JLabel("Metragem: "));
        paneJOP.add(metragemField);
        
        
        ProdutoDAO produtodao = new ProdutoDAO();
        
        try{
            List<Produto> produtoList = produtodao.categoriaBox();
            
            for(Produto produto : produtoList){
                categoriaBox.addItem(produto.getProduto());
            }
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        
        
         //Setando valores iniciais do Field
        categoriaBox.setSelectedItem(categoria);
        lonasField.setText(lonas);
        larguraField.setText(largura);
        metragemField.setText(metragem);
        
        
   
        switch (JOptionPane.showConfirmDialog(null, paneJOP, "Adicionar Pedido", JOptionPane.OK_CANCEL_OPTION)) {
            case JOptionPane.OK_OPTION : 
                
                //if para impedir que seja cadastrado como null
                if (lonasField.getText().isEmpty() || larguraField.getText().isEmpty() || metragemField.getText().isEmpty()) {
                    //JOptionPane de alerta
                    JOptionPane.showMessageDialog(paneJOP, "Preencha todos os campos de cadastro!", "ERRO!", JOptionPane.WARNING_MESSAGE);
                } else {      

                    //Criando objeto ana classe modelo
                    estoque.setCategoria((String) categoriaBox.getSelectedItem());
                    estoque.setLonas(Integer.valueOf(lonasField.getText()));
                    estoque.setLargura(Float.valueOf(larguraField.getText()));
                    estoque.setMetragem(Float.valueOf(metragemField.getText()));
                    
                    //retornando objeto a ser inserido na tabela
                    return estoque;
                   
                }

                break;
            
        }
        
        return null;
            
    }
    
    
    
    
    
    //Insert
    public void insertEstoque(Estoque estoque){
        String sql = "INSERT INTO estoque (categoria,lonas,largura,metragem) VALUES (?,?,?,?);";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,estoque.getCategoria());
            stmt.setInt(2,estoque.getLonas());
            stmt.setFloat(3,estoque.getLargura());
            stmt.setFloat(4,estoque.getMetragem());
            
            stmt.execute();
            stmt.close();
            
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        
        
    }
    
    //Delete
    public void deleteEstoque(int id){
        String sql = "DELETE FROM estoque WHERE id = ?";
        
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
    public List<Estoque> selectEstoque(){
        String sql = "SELECT * FROM estoque";
        
        List<Estoque> estoqueList = new ArrayList();
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Estoque estoque = new Estoque();
                estoque.setId(rs.getInt("id"));
                estoque.setCategoria(rs.getString("categoria"));
                estoque.setLonas(rs.getInt("lonas"));
                estoque.setLargura(rs.getFloat("largura"));
                estoque.setMetragem(rs.getFloat("metragem"));
                
                estoqueList.add(estoque);
            }
            
            stmt.close();
            rs.close();
                    
            
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        
        
        return estoqueList;
    }
    
    
    
    public void updadeEstoque(Estoque estoque, int id){
        String sql = "UPDATE estoque SET categoria = ?, lonas = ?, largura = ?, metragem = ? WHERE id = " + id;
        
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,estoque.getCategoria());
            stmt.setInt(2,estoque.getLonas());
            stmt.setFloat(3,estoque.getLargura());
            stmt.setFloat(4,estoque.getMetragem());
            stmt.execute();
            stmt.close();
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        
    }
    
    
}