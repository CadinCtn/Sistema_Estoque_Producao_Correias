/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estoque;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class EstoquePendenteDAO {
    
    private Connection connection;
    
    public EstoquePendenteDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    
    // Insert
    public void insertEstPend(EstoquePendente estPend){
        String sql = "INSERT INTO estoque_pendente (id_op,";
        
        
        
    }
    
    // Delete
    public void deleteEstPend(int id){
        
    }
    
    // Update
    public void updateEstPend(EstoquePendente estPend, int id){
        
    }
    
    // Retornar List com todos os items da tabela estoque pendente
    public List<EstoquePendente> selectEstPend(){
        
        
        return null;
    }
    
}
