package estoque;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import menus.MenuGUI;
import ordem_producao.ROrdemProducaoGUI;
import pedidos.CPedidosGUI;
import produtos.Produto;
import produtos.ProdutoDAO;
import produtos.ProdutosGUI;
import usuarios.CUsuarioGUI;
import menus.Controller;
import usuarios.LoginGUI;


/**
 *
 * @author Lenovo
 */
public class CEstoqueGUI extends javax.swing.JFrame {

    /**
     * Creates new form CEstoqueGUI
     */
    public CEstoqueGUI() {
        initComponents();
        categoriaBox();
        filtro();   
    }

    
    //Adicionandos os itens da tabela de produtos a  combobox
    public void categoriaBox(){
        ProdutoDAO produtodao = new ProdutoDAO();
            box_category.removeAllItems();
        try{
            List<Produto> produtoList = produtodao.categoriaBox(); 
                box_category.addItem(null);
            for(Produto produto : produtoList){
                box_category.addItem(produto.getProduto()); 
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        box_category.setSelectedItem(null);
        box_lona.setSelectedItem(null);
    }
    
    
    
    // Gerando itens na tabela
    public void filtro(){
        // Aplicando filtro
           EstoqueDAO estoquedao = new EstoqueDAO();
           DefaultTableModel modelo = (DefaultTableModel) tab_estoque.getModel();

           ////
           //limpando a tabela
           while(tab_estoque.getModel().getRowCount() > 0 ){
               ((DefaultTableModel) tab_estoque.getModel()).removeRow(0);
           }
           ////
           
           
           String categoria = String.valueOf(box_category.getSelectedItem());
           String lonas = String.valueOf(box_lona.getSelectedItem());
           String largura = largField.getText();
           String metragem = metField.getText();
           
           if(box_category.getSelectedItem() == null){
            categoria = " ";
            
            } else {
                categoria = " categoria = '" + categoria + "' and";
            }
            //lonas
            if(box_lona.getSelectedItem() == null){
                lonas = "> 0";
            } else {
                lonas = "= " + lonas;
            }
            //largura
            if(largura.isEmpty()){
                largura = "0";
            }
            //metragem
            if(metragem.isEmpty()){
                metragem = "0";
            }
           
           
           // Função que retorna uma lista com os objetos após aplicar o filtro
           List<Estoque> estoqueList = estoquedao.buscaEstoque(categoria, lonas,largura,metragem);
           List<Integer> reservedRows = new ArrayList<>();
           //Inserindo itens na tabela
            for (Estoque estoque : estoqueList) {

               Object[] line = {estoque.getId(), estoque.getCategoria(), estoque.getLonas(), estoque.getLargura(), estoque.getMetragem(), estoque.getObs()};
               modelo.addRow(line);
               if (estoque.isReservado()) {
                    reservedRows.add(estoqueList.indexOf(estoque));
                }
            }

    // Destacar as linhas reservadas após adicionar todas as linhas
    estoquedao.reservedRow(tab_estoque, reservedRows);
        ProdutoDAO produtodao = new ProdutoDAO();
        produtodao.paintCat(tab_estoque, 1);
        
        
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tab_estoque = new javax.swing.JTable();
        add_estoque = new javax.swing.JButton();
        upd_estoque = new javax.swing.JButton();
        del_est = new javax.swing.JButton();
        btn_voltar = new javax.swing.JButton();
        busca_est = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        largField = new javax.swing.JTextField();
        metField = new javax.swing.JTextField();
        box_category = new javax.swing.JComboBox<>();
        box_lona = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_reservar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        submenu_users1 = new javax.swing.JMenu();
        submenu_newop1 = new javax.swing.JMenuItem();
        submenu_newproduct1 = new javax.swing.JMenuItem();
        submenu_estoque1 = new javax.swing.JMenuItem();
        submenu_pedidos1 = new javax.swing.JMenuItem();
        submenu_user1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Estoque Correias");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tab_estoque.setBackground(new java.awt.Color(255, 255, 255));
        tab_estoque.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tab_estoque.setForeground(new java.awt.Color(0, 0, 0));
        tab_estoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Categoria", "Lonas", "Largura", "Metragem", "OBS"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tab_estoque.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tab_estoque.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jScrollPane5.setViewportView(tab_estoque);
        if (tab_estoque.getColumnModel().getColumnCount() > 0) {
            tab_estoque.getColumnModel().getColumn(0).setMinWidth(50);
            tab_estoque.getColumnModel().getColumn(0).setPreferredWidth(50);
            tab_estoque.getColumnModel().getColumn(0).setMaxWidth(50);
            tab_estoque.getColumnModel().getColumn(2).setMinWidth(100);
            tab_estoque.getColumnModel().getColumn(2).setPreferredWidth(100);
            tab_estoque.getColumnModel().getColumn(2).setMaxWidth(100);
            tab_estoque.getColumnModel().getColumn(3).setMinWidth(120);
            tab_estoque.getColumnModel().getColumn(3).setPreferredWidth(120);
            tab_estoque.getColumnModel().getColumn(3).setMaxWidth(120);
            tab_estoque.getColumnModel().getColumn(4).setMinWidth(120);
            tab_estoque.getColumnModel().getColumn(4).setPreferredWidth(120);
            tab_estoque.getColumnModel().getColumn(4).setMaxWidth(120);
        }

        add_estoque.setBackground(new java.awt.Color(255, 255, 255));
        add_estoque.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add_estoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/adicionar.png"))); // NOI18N
        add_estoque.setText("Adicionar");
        add_estoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_estoqueActionPerformed(evt);
            }
        });

        upd_estoque.setBackground(new java.awt.Color(255, 255, 255));
        upd_estoque.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        upd_estoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/editar (2).png"))); // NOI18N
        upd_estoque.setText("Editar");
        upd_estoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upd_estoqueActionPerformed(evt);
            }
        });

        del_est.setBackground(new java.awt.Color(255, 255, 255));
        del_est.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        del_est.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/excluir.png"))); // NOI18N
        del_est.setText("Excluir");
        del_est.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                del_estActionPerformed(evt);
            }
        });

        btn_voltar.setBackground(new java.awt.Color(255, 255, 255));
        btn_voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/botao-voltar (1).png"))); // NOI18N
        btn_voltar.setBorder(null);
        btn_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_voltarActionPerformed(evt);
            }
        });

        busca_est.setBackground(new java.awt.Color(255, 255, 255));
        busca_est.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        busca_est.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/procurar.png"))); // NOI18N
        busca_est.setText("Buscar");
        busca_est.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busca_estActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Filtros:");

        largField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                largFieldActionPerformed(evt);
            }
        });

        metField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                metFieldActionPerformed(evt);
            }
        });

        box_category.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                box_categoryMousePressed(evt);
            }
        });
        box_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box_categoryActionPerformed(evt);
            }
        });

        box_lona.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { null,"2", "3", "4", "5", "6", "8", "10" }));
        box_lona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box_lonaActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Categoria");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Lonas");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Largura");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Metragem");

        btn_reservar.setBackground(new java.awt.Color(255, 255, 255));
        btn_reservar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_reservar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/separado.png"))); // NOI18N
        btn_reservar.setText("Reservado");
        btn_reservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reservarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1015, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_voltar)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(box_category, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(box_lona, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(largField, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(metField, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addComponent(jLabel2)
                                                .addGap(95, 95, 95)
                                                .addComponent(jLabel3)
                                                .addGap(97, 97, 97)
                                                .addComponent(jLabel4))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(add_estoque)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(upd_estoque, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(del_est)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(23, 23, 23)
                                                .addComponent(busca_est)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btn_reservar))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(93, 93, 93)
                                                .addComponent(jLabel5)))))))
                        .addGap(356, 356, 356)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btn_voltar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_estoque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(upd_estoque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(del_est, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(busca_est, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_reservar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(largField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(metField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box_category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box_lona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                .addContainerGap())
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
    
    // Adicionar item
    private void add_estoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_estoqueActionPerformed
        LoginGUI login = Controller.getLogingui();
        
        //Requisitando permissão para gerenciamento da tabela
        switch(login.usuario.getPermissao()){
            case "COMERCIAL":
                JOptionPane.showMessageDialog(null,"Você não possui permissão!");
                break;
                
           default:
               EstoqueDAO estoquedao = new EstoqueDAO();
                // Gerando JOptionPane e inserindo item a tabela
               Estoque addEstoque = estoquedao.pane(null,false);
               if(addEstoque != null){
                    estoquedao.insertEstoque(addEstoque);
                    filtro();
                
               }
                break;
        }
        
        
    }//GEN-LAST:event_add_estoqueActionPerformed
    
    //Remover item
    private void del_estActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_del_estActionPerformed
        LoginGUI login = Controller.getLogingui();
        
        //Requisitando permissão para gerenciamento da tabela
        switch(login.usuario.getPermissao()){
            case "COMERCIAL":
                JOptionPane.showMessageDialog(null,"Você não possui permissão!");
                break;
                
           default:
        
                int linhaSelecionada = -1;
                linhaSelecionada = tab_estoque.getSelectedRow();
                if(linhaSelecionada >=0){

                    //Confirmação do usuario
                    switch(JOptionPane.showConfirmDialog(null,"Deseja mesmo excluir essa correia?","Aviso",JOptionPane.YES_NO_OPTION)){
                        case JOptionPane.YES_OPTION:    
                        EstoqueDAO estoquedao = new EstoqueDAO(); 
                        int id = (int) tab_estoque.getValueAt(linhaSelecionada, 0);
                        //Deletando o produto e gerando a tabela novamente
                        estoquedao.deleteEstoque(id);
                        filtro();

                    break;
                    }

                } else {
                    JOptionPane.showMessageDialog(null,"Selecione a correia que deseja excluir");
                }
            break;
        }
    }//GEN-LAST:event_del_estActionPerformed

    // editar item
    private void upd_estoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upd_estoqueActionPerformed
        LoginGUI login = Controller.getLogingui();
        
        //Requisitando permissão para gerenciamento da tabela
        switch(login.usuario.getPermissao()){
            case "COMERCIAL":
                JOptionPane.showMessageDialog(null,"Você não possui permissão!");
                break;
                
           default:
                EstoqueDAO estoquedao = new EstoqueDAO();

                int linhaSelecionada = -1;
                linhaSelecionada = tab_estoque.getSelectedRow();
                if(linhaSelecionada >=0){
                    
                    Estoque estoque = new Estoque();
                    
                    // Pegando valores da tabela
                    estoque.setId((int) tab_estoque.getValueAt(linhaSelecionada,0));
                    estoque.setCategoria((String) tab_estoque.getValueAt(linhaSelecionada,1));
                    estoque.setLonas(Integer.parseInt( String.valueOf(tab_estoque.getValueAt(linhaSelecionada,2))));
                    estoque.setLargura(Float.valueOf(String.valueOf(tab_estoque.getValueAt(linhaSelecionada,3))));
                    estoque.setMetragem(Float.valueOf(String.valueOf(tab_estoque.getValueAt(linhaSelecionada,4))));
                    estoque.setObs(String.valueOf(tab_estoque.getValueAt(linhaSelecionada, 5)));
                    
                    // Gerando JOptionPane para editar a tabela
                    Estoque updEstoque = estoquedao.pane(estoque,true);
                    if(updEstoque != null){
                        estoquedao.updadeEstoque(updEstoque, estoque.getId());
                        filtro();
                    }


                } else {
                    JOptionPane.showMessageDialog(null, "Selecione a correia que deseja editar");
                }
            break;
        }    
        
        
        
    }//GEN-LAST:event_upd_estoqueActionPerformed
    
    // voltar
    private void btn_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_voltarActionPerformed
        MenuGUI menugui = new MenuGUI();
        menugui.setVisible(true);
        menugui.setExtendedState(MAXIMIZED_BOTH);
        dispose();
    }//GEN-LAST:event_btn_voltarActionPerformed

    // filtar estoque
    private void busca_estActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busca_estActionPerformed
        filtro();
    }//GEN-LAST:event_busca_estActionPerformed

    private void box_lonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box_lonaActionPerformed
        filtro();
    }//GEN-LAST:event_box_lonaActionPerformed

    private void box_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box_categoryActionPerformed
        filtro();
    }//GEN-LAST:event_box_categoryActionPerformed

    private void largFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_largFieldActionPerformed
        filtro();
    }//GEN-LAST:event_largFieldActionPerformed

    private void metFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_metFieldActionPerformed
        filtro();
    }//GEN-LAST:event_metFieldActionPerformed

    private void submenu_newop1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenu_newop1ActionPerformed

        ROrdemProducaoGUI window = new ROrdemProducaoGUI();
        window.setVisible(true);
        window.setExtendedState(MAXIMIZED_BOTH);
        Controller.setrOrdemProducaoGUI(window);
        dispose();
    }//GEN-LAST:event_submenu_newop1ActionPerformed

    private void submenu_newproduct1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submenu_newproduct1ActionPerformed
        
        LoginGUI logingui = Controller.getLogingui();

        if("ADMINISTRADOR".equals(logingui.usuario.getPermissao())){
            ProdutosGUI window = new ProdutosGUI();
            window.setVisible(true);
            window.setLocationRelativeTo(null);
            Produto.setProdutosgui(window);
        
        } else {
            JOptionPane.showMessageDialog(null,"Acesso negado","AVISO!",JOptionPane.WARNING_MESSAGE);
        }
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

        if("ADMINISTRADOR".equals(logingui.usuario.getPermissao())){
            CUsuarioGUI window = new CUsuarioGUI();
            window.setVisible(true);
            window.setLocationRelativeTo(null);
            Controller.setcUsuarioGUI(window);
        } else {
            JOptionPane.showMessageDialog(null,"Acesso negado","AVISO!",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_submenu_user1ActionPerformed

    private void btn_reservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reservarActionPerformed
        int row = -1;
        row = tab_estoque.getSelectedRow();
        if(row >=0){
            EstoqueDAO estoquedao = new EstoqueDAO();
            int id = Integer.parseInt(String.valueOf(tab_estoque.getValueAt(row, 0)));
            estoquedao.reservado(id);
            filtro();
        } else {
            JOptionPane.showMessageDialog(null,"Selecione a correia para reservar");
        }
    }//GEN-LAST:event_btn_reservarActionPerformed

    private void box_categoryMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_box_categoryMousePressed
        categoriaBox();
    }//GEN-LAST:event_box_categoryMousePressed

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
            java.util.logging.Logger.getLogger(CEstoqueGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CEstoqueGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CEstoqueGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CEstoqueGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CEstoqueGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_estoque;
    private javax.swing.JComboBox<String> box_category;
    private javax.swing.JComboBox<String> box_lona;
    private javax.swing.JButton btn_reservar;
    private javax.swing.JButton btn_voltar;
    private javax.swing.JButton busca_est;
    private javax.swing.JButton del_est;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField largField;
    private javax.swing.JTextField metField;
    private javax.swing.JMenuItem submenu_estoque1;
    private javax.swing.JMenuItem submenu_newop1;
    private javax.swing.JMenuItem submenu_newproduct1;
    private javax.swing.JMenuItem submenu_pedidos1;
    private javax.swing.JMenuItem submenu_user1;
    private javax.swing.JMenu submenu_users1;
    private javax.swing.JTable tab_estoque;
    private javax.swing.JButton upd_estoque;
    // End of variables declaration//GEN-END:variables
}
