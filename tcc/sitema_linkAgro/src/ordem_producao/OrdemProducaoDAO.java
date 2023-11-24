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
import java.util.Collections;
import java.util.Comparator;
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

    
    public List<PedidoOp> organize(List<PedidoOp> listPedidoOp, float larguraTecido){
                
        Collections.sort(listPedidoOp, Comparator
                .comparing(PedidoOp::getLargura)
                .reversed()
                .thenComparing(PedidoOp::getMetragem, Comparator.reverseOrder()));
                
                ///////////////////////////////////////
                int qtdListDel = 0;
                for(int i = 0; i < listPedidoOp.size(); i++){
                    PedidoOp pedidoop = listPedidoOp.get(i);
                    
                    int qtdEqualLarg = nextEqualLarg(listPedidoOp, pedidoop.getLargura(),i);
                    int qtdEqualMet = nextEqualMet(listPedidoOp, pedidoop.getMetragem(), i);
                    System.out.println("largura" + qtdEqualLarg + i);
                    System.out.println("metragem" + qtdEqualMet + i);
                    
                    if(qtdEqualLarg != 0 && qtdEqualMet != 0){
                        float newLarg = pedidoop.getLargura();
                        boolean meQTecido = false;
                        for( int in = 1; in <= qtdEqualLarg; in++){
                            if(newLarg + listPedidoOp.get(i+in).getLargura() <= larguraTecido){
                                newLarg += listPedidoOp.get(i+in).getLargura();
                                meQTecido = true;
                            } 
                        }
                    System.out.println("FUNCIONA: "+newLarg);
                    pedidoop.setLargura(newLarg);
                    if(meQTecido){
                        for( int in = 1; in <= qtdEqualLarg; in++){
                        listPedidoOp.remove(i+in);
                        qtdListDel++;
                        }
                    }
                    i += qtdListDel;
                }
                
                
                }
                ////////////////////////////////////////
                
                Collections.sort(listPedidoOp, Comparator
                .comparing(PedidoOp::getLargura)
                .reversed()
                .thenComparing(PedidoOp::getMetragem, Comparator.reverseOrder()));
        
                
                
                return listPedidoOp;
                
    }
    

    public int nextEqualMet(List<PedidoOp> list, float itemAtual, int index){        
            int cont = 0;
            
            // Loop para contar itens iguais após o item atual
            for(int i = index ; i <= list.size(); i++) {
                try{//try para quando chegar ao fim da lista encerrar o for
                        if (itemAtual == list.get(i +1).getMetragem()) {
                            cont++;
                        } else {    
                            break; // Se encontrar um valor diferente, encerra o loop
                        }
                    }
                catch(Exception e){
                    break;
                }
            }
          
        return cont;
    }
    
    public int nextEqualLarg(List<PedidoOp> list, float itemAtual, int index){        
            int cont = 0;
            
            // Loop para contar itens iguais após o item atual
            for(int i = index ; i <= list.size(); i++) {
                try{//try para quando chegar ao fim da lista encerrar o for
                        if (itemAtual == list.get(i +1).getLargura()) {
                            cont++;
                        } else {    
                            break; // Se encontrar um valor diferente, encerra o loop
                        }
                    }
                catch(Exception e){
                    break;
                }
            }
          
        return cont;
    }
    
    
    //Calcular estoque
    public List estoquePend(OrdemProducao op, List<PedidoOp> listPedido){

        float larguraTecido = op.getLarguraTecido();
        float metragemTecido = op.getMetragemTecido();
        float metPedTotal = 0;
        float mpTecido = larguraTecido * metragemTecido;
        float mpPedidos = 0;
        // calculando a área total dos pedidos
        for(PedidoOp pedidoop : listPedido){
            mpPedidos += pedidoop.getLargura() * pedidoop.getMetragem();
        }
        
        
        // ordenando lista de pedidos 
        listPedido = organize(listPedido, larguraTecido);
        
        for(PedidoOp pdop : listPedido){
            metPedTotal += pdop.getMetragem();
            System.out.println(metPedTotal);
        }
        
        
        // criando lista que retorna o estoque pendente
        List<EstoquePendente> listEstPendente = new ArrayList();

        
        // verificando se vai sobrar algum estoque
        if(mpPedidos > mpTecido){
            return null;
        } else { // se a area dos pedidos for menor que a area da bobina sobrará estoque
            int i = 0;
            while(i < listPedido.size()){//percorrendo os pedidos a serem adicionados a op
                PedidoOp pedidoop = listPedido.get(i);
                
                EstoquePendente estpend = new EstoquePendente(); 
                estpend.setId(op.getId());
                estpend.setCategoria(op.getCategoria());
                estpend.setLonas(op.getLonas());
                        
                
                        int qtdEqualLarg = nextEqualLarg(listPedido, pedidoop.getLargura(),i);
                        if(qtdEqualLarg != 0){
                        
                        // somando a metragem dos pedidos que tem a mesma largura
                        float somaMet = pedidoop.getMetragem();
                        
                        for(int index = 0; index < qtdEqualLarg; index++){
                            somaMet += listPedido.get(i + index + 1).getMetragem();
                        }
                        
                        estpend.setLargura(larguraTecido - pedidoop.getLargura());
                        estpend.setMetragem(somaMet);
                        
                        i+= qtdEqualLarg;
                        
                        } else {
                     
                            estpend.setLargura(larguraTecido - pedidoop.getLargura());
                            estpend.setMetragem(pedidoop.getMetragem());
                   
                        }

                listEstPendente.add(estpend);
                i++;
            }


            EstoquePendente estpend = new EstoquePendente();
            estpend.setId(op.getId());
            estpend.setCategoria(op.getCategoria());
            estpend.setLonas(op.getLonas());
            if(metPedTotal < metragemTecido){
                estpend.setLargura(larguraTecido);
                estpend.setMetragem(metragemTecido - metPedTotal);
            }

            listEstPendente.add(estpend);

            
            return listEstPendente;    
        }

    }
    
    
    
    
    //Calcular outra possibilidade de estoque (Corte Vertical)
    public List estoquePendAlt(OrdemProducao op, List<PedidoOp> listPedido){
        // id da ordem de produção que irá sobrar do estoque
        PedidoOpDAO pedidoopdao = new PedidoOpDAO();
        int id_op = pedidoopdao.lastId("id", "ordem_producao") + 1;
        
        //Ordenando em ordem decrescente com base na largura e metragem
        Collections.sort(listPedido, Comparator
                .comparing(PedidoOp::getLargura)
                .reversed()
                .thenComparing(PedidoOp::getMetragem, Comparator.reverseOrder()));

        
        // lista para guardar o estoque pendente
        List<EstoquePendente> listEstPendente = new ArrayList();
        
        float larguraTecido = op.getLarguraTecido();
        float metragemTecido = op.getMetragemTecido();
        float mpTecido = larguraTecido * metragemTecido;
        float mpPedidos = 0;
        float mtsAtual = metragemTecido;
        
        List<Float> larguraPedidos = new ArrayList();
        List<Float> metragemPedidos = new ArrayList();  
        
        for(PedidoOp pedidoop : listPedido){
            larguraPedidos.add(pedidoop.getLargura());
            metragemPedidos.add(pedidoop.getMetragem());
            mpPedidos += pedidoop.getLargura() * pedidoop.getMetragem();
        }
        
        float largPedTotal =  (float) larguraPedidos.stream().mapToDouble(Float::doubleValue).sum();
        
        // verificando se vai sobrar algum estoque
        if(mpPedidos > mpTecido){
            return null;
        } else { // se a area dos pedidos for menor que a area da bobina sobrará estoque
            
            // Verificando o que sobrará dos pedidos
            int i = 0;
            while(i < listPedido.size()){//percorrendo os pedidos a serem adicionados a op
                EstoquePendente estpend = new EstoquePendente(); 
                estpend.setId(id_op);
                estpend.setCategoria(op.getCategoria());
                estpend.setLonas(op.getLonas());
            
                // verificando a forma que será cortado da bobina
                    if(largPedTotal <= larguraTecido){ 

                        // Se a METRAGEM e a LARGURA de todos forem iguais, o estoque a ser retornado é maior
                        if(larguraPedidos.stream().distinct().count() == 1 && metragemPedidos.stream().distinct().count() == 1){
                            estpend.setLargura(largPedTotal);
                            estpend.setMetragem(metragemTecido - metragemPedidos.get(i));
                                
                                //adicionado a lista de estoque pendente
                                listEstPendente.add(estpend);
                            break;
                        } else { 
                            estpend.setLargura(larguraPedidos.get(i));
                            estpend.setMetragem(metragemTecido - metragemPedidos.get(i));   
                        }
                        
                    } else { 
                        try{ // try para quando chegar ao fim do array
                            
                            estpend.setLargura(larguraPedidos.get(i) - larguraPedidos.get(i+1));
                            mtsAtual -= metragemPedidos.get(i);
                            estpend.setMetragem(mtsAtual);
                            System.out.println("Try 1");
                            
                        }
                        catch(Exception e){
                            System.out.println("\n\n" + e + "\n\n");
                            
                            mtsAtual -= metragemPedidos.get(i);
                            estpend.setLargura(larguraPedidos.get(i));
                            estpend.setMetragem(mtsAtual);
                        }
                    }
                
                    //adicionado a lista de estoque pendente
                    listEstPendente.add(estpend);
                
                i++;
            }
            
            // Verificando o que sobrará do restante da bobina
            EstoquePendente estpend = new EstoquePendente();
            estpend.setId(id_op);
            estpend.setCategoria(op.getCategoria());
            estpend.setLonas(op.getLonas());
            if(largPedTotal > larguraTecido){
                estpend.setLargura(larguraTecido - larguraPedidos.get(0));
                estpend.setMetragem(metragemTecido);
            } else {
                estpend.setLargura(larguraTecido - largPedTotal);
                estpend.setMetragem(metragemTecido);
            }
            
            //adicionado a lista de estoque pendente
                listEstPendente.add(estpend);
            
            
            
            return listEstPendente;    
        }
        
    }
    
    
    
    
}