/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estoque_pendente;

import java.awt.Graphics2D;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import ordem_producao.OrdemProducao;
import ordem_producao.PedidoOp;

/**
 *
 * @author Lenovo
 */
public class BackEstoquePendente {
    
    //Função para verificar se uma lista está ordenada
    private boolean estaOrdenada(List<PedidoOp> lista, Comparator<PedidoOp> comparator) {
        for (int i = 0; i < lista.size() - 1; i++) {
            if (comparator.compare(lista.get(i), lista.get(i + 1)) > 0) {
                // Elementos não estão em ordem de acordo com o comparator
                return false;
            }
        }
        return true;
    }
    
    
    // Função para somar larguras onde a metragem é igual
    public List<PedidoOp> organizeLarg(List<PedidoOp> listPedidoOp, float larguraTecido){
        
        Collections.sort(listPedidoOp, Comparator
                .comparing(PedidoOp::getLargura)
                .reversed()
                .thenComparing(PedidoOp::getMetragem, Comparator.reverseOrder()));
                
                ///////////////////////////////////////
                
                for(int i = 0; i < listPedidoOp.size(); i++){
                    int qtdListDel = 0;
                    PedidoOp pedidoop = listPedidoOp.get(i);
                    //Verificando se existem pedidos com as mesmas medidas, retorna a quantidade de pedidos iguais ao index atual(i)
                    int qtdEqualMet = nextEqualMet(listPedidoOp, pedidoop.getMetragem(), i);
                    System.out.println("PedAtual:  " + listPedidoOp.get(i).getLargura() + " X " + listPedidoOp.get(i).getMetragem());
                     
                    
                    if(qtdEqualMet != 0){
                        float newLarg = pedidoop.getLargura();
                        boolean menQTecido = false; // essa variavel continua como falsa caso a soma da largura dos pedidos iguais ultrapasse a largura do tecido
                        for( int in = 1; in <= qtdEqualMet; in++){
                            if(newLarg + listPedidoOp.get(i+in).getLargura() <= larguraTecido){
                                newLarg += listPedidoOp.get(i+in).getLargura(); 
                                qtdListDel++;
                                menQTecido = true;
                                
                            } 
                        }
                        
                        pedidoop.setLargura(newLarg); //definindo largura somada
                        if(menQTecido){
                            for( int in = qtdListDel; in > 0; in--){
                                System.out.println("RemovendoOrg:  " + listPedidoOp.get(i+in).getLargura() + " X " + listPedidoOp.get(i+in).getMetragem());
                     
                                listPedidoOp.remove(i+in); //retirando pedidos que foram somados da lista
                                 
                            }
                            
                            i += qtdListDel-1;
                        }
                    }
                }
                ////////////////////////////////////////
                
                if(estaOrdenada(listPedidoOp, Comparator
                .comparing(PedidoOp::getLargura)
                .reversed()
                .thenComparing(PedidoOp::getMetragem, Comparator.reverseOrder()))){
            
                    return listPedidoOp;
                }
                
                
                return organizeLarg(listPedidoOp, larguraTecido);                
    }
    
    // Função para somar as metragens onde a largura é igual
    public List<PedidoOp> organizeMet(List<PedidoOp> listPedidoOp, float larguraTecido, float metragemTecido){
        
                
                for(int i = 0; i < listPedidoOp.size(); i++){
                    PedidoOp pedidoop = listPedidoOp.get(i);
                    float totalMet = 0;
                    int qtdListDel = 0;
                    totalMet += pedidoop.getMetragem();
                    
                    //Verificando se existem pedidos com as mesmas medidas, retorna a quantidade de pedidos iguais ao index atual(i)
                    int qtdEqualLarg = nextEqualLarg(listPedidoOp, pedidoop.getLargura(),i);
                    if(qtdEqualLarg != 0){
                        
                        float newMet = pedidoop.getMetragem();
                        boolean menQTecido = false; // essa variavel continua como falsa caso a soma da largura dos pedidos iguais ultrapasse a largura do tecido
                        for(int in = 1; in <= qtdEqualLarg; in++){
                            System.out.println(totalMet + listPedidoOp.get(i+in).getMetragem());
                            if(totalMet + listPedidoOp.get(i+in).getMetragem() <= metragemTecido){
                                newMet += listPedidoOp.get(i+in).getMetragem(); 
                                qtdListDel++;
                                menQTecido = true;
                            } 
                        }
                        
                        pedidoop.setMetragem(newMet); //definindo metragem somada
                     
                        if(menQTecido){
                            
                            for( int in = qtdListDel; in > 0; in--){
                                System.out.println("Removendo:  " + listPedidoOp.get(i+in).getLargura() + " X " + listPedidoOp.get(i+in).getMetragem());
                                listPedidoOp.remove(i+in); //retirando pedidos que foram somados da lista
                            }
                            
                            i += qtdListDel-1;
                        }
                    }
               }
                
        if(estaOrdenada(listPedidoOp, Comparator
                .comparing(PedidoOp::getLargura)
                .reversed()
                .thenComparing(PedidoOp::getMetragem, Comparator.reverseOrder()))){
            
                    return listPedidoOp;
                }
        
        return organizeMet(organizeLarg(listPedidoOp, larguraTecido), larguraTecido, metragemTecido);
    }
    
    
    // Função para contar a quantidade de items que possui a METRAGEM igual ao parametro fornecido
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
    
    // Função para contar a quantidade de items que possui a LARGURA igual ao parametro fornecido
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
    
    
    /////////////////
    
    public void desenhoCorte(List<EstoquePendente> listEstPend, OrdemProducao op, Graphics2D g){
        
        //g.drawRect(10, 10, (int) op.getLarguraTecido()*10, (int) op.getMetragemTecido()*10);
        g.drawRect(10, 10, 20*10, 100*10);

        
        
    }
    
    
    
    public void main(String[] args){
        BackEstoquePendente run = new BackEstoquePendente();
        Graphics2D g = null;
        run.desenhoCorte(null, null, g);
    }
    
    
    
}
