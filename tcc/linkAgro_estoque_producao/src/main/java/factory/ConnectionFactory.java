// situa em qual package ou “pacote” está a classe
package factory;

// faz as importações de classes necessárias para o funcionamento do programa
import java.sql.Connection;
// conexão SQL para Java
import java.sql.DriverManager;
// driver de conexão SQL para Java
import java.sql.SQLException;

// classe para tratamento de exceções
public class ConnectionFactory {
    
    public Connection getConnection() {

        try {
            return
            DriverManager.getConnection("jdbc:mysql://192.168.1.16/bd_linkagro","root","root");
            //DriverManager.getConnection("jdbc:mysql://localhost/bd_linkagro","root","root");
        }
        catch(SQLException excecao) {
            throw new RuntimeException(excecao);
        }
    }
}
