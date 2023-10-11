/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pedidos;


import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Lenovo
 */
public class CPedidosGUI extends javax.swing.JFrame {

    /**
     * Creates new form CPedidosGUI
     */
    public CPedidosGUI() {
        initComponents();
        tabela();
    }

    
    
    public void tabela(){
        PedidoDAO pedidodao = new PedidoDAO();
        DefaultTableModel modelo = (DefaultTableModel) tab_pedidos.getModel();
        
        
        while(tab_pedidos.getModel().getRowCount() > 0 ){
            ((DefaultTableModel) tab_pedidos.getModel()).removeRow(0);
        }
        
        
        List<Pedido> pedidoList = pedidodao.selectPedidos();
        for (Pedido pedido : pedidoList) {
            
            Object[] line = {pedido.getId(), pedido.getNomeCliente(), pedido.getFechamento(),pedido.getEmbarque(),pedido.getObservacao()};
            modelo.addRow(line);
            
        }
        
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tab_pedidos = new javax.swing.JTable();
        add_pedido = new javax.swing.JButton();
        upd_pedido = new javax.swing.JButton();
        del_pedido = new javax.swing.JButton();

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
        jScrollPane5.setViewportView(tab_pedidos);
        if (tab_pedidos.getColumnModel().getColumnCount() > 0) {
            tab_pedidos.getColumnModel().getColumn(0).setMinWidth(100);
            tab_pedidos.getColumnModel().getColumn(0).setPreferredWidth(100);
            tab_pedidos.getColumnModel().getColumn(0).setMaxWidth(100);
            tab_pedidos.getColumnModel().getColumn(1).setMinWidth(250);
            tab_pedidos.getColumnModel().getColumn(1).setPreferredWidth(250);
            tab_pedidos.getColumnModel().getColumn(2).setMinWidth(125);
            tab_pedidos.getColumnModel().getColumn(2).setPreferredWidth(125);
            tab_pedidos.getColumnModel().getColumn(2).setMaxWidth(125);
            tab_pedidos.getColumnModel().getColumn(3).setMinWidth(125);
            tab_pedidos.getColumnModel().getColumn(3).setPreferredWidth(125);
            tab_pedidos.getColumnModel().getColumn(3).setMaxWidth(125);
            tab_pedidos.getColumnModel().getColumn(4).setMinWidth(150);
            tab_pedidos.getColumnModel().getColumn(4).setPreferredWidth(150);
        }

        add_pedido.setBackground(new java.awt.Color(255, 255, 255));
        add_pedido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add_pedido.setText("Adicionar");
        add_pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_pedidoActionPerformed(evt);
            }
        });

        upd_pedido.setBackground(new java.awt.Color(255, 255, 255));
        upd_pedido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        upd_pedido.setText("Editar");
        upd_pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upd_pedidoActionPerformed(evt);
            }
        });

        del_pedido.setBackground(new java.awt.Color(255, 255, 255));
        del_pedido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        del_pedido.setText("Excluir");
        del_pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                del_pedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(add_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(upd_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(del_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_pedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(upd_pedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(del_pedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void add_pedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_pedidoActionPerformed
        PedidoDAO pedidodao = new PedidoDAO();
        pedidodao.insertPedido(pedidodao.paneJOP(null,null,null,null,null));
        JOptionPane.showMessageDialog(null,"Pedido adicionado com sucesso!");
        tabela();
    }//GEN-LAST:event_add_pedidoActionPerformed

    private void upd_pedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upd_pedidoActionPerformed
      int linhaSelecionada = -1;
    linhaSelecionada = tab_pedidos.getSelectedRow();
        if(linhaSelecionada >=0){
            int id = (int) tab_pedidos.getValueAt(linhaSelecionada, 0);
            
            PedidoDAO pedidodao = new PedidoDAO();
            
            String Id =  tab_pedidos.getValueAt(linhaSelecionada, 0).toString();
            String nome = (String) tab_pedidos.getValueAt(linhaSelecionada, 1);
            String fechamento = (String) tab_pedidos.getValueAt(linhaSelecionada, 2);
            String embarque = (String) tab_pedidos.getValueAt(linhaSelecionada, 3);
            String obs = (String) tab_pedidos.getValueAt(linhaSelecionada, 4);
          
            pedidodao.updatePedido(pedidodao.paneJOP(Id, nome, fechamento, embarque, obs), id);
            tabela();
        } else {
            JOptionPane.showMessageDialog(null,"Selecione o pedido que deseja editar.");
        }
        

            
    }//GEN-LAST:event_upd_pedidoActionPerformed

    private void del_pedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_del_pedidoActionPerformed
    int linhaSelecionada = -1;
    linhaSelecionada = tab_pedidos.getSelectedRow();
        if(linhaSelecionada >=0){
            
            switch(JOptionPane.showConfirmDialog(null,"Deseja mesmo excluir esse pedido?","Aviso",JOptionPane.YES_NO_OPTION)){
                case JOptionPane.YES_OPTION:    
                PedidoDAO pedidodao = new PedidoDAO(); 
                int id = (int) tab_pedidos.getValueAt(linhaSelecionada, 0);
                pedidodao.deletePedido(id);
                tabela();
                
            break;
            }
            
        } else {
            JOptionPane.showMessageDialog(null,"Selecione o pedido que deseja excluir");
        }
        

    }//GEN-LAST:event_del_pedidoActionPerformed

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
            java.util.logging.Logger.getLogger(CPedidosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CPedidosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CPedidosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CPedidosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CPedidosGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_pedido;
    private javax.swing.JButton del_pedido;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tab_pedidos;
    private javax.swing.JButton upd_pedido;
    // End of variables declaration//GEN-END:variables
}
