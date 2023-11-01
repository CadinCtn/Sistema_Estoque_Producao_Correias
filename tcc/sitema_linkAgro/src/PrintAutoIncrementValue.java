
import ordem_producao.PedidoOpDAO;

public class PrintAutoIncrementValue {
    public static void main(String[] args) {
     
        PedidoOpDAO op = new PedidoOpDAO();
        
        System.out.println(op.lastId());
        
        
        
    }    
}
