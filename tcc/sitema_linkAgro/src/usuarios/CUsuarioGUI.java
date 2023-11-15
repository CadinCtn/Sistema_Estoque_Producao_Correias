/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package usuarios;


import java.sql.SQLException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import menus.MenuGUI;

/**
 *
 * @author Lenovo
 */
public class CUsuarioGUI extends javax.swing.JFrame {

    /**
     * Creates new form CUsuarioGUI
     */
    public CUsuarioGUI() {
        initComponents();
        tabela();
    }
    
    public void tabela(){
        UsuarioDAO usuariodao = new UsuarioDAO();
        DefaultTableModel modelo = (DefaultTableModel) tab_usuarios.getModel();
        
        while(tab_usuarios.getModel().getRowCount() > 0 ){
            ((DefaultTableModel) tab_usuarios.getModel()).removeRow(0);
        }
        
        try {
            List<Usuario> usuarioList = usuariodao.selectUsuario();

            for (Usuario usuario : usuarioList) {
                
                Object[] line = {usuario.getId(),usuario.getLogin(),usuario.getSenha(),usuario.getPermissao()};
                modelo.addRow(line);
                
            }

        } 
        catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Falha ao listar usuários cadastrados!" + e.getMessage(), "ERRO", JOptionPane.WARNING_MESSAGE);

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
        tab_usuarios = new javax.swing.JTable();
        btn_newUser = new javax.swing.JButton();
        btn_deleteUser = new javax.swing.JButton();
        btn_editUser = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Usuários");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tab_usuarios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tab_usuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Login", "Senha", "Permissão"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tab_usuarios);

        btn_newUser.setBackground(new java.awt.Color(255, 255, 255));
        btn_newUser.setText("Cadastrar Usuário");
        btn_newUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newUserActionPerformed(evt);
            }
        });

        btn_deleteUser.setBackground(new java.awt.Color(255, 255, 255));
        btn_deleteUser.setText("Deletar Usuário");
        btn_deleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteUserActionPerformed(evt);
            }
        });

        btn_editUser.setBackground(new java.awt.Color(255, 255, 255));
        btn_editUser.setText("Editar Usuário");
        btn_editUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editUserActionPerformed(evt);
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
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_editUser, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_newUser, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_deleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_back)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(btn_back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_newUser, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_editUser, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_deleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

    private void btn_newUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newUserActionPerformed
        JFrame window = new CadastroUsuarioGUI();
        window.setVisible(true);
        window.setLocationRelativeTo(null);
    }//GEN-LAST:event_btn_newUserActionPerformed

    private void btn_deleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteUserActionPerformed
        UsuarioDAO usuariodao = new UsuarioDAO();

        int linhaSelecionada = -1;
        linhaSelecionada = tab_usuarios.getSelectedRow();
        if(linhaSelecionada >= 0){
            int idUsuario = (int) tab_usuarios.getValueAt(linhaSelecionada, 0);

            
            switch(JOptionPane.showConfirmDialog(null,"Deseja mesmo DELETAR este usuário?","Deletar usuário",JOptionPane.YES_NO_OPTION)){
                case JOptionPane.YES_OPTION:
                usuariodao.deleteUsuario(idUsuario);
                tabela();
                break;
            }
        } else {
            JOptionPane.showMessageDialog(null,"Selecione o usuário que deseja deletar.");
        }
    }//GEN-LAST:event_btn_deleteUserActionPerformed

    private void btn_editUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editUserActionPerformed
        int selectedRow = -1;
        selectedRow = tab_usuarios.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null,"Selecione o usuário que deseja editar");
        } else {
            Usuario usuario = new Usuario();
            Controller.setUsuario(usuario);
            
            usuario.setId((int) tab_usuarios.getValueAt(selectedRow,0));
            usuario.setLogin((String) tab_usuarios.getValueAt(selectedRow,1));
            usuario.setSenha((String) tab_usuarios.getValueAt(selectedRow,2));
            usuario.setPermissao((String) tab_usuarios.getValueAt(selectedRow,3));
            
            CadastroUsuarioGUI cusergui = new CadastroUsuarioGUI();
            cusergui.field_login.setText(usuario.getLogin());
            cusergui.field_password.setText(usuario.getSenha());
                if(usuario.getPermissao() != null){
                    cusergui.permissionBox.setSelected(true);
                }
                
            
            cusergui.edit = true;
            cusergui.setLocationRelativeTo(null);
            cusergui.setVisible(true);
            
        }
        
    }//GEN-LAST:event_btn_editUserActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        dispose();
    }//GEN-LAST:event_btn_backActionPerformed

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
            java.util.logging.Logger.getLogger(CUsuarioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CUsuarioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CUsuarioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CUsuarioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CUsuarioGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_deleteUser;
    private javax.swing.JButton btn_editUser;
    private javax.swing.JButton btn_newUser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tab_usuarios;
    // End of variables declaration//GEN-END:variables
}
