import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class RectanglePanel extends JPanel {
    private Rectangle bigRectangle;
    private List<Rectangle> smallRectangles;

    public RectanglePanel(int bigWidth, int bigHeight) {
        bigRectangle = new Rectangle(50, 50, bigWidth, bigHeight);
        smallRectangles = new ArrayList<>();
    }

    private boolean canDraw(Rectangle newRect) {
        for (Rectangle existingRect : smallRectangles) {
            if (existingRect.intersects(newRect)) {
                return false; // Sobreposição detectada entre retângulos menores
            }
        }
        return bigRectangle.contains(newRect); // Permite sobreposição com o retângulo grande
    }

    public void drawRectangles(int numRectangles, float largBob, float metBob) {
        smallRectangles.clear(); // Limpa os retângulos existentes

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < numRectangles; i++) {
            int newX, newY, newWidth, newHeight;

            if (smallRectangles.isEmpty()) {
                // O primeiro retângulo menor começa onde o retângulo maior começa
                newX = bigRectangle.x;
                newY = bigRectangle.y;
            } else {
                // Tentar colocar o próximo retângulo ao lado do anterior
                Rectangle lastRect = smallRectangles.get(smallRectangles.size() - 1);
                newX = lastRect.x + lastRect.width;
                newY = lastRect.y;

                if (newX + lastRect.width > bigRectangle.x + bigRectangle.width) {
                    // Se não couber ao lado, tente colocar abaixo do anterior
                    newX = bigRectangle.x;
                    newY = lastRect.y + lastRect.height;
                }
            }

            System.out.print("Digite a largura do retângulo " + (i + 1) + " em pixels: ");
            int smallWidth = scanner.nextInt();

            System.out.print("Digite o comprimento do retângulo " + (i + 1) + " em pixels: ");
            int smallHeight = scanner.nextInt();

            int intLarg = Math.round(largBob);
            int intMet = Math.round(metBob);
            
            newWidth = (int) smallWidth * 200 / intLarg;
            newHeight = (int) smallHeight * 300 / intMet;

            Rectangle newRect = new Rectangle(newX, newY, newWidth, newHeight);

            if (canDraw(newRect)) {
                smallRectangles.add(newRect);
            } else {
                System.out.println("Não é possível desenhar um novo retângulo sem sobreposição.");
                //i--; // Reduz o índice para tentar novamente com o mesmo número de retângulos
            }
        }

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(bigRectangle.x, bigRectangle.y, bigRectangle.width, bigRectangle.height);

        for (Rectangle rect : smallRectangles) {
            g.drawRect(rect.x, rect.y, rect.width, rect.height);
        }
    }
}

public class RectangleDrawer extends JFrame {
    private RectanglePanel rectanglePanel;

    public RectangleDrawer(int bigWidth, int bigHeight) {
        rectanglePanel = new RectanglePanel(bigWidth, bigHeight);

        setTitle("Rectangle Drawer");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        add(rectanglePanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Digite a largura do retângulo maior em pixels: ");
            int bigWidth = scanner.nextInt();

            System.out.print("Digite a altura do retângulo maior em pixels: ");
            int bigHeight = scanner.nextInt();

            System.out.print("Digite o número de retângulos menores: ");
            int numRectangles = scanner.nextInt();
            
            
            RectangleDrawer drawer = new RectangleDrawer(200, 300);
            drawer.setVisible(true);

            drawer.rectanglePanel.drawRectangles(numRectangles, bigWidth, bigHeight);
        });
    }
}