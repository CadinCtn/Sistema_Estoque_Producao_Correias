
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
        
        
        
        float initX = 100;
        float initY = 30;
    
        x.add(initX);
        y.add(initY);
        
        for(int index = 1; index < in; index++){
        
            //if para posicionamento
            if(pix.get(index-1)+pix.get(index) > 200 && piy.get(index)+piy.get(index+1) <= 300){
                x2 = 100;
                y2 = piy.get(index-1)+30;
                x.add(x2);
                y.add(y2);
            }else if(pix.get(index)+pix.get(index+1) >200 && piy.get(index)+piy.get(index+1) >300){
                JOptionPane.showMessageDialog(null, "Tamanho inválido!","ERRO!",JOptionPane.WARNING_MESSAGE);
            } else {
                x2 = pix.get(index-1) + 100;
                y2 = 30;
                
                x.add(x2);
                y.add(y2);
            }
            System.out.println(x.get(index)+" "+y.get(index));
        }
    }

    public void paintComponent( Graphics g ){
        super.paintComponent(g);
     
        //bobina
        //g.setColor(Color.blue);
        g.drawRect(100,30, 200,300);
        
        
        int pedX1 = Math.round(pix.get(0));
        int pedY1 = Math.round(piy.get(0));
        
        //pedido1
        g.setColor(Color.ORANGE);
        g.drawRect(100,30, pedX1,pedY1);
        System.out.println(pedX1+ " " +pedY1);
        //proximos pedidos
        for(int index = 1; index <= x.size(); index++){
            
            int x1 = Math.round(x.get(index));
            int y1 = Math.round(y.get(index));
            
            int x2 = Math.round(pix.get(index));
            int y2 = Math.round(piy.get(index));
            
            
            g.setColor(Color.ORANGE);
            g.drawRect(x1,y1, x2,y2);
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