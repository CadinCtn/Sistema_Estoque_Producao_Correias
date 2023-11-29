
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;


class Testes extends JPanel {
    
    
    public Testes(){
        this.setFocusable(true);
        this.setBackground(Color.white);
        
        
    }

   /* 
    public void paint(Graphics g){
        super.paint(g);
        g.drawString("Teste", 20, 20);
    }
    */
    
    public void desenharRetangulo(int x, int y, int largura, int comprimeto){
        Graphics2D g2d = (Graphics2D) this.getGraphics();
        
        //desenhando formas
        g2d.drawRect(x, y, largura, comprimeto);
        
    }
    
}
