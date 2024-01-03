
package doc_arquivados;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import ordem_producao.PedidoOp;
import ordem_producao.PedidoOpDAO;
import pedidos.Pedido;
import pedidos.PedidoDAO;

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

    
    
    public void tabela(int id){
        PedidoOpDAO pedidodao = new PedidoOpDAO();
        DefaultTableModel modeloArch = (DefaultTableModel) tab_pedidos.getModel();
        
        OpArqvDAO dao = new OpArqvDAO();
        List<Pedido> listPedidos = new ArrayList<>();
        
        List<PedidoOp> pedidoOpList = pedidodao.selectPedidoOp(id);
        for (PedidoOp pedidoop : pedidoOpList) {
            
            Pedido pedido = dao.selectPedidobyId(pedidoop.getId());
            if(!listPedidos.contains(pedido)){
                listPedidos.add(pedido);
                    Object[] lineArch = {pedido.getId(),pedido.getNomeCliente(),pedido.getFechamento(),pedido.getEmbarque(),pedido.getObservacao()};
                    modeloArch.addRow(lineArch);
            
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
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Confirmar");

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
                .addComponent(jButton1)
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
                .addComponent(jButton1)
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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ArqvPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ArqvPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ArqvPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ArqvPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ArqvPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_return;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tab_pedidos;
    // End of variables declaration//GEN-END:variables
}
