/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordem_producao;


import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author aluno
 */
public class ROrdemProducaoGUI extends javax.swing.JFrame {

    /**
     * Creates new form ROrdemProducaoGUI
     */
    public ROrdemProducaoGUI() {
        initComponents();
        tabela();
    }

    public void tabela(){
        OrdemProducaoDAO opdao = new OrdemProducaoDAO();
        DefaultTableModel modelo = (DefaultTableModel) tab_ordemProducao.getModel();
        
        
        while(tab_ordemProducao.getModel().getRowCount() > 0 ){
            ((DefaultTableModel) tab_ordemProducao.getModel()).removeRow(0);
        }
        
        List<OrdemProducao> opList = opdao.selectOrdemProducao();
        for (OrdemProducao op : opList) {
            
            Object[] line = {op.getId(), op.getCategoria(), op.getEe(), op.getLarguraTecido(), op.getMetragemTecido(),op.getLonas(),op.getSetor(),op.getObservacao()};
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
        button_createOp = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab_ordemProducao = new javax.swing.JTable();
        button_update = new javax.swing.JButton();
        button_delete = new javax.swing.JButton();
        button_return = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        button_createOp.setBackground(new java.awt.Color(255, 255, 255));
        button_createOp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        button_createOp.setText("Gerar Ordem de Produção");
        button_createOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_createOpActionPerformed(evt);
            }
        });

        tab_ordemProducao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tab_ordemProducao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Categoria", "EE", "Largura", "Metragem", "Lonas", "Setor", "Observação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tab_ordemProducao);

        button_update.setBackground(new java.awt.Color(255, 255, 255));
        button_update.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        button_update.setText("Editar Ordem de Produção");
        button_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_updateActionPerformed(evt);
            }
        });

        button_delete.setBackground(new java.awt.Color(255, 255, 255));
        button_delete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        button_delete.setText("Deletar Ordem de Produção");
        button_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_deleteActionPerformed(evt);
            }
        });

        button_return.setBackground(new java.awt.Color(255, 255, 255));
        button_return.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        button_return.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/botao-voltar (1).png"))); // NOI18N
        button_return.setBorder(null);
        button_return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_returnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(button_createOp)
                        .addGap(18, 18, 18)
                        .addComponent(button_update)
                        .addGap(18, 18, 18)
                        .addComponent(button_delete))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 908, Short.MAX_VALUE)
                    .addComponent(button_return))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(button_return)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_createOp)
                    .addComponent(button_update)
                    .addComponent(button_delete))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                .addContainerGap())
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
    
    private void button_createOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_createOpActionPerformed
        // TODO add your handling code here:
        CUOrdemProducaoGUI window = new CUOrdemProducaoGUI();
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        Controller.setCUOrdemProducao(window);
        dispose();
    }//GEN-LAST:event_button_createOpActionPerformed

    private void button_returnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_returnActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_button_returnActionPerformed

    private void button_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_deleteActionPerformed
        // TODO add your handling code here:
        OrdemProducao op = new OrdemProducao();
        
        int row = -1;
        row = tab_ordemProducao.getSelectedRow();
        
        if(row >=0){
            
            switch(JOptionPane.showConfirmDialog(null,"Deseja mesmo excluir essa ordem de produção?","Aviso",JOptionPane.YES_NO_OPTION)){
                
                case JOptionPane.YES_OPTION:    
                    OrdemProducaoDAO opdao = new OrdemProducaoDAO(); 
                    op.setId(Integer.valueOf(String.valueOf(tab_ordemProducao.getValueAt(row, 0))));
                    opdao.deleteOrdemProducao(op.getId());
                    tabela();
                
                break;
            }
            
        } else {
            JOptionPane.showMessageDialog(null,"Selecione a ordem de produção que deseja excluir.");
        }
        
    }//GEN-LAST:event_button_deleteActionPerformed

    private void button_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_updateActionPerformed
        // TODO add your handling code here:
        OrdemProducao op = new OrdemProducao();
        
        int selectedRow = -1;
        selectedRow = tab_ordemProducao.getSelectedRow();
        
        if(selectedRow >= 0){
            CUOrdemProducaoGUI cuopg = new CUOrdemProducaoGUI();
            
            int id = Integer.valueOf(String.valueOf(tab_ordemProducao.getValueAt(selectedRow, 0)));
            String categoria = String.valueOf(tab_ordemProducao.getValueAt(selectedRow, 1));
            String ee = String.valueOf(tab_ordemProducao.getValueAt(selectedRow, 2));
            String width = String.valueOf(tab_ordemProducao.getValueAt(selectedRow, 3));
            String length = String.valueOf(tab_ordemProducao.getValueAt(selectedRow, 4));
            String lonas = String.valueOf(tab_ordemProducao.getValueAt(selectedRow, 5));
            String setor = String.valueOf(tab_ordemProducao.getValueAt(selectedRow, 6));
            String observacao = String.valueOf(tab_ordemProducao.getValueAt(selectedRow, 7));
            op.setEdit(true);
            
            cuopg.fillFields(op.getEdit(), id, categoria, ee, width, length, lonas, setor, observacao);
            
            
            cuopg.setVisible(true);
            cuopg.setLocationRelativeTo(null);
            dispose();
            
        } else {
            JOptionPane.showMessageDialog(null,"Selecione a ordem de produção que deseja editar.");
        }
        
    }//GEN-LAST:event_button_updateActionPerformed

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
            java.util.logging.Logger.getLogger(ROrdemProducaoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ROrdemProducaoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ROrdemProducaoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ROrdemProducaoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_createOp;
    private javax.swing.JButton button_delete;
    private javax.swing.JButton button_return;
    private javax.swing.JButton button_update;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tab_ordemProducao;
    // End of variables declaration//GEN-END:variables
}
