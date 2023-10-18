
package prototypes;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class DesenhoCorte extends JPanel{
    
    
    private final float bx;
    private final float by;
    private float px;
    private float py;
    private float px2;
    private float py2;
    
    private float x2;
    private float y2;
    
    public DesenhoCorte(){
        Dimension d = new Dimension(400,400);
        super.setPreferredSize(d);
        
        
        
        Scanner le = new Scanner(System.in);
        
        System.out.println("Tamanho Bobina:\nEixo X");
        bx = le.nextFloat();
        System.out.println("Eixo Y");
        by = le.nextFloat();
        
        
        System.out.println("Tamanho Pedido:\nEixo X");
        px = le.nextFloat();
        System.out.println("Eixo Y");
        py = le.nextFloat();
        
        
        System.out.println("Tamanho Pedido 2:\nEixo X");
        px2 = le.nextFloat();
        System.out.println("Eixo Y");
        py2 = le.nextFloat();
        
        
        
        px = (px * 200 / bx);
        py = (py * 300 / by);
        
        px2 = (px2 * 200 / bx);
        py2 = (py2 * 300 / by);
        
        
        //if para posicionamento
        if(px+px2 >= 200 && py+py2 <= 300){
            x2 = 100;
            y2 = py+30;
            
        }else if(px+px2 >200 && py+py2 >300){
            JOptionPane.showMessageDialog(null, "Tamanho inválido!","ERRO!",JOptionPane.WARNING_MESSAGE);
        } else {
            x2 = px + 100;
            y2 = 30;
            
        }
        
    
    
    }

    public void paintComponent( Graphics g ){
        super.paintComponent(g);
     
        //bobina
        //g.setColor(Color.blue);
        g.drawRect(100,30, 200,300);
        
        
        //pedido1
        g.setColor(Color.YELLOW);
        g.fillRect(100,30, (int)px,(int)py);
        
        
        //pedido2
        g.setColor(Color.ORANGE);
        g.fillRect((int)x2,(int)y2, (int)px2,(int)py2);
        
    }
    
    
    public static void main(String args[]){
        DesenhoCorte draw = new DesenhoCorte();
        JFrame frame = new JFrame();
        
        frame.setContentPane(draw);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(frame);
        frame.setVisible(true);
    
    }
   
    
}