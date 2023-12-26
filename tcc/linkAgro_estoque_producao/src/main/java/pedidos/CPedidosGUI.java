/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pedidos;


import estoque.CEstoqueGUI;
import help.HPedidos;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import menus.MenuGUI;
import ordem_producao.ControllerOP;
import ordem_producao.ROrdemProducaoGUI;
import produtos.Produto;
import produtos.ProdutosGUI;
import usuarios.CUsuarioGUI;
import usuarios.Controller;
import usuarios.LoginGUI;


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

    
    //Gerando tabela de pedidos
    public void tabela(){
        PedidoDAO pedidodao = new PedidoDAO();
        DefaultTableModel modelo = (DefaultTableModel) tab_pedidos.getModel();
        
        //limpando tabela
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
        btn_back = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        submenu_users = new javax.swing.JMenu();
        submenu_newop = new javax.swing.JMenuItem();
        submenu_newproduct = new javax.swing.JMenuItem();
        submenu_estoque = new javax.swing.JMenuItem();
        submenu_pedidos = new javax.swing.JMenuItem();
        submenu_user = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
        tab_pedidos.setSelectionBackground(new java.awt.Color(153, 153, 153));
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
        add_pedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/adicionar.png"))); // NOI18N
        add_pedido.setText("Adicionar");
        add_pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_pedidoActionPerformed(evt);
            }
        });

        upd_pedido.setBackground(new java.awt.Color(255, 255, 255));
        upd_pedido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        upd_pedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/editar (2).png"))); // NOI18N
        upd_pedido.setText("Editar");
        upd_pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upd_pedidoActionPerformed(evt);
            }
        });

        del_pedido.setBackground(new java.awt.Color(255, 255, 255));
        del_pedido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        del_pedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/excluir.png"))); // NOI18N
        del_pedido.setText("Excluir");
        del_pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                del_pedidoActionPerformed(evt);
            }
        });

        btn_back.setBackground(new java.awt.Color(255, 255, 255));
        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/botao-voltar (1).png"))); // NOI18N
        btn_back.setBorder(null);
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_back)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(add_pedido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(upd_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(del_pedido)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btn_back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_pedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(upd_pedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(del_pedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
                .addContainerGap())
        );

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

        jMenuBar1.add(submenu_users);

        jMenu2.setText("Ajuda");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon_help.png"))); // NOI18N
        jMenuItem1.setText("Sobre Pedidos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

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
    

    //Adicionando novo pedido
    private void add_pedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_pedidoActionPerformed
        PedidoDAO pedidodao = new PedidoDAO();
        pedidodao.insertPedido(pedidodao.paneJOP(null,null,null,null,null));
        JOptionPane.showMessageDialog(null,"Pedido adicionado com sucesso!");
        tabela();
    }//GEN-LAST:event_add_pedidoActionPerformed

    //Atualizando pedido
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

    
    //Deletando Pedido
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

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        MenuGUI menugui = new MenuGUI();
        menugui.setVisible(true);
        menugui.setExtendedState(MAXIMIZED_BOTH);
        dispose();
    }//GEN-LAST:event_btn_backActionPerformed

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

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        HPedidos window = new HPedidos();
        window.setVisible(true);
        window.setLocationRelativeTo(null);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
    private javax.swing.JButton btn_back;
    private javax.swing.JButton del_pedido;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JMenuItem submenu_estoque;
    private javax.swing.JMenuItem submenu_newop;
    private javax.swing.JMenuItem submenu_newproduct;
    private javax.swing.JMenuItem submenu_pedidos;
    private javax.swing.JMenuItem submenu_user;
    private javax.swing.JMenu submenu_users;
    private javax.swing.JTable tab_pedidos;
    private javax.swing.JButton upd_pedido;
    // End of variables declaration//GEN-END:variables
}