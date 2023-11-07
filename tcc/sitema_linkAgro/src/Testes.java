import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Testes {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Exemplo JOptionPane com Ícone Personalizado");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        JButton showDialogButton = new JButton("Mostrar JOptionPane");
        showDialogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarJOptionPaneComIconePersonalizado(frame);
            }
        });

        frame.add(showDialogButton);
        frame.setVisible(true);
    }

    public static void mostrarJOptionPaneComIconePersonalizado(JFrame parentFrame) {
        // Crie um JPanel personalizado com um ícone e texto
        JPanel panel = new JPanel(new FlowLayout());
        ImageIcon icon = new ImageIcon("/icons/icon_clipboard.png"); // Substitua pelo caminho do seu ícone
        JLabel label = new JLabel("Esta é uma mensagem com um ícone personalizado", icon, SwingConstants.LEFT);
        panel.add(label);

        // Mostre o JOptionPane com o JPanel personalizado
        JOptionPane.showOptionDialog(parentFrame, panel, "Título do Diálogo", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, new Object[]{}, null);
    }
}
