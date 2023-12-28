package imprimir;

import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import ordem_producao.OrdemProducao;
import ordem_producao.PedidoOp;

public class Preview extends JPanel {

    public Preview(){
        //Imprimir
        JButton btnPrint = new JButton("IMPRIMIR");
        btnPrint.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Adicionar o código que será executado quando o botão for clicado
                new ImprimirOp();
            }
        });
        btnPrint.setBounds(217, 5, 120, 30); // Posição e tamanho do botão
        add(btnPrint);
        
    }
    
        public void fillFilds(List<PedidoOp> listPedOp, OrdemProducao op){
            this.op = String.valueOf(op.getId());
            this.categoria = op.getCategoria();
            this.ee = String.valueOf(op.getEe());
            this.lonas = String.valueOf(op.getLonas());
            this.larg = String.valueOf(op.getLarguraTecido());
            this.met = String.valueOf(op.getMetragemTecido() + op.getMetExtra());
            this.espessura = op.getEspessura();
            this.obs = op.getObservacao();
            
            this.listPed = listPedOp;
        
            System.out.println(op.getCategoria());
            System.out.println(this.categoria);
            
        }
        
         String op = "";
         String categoria = "";
         String ee = "";
         String lonas = "";
         String larg = "";
         String met = "";
         String espessura = "";
         String obs = "";
         List<PedidoOp> listPed = new ArrayList<>();
        
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        int y;
        
        //Definindo número da OP
        g2d.setFont(new Font("Arial Black",Font.PLAIN, 22));
        g2d.drawString("OP: " + op, 35, 67);
        //
        
        //Caixa de especificações
        g2d.setStroke(new BasicStroke(2.25f));//Mudando espessura das linhas
        g2d.draw(new Rectangle2D.Double(35,72,500,50));
        //
        
        ////Especificações
        //Categoria
            g2d.setFont(new Font("Arial", Font.BOLD,16)); //Arial Negrito/BOLD
            g2d.drawString("Categoria:", 60, 90);
            g2d.setFont(new Font("Arial", Font.PLAIN,16)); //Arial Normal/PLAIN
            g2d.drawString(categoria,145,90);
        //EE
            g2d.setFont(new Font("Arial", Font.BOLD,16)); //Arial Negrito/BOLD
            g2d.drawString("EE:", 445, 90);
            g2d.setFont(new Font("Arial", Font.PLAIN,16)); //Arial Normal/PLAIN
            g2d.drawString(ee,475,90);
            
        //Lonas
            g2d.setFont(new Font("Arial", Font.BOLD,16)); //Arial Negrito/BOLD
            g2d.drawString("Lonas:", 60, 110);
            g2d.setFont(new Font("Arial", Font.PLAIN,16)); //Arial Normal/PLAIN
            g2d.drawString(lonas + "L", 120, 110);
        //
        //Medida
            g2d.setFont(new Font("Arial", Font.BOLD,16)); //Arial Negrito/BOLD
            g2d.drawString("Medida:", 155, 110);
            g2d.setFont(new Font("Arial", Font.PLAIN,16)); //Arial Normal/PLAIN
            g2d.drawString(larg+"\" X " + met + "mts",220,110);
        //
        //Espesura
            g2d.setFont(new Font("Arial", Font.BOLD,16)); //Arial Negrito/BOLD
            g2d.drawString("Espessura:", 385, 110);
            g2d.setFont(new Font("Arial", Font.PLAIN,16)); //Arial Normal/PLAIN
            g2d.drawString(espessura, 475, 110);
        //
        ////
        
        //Observação
            g2d.setFont(new Font("Arial Black", Font.PLAIN,16)); //Arial Negrito/BOLD
            g2d.drawString("Observação:", 40, 145);
            g2d.setFont(new Font("Arial", Font.PLAIN,16)); //Arial Normal/PLAIN
            
            y = 145;
            // Quebrando o texto em linhas
            String[] linhas = obs.split("\n");
            // Desenhando cada linha
            for (String linha : linhas) {
                g2d.drawString(linha, 155, y);
                y += g2d.getFontMetrics().getHeight();
            }
        //    
        
        ////Pedidos
        //Tabela
        g2d.setFont(new Font("Arial", Font.BOLD,16)); //Arial Negrito/BOLD
        y = g2d.getFontMetrics().getHeight();
        g2d.drawString("Pedidos:",35,255);
        g2d.draw(new Rectangle2D.Double(35,260,500,124));
        //
        //Colunas
        g2d.setFont(new Font("Arial", Font.BOLD,15)); //Arial Negrito/BOLD
        //id
        g2d.drawString("ID", 48, 275);
        g2d.drawRect(35, 260, 40, y);
        //nome cliente
        g2d.drawString("Nome Cliente", 85, 275);
        g2d.drawRect(75, 260, 370, y);
        //largura
        g2d.drawString("Larg.", 449, 275);
        g2d.drawRect(445, 260, 45, y);
        //metragem
        g2d.drawString("Met.", 494, 275);
        g2d.drawRect(490, 260, 45, y);
        //
        //Preenchento tabela
        g2d.setStroke(new BasicStroke(1.2f));//Espessura das linhas
        g2d.setFont(new Font("Arial", Font.PLAIN,14)); //Arial Negrito/BOLD
       
        y = 294;
        int yt = g2d.getFontMetrics().getHeight() + 262;
        //Preenchendo os dados
        for(PedidoOp linha : listPed){
            //id
            g2d.draw(new Rectangle2D.Double(35,yt,40,g2d.getFontMetrics().getHeight()+1));
            g2d.drawString(String.valueOf(linha.getId()),38, y);
           //nome
            Rectangle2D rectNome = new Rectangle2D.Double(75,yt,370,g2d.getFontMetrics().getHeight()+1);
            g2d.draw(rectNome);
            clipText(g2d, linha.getNome_cliente(), rectNome);
            //largura
            Rectangle2D rectLarg = new Rectangle2D.Double(445, yt, 45, g2d.getFontMetrics().getHeight()+1);
            g2d.draw(rectLarg);
            g2d.drawString(String.valueOf(linha.getLargura()), (int)rectLarg.getX()+1, y);
            //metragem
            Rectangle2D rectMet = new Rectangle2D.Double(490, yt, 45, g2d.getFontMetrics().getHeight()+1);
            g2d.draw(rectMet);
            g2d.drawString(String.valueOf(linha.getMetragem()), (int)rectMet.getX()+1, y);
           
            //proxima linha
            y+=g2d.getFontMetrics().getHeight()+1;
            yt+=g2d.getFontMetrics().getHeight()+1;
            
        }
        //
        ////
        
        ////Setores relatório
        //Calandra
        g2d.setFont(new Font("Arial Black", Font.PLAIN,14)); //Arial Negrito/BOLD
        g2d.drawString("Calandra:",40,415);
        g2d.setStroke(new BasicStroke(2.25f));//Mudando espessura das linhas
        g2d.draw(new Rectangle2D.Double(35,417,205,96));
        //Campos
        g2d.setFont(new Font("Consolas",Font.PLAIN,14));
        g2d.drawString("Data início: ___________",40,432);
        g2d.drawString("Hora Início: ___________", 40, 451);
        g2d.drawString("Hora Fim: ______________", 40, 468);
        g2d.drawString("Data Fim: ______________", 40, 485);
        g2d.drawString("Espessura: _____________", 40, 502);    
        g2d.drawString("Colaborador:", 252, 508);
        //
        
        //Prensa
        g2d.setFont(new Font("Arial Black", Font.PLAIN,14)); //Arial Negrito/BOLD
        g2d.drawString("Prensa:",40,532);
        g2d.draw(new Rectangle2D.Double(35,534,205,96));
        //Campos
        g2d.setFont(new Font("Consolas",Font.PLAIN,14));
        g2d.drawString("Data início: ___________",40,549);
        g2d.drawString("Hora Início: ___________", 40, 566);
        g2d.drawString("Hora Fim: ______________", 40, 583);
        g2d.drawString("Data Fim: ______________", 40, 600);
        g2d.drawString("Tempo (min.): __________", 40, 617);   
        g2d.drawString("Colaborador:", 252, 623);
        //
        
        //Corte
        g2d.setFont(new Font("Arial Black", Font.PLAIN,14)); //Arial Negrito/BOLD
        g2d.drawString("Corte:",40,649);
        g2d.draw(new Rectangle2D.Double(35,651,205,96));
        //Campos
        g2d.setFont(new Font("Consolas",Font.PLAIN,14));
        g2d.drawString("Data início: ___________",40,666);
        g2d.drawString("Hora Início: ___________", 40, 683);
        g2d.drawString("Hora Fim: ______________", 40, 700);
        g2d.drawString("Data Fim: ______________", 40, 717);
        g2d.drawString("Conserto:  SIM    NÃO", 40, 734);
        g2d.drawRect(157, 724, 12, 12);
        g2d.drawRect(212, 724, 12, 12);
        g2d.drawString("Colaborador:", 252, 740);
        //
        
        //Observações
        //Calandra
        g2d.setFont(new Font("Arial Black", Font.PLAIN,14)); //Arial Negrito/BOLD
        g2d.drawString("OBS Calandra:",255,415);
        g2d.draw(new Rectangle2D.Double(250,417,285,96));
        //Prensa
        g2d.drawString("OBS Prensa:",255,532);
        g2d.draw(new Rectangle2D.Double(250,534,285,96));
        //Corte
        g2d.drawString("OBS Corte:",255,649);
        g2d.draw(new Rectangle2D.Double(250,651,285,96));
        //
        ////
        
    }
    
   
    
    //método para escrever o nome do cliente na célula da tabela
     private void clipText(Graphics2D g2d, String text, Rectangle2D rect) {
        String originalText = text;

        // Obtém a largura disponível na célula
        int availableWidth = (int) rect.getWidth();

        // Obtém a largura do texto
        int textWidth = g2d.getFontMetrics().stringWidth(text);

        // Se o texto for mais largo do que a célula, corta e adiciona "..."
        if (textWidth > availableWidth) {
            while (textWidth > availableWidth && text.length() > 1) {
                // Remove um caractere do final do texto
                text = text.substring(0, text.length() - 1);

                // Recalcula a largura do texto
                textWidth = g2d.getFontMetrics().stringWidth(text + "...");
            }

            // Adiciona "..." ao final do texto
            text += "...";
        }

        // Desenha o texto na célula
        g2d.drawString(text, (int) rect.getX()+1, (int) (rect.getY() + g2d.getFontMetrics().getHeight())-1);

        // Restaura o texto original (sem "...")
        text = originalText;
    }

     public void frame(List<PedidoOp> listPed, OrdemProducao op, Preview print){
        //Criando JFrame para visualização
         fillFilds(listPed, op);
        JFrame frame = new JFrame("Imprimindo OP");
        Preview painel = print;
        frame.add(painel);
        frame.setSize(570, 877); // Tamanho ajustado para acomodar o retângulo
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(2);
        
        
        
     }
    
}
