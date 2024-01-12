import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Testes extends JFrame{

    //Função para verificar se uma lista está ordenada
    private static boolean estaOrdenada(List<Medida> lista, Comparator<Medida> comparator) {
        for (int i = 0; i < lista.size() - 1; i++) {
            if (comparator.compare(lista.get(i), lista.get(i + 1)) > 0) {
                // Elementos não estão em ordem de acordo com o comparator
                return false;
            }
        }
        return true;
    }
    
    
    // Função para somar larguras onde a metragem é igual
    public List<Medida> organizeLarg(List<Medida> listPedidoOp, float larguraTecido){
        
        Collections.sort(listPedidoOp, Comparator
                .comparing(Medida::getLarg)
                .reversed()
                .thenComparing(Medida::getMet, Comparator.reverseOrder()));
                
                ///////////////////////////////////////
                
                for(int i = 0; i < listPedidoOp.size(); i++){
                    int qtdListDel = 0;
                    Medida pedidoop = listPedidoOp.get(i);
                    //Verificando se existem pedidos com as mesmas medidas, retorna a quantidade de pedidos iguais ao index atual(i)
                    int qtdEqualMet = nextEqualMet(listPedidoOp, pedidoop.getMet(), i);
                    System.out.println("PedAtual:  " + listPedidoOp.get(i).getLarg() + " X " + listPedidoOp.get(i).getMet());
                     
                    
                    if(qtdEqualMet != 0){
                        float newLarg = pedidoop.getLarg();
                        boolean menQTecido = false; // essa variavel continua como falsa caso a soma da largura dos pedidos iguais ultrapasse a largura do tecido
                        for( int in = 1; in <= qtdEqualMet; in++){
                            if(newLarg + listPedidoOp.get(i+in).getLarg() <= larguraTecido){
                                newLarg += listPedidoOp.get(i+in).getLarg(); 
                                qtdListDel++;
                                menQTecido = true;
                                
                            } 
                        }
                        
                        pedidoop.setLarg(newLarg); //definindo largura somada
                        if(menQTecido){
                            for( int in = qtdListDel; in > 0; in--){
                                System.out.println("RemovendoOrg:  " + listPedidoOp.get(i+in).getLarg() + " X " + listPedidoOp.get(i+in).getMet());
                     
                                listPedidoOp.remove(i+in); //retirando pedidos que foram somados da lista
                                 
                            }
                            
                            i += qtdListDel-1;
                        }
                    }
                }
                ////////////////////////////////////////
                
                if(estaOrdenada(listPedidoOp, Comparator
                .comparing(Medida::getLarg)
                .reversed()
                .thenComparing(Medida::getMet, Comparator.reverseOrder()))){
            
                    return listPedidoOp;
                }
                
                
                return organizeLarg(listPedidoOp, larguraTecido);                
    }
    
    // Função para somar as metragens onde a largura é igual
    public List<Medida> organizeMet(List<Medida> listPedidoOp, float larguraTecido, float metragemTecido){
        
                
                for(int i = 0; i < listPedidoOp.size(); i++){
                    Medida pedidoop = listPedidoOp.get(i);
                    float totalMet = 0;
                    int qtdListDel = 0;
                    totalMet += pedidoop.getMet();
                    
                    //Verificando se existem pedidos com as mesmas medidas, retorna a quantidade de pedidos iguais ao index atual(i)
                    int qtdEqualLarg = nextEqualLarg(listPedidoOp, pedidoop.getLarg(),i);
                    if(qtdEqualLarg != 0){
                        
                        float newMet = pedidoop.getMet();
                        boolean menQTecido = false; // essa variavel continua como falsa caso a soma da largura dos pedidos iguais ultrapasse a largura do tecido
                        for(int in = 1; in <= qtdEqualLarg; in++){
                            System.out.println(totalMet + listPedidoOp.get(i+in).getMet());
                            if(totalMet + listPedidoOp.get(i+in).getMet() <= metragemTecido){
                                newMet += listPedidoOp.get(i+in).getMet(); 
                                qtdListDel++;
                                menQTecido = true;
                            } 
                        }
                        
                        pedidoop.setMet(newMet); //definindo metragem somada
                     
                        if(menQTecido){
                            
                            for( int in = qtdListDel; in > 0; in--){
                                System.out.println("Removendo:  " + listPedidoOp.get(i+in).getLarg() + " X " + listPedidoOp.get(i+in).getMet());
                                listPedidoOp.remove(i+in); //retirando pedidos que foram somados da lista
                            }
                            
                            i += qtdListDel-1;
                        }
                    }
               }
                
        if(estaOrdenada(listPedidoOp, Comparator
                .comparing(Medida::getLarg)
                .reversed()
                .thenComparing(Medida::getMet, Comparator.reverseOrder()))){
            
                    return listPedidoOp;
                }
        
        return organizeMet(organizeLarg(listPedidoOp, larguraTecido), larguraTecido, metragemTecido);
    }
    
    
    // Função para contar a quantidade de items que possui a METRAGEM igual ao parametro fornecido
    public int nextEqualMet(List<Medida> list, float itemAtual, int index){        
            int cont = 0;
            
            // Loop para contar itens iguais após o item atual
            for(int i = index ; i <= list.size(); i++) {
                try{//try para quando chegar ao fim da lista encerrar o for
                        if (itemAtual == list.get(i +1).getMet()) {
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
    public int nextEqualLarg(List<Medida> list, float itemAtual, int index){        
            int cont = 0;
            
            // Loop para contar itens iguais após o item atual
            for(int i = index ; i <= list.size(); i++) {
                try{//try para quando chegar ao fim da lista encerrar o for
                        if (itemAtual == list.get(i +1).getLarg()) {
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
    
    
    /////
    
    
        List<Medida> pedidos = new ArrayList<>();
        List<Medida> estoque = new ArrayList<>();
        Medida retanguloMaior;

    
    public Testes(){
        retanguloMaior = new Medida(20,100);
        
        pedidos.add(new Medida(12,50));
        pedidos.add(new Medida(15, 50));
        
        estoque.add(new Medida(8,50));
        estoque.add(new Medida(5,50));

        pedidos = organizeMet(pedidos, retanguloMaior.larg, retanguloMaior.met);
        
    }
    
    
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        desenharRetangulos(g);
    }

    private void desenharRetangulos(Graphics g) {
        // Desenhar retângulo maior
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(50, 50, (int) retanguloMaior.larg, (int) retanguloMaior.met);

        // Desenhar retângulos de pedidos
        int xPedidos = 50;
        int yPedidos = 50;
        float largAtual = retanguloMaior.larg;
        
        g.setColor(Color.BLUE);
        for (Medida pedido : pedidos) {
            
            if(pedido.larg > largAtual){
                yPedidos += pedido.met; // Adicionar espaço entre os retângulos
                largAtual = retanguloMaior.larg;
            } else {
                xPedidos += pedido.larg; // Adicionar espaço entre os retângulos
                largAtual-=pedido.larg;
            }
        
            g.drawRect(xPedidos, yPedidos, (int) pedido.larg, (int) pedido.met);

        }

        // Desenhar retângulos de estoque
        int xEstoque = 50;
        int yEstoque = 50; // Espaço entre pedidos e estoque
        g.setColor(Color.RED);
        for (Medida estoque : estoque) {
        
            if(estoque.larg > largAtual){
                yPedidos += estoque.met; // Adicionar espaço entre os retângulos
                largAtual = retanguloMaior.larg;
            } else {
                xPedidos += estoque.larg; // Adicionar espaço entre os retângulos
                largAtual-= estoque.larg;
            }
        
            g.drawRect(xEstoque, yEstoque, (int) estoque.larg, (int) estoque.met);

        }
    }
    
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new Testes();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 200);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
        
        
        
    }

    static class Medida{

        public float getLarg() {
            return larg;
        }

        public void setLarg(float larg) {
            this.larg = larg;
        }

        public float getMet() {
            return met;
        }

        public void setMet(float met) {
            this.met = met;
        }
        float larg,met;
        public Medida(float larg, float met){
            
            this.larg = larg;
            this.met = met;
        
        }
    }
}
