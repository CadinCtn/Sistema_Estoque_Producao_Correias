/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ordem_producao;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pedidos.Pedido;
import pedidos.PedidoDAO;

/**
 *
 * @author Lenovo
 */
public class CPedidoOpGUI extends javax.swing.JFrame {

    /**
     * Creates new form CPedidoOpGUI
     */
    public CPedidoOpGUI() {
        initComponents();
        tabela();
    }

    
    //Método para popular a tabela pedidos op com os pedidos cadastrados
    public void tabela(){
        PedidoDAO pedidodao = new PedidoDAO();
        DefaultTableModel modelo = (DefaultTableModel) tab_pedidos.getModel();
        
        // Inserindo itens na tabela
        List<Pedido> pedidoList = pedidodao.selectPedidos();
        for (Pedido pedido : pedidoList) {
            
            Object[] line = {pedido.getId(), pedido.getNomeCliente(), pedido.getFechamento(),pedido.getEmbarque(),pedido.getObservacao()};
            modelo.addRow(line);
            
        }
        
    }
    
        private void selectPedido(int idPedido) {
        DefaultTableModel model = (DefaultTableModel) tab_pedidos.getModel();
        
        for (int i = 0; i < model.getRowCount(); i++) {
            int id = Integer.parseInt(String.valueOf(model.getValueAt(i, 0))); // Coluna ID

            if (id == idPedido) {
                tab_pedidos.getSelectionModel().setSelectionInterval(i, i);
                break;
            }
        }
    }
    
    
    String cod;
    boolean edit = false;
    int indexRow = -1;
   // Preenchendo campos quando editar
    public void fillFields(int index, boolean edit, String id, String largura, String metragem, String cod){
        largField.setText(largura);
        metField.setText(metragem);
        
        selectPedido(Integer.valueOf(id));
        this.cod = cod;
        
        
        this.edit = edit;
        this.indexRow = index;
    }
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tab_pedidos = new javax.swing.JTable();
        button_return = new javax.swing.JButton();
        largField = new javax.swing.JTextField();
        metField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        button_confirm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pedido Op");

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

        largField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                largFieldActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Largura:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Metragem:");

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(button_return)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(metField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(largField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(button_confirm)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(button_return)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(largField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(metField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(button_confirm)
                .addGap(20, 20, 20))
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

    private void largFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_largFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_largFieldActionPerformed

    private void button_confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_confirmActionPerformed
        int selectedLine = -1;
        selectedLine = tab_pedidos.getSelectedRow();
        if(selectedLine >= 0){
            if(largField.getText().isEmpty() || metField.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Preencha a largura e a metragem!");
            } else {
                if(edit){
                    CUOrdemProducaoGUI cuopgui = ControllerOP.getCUOrdemProducao();

                    PedidoOp pedidoop = new PedidoOp();
                    pedidoop.setId((int) tab_pedidos.getValueAt(selectedLine,0));
                    pedidoop.setNome_cliente((String) tab_pedidos.getValueAt(selectedLine,1));
                    pedidoop.setLargura(Float.valueOf(largField.getText()));
                    pedidoop.setMetragem(Float.valueOf(metField.getText()));
                    

                        //try para editar pedido que não esta no banco de dados ainda
                            try{
                                pedidoop.setCod(Integer.valueOf(cod));
                                
                                //Edita o pedido que está cadastrado no banco de dados
                                PedidoOpDAO pedidoopdao = new PedidoOpDAO();

                                pedidoopdao.updatePedidoOp(pedidoop, pedidoop.getCod());
                                cuopgui.addRow(pedidoop, edit,indexRow);

                            }
                            catch(Exception e){
                                //Retirando pedido da tabela
                                cuopgui.addRow(pedidoop, edit,indexRow);
                                    
                            }
                } else {
                        
                        //Criando objeto
                        PedidoOp pedidoop = new PedidoOp();

                        pedidoop.setId((int) tab_pedidos.getValueAt(selectedLine,0));
                        pedidoop.setNome_cliente((String) tab_pedidos.getValueAt(selectedLine,1));
                        pedidoop.setLargura(Float.valueOf(largField.getText()));
                        pedidoop.setMetragem(Float.valueOf(metField.getText()));

                        //Adicionando o pedido com as medidas especificadas a tabela do CUOrdemProducaoGUI
                        CUOrdemProducaoGUI cuopgui = ControllerOP.getCUOrdemProducao();
                        cuopgui.addRow(pedidoop,edit, indexRow);

                        
                }        
            dispose();
            }
                
        } else {
            JOptionPane.showMessageDialog(null,"Selecione um pedido");
        }

    }//GEN-LAST:event_button_confirmActionPerformed

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
            java.util.logging.Logger.getLogger(CPedidoOpGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CPedidoOpGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CPedidoOpGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CPedidoOpGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CPedidoOpGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_confirm;
    private javax.swing.JButton button_return;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField largField;
    private javax.swing.JTextField metField;
    private javax.swing.JTable tab_pedidos;
    // End of variables declaration//GEN-END:variables
}
