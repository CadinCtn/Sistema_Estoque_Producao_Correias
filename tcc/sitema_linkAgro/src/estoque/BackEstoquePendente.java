
package estoque;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import ordem_producao.OrdemProducao;
import ordem_producao.PedidoOp;

/**
 *
 * @author Lenovo
 */
public class BackEstoquePendente {
   
    //Função para verificar se uma lista está ordenada
    private static boolean estaOrdenada(List<PedidoOp> lista, Comparator<PedidoOp> comparator) {
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
    
    
    //Calcular estoque
    public List estoquePendHori(OrdemProducao op, List<PedidoOp> listPedido){
    try{
        float larguraTecido = op.getLarguraTecido();
        float metragemTecido = op.getMetragemTecido();
        float largAtual = 0;
        float metPedTotal = 0;
        float mpTecido = larguraTecido * metragemTecido;
        float mpPedidos = 0;
        // calculando a área total dos pedidos
        for(PedidoOp pedidoop : listPedido){
            mpPedidos += pedidoop.getLargura() * pedidoop.getMetragem();
        }
        
        // ordenando lista de pedidos 
        listPedido = organizeMet(organizeLarg(listPedido, larguraTecido), larguraTecido,metragemTecido);

        System.out.println("//////////");
        for(PedidoOp oop : listPedido){
            System.out.println("larg/met:   " + oop.getLargura() + " x " + oop.getMetragem());
        }
        System.out.println("//////////");


        // criando lista que retorna o estoque pendente
        List<EstoquePendente> listEstPendente = new ArrayList();

        
        // verificando se vai sobrar algum estoque
        if(mpPedidos > mpTecido){
             JOptionPane.showMessageDialog(null,"Essa Ordem de Produção não pode atender os pedidos adicionados","AVISO!",JOptionPane.WARNING_MESSAGE);
            
        } else { // se a area dos pedidos for menor que a area da bobina sobrará estoque

            int i = 0;
            int nextIndex = 0;
            ////////
            // se a metragem ou largura do pedido preencher totalmenteo limite da bobina é descontado a área desse pedido
                for(int index = 0; index < listPedido.size(); index++){
                    if(listPedido.get(index).getMetragem() >= metragemTecido){
                        larguraTecido -= listPedido.get(index).getLargura();
                        nextIndex++;
                    } else if(listPedido.get(index).getLargura() >= larguraTecido){
                        metragemTecido -= listPedido.get(index).getMetragem();
                        nextIndex++;
                    }
                }
                i += nextIndex;
            ////////
            
            // while para percorrer os pedidos e tirar de cada um a sobra de estoque
            while(i < listPedido.size()){
                PedidoOp pedidoop = listPedido.get(i);//pedido atual
                
                EstoquePendente estpend = new EstoquePendente(op.getId(),op.getCategoria(),op.getLonas(),0,0); 
                    
                    //incrementando largura para posicionamento do pedido na bobina
                    largAtual += pedidoop.getLargura();
                    if(largAtual <= larguraTecido){
                        
                        // Definindo largura e metragem do estoque
                        estpend.setLargura(larguraTecido - largAtual);
                        estpend.setMetragem(pedidoop.getMetragem());
                        System.out.println(largAtual +" " + pedidoop.getLargura());
                        // se há outro pedido posicionado horizontalmente em relação ao atual
                        if(largAtual > pedidoop.getLargura()){
                            // substituindo metragem do pedido anterior em relação ao posicionamento do pedido atual
                            float newMetPedAnterior = listPedido.get(i-1).getMetragem() - pedidoop.getMetragem();
                            if(newMetPedAnterior < 0){ ///////// Se a metragem for negativa, entao a metragem do pedido atual é maior que a do pedido anterior
                                // recalculando valores
                                listEstPendente.get(i-1).setLargura(listPedido.get(i-1).getLargura()); // substituindo largura 
                                newMetPedAnterior = newMetPedAnterior * (-1); // mudando o sinal da nova metragem
                                
                                // Retirando pedido anterior da metragem linear para substituir a a incrementação
                                metPedTotal -= listPedido.get(i-1).getMetragem();
                                //Metragem linear dos pedidos
                                metPedTotal += pedidoop.getMetragem();
                            }
                            
//nextIndex ->  ////////////// O next index serve para retornar o index para ser igual o index i do pedido atual,
                            // se o index for diferente de 0 entao existe um pedido preenchendo um dos limites da bobina.
                            // Nesse caso como o estoque desse pedido não foi adicionado a lista estoque pendente, os index não estão iguais.
                            // o nextIndex serve para igualar os index.
                            listEstPendente.get(i-1-nextIndex).setMetragem(newMetPedAnterior); // substituindo metragem
                        } else {
                            //Metragem linear dos pedidos
                            metPedTotal += pedidoop.getMetragem();
                            
                        }
                    } else {
                        largAtual = pedidoop.getLargura(); //resetando largura
                        estpend.setLargura(larguraTecido - pedidoop.getLargura());
                        estpend.setMetragem(pedidoop.getMetragem());
                        
                        //Metragem linear dos pedidos
                         metPedTotal += pedidoop.getMetragem();
                           
                    }
                        
                        System.out.println("MetTotal: " + metPedTotal);
                    
                        listEstPendente.add(estpend);
                        
                    i++;
            }
            
            if(metPedTotal < metragemTecido){
                EstoquePendente estpend = new EstoquePendente(op.getId(),op.getCategoria(),op.getLonas(),0,0);
                
                //Definindo largura e metragem que sobraram na bobina após os pedidos
                estpend.setLargura(larguraTecido);
                estpend.setMetragem(metragemTecido - metPedTotal);
                 
                listEstPendente.add(estpend);

            }
        
        }
        return listEstPendente;
    } catch(Exception e){
        return null;
    }
    }
    
    
    
    //Calcular outra possibilidade de estoque (Corte Vertical)
    public List estoquePendVert(OrdemProducao op, List<PedidoOp> listPedido){
  //  try{
        System.out.println("\n\n///////////////////\nCorte Vertical\n");
        
        float larguraTecido = op.getLarguraTecido();
        float metragemTecido = op.getMetragemTecido();
        float largTecAtual = op.getLarguraTecido();
        float metTecAtual = op.getMetragemTecido();
        float largAtual = 0;
        float largPedTotal = 0;
        float mpTecido = larguraTecido * metragemTecido;
        float mpPedidos = 0;
        int indexLargTec = 0;
        
        // calculando a área total dos pedidos
        for(PedidoOp pedidoop : listPedido){
            mpPedidos += pedidoop.getLargura() * pedidoop.getMetragem();
        }
        // criando lista que retorna o estoque pendente
        List<EstoquePendente> listEstPendente = new ArrayList();
        

        // ordenando lista de pedidos 
        listPedido = organizeMet(organizeLarg(listPedido, larguraTecido), larguraTecido,metragemTecido);

        System.out.println("//////////");
        for(PedidoOp oop : listPedido){
            System.out.println("larg/met:   " + oop.getLargura() + " x " + oop.getMetragem());
        }
        System.out.println("//////////");


        // verificando se é possivel atender os pedidos com essa ordem de produção
        if(mpPedidos > mpTecido){
             JOptionPane.showMessageDialog(null,"Essa Ordem de Produção não pode atender os pedidos adicionados","AVISO!",JOptionPane.WARNING_MESSAGE);
            
        } else { 
            
            int i = 0;
            int nextIndex = 0;
            ////////
            // se a metragem ou largura do pedido preencher totalmenteo limite da bobina é descontado a área desse pedido
                for(int index = 0; index < listPedido.size(); index++){
                    if(listPedido.get(index).getMetragem() >= metragemTecido){
                        larguraTecido -= listPedido.get(index).getLargura();
                        nextIndex++;
                    } else if(listPedido.get(index).getLargura() >= larguraTecido){
                        metragemTecido -= listPedido.get(index).getMetragem();
                        nextIndex++;
                    }
                    //Definindo largura total dos pedidos
                    largPedTotal += listPedido.get(index).getLargura();
                }
                i += nextIndex;
            ////////
            
           
            while(i < listPedido.size()){//percorrendo os pedidos a serem adicionados a op
                EstoquePendente estpend = new EstoquePendente(op.getId(),op.getCategoria(),op.getLonas(),0,0); 
                PedidoOp pedidoop = listPedido.get(i);//Pedido atual do loop
                
                    
                    // verificando a forma que será cortado da bobina
                    if(largPedTotal <= larguraTecido){ 
                        estpend.setLargura(pedidoop.getLargura());
                        estpend.setMetragem(metragemTecido - pedidoop.getMetragem());   
                        
                    } else { 
                        int in = 1;
                        ///////////////////////                        
                        try{
                            
                            // largura do pedido atual
                            largAtual = pedidoop.getLargura();
                            System.out.println(pedidoop.getLargura() + " index: " + i);
                            //Verificando se é possivel posicionar outro pedido horizontalmente
                            if(largTecAtual < largAtual + listPedido.get(i+1).getLargura()){

                                // definindo estoque pendente
                                estpend.setLargura(largTecAtual - largAtual);
                                estpend.setMetragem(metTecAtual);
                                // delimitando área restante da bobina
                                largTecAtual -= larguraTecido - largAtual;
                                metTecAtual -= pedidoop.getMetragem();

                                
                            } else {
                                
                                // setando largura e calculando metragem dos pedidos posicionados horizontalmente
                                
                                System.out.println("LargTec Atual: " + largTecAtual);
                                while(largTecAtual > largAtual + listPedido.get(i+in).getLargura()){
                                    System.out.println("largAtual: " + largAtual);
                                   // System.out.println("Teste: " + listPedido.get(i+in).getLargura() + " x " + listPedido.get(i+in).getMetragem());
                                    
                                    estpend.setLargura(listPedido.get(i+in).getLargura());
                                    estpend.setMetragem(metTecAtual - listPedido.get(i+in).getMetragem());
                                    
                                    System.out.println(estpend.getLargura() + " x " + estpend.getMetragem());
                                    listEstPendente.add(new EstoquePendente(op.getId(),op.getCategoria(),op.getLonas(),estpend.getLargura(),estpend.getMetragem()));
                                    
                                    largAtual += listPedido.get(i+in).getLargura();
                                    in++;
                                    
                                }
                                i+=in;
                                // definindo estoque pendente
                                estpend.setLargura(largTecAtual - largAtual);
                                estpend.setMetragem(metTecAtual);

                                // delimitando área restante da bobina
                                largTecAtual = pedidoop.getLargura();
                                metTecAtual -= pedidoop.getMetragem();
                                indexLargTec = i;
                                
                            }
                        } catch(Exception e){
                           
                        }
                        ///////////////////////
                        
                        
                    }
                    System.out.println("\n// Estoque Adicionado: " + estpend.getLargura() + " x " + estpend.getMetragem());
                    //adicionado a lista de estoque pendente
                    listEstPendente.add(estpend);
                
                 
                i++;
                    
            }
          
            
            // Verificando o que sobrará do restante da bobina
            EstoquePendente estpend = new EstoquePendente(op.getId(),op.getCategoria(),op.getLonas(),0,0);
            if(largPedTotal <= larguraTecido){
                estpend.setLargura(larguraTecido - largPedTotal);
                estpend.setMetragem(metragemTecido);
            } else {
                //Resetando largura atual
                largAtual = 0;
                while(indexLargTec <= listPedido.size()-1){
                    
                    largAtual += listPedido.get(indexLargTec).getLargura();
                    System.out.println("Largura Atual Sobra: " + largAtual + "LargTec: " + largTecAtual + " index: " + indexLargTec);
                    listEstPendente.add(new EstoquePendente(op.getId(),op.getCategoria(),op.getLonas(),listPedido.get(indexLargTec).getLargura(),metTecAtual - listPedido.get(indexLargTec).getMetragem()));
                    indexLargTec++;
                }
                estpend.setLargura(largTecAtual - largAtual);
                estpend.setMetragem(metTecAtual);
            }
            //adicionado a lista de estoque pendente
                listEstPendente.add(estpend);
            
            
        }
        return listEstPendente;    
        
 //   } catch(Exception e){
   //     return null;
    //}
 
    }
}
