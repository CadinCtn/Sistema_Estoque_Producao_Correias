/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package produtos;

import factory.ConnectionFactory;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Lenovo
 */
public class ProdutoDAO {
    
    private Connection connection;
    
    public ProdutoDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    //Insert
    public void adicionaProduto(Produto produto){
        String sql = "INSERT INTO produtos (produto, cor_produto) VALUES (?,?);";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,produto.getProduto());
            stmt.setString(2, produto.getCor_produto());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null,"Produto ADICIONADO com sucesso.");
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Não é possivel adicionar um produto igual a um que ja existe!\n");
        }
        
    }
    //Delete
    public void deleteProdutos(String produto){
        String sql = "DELETE FROM produtos WHERE produto = ?;";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,produto);
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null,"Produto DELETADO com sucesso.");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Não foi possivel deletar o produto, existem itens cadastrados com esse produdo!\n");
        }
        
    }
    
    
    //Update
    public void updadeProduto(String produto, Produto newProduto){
        String sqlIns = "INSERT INTO produtos (produto, cor_produto) VALUES (?,?)";
        String sqlDel = "DELETE FROM produtos WHERE produto = ?;";
        try{
            PreparedStatement stmt = connection.prepareStatement(sqlIns);
            stmt.setString(1,newProduto.getProduto());
            stmt.setString(2,newProduto.getCor_produto());
            stmt.execute();
            stmt.close();
            
            updateItens(produto, newProduto.getProduto());
            
            stmt = connection.prepareStatement(sqlDel);
            stmt.setString(1,produto);
            stmt.execute();
            stmt.close();
            
        }
        catch(Exception e){
                String sql = "UPDATE produtos SET cor_produto = ? WHERE produto = ?";
            try {
                PreparedStatement stmt = connection.prepareStatement(sql);
                     stmt.setString(1,newProduto.getCor_produto());
                     stmt.setString(2, produto);
                     stmt.execute();
                     stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        
    }
    
    //Alterando todos os itens cadastrados nas tabelas com o antigo produto para o novo produto
    public void updateItens(String produto, String newProduto){
         String sqlEst = "UPDATE estoque SET categoria = '" + newProduto + "' WHERE categoria = '" + produto + "';";
         String sqlOp = "UPDATE ordem_producao SET categoria = '" + newProduto + "' WHERE categoria = '" + produto + "';";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sqlEst);
            stmt.execute();
            stmt.close();
            
            stmt = connection.prepareStatement(sqlOp);
            stmt.execute();
            stmt.close();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    //Select
    public List<Produto> categoriaBox() throws SQLException{
        String sql = "Select produto FROM produtos;";
        
         List<Produto> produtoList = new ArrayList<>();
        
        
        try(PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();){
            
            while(rs.next()){
                Produto produto = new Produto();
                produto.setProduto(rs.getString("Produto"));
                produtoList.add(produto);
                
            }
            
            stmt.close();
            rs.close();
        }
        
        catch (SQLException u) {
        throw new RuntimeException(u);
        }
        
        return produtoList;
        
    }
    
    //Função para selecionar a cor que está em determinado produto
    public String selectColor(String produto){
        String sql = "SELECT cor_produto FROM produtos WHERE produto = ?;";
        
        String color = null;
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, produto);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                color = rs.getString("cor_produto");
            }
            stmt.close();
            
        } catch(SQLException e){
            e.printStackTrace();
        }
            
        return color;
    }
    
    
    
    
    //Convertendo String para cor
    private static Color stringParaCor(String corString) {
        try {
            // Usar expressão regular para extrair os valores de R, G e B
            Pattern pattern = Pattern.compile("java\\.awt\\.Color\\[r=(\\d+),g=(\\d+),b=(\\d+)\\]");
            Matcher matcher = pattern.matcher(corString);

            if (matcher.matches()) {
                // Extrair os valores de R, G e B
                int r = Integer.parseInt(matcher.group(1));
                int g = Integer.parseInt(matcher.group(2));
                int b = Integer.parseInt(matcher.group(3));

                // Cria e retorna o objeto Color
                return new Color(r, g, b);
            } else {
                return null;
            }
        } catch (Exception e) {
            // Trata erro de formatação
            e.printStackTrace();
            System.out.println("Deu não");
            return null;
        }
    }
    
    
    // Método para aplicar a lógica de cor com base no conteudo da célula
    public void paintCat(JTable table, int columnIndex) {
        table.getColumnModel().getColumn(columnIndex).setCellRenderer(new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(
                    JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Obtém o valor da célula
                String categoria = String.valueOf(table.getValueAt(row, column));
                    // Define a cor da célula com base no valor
                    component.setForeground(stringParaCor(selectColor(categoria))); 
                    
                component.setFont(component.getFont().deriveFont(Font.BOLD));
                return component;
            }
        });
    }

}
