package estoque;

import produtos.ProdutoDAO;
import factory.ConnectionFactory;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import produtos.Produto;


public class EstoqueDAO {
    
    private Connection connection;
    
    public EstoqueDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    
    //Método que cria JOptionPane para adicionar ou editar um estoque
    public Estoque pane(Estoque estoque, boolean edit){
        
        //Criando painel do JOptionPane
        JPanel paneJOP = new JPanel();

        //Campos para digitalizar o texto
        JComboBox categoriaBox = new JComboBox();
        JComboBox lonasBox = new JComboBox();
        JTextField larguraField = new JTextField(7);
        JTextField metragemField = new JTextField(7);
        JTextField obsField = new JTextField(20);
        
        //Adicionando elementos ao painel
        paneJOP.add(new JLabel("Categoria: "));
        paneJOP.add(categoriaBox);
        paneJOP.add(new JLabel("Lonas: "));
        paneJOP.add(lonasBox);
        paneJOP.add(new JLabel("Largura: "));
        paneJOP.add(larguraField);
        paneJOP.add(new JLabel("Metragem: "));
        paneJOP.add(metragemField);
        paneJOP.add(new JLabel("OBS: "));
        paneJOP.add(obsField);
        
        //Adicionando itens as comboBox
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
          for (int i = 2; i <= 10; i++) {
            if (i != 7 && i != 9) {
                lonasBox.addItem(i);
            }
        }
        
          
           
            //Setando valores iniciais do Field
        if(edit){
            categoriaBox.setSelectedItem(estoque.getCategoria());
            lonasBox.setSelectedItem(estoque.getLonas());
            larguraField.setText(String.valueOf(estoque.getLargura()));
            metragemField.setText(String.valueOf(estoque.getMetragem()));
            obsField.setText(estoque.getObs());
        } else {
            categoriaBox.setSelectedItem(null);
            lonasBox.setSelectedItem(null);
        }
        
   
        switch (JOptionPane.showConfirmDialog(null, paneJOP, "Adicionar Estoque", JOptionPane.OK_CANCEL_OPTION)) {
            case JOptionPane.OK_OPTION : 
                
                //if para impedir que seja cadastrado como null
                if ( larguraField.getText().isEmpty() || metragemField.getText().isEmpty()) {
                    //JOptionPane de alerta
                    JOptionPane.showMessageDialog(paneJOP, "Preencha todos os campos de cadastro!", "ERRO!", JOptionPane.WARNING_MESSAGE);
                } else {      
                        Estoque addEstoque = new Estoque();
                    //Criando objeto ana classe modelo
                    addEstoque.setLonas(Integer.parseInt(String.valueOf(lonasBox.getSelectedItem())));
                    addEstoque.setCategoria(String.valueOf(categoriaBox.getSelectedItem()));
                    try{
                        addEstoque.setLargura(Float.parseFloat(larguraField.getText()));
                        addEstoque.setMetragem(Float.parseFloat(metragemField.getText()));
                    
                    }catch(NumberFormatException e){
                        JOptionPane.showMessageDialog(null,"Digite um valor numérico!\nUtilize ponto no lugar da vírgula se houver.","AVISO",JOptionPane.ERROR_MESSAGE);
                        return null;
                    }
                    addEstoque.setObs(obsField.getText());
                    
                    //retornando objeto a ser inserido na tabela
                    return addEstoque;
                   
                }

                break;
            
        }
        
        return null;
            
    }
    
    
    
    
    
    //Insert
    public void insertEstoque(Estoque estoque){
        String sql = "INSERT INTO estoque (categoria,lonas,largura,metragem,reservado,observacao) VALUES (?,?,?,?,?,?);";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,estoque.getCategoria());
            stmt.setInt(2,estoque.getLonas());
            stmt.setFloat(3,estoque.getLargura());
            stmt.setFloat(4,estoque.getMetragem());
            stmt.setBoolean(5, false);
            stmt.setString(6,estoque.getObs());
            
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null,"Correia adicionada com sucesso!\n"+estoque.getCategoria() + " " + estoque.getLonas() +"L   " + estoque.getLargura()+" x " + estoque.getMetragem());
        
            
        }
        catch(SQLException e){
            e.printStackTrace();
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
                estoque.setReservado(rs.getBoolean("reservado"));
                estoque.setObs(rs.getString("observacao"));
                
                estoqueList.add(estoque);
            }
            
            stmt.close();
            rs.close();
                    
            
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        
        //agrupando categorias e ordenando a largura em ordem crescente
        ordem(estoqueList);
        
        return estoqueList;
    }
    
    
    //Agrupando e ordenando os objetos
    public void ordem(List<Estoque> list){
        Comparator<Estoque> comparator = new Comparator<Estoque>(){
          public int compare(Estoque est1, Estoque est2){
              int result = est1.getCategoria().compareTo(est2.getCategoria());
              if(result == 0){
                  result = Integer.compare(est1.getLonas(),est2.getLonas());
                  if(result == 0){
                    result = Float.compare(est1.getLargura(),est2.getLargura());   
                    if(result == 0){
                        result = Float.compare(est1.getMetragem(),est2.getMetragem());
                    }
                  }
              }
              return result;
          }  
        };
        Collections.sort(list,comparator);
    }
        
    
    
    //Update
    public void updadeEstoque(Estoque estoque, int id){
        String sql = "UPDATE estoque SET categoria = ?, lonas = ?, largura = ?, metragem = ?, observacao = ? WHERE id = " + id;
        
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,estoque.getCategoria());
            stmt.setInt(2,estoque.getLonas());
            stmt.setFloat(3,estoque.getLargura());
            stmt.setFloat(4,estoque.getMetragem());
            stmt.setString(5,estoque.getObs());
            stmt.execute();
            stmt.close();
            
                JOptionPane.showMessageDialog(null,"Correia editada com sucesso!\n"+estoque.getCategoria() + " " + estoque.getLonas() +"L   " + estoque.getLargura()+" x " + estoque.getMetragem());
        
            
        }
        catch(Exception e){
            e.printStackTrace();
            
        }
        
    }
    
    
    
    //Metodo para filtrar a tabela
    public List<Estoque> buscaEstoque(String categoria, String lonas, String largura, String metragem){
        List<Estoque> estoqueFiltList = new ArrayList();
        
        
        
        String sql = "SELECT * FROM estoque WHERE " + categoria +" lonas " + lonas + " and largura >= " + largura + " and metragem >= " + metragem;
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
                estoque.setReservado(rs.getBoolean("reservado"));
                estoque.setObs(rs.getString("observacao"));
                estoqueFiltList.add(estoque);
            }
            
            stmt.close();
            rs.close();
                    
            
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        
        //agrupando categorias e ordenando a largura em oredm crescente
        ordem(estoqueFiltList);
        
        return estoqueFiltList;
    }
    

    public void reservado(int id){
        String sql = "SELECT reservado FROM estoque WHERE id = ?;";
        String reservar = "UPDATE estoque SET reservado = ? WHERE id = ?";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                
                if(rs.getBoolean("reservado")){
                    stmt = connection.prepareStatement(reservar);
                    stmt.setBoolean(1, false);
                    stmt.setInt(2, id);
                    stmt.execute();
                } else {
                    stmt = connection.prepareStatement(reservar);
                    stmt.setBoolean(1, true);
                    stmt.setInt(2, id);
                    stmt.execute();
                }
            }
        stmt.close();
        rs.close();
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    
    //Estoque reservado
    public static void reservedRow(JTable table, List<Integer> rowIndexList) {
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                           boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (rowIndexList.contains(row) && !isSelected) {
                    c.setBackground(new Color(255,222,0));
                } else {
                    // Mantém a cor padrão das outras linhas ou células selecionadas
                    c.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
                }

                return c;
            }
        });

        // Atualiza a tabela para refletir as mudanças de renderização
        table.repaint();
    }

    


    
    
}
