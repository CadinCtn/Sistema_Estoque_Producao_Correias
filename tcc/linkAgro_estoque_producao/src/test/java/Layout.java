import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Layout {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Exemplo de JDialog Interativo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Abrir JDialog");
        button.addActionListener(e -> abrirDialog(frame));

        frame.getContentPane().add(button);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    private static void abrirDialog(JFrame framePai) {
        JDialog dialog = new JDialog(framePai, "JDialog Interativo", true);

        JLabel label = new JLabel("Este é um JDialog que requer interação.");
        JButton closeButton = new JButton("Fechar");
        closeButton.addActionListener(e -> dialog.dispose());

        dialog.getContentPane().add(label);
        dialog.getContentPane().add(closeButton);

        dialog.setSize(200, 100);
        dialog.setLocationRelativeTo(framePai);
        dialog.setVisible(true);
    }
}
