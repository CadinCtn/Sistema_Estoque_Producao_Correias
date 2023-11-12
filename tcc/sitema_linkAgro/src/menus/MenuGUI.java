/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menus;

import estoque.CEstoqueGUI;
import java.awt.event.ActionEvent;
import ordem_producao.ROrdemProducaoGUI;
import produtos.CProdutosGUI;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import pedidos.CPedidosGUI;
import usuarios.CUsuarioGUI;
import usuarios.Controller;
import usuarios.LoginGUI;


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
        jMenuItem1 = new javax.swing.JMenuItem();
        submenu_user = new javax.swing.JMenuItem();
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
            .addGap(0, 385, Short.MAX_VALUE)
        );

        menubar.setBackground(new java.awt.Color(255, 255, 255));

        menu_new.setText("Novo");
        menu_new.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N

        submenu_newop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon_clipboard.png"))); // NOI18N
        submenu_newop.setText("Ordem de produção");
        submenu_newop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenu_newopActionPerformed(evt);
            }
        });
        menu_new.add(submenu_newop);

        submenu_newproduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon_belt.png"))); // NOI18N
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

        jMenuItem1.setText("Pedidos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menu_new.add(jMenuItem1);

        submenu_user.setText("Usuarios");
        submenu_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenu_userActionPerformed(evt);
            }
        });
        menu_new.add(submenu_user);

        menubar.add(menu_new);

        menu_help.setText("Ajuda");
        menu_help.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
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
        
        JFrame window = new ROrdemProducaoGUI();
        window.setVisible(true);
        window.setExtendedState(MAXIMIZED_BOTH);
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

    private void submenu_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenu_userActionPerformed
        
        LoginGUI logingui = Controller.getLogingui();
        
        if(logingui.permissao){
            CUsuarioGUI window = new CUsuarioGUI();
            window.setVisible(true);
            window.setLocationRelativeTo(null);
            Controller.setcUsuarioGUI(window);
        } else {
            JOptionPane.showMessageDialog(null,"Acesso negado","AVISO!",JOptionPane.WARNING_MESSAGE);
        }
        
        
        
        
    }//GEN-LAST:event_submenu_userActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
        CPedidosGUI cpedidosgui = new CPedidosGUI();
        cpedidosgui.setVisible(true);
        cpedidosgui.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItem1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu menu_help;
    private javax.swing.JMenu menu_new;
    private javax.swing.JMenuBar menubar;
    private javax.swing.JPanel panel_background;
    private javax.swing.JMenuItem submenu_estoque;
    private javax.swing.JMenuItem submenu_newop;
    private javax.swing.JMenuItem submenu_newproduct;
    private javax.swing.JMenuItem submenu_user;
    // End of variables declaration//GEN-END:variables
}
