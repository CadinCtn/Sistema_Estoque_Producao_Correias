/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menus;

import estoque.CEstoqueGUI;
import ordem_producao.COrdemProducaoGUI;
import produtos.CProdutosGUI;
import javax.swing.JFrame;
import usuarios.CUsuarioGUI;

/**
 *
 * @author Senai
 */
public class MenuAdmGUI extends javax.swing.JFrame {
    
    /**
     * Creates new form MenuGUI
     */
    public MenuAdmGUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_new = new javax.swing.JMenu();
        submenu_newop = new javax.swing.JMenuItem();
        submenu_newUser = new javax.swing.JMenuItem();
        submenu_newproduct = new javax.swing.JMenuItem();
        submenu_estoque = new javax.swing.JMenuItem();
        menu_help = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 737, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 386, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));

        menu_new.setText("Novo");

        submenu_newop.setText("Ordem de produção");
        submenu_newop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenu_newopActionPerformed(evt);
            }
        });
        menu_new.add(submenu_newop);

        submenu_newUser.setText("Usuários");
        submenu_newUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenu_newUserActionPerformed(evt);
            }
        });
        menu_new.add(submenu_newUser);

        submenu_newproduct.setText("Produtos");
        submenu_newproduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenu_newproductActionPerformed(evt);
            }
        });
        menu_new.add(submenu_newproduct);

        submenu_estoque.setText("Estoque Correias");
        submenu_estoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenu_estoqueActionPerformed(evt);
            }
        });
        menu_new.add(submenu_estoque);

        jMenuBar1.add(menu_new);

        menu_help.setText("Ajuda");
        jMenuBar1.add(menu_help);

        setJMenuBar(jMenuBar1);

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

    private void submenu_newopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenu_newopActionPerformed
        
        JFrame window = new COrdemProducaoGUI();
        window.setVisible(true);
        window.setLocationRelativeTo(null);
    }//GEN-LAST:event_submenu_newopActionPerformed

    private void submenu_newUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenu_newUserActionPerformed
      
        JFrame window = new CUsuarioGUI();
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_submenu_newUserActionPerformed

    private void submenu_newproductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenu_newproductActionPerformed
        JFrame window = new CProdutosGUI();
        window.setVisible(true);
        window.setLocationRelativeTo(null);
    }//GEN-LAST:event_submenu_newproductActionPerformed

    private void submenu_estoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenu_estoqueActionPerformed
        JFrame window = new CEstoqueGUI();
        window.setVisible(true);
        window.setLocationRelativeTo(this);
    }//GEN-LAST:event_submenu_estoqueActionPerformed

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
            java.util.logging.Logger.getLogger(MenuAdmGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuAdmGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuAdmGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAdmGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuAdmGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenu menu_help;
    private javax.swing.JMenu menu_new;
    private javax.swing.JMenuItem submenu_estoque;
    private javax.swing.JMenuItem submenu_newUser;
    private javax.swing.JMenuItem submenu_newop;
    private javax.swing.JMenuItem submenu_newproduct;
    // End of variables declaration//GEN-END:variables
}
