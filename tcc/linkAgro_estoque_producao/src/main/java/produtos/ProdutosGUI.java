/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package produtos;

import produtos.ProdutoDAO;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import produtos.Produto;

/**
 *
 * @author C & F
 */
public class ProdutosGUI extends javax.swing.JFrame {

    public ProdutosGUI() {
        initComponents();
        tabela();
    }
    
    public void tabela(){
        ProdutoDAO produtodao = new ProdutoDAO();
        DefaultTableModel modelo = (DefaultTableModel) tab_produtos.getModel();
        
        while(tab_produtos.getModel().getRowCount() > 0 ){
            ((DefaultTableModel) tab_produtos.getModel()).removeRow(0);
        }
        
        try {
            List<Produto> produtoList = produtodao.categoriaBox();

            for (Produto produto : produtoList) {
                
                Object[] line = {produto.getProduto()};
                modelo.addRow(line);
                
            }
            produtodao.paintCat(tab_produtos, 0);

        } 
        catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Falha ao listar usuários cadastrados!" + e.getMessage(), "ERRO", JOptionPane.WARNING_MESSAGE);

        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tab_produtos = new javax.swing.JTable();
        btn_newProduct = new javax.swing.JButton();
        btn_deleteProduct = new javax.swing.JButton();
        btn_updateProduct = new javax.swing.JButton();
        btn_voltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Produtos");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tab_produtos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tab_produtos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produtos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tab_produtos.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jScrollPane5.setViewportView(tab_produtos);

        btn_newProduct.setBackground(new java.awt.Color(255, 255, 255));
        btn_newProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/adicionar.png"))); // NOI18N
        btn_newProduct.setText("Adicionar Produto");
        btn_newProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newProductActionPerformed(evt);
            }
        });

        btn_deleteProduct.setBackground(new java.awt.Color(255, 255, 255));
        btn_deleteProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/excluir.png"))); // NOI18N
        btn_deleteProduct.setText("Deletar Produto");
        btn_deleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteProductActionPerformed(evt);
            }
        });

        btn_updateProduct.setBackground(new java.awt.Color(255, 255, 255));
        btn_updateProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/editar (2).png"))); // NOI18N
        btn_updateProduct.setText("Editar Produto");
        btn_updateProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateProductActionPerformed(evt);
            }
        });

        btn_voltar.setBackground(new java.awt.Color(255, 255, 255));
        btn_voltar.setBorder(null);
        btn_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_voltarActionPerformed(evt);
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
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_updateProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_deleteProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_newProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_voltar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(btn_voltar)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_newProduct)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_updateProduct)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_deleteProduct))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        //Adicionar novo produto
    private void btn_newProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newProductActionPerformed
        ProdutoDAO ordemproducaodao = new ProdutoDAO();
        CProdutoGUI window = new CProdutoGUI();
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        
        /* String produto = JOptionPane.showInputDialog(null,"Digite o nome do novo produto a ser adicionado");
 
        if(produto.equals("")){
          JOptionPane.showMessageDialog(null, "Nome inválido","AVISO!",JOptionPane.WARNING_MESSAGE);
        } else {
            ordemproducaodao.adicionaProduto(produto);
        }
        */        
    }//GEN-LAST:event_btn_newProductActionPerformed

    //Deletar produto
    private void btn_deleteProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteProductActionPerformed
        ProdutoDAO produtodao = new ProdutoDAO();
        
        int linhaSelecionada = -1;
        linhaSelecionada = tab_produtos.getSelectedRow();
        if(linhaSelecionada >= 0){
            String produto = (String) tab_produtos.getValueAt(linhaSelecionada, 0);
            switch(JOptionPane.showConfirmDialog(null,"Deseja mesmo DELETAR o produto "+ produto + " ?","Deletar protudo",JOptionPane.YES_NO_OPTION)){
                case JOptionPane.YES_OPTION:
                produtodao.deleteProdutos(produto);
                tabela();
                break;
            }
        } else {
            JOptionPane.showMessageDialog(null,"Selecione o produto que deseja deletar.");
        }
    }//GEN-LAST:event_btn_deleteProductActionPerformed

    //Atualizar produto
    boolean edit = false;
    private void btn_updateProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateProductActionPerformed
        
        int linhaSelecionada = -1;
        linhaSelecionada = tab_produtos.getSelectedRow();
        if(linhaSelecionada >= 0){
            CProdutoGUI window = new CProdutoGUI();
            window.setVisible(true);
            window.setLocationRelativeTo(null);
            edit = true;
            window.fillFilds(String.valueOf(tab_produtos.getValueAt(linhaSelecionada, 0)));
            
        } else {
            JOptionPane.showMessageDialog(null,"Selecione o produto que deseja editar.");
        }
        
        
    }//GEN-LAST:event_btn_updateProductActionPerformed

    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        dispose();
    }//GEN-LAST:event_btn_voltarActionPerformed

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
            java.util.logging.Logger.getLogger(ProdutosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProdutosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProdutosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProdutosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProdutosGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_deleteProduct;
    private javax.swing.JButton btn_newProduct;
    private javax.swing.JButton btn_updateProduct;
    private javax.swing.JButton btn_voltar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tab_produtos;
    // End of variables declaration//GEN-END:variables
}