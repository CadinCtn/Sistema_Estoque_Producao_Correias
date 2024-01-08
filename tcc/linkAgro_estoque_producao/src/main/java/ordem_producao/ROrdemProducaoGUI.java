/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordem_producao;


import doc_arquivados.CArqvOrdemProducaoGUI;
import doc_arquivados.OpArqvDAO;
import doc_arquivados.RelatorioOp;
import estoque.CEstoqueGUI;
import imprimir.Preview;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import menus.MenuGUI;
import pedidos.CPedidosGUI;
import produtos.Produto;
import produtos.ProdutoDAO;
import produtos.ProdutosGUI;
import usuarios.CUsuarioGUI;
import menus.Controller;
import usuarios.LoginGUI;

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
        tabelaProd();
        tabelaPedidosOp();
        tabelaArch();
    }

    //Gerando tabela de ordem de producao
    public void tabelaProd(){
        OrdemProducaoDAO opdao = new OrdemProducaoDAO();
        DefaultTableModel modelo = (DefaultTableModel) tab_ordemProducao.getModel();
        
        
        while(tab_ordemProducao.getModel().getRowCount() > 0 ){
            ((DefaultTableModel) tab_ordemProducao.getModel()).removeRow(0);
        }
        
        List<OrdemProducao> opList = opdao.selectOrdemProducao();
        for (OrdemProducao op : opList) {
            
            Object[] line = {op.getId(), op.getCategoria(), op.getEe(), op.getLarguraTecido(), op.getMetragemTecido(), op.getMetExtra(),op.getLonas(), op.getEspessura(),op.getSetor(),op.getObservacao()};
            modelo.addRow(line);
            
        }
        
        
        ProdutoDAO produtodao = new ProdutoDAO();
        produtodao.paintCat(tab_ordemProducao, 1);
        
        
    }
    
    //Tabela de OP's arquivadas
        public void tabelaArch(){
            OpArqvDAO opArqvDAO = new OpArqvDAO();
            DefaultTableModel modelo = (DefaultTableModel) tab_opArch.getModel();


            while(tab_opArch.getModel().getRowCount() > 0 ){
                ((DefaultTableModel) tab_opArch.getModel()).removeRow(0);
            }

            List<OrdemProducao> opList = opArqvDAO.selectArchivedOrdemProducao();
            for (OrdemProducao op : opList) {

                Object[] line = {op.getId(), op.getCategoria(), op.getEe(), op.getLarguraTecido(), op.getMetragemTecido(), op.getMetExtra(),op.getLonas(), op.getEspessura(),op.getSetor(),op.getObservacao()};
                modelo.addRow(line);

            }


            ProdutoDAO produtodao = new ProdutoDAO();
            produtodao.paintCat(tab_opArch, 1);
        
        
        }

    
    //Gerando tabela de pedidos da ordem de producao selecionada
    public void tabelaPedidosOp(){
        tab_ordemProducao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  // Permite apenas uma seleção por vez
        
        // Adicionar o ListSelectionListener para a tabela
        tab_ordemProducao.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent evt){
                if(!evt.getValueIsAdjusting()){
                    
                    //Limpando tabela
                        while(tab_rPedidosOp.getModel().getRowCount() > 0 ){
                        ((DefaultTableModel) tab_rPedidosOp.getModel()).removeRow(0);
                        }
                        
                    //Verificando a linha selecionada
                    int selectedRow = -1;
                    selectedRow = tab_ordemProducao.getSelectedRow();
                    if(selectedRow >= 0){
                        
                        //Buscando por pedidos vinculados a ordem de produção
                        PedidoOpDAO pedidodao = new PedidoOpDAO();
                        DefaultTableModel modelo = (DefaultTableModel) tab_rPedidosOp.getModel();
                        //Adicionando a tabela os pedidos para visualizar
                        List<PedidoOp> pedidoOpList = pedidodao.selectPedidoOp((int) tab_ordemProducao.getValueAt(selectedRow, 0));
                            for (PedidoOp pedidoop : pedidoOpList) {
                                Object[] line = {pedidoop.getId(),pedidoop.getNome_cliente(),pedidoop.getLargura(),pedidoop.getMetragem(),pedidoop.getCod()};
                                modelo.addRow(line);
            
                            }
                    }
                }
            }
        });
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
        button_return = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab_ordemProducao = new javax.swing.JTable();
        button_printer = new javax.swing.JButton();
        button_aqv = new javax.swing.JButton();
        button_delete = new javax.swing.JButton();
        button_update = new javax.swing.JButton();
        button_createOp = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tab_rPedidosOp = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tab_opArch = new javax.swing.JTable();
        button_relatorio = new javax.swing.JButton();
        button_delete1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        submenu_users1 = new javax.swing.JMenu();
        submenu_newop1 = new javax.swing.JMenuItem();
        submenu_newproduct1 = new javax.swing.JMenuItem();
        submenu_estoque1 = new javax.swing.JMenuItem();
        submenu_pedidos1 = new javax.swing.JMenuItem();
        submenu_user1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ordem de Produção");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        button_return.setBackground(new java.awt.Color(255, 255, 255));
        button_return.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        button_return.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/botao-voltar (1).png"))); // NOI18N
        button_return.setBorder(null);
        button_return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_returnActionPerformed(evt);
            }
        });

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        tab_ordemProducao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tab_ordemProducao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Categoria", "EE", "Largura", "Metragem", "+Mts", "Lonas", "Espessura", "Setor", "Observação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tab_ordemProducao.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jScrollPane1.setViewportView(tab_ordemProducao);

        button_printer.setBackground(new java.awt.Color(255, 255, 255));
        button_printer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        button_printer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/impressora.png"))); // NOI18N
        button_printer.setText("Imprimir");
        button_printer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_printerActionPerformed(evt);
            }
        });

        button_aqv.setBackground(new java.awt.Color(255, 255, 255));
        button_aqv.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        button_aqv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pedido.png"))); // NOI18N
        button_aqv.setText("Arquivar");
        button_aqv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_aqvActionPerformed(evt);
            }
        });

        button_delete.setBackground(new java.awt.Color(255, 255, 255));
        button_delete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        button_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/excluir.png"))); // NOI18N
        button_delete.setText("Deletar Ordem de Produção");
        button_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_deleteActionPerformed(evt);
            }
        });

        button_update.setBackground(new java.awt.Color(255, 255, 255));
        button_update.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        button_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/editar (2).png"))); // NOI18N
        button_update.setText("Editar Ordem de Produção");
        button_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_updateActionPerformed(evt);
            }
        });

        button_createOp.setBackground(new java.awt.Color(255, 255, 255));
        button_createOp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        button_createOp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/adicionar.png"))); // NOI18N
        button_createOp.setText("Gerar Ordem de Produção");
        button_createOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_createOpActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Pedidos da Ordem de Produção");

        tab_rPedidosOp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tab_rPedidosOp.setModel(new javax.swing.table.DefaultTableModel(
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
        tab_rPedidosOp.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jScrollPane2.setViewportView(tab_rPedidosOp);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 650, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(button_aqv)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_printer))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(button_createOp)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_update)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_delete))))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_printer)
                    .addComponent(button_aqv))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_createOp)
                    .addComponent(button_update)
                    .addComponent(button_delete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Em Produção", jPanel2);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Relatórios de Produção");

        tab_opArch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tab_opArch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Categoria", "EE", "Largura", "Metragem", "+Mts", "Lonas", "Espessura", "Setor", "Observação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tab_opArch.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jScrollPane3.setViewportView(tab_opArch);

        button_relatorio.setBackground(new java.awt.Color(255, 255, 255));
        button_relatorio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        button_relatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/relatorio.png"))); // NOI18N
        button_relatorio.setText("Exibir Relatório");
        button_relatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_relatorioActionPerformed(evt);
            }
        });

        button_delete1.setBackground(new java.awt.Color(255, 255, 255));
        button_delete1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        button_delete1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/excluir.png"))); // NOI18N
        button_delete1.setText("Deletar Ordem de Produção");
        button_delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_delete1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 919, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button_relatorio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_delete1)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(button_relatorio)
                        .addComponent(button_delete1))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Arquivadas", jPanel3);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Ordem de Produção");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(button_return)
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button_return)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
        );

        submenu_users1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon_plus.png"))); // NOI18N
        submenu_users1.setText("Menu");
        submenu_users1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N

        submenu_newop1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/clipboard.png"))); // NOI18N
        submenu_newop1.setText("Ordem de produção");
        submenu_newop1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenu_newop1ActionPerformed(evt);
            }
        });
        submenu_users1.add(submenu_newop1);

        submenu_newproduct1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icon_belt.png"))); // NOI18N
        submenu_newproduct1.setText("Produtos");
        submenu_newproduct1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenu_newproduct1ActionPerformed(evt);
            }
        });
        submenu_users1.add(submenu_newproduct1);

        submenu_estoque1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/estoque.png"))); // NOI18N
        submenu_estoque1.setText("Estoque Correias");
        submenu_estoque1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenu_estoque1ActionPerformed(evt);
            }
        });
        submenu_users1.add(submenu_estoque1);

        submenu_pedidos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pedidos.png"))); // NOI18N
        submenu_pedidos1.setText("Pedidos");
        submenu_pedidos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenu_pedidos1ActionPerformed(evt);
            }
        });
        submenu_users1.add(submenu_pedidos1);

        submenu_user1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/adicionar-usuario.png"))); // NOI18N
        submenu_user1.setText("Usuarios");
        submenu_user1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submenu_user1ActionPerformed(evt);
            }
        });
        submenu_users1.add(submenu_user1);

        jMenuBar1.add(submenu_users1);

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
    
    private void button_returnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_returnActionPerformed
        MenuGUI menugui = new MenuGUI();
        menugui.setVisible(true);
        menugui.setExtendedState(MAXIMIZED_BOTH);
        dispose();
    }//GEN-LAST:event_button_returnActionPerformed

    private void submenu_newop1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenu_newop1ActionPerformed

        ROrdemProducaoGUI window = new ROrdemProducaoGUI();
        window.setVisible(true);
        window.setExtendedState(MAXIMIZED_BOTH);
        Controller.setrOrdemProducaoGUI(window);
        dispose();
    }//GEN-LAST:event_submenu_newop1ActionPerformed

    private void submenu_newproduct1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenu_newproduct1ActionPerformed
        ProdutosGUI window = new ProdutosGUI();
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        Produto.setProdutosgui(window);
    }//GEN-LAST:event_submenu_newproduct1ActionPerformed

    private void submenu_estoque1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenu_estoque1ActionPerformed
        CEstoqueGUI window = new CEstoqueGUI();
        window.setVisible(true);
        window.setExtendedState(MAXIMIZED_BOTH);
        dispose();
    }//GEN-LAST:event_submenu_estoque1ActionPerformed

    private void submenu_pedidos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenu_pedidos1ActionPerformed

        CPedidosGUI cpedidosgui = new CPedidosGUI();
        cpedidosgui.setVisible(true);
        cpedidosgui.setExtendedState(MAXIMIZED_BOTH);
        dispose();
    }//GEN-LAST:event_submenu_pedidos1ActionPerformed

    private void submenu_user1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenu_user1ActionPerformed

        LoginGUI logingui = Controller.getLogingui();

        if(logingui.permissao){
            CUsuarioGUI window = new CUsuarioGUI();
            window.setVisible(true);
            window.setLocationRelativeTo(null);
            Controller.setcUsuarioGUI(window);
        } else {
            JOptionPane.showMessageDialog(null,"Acesso negado","AVISO!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_submenu_user1ActionPerformed

    private void button_printerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_printerActionPerformed

        int selectedRow = -1;
        selectedRow = tab_ordemProducao.getSelectedRow();

        if(selectedRow >=0){
            int idOp = (int) tab_ordemProducao.getValueAt(selectedRow, 0);
            PedidoOpDAO pedidoopdao = new PedidoOpDAO();
            OrdemProducaoDAO opdao = new OrdemProducaoDAO();
            Preview print = new Preview();
            print.frame(pedidoopdao.selectPedidoOp(idOp), opdao.selectOrdemProducaoById(idOp),print);
            Controller.setPreview(print);

        } else {
            JOptionPane.showMessageDialog(null,"Selecione a ordem de produção que deseja imprimir.");
        }

    }//GEN-LAST:event_button_printerActionPerformed

    private void button_aqvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_aqvActionPerformed

        int selectedRow = -1;
        selectedRow = tab_ordemProducao.getSelectedRow();
        if(selectedRow >= 0){
            OrdemProducaoDAO opdao = new OrdemProducaoDAO();
            //Criando Objeto
            OrdemProducao op = opdao.selectOrdemProducaoById(Integer.parseInt(String.valueOf(tab_ordemProducao.getValueAt(selectedRow, 0))));
            //Iniciando criação do relatório
            CArqvOrdemProducaoGUI window = new CArqvOrdemProducaoGUI(op, null, false);
            window.setVisible(true);
            window.setExtendedState(MAXIMIZED_BOTH);
            Controller.setcArqvOrdemProducaoGUI(window);

        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma ordem de produção para arquivar");
        }

    }//GEN-LAST:event_button_aqvActionPerformed

    private void button_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_deleteActionPerformed
        // TODO add your handling code here:
        OrdemProducao op = new OrdemProducao();

        int selectedRow = -1;
        selectedRow = tab_ordemProducao.getSelectedRow();

        if(selectedRow >=0){

            switch(JOptionPane.showConfirmDialog(null,"Deseja mesmo excluir essa ordem de produção?","Aviso",JOptionPane.YES_NO_OPTION)){

                case JOptionPane.YES_OPTION:
                PedidoOpDAO pedidoopdao = new PedidoOpDAO();
                OrdemProducaoDAO opdao = new OrdemProducaoDAO();

                op.setId(Integer.valueOf(String.valueOf(tab_ordemProducao.getValueAt(selectedRow, 0))));
                pedidoopdao.deleteAllPedidosOfOp(op.getId());
                opdao.deleteOrdemProducao(op.getId());

                tabelaProd();

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
            String metExtra = String.valueOf(tab_ordemProducao.getValueAt(selectedRow, 5));
            String lonas = String.valueOf(tab_ordemProducao.getValueAt(selectedRow, 6));
            String espessura = String.valueOf(tab_ordemProducao.getValueAt(selectedRow, 7));
            String setor = String.valueOf(tab_ordemProducao.getValueAt(selectedRow, 8));
            String observacao = String.valueOf(tab_ordemProducao.getValueAt(selectedRow, 9));
            op.setEdit(true);

            cuopg.fillFields(op.getEdit(), id, categoria, ee, width, length, metExtra,lonas, espessura,setor, observacao);

            cuopg.setVisible(true);
            cuopg.setLocationRelativeTo(null);
            Controller.setCuOrdemProducaoGui(cuopg);

        } else {
            JOptionPane.showMessageDialog(null,"Selecione a ordem de produção que deseja editar.");
        }

    }//GEN-LAST:event_button_updateActionPerformed

    private void button_createOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_createOpActionPerformed
        // TODO add your handling code here:
        CUOrdemProducaoGUI window = new CUOrdemProducaoGUI();
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        Controller.setCuOrdemProducaoGui(window);

    }//GEN-LAST:event_button_createOpActionPerformed

    private void button_relatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_relatorioActionPerformed
        int selectedRow = -1;
        selectedRow = tab_opArch.getSelectedRow();
        if(selectedRow >= 0){
            OrdemProducaoDAO opdao = new OrdemProducaoDAO();
            OpArqvDAO arqvDAO = new OpArqvDAO();

            //Criando objetos
            OrdemProducao op = opdao.selectOrdemProducaoById(Integer.parseInt(String.valueOf(tab_opArch.getValueAt(selectedRow, 0))));
            RelatorioOp relatorio = arqvDAO.selectRelatorio(Integer.parseInt(String.valueOf(tab_opArch.getValueAt(selectedRow, 0))));

            //Exibindo relatorio
            CArqvOrdemProducaoGUI window = new CArqvOrdemProducaoGUI(op, relatorio, true);
            window.setVisible(true);
            window.setExtendedState(MAXIMIZED_BOTH);
            Controller.setcArqvOrdemProducaoGUI(window);

        }else{
            JOptionPane.showMessageDialog(null, "Selecione uma Ordem de Produção");
        }
    }//GEN-LAST:event_button_relatorioActionPerformed

    private void button_delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_delete1ActionPerformed
        // TODO add your handling code here:
        OrdemProducao op = new OrdemProducao();

        int selectedRow = -1;
        selectedRow = tab_opArch.getSelectedRow();

        if(selectedRow >=0){

            switch(JOptionPane.showConfirmDialog(null,"Deseja mesmo excluir essa ordem de produção?","Aviso",JOptionPane.YES_NO_OPTION)){

                case JOptionPane.YES_OPTION:
                PedidoOpDAO pedidoopdao = new PedidoOpDAO();
                OrdemProducaoDAO opdao = new OrdemProducaoDAO();
                OpArqvDAO opArqvDAO = new OpArqvDAO();

                op.setId(Integer.parseInt(String.valueOf(tab_opArch.getValueAt(selectedRow, 0))));
                opArqvDAO.deleteRelatorio(op.getId());
                pedidoopdao.deleteAllPedidosOfOp(op.getId());
                opdao.deleteOrdemProducao(op.getId());

                tabelaArch();

                break;
            }

        } else {
            JOptionPane.showMessageDialog(null,"Selecione a ordem de produção que deseja excluir.");
        }

    }//GEN-LAST:event_button_delete1ActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        tabelaProd();
        tabelaPedidosOp();
        tabelaArch();
    }//GEN-LAST:event_jTabbedPane1MouseClicked

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
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
    private javax.swing.JButton button_aqv;
    private javax.swing.JButton button_createOp;
    private javax.swing.JButton button_delete;
    private javax.swing.JButton button_delete1;
    private javax.swing.JButton button_printer;
    private javax.swing.JButton button_relatorio;
    private javax.swing.JButton button_return;
    private javax.swing.JButton button_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JMenuItem submenu_estoque1;
    private javax.swing.JMenuItem submenu_newop1;
    private javax.swing.JMenuItem submenu_newproduct1;
    private javax.swing.JMenuItem submenu_pedidos1;
    private javax.swing.JMenuItem submenu_user1;
    private javax.swing.JMenu submenu_users1;
    private javax.swing.JTable tab_opArch;
    private javax.swing.JTable tab_ordemProducao;
    public javax.swing.JTable tab_rPedidosOp;
    // End of variables declaration//GEN-END:variables
}
