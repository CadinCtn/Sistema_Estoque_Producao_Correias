
package prototypes;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DesenhoCorte extends JPanel{
    
    
    private final float bx;
    private final float by;
    private float px;
    private float py;
    
    private float x2;
    private float y2;
    
    // lista dos pedidos
    ArrayList<Float> ex = new ArrayList<>();
    ArrayList<Float> ey = new ArrayList<>();
    
    //lista do tamnho do pixel dos pedidos
    ArrayList<Float> pix = new ArrayList<>();
    ArrayList<Float> piy = new ArrayList<>();
    
    //posicionamento
    ArrayList<Float> x = new ArrayList<>();
    ArrayList<Float> y = new ArrayList<>();
    
    public DesenhoCorte(){
        Dimension d = new Dimension(400,400);
        super.setPreferredSize(d);
        
        
        Scanner le = new Scanner(System.in);
        
        System.out.println("Tamanho Bobina:\nEixo X");
        bx = le.nextFloat();
        System.out.println("Eixo Y");
        by = le.nextFloat();
        

        System.out.println("/////////////////////\nQuantos pedidos sairao da bobina?\n");
        int in = le.nextInt();
        for(int i = 1; i <= in; i++){
            System.out.println("Tamanho Pedido " + i +":\nEixo X");
            px = le.nextFloat();
            ex.add(px);
            System.out.println("Eixo Y");
            py = le.nextFloat();
            ey.add(py);
        
        }
        
      
        for(int index = 0; index < ex.size(); index++){
            pix.add(ex.get(index) * 200 / bx);
            piy.add(ey.get(index) * 300 / by);
        }
        System.out.print("aaa");
        for(int index = 0; index < ex.size()-1; index++){
         System.out.print("aaa");
            //if para posicionamento
            if(pix.get(index)+pix.get(index+1) >= 200 && pix.get(index)+pix.get(index+1) <= 300){
                x2 = 100;
                y2 = piy.get(index)+30;
                x.add(x2);
                y.add(y2);
            }else if(pix.get(index)+pix.get(index+1) >200 && pix.get(index)+pix.get(index+1) >300){
                JOptionPane.showMessageDialog(null, "Tamanho inválido!","ERRO!",JOptionPane.WARNING_MESSAGE);
            } else {
                x2 = pix.get(index) + 100;
                y2 = 30;
                
                x.add(x2);
                y.add(y2);
                    
            }
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
        
        //proximos pedidos
        for(int index = 1; index <= ex.size(); index++){
            
            int x1 = Integer.valueOf(String.valueOf(pix.get(index-1)));
            int y1 = Integer.valueOf(String.valueOf(piy.get(index-1)));
            
            int x2 = Integer.valueOf(String.valueOf(pix.get(index)));
            int y2 = Integer.valueOf(String.valueOf(piy.get(index)));
            
            g.setColor(Color.ORANGE);
            g.fillRect(x1,y1, x2,y2);
        }
        
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