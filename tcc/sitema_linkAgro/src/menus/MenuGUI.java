/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menus;

import estoque.CEstoqueGUI;
import ordem_producao.COrdemProducaoGUI;
import produtos.CProdutosGUI;
import usuarios.CUsuarioGUI;
import usuarios.LoginGUI;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Senai
 */
public class MenuGUI extends javax.swing.JFrame {
    
    /**
     * Creates new form MenuGUI
     */
    public MenuGUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_background = new javax.swing.JPanel();
        menubar = new javax.swing.JMenuBar();
        menu_new = new javax.swing.JMenu();
        submenu_newop = new javax.swing.JMenuItem();
        submenu_newproduct = new javax.swing.JMenuItem();
        submenu_estoque = new javax.swing.JMenuItem();
        menu_help = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema LinkAgro");

        panel_background.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panel_backgroundLayout = new javax.swing.GroupLayout(panel_background);
        panel_background.setLayout(panel_backgroundLayout);
        panel_backgroundLayout.setHorizontalGroup(
            panel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 737, Short.MAX_VALUE)
        );
        panel_backgroundLayout.setVerticalGroup(
            panel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 386, Short.MAX_VALUE)
        );

        menubar.setBackground(new java.awt.Color(255, 255, 255));

        menu_new.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon_plus.png"))); // NOI18N
        menu_new.setText("Novo");

        submenu_newop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/211649_clipboard_icon.png"))); // NOI18N
        submenu_newop.setText("Ordem de produção");
        submenu_newop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenu_newopActionPerformed(evt);
            }
        });
        menu_new.add(submenu_newop);

        submenu_newproduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/379490_belt_conveyor_icon (1).png"))); // NOI18N
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

        menubar.add(menu_new);

        menu_help.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon_help.png"))); // NOI18N
        menu_help.setText("Ajuda");
        menubar.add(menu_help);

        setJMenuBar(menubar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submenu_newopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenu_newopActionPerformed
        
        JFrame window = new COrdemProducaoGUI();
        window.setVisible(true);
        window.setLocationRelativeTo(null);
    }//GEN-LAST:event_submenu_newopActionPerformed

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
            java.util.logging.Logger.getLogger(MenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu menu_help;
    private javax.swing.JMenu menu_new;
    private javax.swing.JMenuBar menubar;
    private javax.swing.JPanel panel_background;
    private javax.swing.JMenuItem submenu_estoque;
    private javax.swing.JMenuItem submenu_newop;
    private javax.swing.JMenuItem submenu_newproduct;
    // End of variables declaration//GEN-END:variables
}
