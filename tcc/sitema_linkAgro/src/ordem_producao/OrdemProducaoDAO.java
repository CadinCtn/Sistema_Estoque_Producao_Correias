/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordem_producao;

import estoque.EstoquePendente;
import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;



/**
 *
 * @author senai
 */
public class OrdemProducaoDAO {
    
    
    private Connection connection;
    
    public OrdemProducaoDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    
     //Insert
    public void insertOrdemProducao(OrdemProducao op){
        String sql = "INSERT INTO ordem_producao (categoria,EE,largura_tecido,metragem_tecido,lonas,setor,observacao) VALUES (?,?,?,?,?,?,?);";
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,op.getCategoria());
            stmt.setInt(2,op.getEe());
            stmt.setFloat(3,op.getLarguraTecido());
            stmt.setFloat(4,op.getMetragemTecido());
            stmt.setFloat(5,op.getLonas());
            stmt.setString(6,op.getSetor());
            stmt.setString(7,op.getObservacao());
            
            stmt.execute();
            stmt.close();
            
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        
        
    }
    
    //Delete
    public void deleteOrdemProducao(int id){
        String sql = "DELETE FROM ordem_producao WHERE id = ?";
        
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
    public List<OrdemProducao> selectOrdemProducao(){
        String sql = "SELECT * FROM ordem_producao";
        
        List<OrdemProducao> opList = new ArrayList();
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                OrdemProducao op = new OrdemProducao();
                op.setId(rs.getInt("id"));
                op.setCategoria(rs.getString("categoria"));
                op.setEe(rs.getInt("EE"));
                op.setLarguraTecido(rs.getFloat("largura_tecido"));
                op.setMetragemTecido(rs.getFloat("metragem_tecido"));
                op.setLonas(rs.getInt("lonas"));
                op.setSetor(rs.getString("setor"));
                op.setObservacao(rs.getString("observacao"));
                
                opList.add(op);
            }
            
            stmt.close();
            rs.close();
                    
            
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        
        
        return opList;
    }
    
    
    // Update
    public void updadeOrdemProducao(OrdemProducao op, int id){
        String sql = "UPDATE ordem_producao SET categoria = ?, EE = ?, largura_tecido = ?, metragem_tecido = ?, lonas = ?, setor = ?, observacao = ? WHERE id = " + id;
        
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,op.getCategoria());
            stmt.setInt(2,op.getEe());
            stmt.setFloat(3,op.getLarguraTecido());
            stmt.setFloat(4,op.getMetragemTecido());
            stmt.setInt(5,op.getLonas());
            stmt.setString(6,op.getSetor());
            stmt.setString(7,op.getObservacao());
            stmt.execute();
            stmt.close();
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        
    }

    //Calcular estoque
    public List estoquePend(OrdemProducao op, List<PedidoOp> listPedido){
        
        List<EstoquePendente> listEstPendente = new ArrayList();
        
        float larguraTecido = op.getLarguraTecido();
        float metragemTecido = op.getMetragemTecido();
        float mpTecido = larguraTecido * metragemTecido;
        float mpPedidos = 0;
        
        List<Float> larguraPedidos = new ArrayList();
        List<Float> metragemPedidos = new ArrayList();  
        
        for(PedidoOp pedidoop : listPedido){
            larguraPedidos.add(pedidoop.getLargura());
            metragemPedidos.add(pedidoop.getMetragem());
            mpPedidos += pedidoop.getLargura() * pedidoop.getMetragem();
        }
        
        float largPedTotal =  (float) larguraPedidos.stream().mapToDouble(Float::doubleValue).sum();
        float metPedTotal = (float) metragemPedidos.stream().mapToDouble(Float::doubleValue).sum();
        
        
        
        // verificando se vai sobrar algum estoque
        if(mpPedidos > mpTecido){
            return null;
        } else if(mpPedidos == mpTecido){
            return null;
        } else { // se a area dos pedidos for menor que a area da bobina sobrará estoque
            int i = 0;
            while(i < listPedido.size()){//percorrendo os pedidos a serem adicionados a op
                EstoquePendente estpend = new EstoquePendente(); 
                estpend.setId(op.getId());
                estpend.setCategoria(op.getCategoria());
                estpend.setLonas(op.getLonas());
            
                    if(largPedTotal <= larguraTecido){ // verificando a forma que será cortado da bobina

                        // Se a METRAGEM e a LARGURA de todos forem iguais, o estoque a ser retornado é maior
                        if(larguraPedidos.stream().distinct().count() == 1 && metragemPedidos.stream().distinct().count() == 1){
                            estpend.setLargura(largPedTotal);
                            estpend.setMetragem(metragemTecido - metragemPedidos.get(i));
                            //adicionado a lista de estoque pendente
                            listEstPendente.add(estpend);
                            
                        break;

                    } else{ 
                        estpend.setLargura(larguraPedidos.get(i));
                        estpend.setMetragem(metragemTecido - metragemPedidos.get(i));   
                    }
                } else {
                    estpend.setLargura(larguraTecido - larguraPedidos.get(i));
                    estpend.setMetragem(metragemPedidos.get(i));
                }
                
                
                listEstPendente.add(estpend);
                i++;
            }
            
            
            EstoquePendente estpend = new EstoquePendente();
            estpend.setId(op.getId());
            estpend.setCategoria(op.getCategoria());
            estpend.setLonas(op.getLonas());
            if(largPedTotal < larguraTecido){
                estpend.setLargura(larguraTecido - largPedTotal);
                estpend.setMetragem(metragemTecido);
            } else {
                estpend.setLargura(larguraTecido);
                estpend.setMetragem(metragemTecido - metPedTotal);
            }
            
            listEstPendente.add(estpend);
            
            for(EstoquePendente ep : listEstPendente){
                System.out.print("\n\nID: " + ep.getId() + "\nCategoria: " + ep.getCategoria() + "Lonas: " + ep.getLonas() + "\nLargura: " + ep.getLargura() + "\nMetragem: " + ep.getMetragem());
            }
            return listEstPendente;    
        }
        
    }
    


}
