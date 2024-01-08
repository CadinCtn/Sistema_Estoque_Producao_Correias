
package doc_arquivados;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import menus.Controller;
import ordem_producao.PedidoOp;
import ordem_producao.PedidoOpDAO;
import pedidos.Pedido;

/**
 *
 * @author Lenovo
 */
public class ArqvPedido extends javax.swing.JFrame {

    /**
     * Creates new form ArqvPedido
     */
    public ArqvPedido() {
        initComponents();
    }
    boolean edit = false;
    
    
    public void tabela(int id, List<Pedido> listArch){
        PedidoOpDAO pedidodao = new PedidoOpDAO();
        DefaultTableModel modeloArch = (DefaultTableModel) tab_pedidos.getModel();
        
        OpArqvDAO dao = new OpArqvDAO();
        
        List<PedidoOp> pedidoOpList = pedidodao.selectPedidoOp(id);
        for (PedidoOp pedidoop : pedidoOpList) {
            
            Pedido pedido = dao.selectPedidobyId(pedidoop.getId(), false);
            if(!listArch.contains(pedido)){
                    Object[] lineArch = {pedido.getId(),pedido.getNomeCliente(),pedido.getFechamento(),pedido.getEmbarque(),pedido.getObservacao()};
                    modeloArch.addRow(lineArch);
                    listArch.add(pedido);
            }
            
        }
        
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tab_pedidos = new javax.swing.JTable();
        button_return = new javax.swing.JButton();
        button_confirm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pedidos");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tab_pedidos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tab_pedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Pedido", "Nome Cliente", "Data Fechamento", "Data Embarque", "OBS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tab_pedidos.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jScrollPane5.setViewportView(tab_pedidos);

        button_return.setBackground(new java.awt.Color(255, 255, 255));
        button_return.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        button_return.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/botao-voltar (1).png"))); // NOI18N
        button_return.setBorder(null);
        button_return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_returnActionPerformed(evt);
            }
        });

        button_confirm.setBackground(new java.awt.Color(255, 255, 255));
        button_confirm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        button_confirm.setText("Confirmar");
        button_confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_confirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(button_return)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(219, 219, 219)
                .addComponent(button_confirm)
                .addGap(219, 219, 219))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(button_return)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(button_confirm)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_returnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_returnActionPerformed
        dispose();
    }//GEN-LAST:event_button_returnActionPerformed

    private void button_confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_confirmActionPerformed
        
        int selectedRow = -1;
        selectedRow = tab_pedidos.getSelectedRow();
        if(selectedRow>=0){
            if(edit){
                DefaultTableModel modelo = (DefaultTableModel) Controller.getcArqvOrdemProducaoGUI().tab_pedidos.getModel();
                modelo.removeRow(Controller.getcArqvOrdemProducaoGUI().selectedRow);
                
                Object[] line = {tab_pedidos.getValueAt(selectedRow, 0),tab_pedidos.getValueAt(selectedRow, 1), tab_pedidos.getValueAt(selectedRow, 2), tab_pedidos.getValueAt(selectedRow, 3), tab_pedidos.getValueAt(selectedRow, 4)};
                Controller.getcArqvOrdemProducaoGUI().addRow(line);
            
            }else{
                Object[] line = {tab_pedidos.getValueAt(selectedRow, 0),tab_pedidos.getValueAt(selectedRow, 1), tab_pedidos.getValueAt(selectedRow, 2), tab_pedidos.getValueAt(selectedRow, 3), tab_pedidos.getValueAt(selectedRow, 4)};
                Controller.getcArqvOrdemProducaoGUI().addRow(line);
            
            }
            dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Selecione um pedido");
        }
        
    }//GEN-LAST:event_button_confirmActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_confirm;
    private javax.swing.JButton button_return;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tab_pedidos;
    // End of variables declaration//GEN-END:variables
}
