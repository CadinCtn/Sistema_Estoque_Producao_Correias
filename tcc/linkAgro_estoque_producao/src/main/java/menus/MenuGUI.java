package menus;

import estoque.CEstoqueGUI;
import ordem_producao.ROrdemProducaoGUI;
import ordem_producao.ControllerOP;
import produtos.ProdutosGUI;
import javax.swing.JOptionPane;
import pedidos.CPedidosGUI;
import produtos.Produto;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        panel_background = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        menubar = new javax.swing.JMenuBar();
        submenu_users = new javax.swing.JMenu();
        submenu_newop = new javax.swing.JMenuItem();
        submenu_newproduct = new javax.swing.JMenuItem();
        submenu_estoque = new javax.swing.JMenuItem();
        submenu_pedidos = new javax.swing.JMenuItem();
        submenu_user = new javax.swing.JMenuItem();

        jScrollPane1.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema LinkAgro");

        panel_background.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/linkagroMenu.jpg"))); // NOI18N
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/botao-de-energia-desligado.png"))); // NOI18N
        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_backgroundLayout = new javax.swing.GroupLayout(panel_background);
        panel_background.setLayout(panel_backgroundLayout);
        panel_backgroundLayout.setHorizontalGroup(
            panel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_backgroundLayout.createSequentialGroup()
                .addContainerGap(72, Short.MAX_VALUE)
                .addGroup(panel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        panel_backgroundLayout.setVerticalGroup(
            panel_backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_backgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        menubar.setBackground(new java.awt.Color(255, 255, 255));

        submenu_users.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon_plus.png"))); // NOI18N
        submenu_users.setText("Menu");
        submenu_users.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N

        submenu_newop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon_clipboard.png"))); // NOI18N
        submenu_newop.setText("Ordem de produção");
        submenu_newop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenu_newopActionPerformed(evt);
            }
        });
        submenu_users.add(submenu_newop);

        submenu_newproduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon_belt.png"))); // NOI18N
        submenu_newproduct.setText("Produtos");
        submenu_newproduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenu_newproductActionPerformed(evt);
            }
        });
        submenu_users.add(submenu_newproduct);

        submenu_estoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/estoque.png"))); // NOI18N
        submenu_estoque.setText("Estoque Correias");
        submenu_estoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenu_estoqueActionPerformed(evt);
            }
        });
        submenu_users.add(submenu_estoque);

        submenu_pedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pedidos.png"))); // NOI18N
        submenu_pedidos.setText("Pedidos");
        submenu_pedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenu_pedidosActionPerformed(evt);
            }
        });
        submenu_users.add(submenu_pedidos);

        submenu_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/adicionar-usuario.png"))); // NOI18N
        submenu_user.setText("Usuarios");
        submenu_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenu_userActionPerformed(evt);
            }
        });
        submenu_users.add(submenu_user);

        menubar.add(submenu_users);

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        switch(JOptionPane.showConfirmDialog(null,"Deseja sair do sistema?","Sair",JOptionPane.YES_NO_OPTION)){
            case JOptionPane.YES_OPTION:
                    dispose();
                    LoginGUI window = new LoginGUI();
                    window.setVisible(true);
                    window.setLocationRelativeTo(null);
                    Controller.setLogingui(window);
                break;
        }
        

    }//GEN-LAST:event_jButton1ActionPerformed

    private void submenu_newopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenu_newopActionPerformed

        ROrdemProducaoGUI window = new ROrdemProducaoGUI();
        window.setVisible(true);
        window.setExtendedState(MAXIMIZED_BOTH);
        ControllerOP.setrOrdemProducaoGUI(window);
        dispose();
    }//GEN-LAST:event_submenu_newopActionPerformed

    private void submenu_newproductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenu_newproductActionPerformed
        ProdutosGUI window = new ProdutosGUI();
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        Produto.setProdutosgui(window);
    }//GEN-LAST:event_submenu_newproductActionPerformed

    private void submenu_estoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenu_estoqueActionPerformed
        CEstoqueGUI window = new CEstoqueGUI();
        window.setVisible(true);
        window.setExtendedState(MAXIMIZED_BOTH);
        dispose();
    }//GEN-LAST:event_submenu_estoqueActionPerformed

    private void submenu_pedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenu_pedidosActionPerformed

        CPedidosGUI cpedidosgui = new CPedidosGUI();
        cpedidosgui.setVisible(true);
        cpedidosgui.setExtendedState(MAXIMIZED_BOTH);
        dispose();
    }//GEN-LAST:event_submenu_pedidosActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuBar menubar;
    private javax.swing.JPanel panel_background;
    private javax.swing.JMenuItem submenu_estoque;
    private javax.swing.JMenuItem submenu_newop;
    private javax.swing.JMenuItem submenu_newproduct;
    private javax.swing.JMenuItem submenu_pedidos;
    private javax.swing.JMenuItem submenu_user;
    private javax.swing.JMenu submenu_users;
    // End of variables declaration//GEN-END:variables
}
