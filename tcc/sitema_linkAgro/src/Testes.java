import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class Testes extends JFrame {

    private JTable tabela;
    private DefaultTableModel modelo;

    public Testes() {
        // Criar uma tabela com alguns dados de exemplo
        modelo = new DefaultTableModel();
        modelo.addColumn("Nome");
        modelo.addColumn("Valor");

        // Adicionar alguns dados de exemplo
        modelo.addRow(new Object[]{"Item 1", 10});
        modelo.addRow(new Object[]{"Item 2", 20});
        modelo.addRow(new Object[]{"Item 3", 30});

        tabela = new JTable(modelo);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Permite apenas uma seleção por vez

        // Adicionar o ListSelectionListener para a tabela
        tabela.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    // A ação que você quer realizar quando um item é selecionado vai aqui
                    int linhaSelecionada = tabela.getSelectedRow();
                    if (linhaSelecionada != -1) {
                        String nome = (String) tabela.getValueAt(linhaSelecionada, 0);
                        int valor = (int) tabela.getValueAt(linhaSelecionada, 1);
                        System.out.println("Item selecionado: " + nome + ", Valor: " + valor);
                        // Faça o que você quiser com os dados selecionados
                    }
                }
            }
        });

        // Adicionar a tabela a um JScrollPane
        JScrollPane scrollPane = new JScrollPane(tabela);

        // Configuração básica do JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        // Adicionar o JScrollPane ao JFrame
        getContentPane().add(scrollPane);

        // Exibir o JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        new Testes();
    }
}
