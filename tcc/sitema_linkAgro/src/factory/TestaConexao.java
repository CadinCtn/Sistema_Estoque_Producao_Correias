package factory;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class TestaConexao {
    
    public static void main(String[] args) throws SQLException {
    
        Connection connection = new ConnectionFactory().getConnection();
        System.out.println("Conexão aberta!");
        JOptionPane.showMessageDialog(null,"Conexão Efetuada com Sucesso!");
        connection.close();

    }
}