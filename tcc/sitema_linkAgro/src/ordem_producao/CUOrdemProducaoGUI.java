/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordem_producao;

import estoque.EstoquePendente;
import java.util.ArrayList;
import produtos.ProdutoDAO;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import produtos.Produto;

public class CUOrdemProducaoGUI extends javax.swing.JFrame {
    
    
    public CUOrdemProducaoGUI() {
        initComponents();
        categoriaBox();
 
    }
  
    public void tabela(int id){
        PedidoOpDAO pedidodao = new PedidoOpDAO();
        DefaultTableModel modelo = (DefaultTableModel) tab_pedidosOp.getModel();
        
        
        List<PedidoOp> pedidoOpList = pedidodao.selectPedidoOp(id);
        for (PedidoOp pedidoop : pedidoOpList) {
            
            Object[] line = {pedidoop.getId(),pedidoop.getNome_cliente(),pedidoop.getLargura(),pedidoop.getMetragem(),pedidoop.getCod()};
            modelo.addRow(line);
            
        }
        
    }
    
    
    ///////// Array com todos os pedidos da opmpara adicionar a tabela no banco de dados
   
    
    //Adicionando linha a tabela tab_pedidosOp e no array
    public void addRow(PedidoOp pedidoop){
       
        //adiciona na tabela
       DefaultTableModel modelo = (DefaultTableModel) tab_pedidosOp.getModel();
       Object[] line = {pedidoop.getId(),pedidoop.getNome_cliente(),pedidoop.getLargura(),pedidoop.getMetragem(),null};
       modelo.addRow(line);
       
    }
    
    // Adicionando itens da tabela no List
    public List<PedidoOp> addList(){
        List<PedidoOp> listPedidoOp = new ArrayList<>();
        
        for(int i = 0; i < tab_pedidosOp.getRowCount(); i++){
            PedidoOp pedidoop = new PedidoOp();
            pedidoop.setId((int) tab_pedidosOp.getValueAt(i,0));
            pedidoop.setNome_cliente((String) tab_pedidosOp.getValueAt(i,1));
            pedidoop.setLargura((float) tab_pedidosOp.getValueAt(i,2));
            pedidoop.setMetragem((float) tab_pedidosOp.getValueAt(i,3));
            listPedidoOp.add(pedidoop);
        }
        
        return listPedidoOp;
    }
   
    
    // Gerando itens da combobox
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
    
    
    int id;
    boolean edit = false;
   
    public void fillFields(boolean edit, int id, String categoria, String ee, String width, String length, String lonas, String setor, String observation){
        
        if(edit){
            
            idText.setText("OP: " + String.valueOf(id));
            box_category.setSelectedItem(categoria);
            box_ee.setSelectedItem(ee);
            box_width.setSelectedItem(width);
            field_length.setText(length);
            box_lonas.setSelectedItem(lonas);
            field_sector.setText(setor);
            field_observation.setText(observation);
            
            tabela(id);
            
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
        button_addPedOp = new javax.swing.JButton();
        box_ee = new javax.swing.JComboBox<>();
        box_width = new javax.swing.JComboBox<>();
        box_lonas = new javax.swing.JComboBox<>();
        button_confirm = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tab_pedidosOp = new javax.swing.JTable();
        label_sector = new javax.swing.JLabel();
        field_sector = new javax.swing.JTextField();
        button_removePedidoOp = new javax.swing.JButton();
        button_return = new javax.swing.JButton();
        idText = new javax.swing.JLabel();
        field_mtsExtra = new javax.swing.JTextField();
        label_lonas1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerar ordem de produção");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setToolTipText("");

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

        button_addPedOp.setBackground(new java.awt.Color(255, 255, 255));
        button_addPedOp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        button_addPedOp.setText("Adicionar Pedido");
        button_addPedOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_addPedOpActionPerformed(evt);
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
                "ID", "Nome do Cliente", "Largura ", "Metragem", "Cod."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tab_pedidosOp);
        if (tab_pedidosOp.getColumnModel().getColumnCount() > 0) {
            tab_pedidosOp.getColumnModel().getColumn(4).setMinWidth(40);
            tab_pedidosOp.getColumnModel().getColumn(4).setPreferredWidth(40);
            tab_pedidosOp.getColumnModel().getColumn(4).setMaxWidth(40);
        }

        label_sector.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_sector.setText("Setor");

        field_sector.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        field_sector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_sectorActionPerformed(evt);
            }
        });

        button_removePedidoOp.setBackground(new java.awt.Color(255, 255, 255));
        button_removePedidoOp.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        button_removePedidoOp.setText("Remover Pedido");
        button_removePedidoOp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_removePedidoOpActionPerformed(evt);
            }
        });

        button_return.setBackground(new java.awt.Color(255, 255, 255));
        button_return.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        button_return.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/botao-voltar (1).png"))); // NOI18N
        button_return.setBorder(null);
        button_return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_returnActionPerformed(evt);
            }
        });

        idText.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        field_mtsExtra.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        label_lonas1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_lonas1.setText("+mts");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(label_sector)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                                .addComponent(label_width)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(button_return)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(label_length)
                                        .addComponent(field_length, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(11, 11, 11)
                                            .addComponent(field_mtsExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(box_lonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(label_lonas1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(label_lonas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(label_obs)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(button_addPedOp)
                        .addGap(18, 18, 18)
                        .addComponent(button_removePedidoOp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button_confirm)
                        .addGap(20, 20, 20))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button_return, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(idText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_category)
                    .addComponent(label_ee)
                    .addComponent(label_width)
                    .addComponent(label_length)
                    .addComponent(button_addCategory)
                    .addComponent(label_lonas)
                    .addComponent(label_obs)
                    .addComponent(label_lonas1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button_addPedOp)
                            .addComponent(button_confirm)
                            .addComponent(button_removePedidoOp))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(box_category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(box_ee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(box_width, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(field_length, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(box_lonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(field_mtsExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        
        dispose();
    }//GEN-LAST:event_button_returnActionPerformed

    private void button_confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_confirmActionPerformed
        if(field_length.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Preencha todos os campos necessários para gerar a Ordem de Produção","Aviso",JOptionPane.WARNING_MESSAGE);
        } else {
            
        //Adicionando ao obj da clase modelo 
        OrdemProducao op = new OrdemProducao();
        op.setCategoria(String.valueOf(box_category.getSelectedItem()));
        op.setEe(Integer.valueOf(String.valueOf(box_ee.getSelectedItem())));
        op.setLarguraTecido(Float.valueOf(String.valueOf(box_width.getSelectedItem())));
        op.setMetragemTecido(Float.valueOf(field_length.getText()));
        op.setLonas(Integer.valueOf(String.valueOf(box_lonas.getSelectedItem())));
        op.setSetor(field_sector.getText());
        op.setObservacao(field_observation.getText());
        
        // Verificando se a op pode atender aos pedidos calculando estoque
            OrdemProducaoDAO opdao = new OrdemProducaoDAO();
            List <EstoquePendente> estPendList = opdao.estoquePend(op, addList());
            List<EstoquePendente> est = opdao.estoquePendAlt(op, addList());
            if (estPendList == null){
                JOptionPane.showMessageDialog(null,"Essa Ordem de Produção não pode atender os pedidos adicionados","AVISO!",JOptionPane.WARNING_MESSAGE);
            } else {
                
                // Criando ou editando a op
                cU(op,edit,id);
        
        
                //adicionando os pedidos da op na tabela do banco de dados
                PedidoOpDAO pedidoopdao = new PedidoOpDAO();
                for (PedidoOp pedidoop : addList()) {
                    pedidoopdao.insertPedidoOp(pedidoop,edit);
                }
                
                    // Adicionando estoque pendente ao banco de dados
                    for(EstoquePendente estpend : estPendList){
                        // Se houver estoque adiciona ao estoque pendente
                        if(estpend.getLargura() != 0 && estpend.getMetragem() != 0){
                            System.out.println("\n\nID: " + estpend.getId() + "\nCategoria: " + estpend.getCategoria() + "\nLonas: " + estpend.getLonas() + "\nLargura: " + estpend.getLargura() + "\nMetragem: " + estpend.getMetragem());
                        }
                    }
                    
                    
                    for(EstoquePendente estpend : est){
                        // Se houver estoque adiciona ao estoque pendente
                        if(estpend.getLargura() != 0 && estpend.getMetragem() != 0){
                            System.out.println("\n\nID: " + estpend.getId() + "\nCategoria: " + estpend.getCategoria() + "\nLonas: " + estpend.getLonas() + "\nLargura: " + estpend.getLargura() + "\nMetragem: " + estpend.getMetragem());
                        }
                    }

                
                //Atualizando a tabela de op GUI
                ROrdemProducaoGUI ropgui = ControllerOP.getrOrdemProducaoGUI();
                ropgui.tabela();
                ropgui.tabelaPedidosOp();
                        
                dispose();
                }
            
            }

    }//GEN-LAST:event_button_confirmActionPerformed

    private void box_eeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box_eeActionPerformed
        
    }//GEN-LAST:event_box_eeActionPerformed

    private void button_addCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_addCategoryActionPerformed
        ProdutoDAO ordemproducaodao = new ProdutoDAO();
        String produto = JOptionPane.showInputDialog(null,"Digite o nome do novo produto a ser adicionado");

        if(produto.equals("")){
            JOptionPane.showMessageDialog(null, "Nome inválido");
        } else {
            ordemproducaodao.adicionaProduto(produto);
            categoriaBox();
        }

    }//GEN-LAST:event_button_addCategoryActionPerformed

    private void box_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box_categoryActionPerformed
     
    }//GEN-LAST:event_box_categoryActionPerformed

    private void button_addPedOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_addPedOpActionPerformed
        JFrame window = new CPedidoOpGUI();
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_button_addPedOpActionPerformed

    private void field_sectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_sectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_field_sectorActionPerformed

    private void button_removePedidoOpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_removePedidoOpActionPerformed
        int selectedRow = -1;
        selectedRow = tab_pedidosOp.getSelectedRow();
        
        if(selectedRow >=0){
            
            switch(JOptionPane.showConfirmDialog(null,"Deseja mesmo excluir essa pedido?","Aviso",JOptionPane.YES_NO_OPTION)){
                
                case JOptionPane.YES_OPTION:    
                    if(edit){
                        //Deleta o pedido que está cadastrado no banco de dados
                        int cod = (int) tab_pedidosOp.getValueAt(selectedRow, 4);
                        PedidoOpDAO pedidoopdao = new PedidoOpDAO();
                        pedidoopdao.deletePedidoOp(cod);
                        
                        ((DefaultTableModel) tab_pedidosOp.getModel()).removeRow(selectedRow);  
                        
                    } else {
                        ((DefaultTableModel) tab_pedidosOp.getModel()).removeRow(selectedRow);   
                    }
                    
                break;
            }
            
        } else {
            JOptionPane.showMessageDialog(null,"Selecione o pedido que deseja excluir.");
        }
    }//GEN-LAST:event_button_removePedidoOpActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
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
    private javax.swing.JButton button_addPedOp;
    private javax.swing.JButton button_confirm;
    private javax.swing.JButton button_removePedidoOp;
    private javax.swing.JButton button_return;
    private javax.swing.JTextField field_length;
    private javax.swing.JTextField field_mtsExtra;
    private javax.swing.JTextArea field_observation;
    private javax.swing.JTextField field_sector;
    private javax.swing.JLabel idText;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_category;
    private javax.swing.JLabel label_ee;
    private javax.swing.JLabel label_length;
    private javax.swing.JLabel label_lonas;
    private javax.swing.JLabel label_lonas1;
    private javax.swing.JLabel label_obs;
    private javax.swing.JLabel label_sector;
    private javax.swing.JLabel label_width;
    private javax.swing.JTable tab_pedidosOp;
    // End of variables declaration//GEN-END:variables
}
