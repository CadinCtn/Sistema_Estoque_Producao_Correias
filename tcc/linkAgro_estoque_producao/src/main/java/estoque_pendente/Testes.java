package estoque_pendente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import ordem_producao.OrdemProducao;

class Retangulo {
    int x, y, largura, altura;

    public Retangulo(int x, int y, int largura, int altura) {
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;
    }

    public boolean contemPonto(int px, int py) {
        return px >= x && px <= x + largura && py >= y && py <= y + altura;
    }

    public boolean sobrepostoCom(Retangulo outro) {
        return this.x < outro.x + outro.largura &&
               this.x + this.largura > outro.x &&
               this.y < outro.y + outro.altura &&
               this.y + this.altura > outro.y;
    }

    public boolean bordasProximas(Retangulo r1, Retangulo r2, int distancia) {
    return Math.abs(r1.x - r2.x) <= distancia ||
           Math.abs(r1.x + r1.largura - (r2.x + r2.largura)) <= distancia ||
           Math.abs(r1.y - r2.y) <= distancia ||
           Math.abs(r1.y + r1.altura - (r2.y + r2.altura)) <= distancia;
}

    
    
    public void moverPara(int novoX, int novoY) {
        this.x = novoX;
        this.y = novoY;
    }

    public void desenhar(Graphics g, String medida) {
        g.drawRect(x, y, largura, altura);
        g.drawString(medida, x + 3, y + 12);
    }
}

class DesenhoPanel extends JPanel {
    public OrdemProducao op;
    public List<Retangulo> retangulos = new ArrayList<>();
    private List<Retangulo> tWall = new ArrayList<>();
    private Retangulo retanguloAtual;
    private final int TAMANHO_GRADE = 1; // Tamanho da célula na grade
    public DesenhoPanel() {
        tWall.add(new Retangulo(-600, -600, 640, 1400)); //esquerda
        tWall.add(new Retangulo(40, -400, 2000, 440)); // cima
        tWall.add(new Retangulo(40, 340, 2000, 600)); // baixo
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                boolean sobreposto = false;
                for (Retangulo retangulo : retangulos) {
                    if (retangulo.contemPonto(e.getX(), e.getY())) {
                        sobreposto = true;
                        retanguloAtual = retangulo;
                        e.getPoint();
                        return;
                    }
                }

                if (!sobreposto) {
                    // Se não clicou em um retângulo existente, cria um novo
                    Retangulo novoRetangulo = new Retangulo(
                            snapToGrid(e.getX(), TAMANHO_GRADE),
                            snapToGrid(e.getY(), TAMANHO_GRADE),
                            100,
                            50
                    );
                
                
                    // Verifica sobreposição com retângulos existentes
                    while (sobreposicaoComRetangulos(novoRetangulo)) {
                        // Move o novo retângulo para a margem do retângulo existente
                        novoRetangulo.moverPara(
                                novoRetangulo.x + TAMANHO_GRADE,
                                novoRetangulo.y + TAMANHO_GRADE
                        );
                    }

                    retangulos.add(novoRetangulo);
                    repaint();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                retanguloAtual = null;
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                    if (retanguloAtual != null) {
                        int novoX = snapToGrid(e.getX(), TAMANHO_GRADE) - retanguloAtual.largura/2;
                        int novoY = snapToGrid(e.getY(), TAMANHO_GRADE) - retanguloAtual.altura/2;

                        // Verifica sobreposição com retângulos existentes
                        Retangulo novoRetangulo = new Retangulo(novoX, novoY, retanguloAtual.largura, retanguloAtual.altura);
                        while (sobreposicaoComRetangulos(novoRetangulo)) {
                            
                            // Move o novo retângulo para a margem do retângulo existente
                            novoRetangulo.moverPara(
                                    novoRetangulo.x + TAMANHO_GRADE,
                                    novoRetangulo.y + TAMANHO_GRADE
                            );
                        }


                        retanguloAtual.moverPara(novoRetangulo.x, novoRetangulo.y);
                        repaint();
                    }
            }
        });
    }

    private int snapToGrid(int valor, int tamanhoCelula) {
        return Math.round(valor / (float) tamanhoCelula) * tamanhoCelula;
    }

    private boolean sobreposicaoComRetangulos(Retangulo novoRetangulo) {
        for (Retangulo retangulo : retangulos) { 
            if (novoRetangulo.sobrepostoCom(retangulo) && retangulo != retanguloAtual || novoRetangulo.bordasProximas(novoRetangulo, retangulo, 5)) {
                return true;
            } 
        }
        for (Retangulo wall : tWall) {
            if (novoRetangulo.sobrepostoCom(wall) && wall != retanguloAtual) {
                return true;
            } 
        }
        
        return false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.red);
        for(Retangulo wall : tWall){
            wall.desenhar(g,"");
        }
        
        g.setColor(Color.black);
        Retangulo bobina = new Retangulo(40, 40, 200, 300);
        bobina.desenhar(g,"");
        g.drawString(String.valueOf(op.getLarguraTecido() + " X " + op.getMetragemTecido()), 40, 35);
        for (Retangulo retangulo : retangulos) {
            retangulo.desenhar(g,"10x14,28");
        }
    }
}

