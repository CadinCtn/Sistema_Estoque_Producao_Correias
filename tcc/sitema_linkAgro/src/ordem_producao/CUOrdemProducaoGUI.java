/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordem_producao;

import produtos.ProdutoDAO;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import produtos.Produto;

public class CUOrdemProducaoGUI extends javax.swing.JFrame {

    public void categoriaBox(){
        ProdutoDAO produtodao = new ProdutoDAO();
        
        box_category.removeAllItems();
        
        try{
            List<Produto> produtoList = produtodao.categoriaBox();
            
            for(Produto produto : produtoList){
                box_category.addItem(produto.getProduto()); 
        }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void setEdit(boolean edit){
        
    }
    
    int id;
    boolean edit = false;
    
    public void fillFields(boolean edit, int id, String categoria, String ee, String width, String length, String lonas, String setor, String observation){
        
        if(edit){
            
            box_category.setSelectedItem(categoria);
            box_ee.setSelectedItem(ee);
            box_width.setSelectedItem(width);
            field_length.setText(String.valueOf(length));
            box_lonas.setSelectedItem(lonas);
            field_sector.setText(setor);
            field_observation.setText(observation);
            this.id = id;
            this.edit = edit;
            
        }
    }
    
    public void cU (OrdemProducao op, boolean edit, int id){
        OrdemProducaoDAO opdao = new OrdemProducaoDAO();
        if(edit){
            opdao.updadeOrdemProducao(op, id);
        } else {
            
            opdao.insertOrdemProducao(op);
        }
    }
    
    
    public CUOrdemProducaoGUI() {
        initComponents();
        categoriaBox();
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        label_category = new javax.swing.JLabel();
        label_ee = new javax.swing.JLabel();
        label_width = new javax.swing.JLabel();
        label_length = new javax.swing.JLabel();
        label_lonas = new javax.swing.JLabel();
        label_obs = new javax.swing.JLabel();
        box_category = new javax.swing.JComboBox<>();
        button_addCategory = new javax.swing.JButton();
        field_length = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        field_observation = new javax.swing.JTextArea();
        button_addOrder = new javax.swing.JButton();
        box_ee = new javax.swing.JComboBox<>();
        box_width = new javax.swing.JComboBox<>();
        box_lonas = new javax.swing.JComboBox<>();
        button_confirm = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tab_pedidosOp = new javax.swing.JTable();
        label_sector = new javax.swing.JLabel();
        field_sector = new javax.swing.JTextField();
        button_delete = new javax.swing.JButton();
        button_return = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerar ordem de produção");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        label_category.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_category.setText("Categoria");

        label_ee.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_ee.setText("EE");

        label_width.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_width.setText("Largura Tecido");

        label_length.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_length.setText("Metragem Tecido");

        label_lonas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_lonas.setText("Lonas");

        label_obs.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_obs.setText("Observação");

        box_category.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        box_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box_categoryActionPerformed(evt);
            }
        });

        button_addCategory.setBackground(new java.awt.Color(255, 255, 255));
        button_addCategory.setText("+");
        button_addCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_addCategoryActionPerformed(evt);
            }
        });

        field_length.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        field_observation.setColumns(20);
        field_observation.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        field_observation.setRows(5);
        jScrollPane1.setViewportView(field_observation);

        button_addOrder.setBackground(new java.awt.Color(255, 255, 255));
        button_addOrder.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        button_addOrder.setText("Adicionar Pedido");
        button_addOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_addOrderActionPerformed(evt);
            }
        });

        box_ee.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        box_ee.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "90", "100", "125", "140" }));
        box_ee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box_eeActionPerformed(evt);
            }
        });

        box_width.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        box_width.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "16", "20", "24", "28" }));

        box_lonas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        box_lonas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "3", "4", "5", "6", "8", "10" }));

        button_confirm.setBackground(new java.awt.Color(255, 255, 255));
        button_confirm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        button_confirm.setText("Confirmar");
        button_confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_confirmActionPerformed(evt);
            }
        });

        tab_pedidosOp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tab_pedidosOp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome do Cliente", "Largura ", "Metragem"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tab_pedidosOp);

        label_sector.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_sector.setText("Setor");

        field_sector.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        button_delete.setBackground(new java.awt.Color(255, 255, 255));
        button_delete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        button_delete.setText("Remover Pedido");

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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_sector)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(field_sector, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(label_category)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(button_addCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addComponent(box_category, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(label_ee)
                                            .addComponent(box_ee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(box_width, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label_width))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(label_length)
                                            .addComponent(field_length, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(box_lonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label_lonas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(button_return))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_obs)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(button_addOrder)
                        .addGap(18, 18, 18)
                        .addComponent(button_delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button_confirm)
                        .addGap(36, 36, 36))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_obs)
                    .addComponent(button_return))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button_addOrder)
                            .addComponent(button_confirm)
                            .addComponent(button_delete))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_category)
                            .addComponent(label_ee)
                            .addComponent(label_width)
                            .addComponent(label_length)
                            .addComponent(button_addCategory)
                            .addComponent(label_lonas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(box_category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(box_ee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(box_width, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(field_length, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(box_lonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(label_sector)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(field_sector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
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

    private void button_returnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_returnActionPerformed
        // TODO add your handling code here:
        JFrame window = new ROrdemProducaoGUI();
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        dispose();

    }//GEN-LAST:event_button_returnActionPerformed

    private void button_confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_confirmActionPerformed
        if(field_length.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Preencha todos os campos necessários para gerar a Ordem de Produção","Aviso",JOptionPane.WARNING_MESSAGE);
        } else {
        
        OrdemProducao op = new OrdemProducao();
        op.setCategoria(String.valueOf(box_category.getSelectedItem()));
        op.setEe(Integer.valueOf(String.valueOf(box_ee.getSelectedItem())));
        op.setLarguraTecido(Float.valueOf(String.valueOf(box_width.getSelectedItem())));
        op.setMetragemTecido(Float.valueOf(field_length.getText()));
        op.setLonas(Integer.valueOf(String.valueOf(box_lonas.getSelectedItem())));
        op.setSetor(field_sector.getText());
        op.setObservacao(field_observation.getText());
        
        cU(op,edit,id);

        JFrame window = new ROrdemProducaoGUI();
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        dispose();
        }

    }//GEN-LAST:event_button_confirmActionPerformed

    private void box_eeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box_eeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_box_eeActionPerformed

    private void button_addCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_addCategoryActionPerformed
        ProdutoDAO ordemproducaodao = new ProdutoDAO();
        String produto = JOptionPane.showInputDialog(null,"Digite o nome do novo produto a ser adicionado");

        if(produto.equals("")){
            JOptionPane.showMessageDialog(null, "Nome inválido");
        } else {
            ordemproducaodao.adicionaProduto(produto);
        }

        categoriaBox();
    }//GEN-LAST:event_button_addCategoryActionPerformed

    private void box_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box_categoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_box_categoryActionPerformed

    private void button_addOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_addOrderActionPerformed
        JFrame window = new PedidoOpGui();
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_button_addOrderActionPerformed

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
            java.util.logging.Logger.getLogger(CUOrdemProducaoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CUOrdemProducaoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CUOrdemProducaoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CUOrdemProducaoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CUOrdemProducaoGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> box_category;
    private javax.swing.JComboBox<String> box_ee;
    private javax.swing.JComboBox<String> box_lonas;
    private javax.swing.JComboBox<String> box_width;
    private javax.swing.JButton button_addCategory;
    private javax.swing.JButton button_addOrder;
    private javax.swing.JButton button_confirm;
    private javax.swing.JButton button_delete;
    private javax.swing.JButton button_return;
    private javax.swing.JTextField field_length;
    private javax.swing.JTextArea field_observation;
    private javax.swing.JTextField field_sector;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_category;
    private javax.swing.JLabel label_ee;
    private javax.swing.JLabel label_length;
    private javax.swing.JLabel label_lonas;
    private javax.swing.JLabel label_obs;
    private javax.swing.JLabel label_sector;
    private javax.swing.JLabel label_width;
    private javax.swing.JTable tab_pedidosOp;
    // End of variables declaration//GEN-END:variables
}
