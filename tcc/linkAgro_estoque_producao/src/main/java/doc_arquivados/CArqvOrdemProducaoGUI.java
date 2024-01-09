/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package doc_arquivados;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import menus.Controller;
import ordem_producao.OrdemProducao;
import ordem_producao.PedidoOp;
import ordem_producao.PedidoOpDAO;
import pedidos.Pedido;

/**
 *
 * @author Lenovo
 */
public class CArqvOrdemProducaoGUI extends javax.swing.JFrame {

    /**
     * Creates new form CArqvOrdemProducaoGUI
     */
    public CArqvOrdemProducaoGUI(OrdemProducao op, RelatorioOp relatorio, boolean edit) {
        initComponents();
        fillFilds(op,relatorio, edit);
        
    }
    int id_op;
    public int selectedRow = -1;
    boolean edit = false;
    
     public void addRow(Object[] line){
        DefaultTableModel modeloArch = (DefaultTableModel) tab_pedidos.getModel();
        modeloArch.addRow(line);
    }
    
    
    public void fillFilds(OrdemProducao op, RelatorioOp relatorio, boolean edit) {
        idText.setText("OP: " + op.getId());
        
        box_category.addItem(op.getCategoria());
        box_ee.addItem(String.valueOf(op.getEe()));
        box_largTecido.addItem(String.valueOf(op.getLarguraTecido()));
        field_length.setText(String.valueOf(op.getMetragemTecido()));
        field_mtsExtra.setText(String.valueOf(op.getMetExtra()));
        box_lonas.addItem(String.valueOf(op.getLonas()));
        field_espessura.setText(op.getEspessura());
        field_observation.setText(op.getObservacao());
        
        this.id_op = op.getId();
        if(edit){
            this.edit = edit;
            button_confirm.setText("Atualizar");
            
            try{
                
            //Formato da data
            SimpleDateFormat dateForm = new SimpleDateFormat("dd/MM/yyyy");
            
            cal_dataInicio.setDate(dateForm.parse(relatorio.getCal_dataInicio()));
            cal_horaInicio.setText(relatorio.getCal_horaInicio());
            cal_horaFim.setText(relatorio.getCal_horaFim());
            cal_dataFim.setDate(dateForm.parse(relatorio.getCal_dataFim()));
            cal_espessura.setText(relatorio.getCal_espessura());
            cal_resp.setText(relatorio.getCal_resp());
            obs_cal.setText(relatorio.getObs_cal());
            
            pre_dataInicio.setDate(dateForm.parse(relatorio.getPre_dataInicio()));
            pre_horaInicio.setText(relatorio.getPre_horaInicio());
            pre_horaFim.setText(relatorio.getPre_horaFim());
            pre_dataFim.setDate(dateForm.parse(relatorio.getPre_dataFim()));
            pre_tempo.setText(relatorio.getPre_tempo());
            pre_resp.setText(relatorio.getPre_resp());
            obs_pre.setText(relatorio.getObs_pre());
            
            cor_dataInicio.setDate(dateForm.parse(relatorio.getCor_dataInicio()));
            cor_horaInicio.setText(relatorio.getCor_horaInicio());
            cor_horaFim.setText(relatorio.getCor_horaFim());
            cor_dataFim.setDate(dateForm.parse(relatorio.getCor_dataFim()));
            if("SIM".equals(relatorio.getCor_concerto())){
                cor_btnConcerto.setSelected(true);
                cor_btnConcerto.setText("SIM");
            } else {
                cor_btnConcerto.setSelected(false);
                cor_btnConcerto.setText("NÃO");
            }
            cor_resp.setText(relatorio.getCor_resp());
            obs_cor.setText(relatorio.getObs_cor());
            
            
            
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
        
        tabelas(op.getId());
        
    }
    
    
    //Gerando itens na tabela
    public void tabelas(int id){
        PedidoOpDAO pedidodao = new PedidoOpDAO();
        DefaultTableModel modeloOp = (DefaultTableModel) tab_pedidosOp.getModel();
        DefaultTableModel modeloArch = (DefaultTableModel) tab_pedidos.getModel();
        
        OpArqvDAO dao = new OpArqvDAO();
        List<Pedido> listPedidos = new ArrayList<>();
        
        List<PedidoOp> pedidoOpList = pedidodao.selectPedidoOp(id);
        for (PedidoOp pedidoop : pedidoOpList) {
            
            Object[] line = {pedidoop.getId(),pedidoop.getNome_cliente(),pedidoop.getLargura(),pedidoop.getMetragem(),pedidoop.getCod()};
            modeloOp.addRow(line);
            
            Pedido pedido = dao.selectPedidobyId(pedidoop.getId(), edit);
            if(!listPedidos.contains(pedido) && pedido.getId() != 0){
                listPedidos.add(pedido);
                    Object[] lineArch = {pedido.getId(),pedido.getNomeCliente(),pedido.getFechamento(),pedido.getEmbarque(),pedido.getObservacao()};
                    modeloArch.addRow(lineArch);
            
            }
            
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
        button_return = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cal_resp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cal_espessura = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cal_dataFim = new com.toedter.calendar.JDateChooser();
        cal_horaInicio = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        cal_horaFim = new javax.swing.JFormattedTextField();
        cal_dataInicio = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        obs_cal = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        obs_pre = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        pre_resp = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        pre_dataFim = new com.toedter.calendar.JDateChooser();
        pre_horaInicio = new javax.swing.JFormattedTextField();
        jLabel18 = new javax.swing.JLabel();
        pre_horaFim = new javax.swing.JFormattedTextField();
        pre_dataInicio = new com.toedter.calendar.JDateChooser();
        pre_tempo = new javax.swing.JFormattedTextField();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        obs_cor = new javax.swing.JTextArea();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        cor_resp = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        cor_dataFim = new com.toedter.calendar.JDateChooser();
        cor_horaInicio = new javax.swing.JFormattedTextField();
        jLabel27 = new javax.swing.JLabel();
        cor_horaFim = new javax.swing.JFormattedTextField();
        cor_dataInicio = new com.toedter.calendar.JDateChooser();
        cor_btnConcerto = new javax.swing.JToggleButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tab_pedidosOp = new javax.swing.JTable();
        box_category = new javax.swing.JComboBox<>();
        label_category = new javax.swing.JLabel();
        label_ee = new javax.swing.JLabel();
        box_ee = new javax.swing.JComboBox<>();
        box_largTecido = new javax.swing.JComboBox<>();
        label_width = new javax.swing.JLabel();
        label_length = new javax.swing.JLabel();
        field_length = new javax.swing.JTextField();
        field_mtsExtra = new javax.swing.JTextField();
        label_lonas1 = new javax.swing.JLabel();
        label_lonas = new javax.swing.JLabel();
        box_lonas = new javax.swing.JComboBox<>();
        field_espessura = new javax.swing.JTextField();
        label_espessura = new javax.swing.JLabel();
        label_obs = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        field_observation = new javax.swing.JTextArea();
        label_obs1 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tab_pedidos = new javax.swing.JTable();
        button_confirm = new javax.swing.JButton();
        label_obs2 = new javax.swing.JLabel();
        del_pedido = new javax.swing.JButton();
        add_pedido = new javax.swing.JButton();
        upd_pedido = new javax.swing.JButton();
        idText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Relatório");

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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Relatório de Produção");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setText("Calandra:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Hora Início:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Hora Fim:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Data Fim:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Espessura:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Responsável:");

        try {
            cal_horaInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Data Início:");

        try {
            cal_horaFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel6)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cal_dataInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cal_dataFim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cal_horaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cal_horaFim, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cal_espessura)
                    .addComponent(cal_resp, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(cal_dataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cal_horaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(3, 3, 3)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cal_horaFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(55, 55, 55)))
                        .addGap(3, 3, 3)
                        .addComponent(cal_dataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(cal_espessura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(cal_resp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(25, 25, 25))
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        obs_cal.setColumns(20);
        obs_cal.setRows(5);
        jScrollPane1.setViewportView(obs_cal);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel11.setText("OBS Calandra:");

        obs_pre.setColumns(20);
        obs_pre.setRows(5);
        jScrollPane2.setViewportView(obs_pre);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel12.setText("OBS Prensa:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Hora Início:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Hora Fim:");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Data Fim:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Tempo (min.):");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Responsável:");

        try {
            pre_horaInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Data Início:");

        try {
            pre_horaFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            pre_tempo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel18)
                        .addComponent(jLabel13)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(pre_dataInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pre_dataFim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pre_horaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pre_horaFim, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(pre_resp, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pre_tempo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addGap(25, 25, 25))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(pre_dataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(pre_horaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pre_horaFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(3, 3, 3)
                        .addComponent(pre_dataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(pre_tempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pre_resp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel19.setText("Prensa:");

        obs_cor.setColumns(20);
        obs_cor.setRows(5);
        jScrollPane3.setViewportView(obs_cor);

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel20.setText("Corte:");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel21.setText("OBS Corte:");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Hora Início:");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Hora Fim:");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setText("Data Fim:");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setText("Concerto:");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("Responsável:");

        try {
            cor_horaInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setText("Data Início:");

        try {
            cor_horaFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        cor_btnConcerto.setBackground(new java.awt.Color(255, 255, 255));
        cor_btnConcerto.setText("NÃO");
        cor_btnConcerto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cor_btnConcertoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25)
                            .addComponent(jLabel22))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cor_horaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cor_horaFim, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cor_dataInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cor_btnConcerto, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cor_dataFim, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(cor_resp))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel24)
                        .addGap(60, 60, 60))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(cor_dataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(cor_horaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(cor_horaFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel25))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(cor_dataFim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cor_btnConcerto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cor_resp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(button_return)
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addContainerGap(410, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel2)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel21)
                    .addComponent(jLabel12)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(button_return)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(62, 62, 62))
        );

        jPanel5.setBackground(new java.awt.Color(236, 236, 236));

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
        tab_pedidosOp.setSelectionBackground(new java.awt.Color(153, 153, 153));
        //Centralizando valores nas celulas das colunas 0, 2, 3 e 4
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        tab_pedidosOp.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tab_pedidosOp.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tab_pedidosOp.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tab_pedidosOp.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
        jScrollPane4.setViewportView(tab_pedidosOp);
        if (tab_pedidosOp.getColumnModel().getColumnCount() > 0) {
            tab_pedidosOp.getColumnModel().getColumn(0).setMinWidth(50);
            tab_pedidosOp.getColumnModel().getColumn(0).setPreferredWidth(50);
            tab_pedidosOp.getColumnModel().getColumn(0).setMaxWidth(50);
            tab_pedidosOp.getColumnModel().getColumn(2).setMinWidth(75);
            tab_pedidosOp.getColumnModel().getColumn(2).setPreferredWidth(75);
            tab_pedidosOp.getColumnModel().getColumn(2).setMaxWidth(75);
            tab_pedidosOp.getColumnModel().getColumn(3).setMinWidth(75);
            tab_pedidosOp.getColumnModel().getColumn(3).setPreferredWidth(75);
            tab_pedidosOp.getColumnModel().getColumn(3).setMaxWidth(75);
            tab_pedidosOp.getColumnModel().getColumn(4).setMinWidth(40);
            tab_pedidosOp.getColumnModel().getColumn(4).setPreferredWidth(40);
            tab_pedidosOp.getColumnModel().getColumn(4).setMaxWidth(40);
        }

        box_category.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        box_category.setEditable(false);
        box_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box_categoryActionPerformed(evt);
            }
        });

        label_category.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_category.setText("Categoria");

        label_ee.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_ee.setText("EE");

        box_ee.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        box_ee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box_eeActionPerformed(evt);
            }
        });

        box_largTecido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        box_largTecido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box_largTecidoActionPerformed(evt);
            }
        });

        label_width.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_width.setText("Largura Tecido");

        label_length.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_length.setText("Metragem Tecido");

        field_length.setEditable(false);
        field_length.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        field_mtsExtra.setEditable(false);
        field_mtsExtra.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        label_lonas1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_lonas1.setText("+mts");

        label_lonas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_lonas.setText("Lonas");

        box_lonas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        field_espessura.setEditable(false);
        field_espessura.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        label_espessura.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_espessura.setText("Espessura");

        label_obs.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_obs.setText("Observação");

        field_observation.setEditable(false);
        field_observation.setColumns(20);
        field_observation.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        field_observation.setRows(5);
        jScrollPane5.setViewportView(field_observation);

        label_obs1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        label_obs1.setText("Pedidos da Ordem de Produção");

        tab_pedidos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tab_pedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome do Cliente", "Data Fechamento", "Data Embarque", "OBS"
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
        tab_pedidos.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tab_pedidos.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tab_pedidos.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        jScrollPane6.setViewportView(tab_pedidos);
        if (tab_pedidos.getColumnModel().getColumnCount() > 0) {
            tab_pedidos.getColumnModel().getColumn(0).setMinWidth(50);
            tab_pedidos.getColumnModel().getColumn(0).setPreferredWidth(50);
            tab_pedidos.getColumnModel().getColumn(0).setMaxWidth(50);
            tab_pedidos.getColumnModel().getColumn(2).setMinWidth(100);
            tab_pedidos.getColumnModel().getColumn(2).setPreferredWidth(100);
            tab_pedidos.getColumnModel().getColumn(2).setMaxWidth(100);
            tab_pedidos.getColumnModel().getColumn(3).setMinWidth(100);
            tab_pedidos.getColumnModel().getColumn(3).setPreferredWidth(100);
            tab_pedidos.getColumnModel().getColumn(3).setMaxWidth(100);
        }

        button_confirm.setBackground(new java.awt.Color(255, 255, 255));
        button_confirm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        button_confirm.setText("Confirmar");
        button_confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_confirmActionPerformed(evt);
            }
        });

        label_obs2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        label_obs2.setText("Pedidos a serem arquivados");

        del_pedido.setBackground(new java.awt.Color(255, 255, 255));
        del_pedido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        del_pedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/excluir.png"))); // NOI18N
        del_pedido.setText("Excluir");
        del_pedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                del_pedidoActionPerformed(evt);
            }
        });

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

        idText.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        idText.setText("OP: ");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(label_obs2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(add_pedido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(upd_pedido, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(del_pedido))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(label_category, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(box_category, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(label_ee)
                                        .addComponent(box_ee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(label_width, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(box_largTecido, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(22, 22, 22)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(label_length)
                                        .addComponent(field_length, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addGap(11, 11, 11)
                                            .addComponent(field_mtsExtra, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(box_lonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(label_lonas1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(label_lonas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(field_espessura, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label_espessura)))
                                .addComponent(label_obs)
                                .addComponent(label_obs1)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_confirm))
                        .addGap(0, 663, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(idText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_category)
                    .addComponent(label_ee)
                    .addComponent(label_width)
                    .addComponent(label_length)
                    .addComponent(label_lonas)
                    .addComponent(label_lonas1)
                    .addComponent(label_espessura))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(box_category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box_ee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field_length, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box_lonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field_mtsExtra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box_largTecido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field_espessura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(label_obs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_obs1)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(add_pedido)
                        .addComponent(upd_pedido)
                        .addComponent(del_pedido))
                    .addComponent(label_obs2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(button_confirm)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_returnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_returnActionPerformed
        dispose();
    }//GEN-LAST:event_button_returnActionPerformed

    private void cor_btnConcertoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cor_btnConcertoActionPerformed
        if(cor_btnConcerto.isSelected()){
            cor_btnConcerto.setText("SIM");
        } else {
            cor_btnConcerto.setText("NÃO");
        }
        
    }//GEN-LAST:event_cor_btnConcertoActionPerformed

    private void button_confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_confirmActionPerformed

        
        if( cal_dataInicio.getDateFormatString().isEmpty() || cal_horaInicio.getText().isEmpty() || cal_horaFim.getText().isEmpty() || cal_dataFim.getDateFormatString().isEmpty() ||cal_espessura.getText().isEmpty() || cal_resp.getText().isEmpty() ||
            pre_dataInicio.getDateFormatString().isEmpty() || pre_horaInicio.getText().isEmpty() || pre_horaFim.getText().isEmpty() || pre_dataFim.getDateFormatString().isEmpty() || pre_tempo.getText().isEmpty()    || pre_resp.getText().isEmpty() ||
            cor_dataInicio.getDateFormatString().isEmpty() || cor_horaInicio.getText().isEmpty() || cor_horaFim.getText().isEmpty() || cor_dataFim.getDateFormatString().isEmpty() || cor_resp.getText().isEmpty() ){
                
                JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios.");

        } else {
                
                RelatorioOp relatorio = new RelatorioOp();
                //Formato da data
                SimpleDateFormat dateForm = new SimpleDateFormat("dd/MM/yyyy");

                    //calandra
                    relatorio.setCal_dataInicio(dateForm.format(cal_dataInicio.getDate()));
                    relatorio.setCal_horaInicio(cal_horaInicio.getText());
                    relatorio.setCal_horaFim(cal_horaFim.getText());
                    relatorio.setCal_dataFim(dateForm.format(cal_dataFim.getDate()));
                    relatorio.setCal_espessura(cal_espessura.getText());
                    relatorio.setCal_resp(cal_resp.getText());
                    relatorio.setObs_cal(obs_cal.getText());

                    //prensa
                    relatorio.setPre_dataInicio(dateForm.format(pre_dataInicio.getDate()));
                    relatorio.setPre_horaInicio(pre_horaInicio.getText());
                    relatorio.setPre_horaFim(pre_horaFim.getText());
                    relatorio.setPre_dataFim(dateForm.format(pre_dataFim.getDate()));
                    relatorio.setPre_tempo(pre_tempo.getText());
                    relatorio.setPre_resp(pre_resp.getText());
                    relatorio.setObs_pre(obs_pre.getText());


                    //corte
                    relatorio.setCor_dataInicio(dateForm.format(cor_dataInicio.getDate()));
                    relatorio.setCor_horaInicio(cor_horaInicio.getText());
                    relatorio.setCor_horaFim(cor_horaFim.getText());
                    relatorio.setCor_dataFim(dateForm.format(cor_dataFim.getDate()));
                    relatorio.setCor_concerto(cor_btnConcerto.getText());
                    relatorio.setCor_resp(cor_resp.getText());
                    relatorio.setObs_cor(obs_cor.getText());
                    
                    List<Pedido> listPedArch = new ArrayList<>();
                    for(int i = 0; i < tab_pedidos.getRowCount(); i++){
                        Pedido pedido = new Pedido();
                        pedido.setId(Integer.parseInt(String.valueOf(tab_pedidos.getValueAt(i, 0))));
                        pedido.setNomeCliente(String.valueOf(tab_pedidos.getValueAt(i,1)));
                        pedido.setFechamento(String.valueOf(tab_pedidos.getValueAt(i,2)));
                        pedido.setEmbarque(String.valueOf(tab_pedidos.getValueAt(i, 3)));
                        pedido.setObservacao(String.valueOf(tab_pedidos.getValueAt(i, 4)));
                        listPedArch.add(pedido);
                    }
                    
                    OpArqvDAO oparqvDAO = new OpArqvDAO();
                    if(edit){
                        oparqvDAO.updateRelatorio(listPedArch, id_op, relatorio);
                    }else{
                        oparqvDAO.insertRelatorio(listPedArch, id_op, relatorio);
                    }
                    Controller.getrOrdemProducaoGUI().tabelaProd();
                    Controller.getrOrdemProducaoGUI().tabelaArch();
                    
                    dispose();
        }
        
        
    }//GEN-LAST:event_button_confirmActionPerformed

    private void box_largTecidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box_largTecidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_box_largTecidoActionPerformed

    private void box_eeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box_eeActionPerformed

    }//GEN-LAST:event_box_eeActionPerformed

    private void box_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box_categoryActionPerformed

    }//GEN-LAST:event_box_categoryActionPerformed

    private void add_pedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_pedidoActionPerformed
        ArqvPedido arqvPedido = new ArqvPedido();
        arqvPedido.setVisible(true);
        arqvPedido.setLocationRelativeTo(null);
        List<Pedido> listArch = new ArrayList<>();
        for(int i = 0; i < tab_pedidos.getRowCount(); i++){
            Pedido pedido = new Pedido();
            pedido.setId(Integer.valueOf(String.valueOf(tab_pedidos.getValueAt(i, 0))));
            pedido.setNomeCliente(String.valueOf(tab_pedidos.getValueAt(i,1)));
            pedido.setFechamento(String.valueOf(tab_pedidos.getValueAt(i,2)));
            pedido.setEmbarque(String.valueOf(tab_pedidos.getValueAt(i, 3)));
            pedido.setObservacao(String.valueOf(tab_pedidos.getValueAt(i, 4)));
            listArch.add(pedido);
        }
        
        arqvPedido.tabela(id_op, listArch);
    }//GEN-LAST:event_add_pedidoActionPerformed

    private void upd_pedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upd_pedidoActionPerformed
  
        selectedRow = tab_pedidos.getSelectedRow();
        if(selectedRow>=0){
            ArqvPedido arqvPedido = new ArqvPedido();
            arqvPedido.setVisible(true);
            arqvPedido.setLocationRelativeTo(null);
            List<Pedido> listArch = new ArrayList<>();
            for(int i = 0; i < tab_pedidos.getRowCount(); i++){
                Pedido pedido = new Pedido();
                pedido.setId(Integer.valueOf(String.valueOf(tab_pedidos.getValueAt(i, 0))));
                pedido.setNomeCliente(String.valueOf(tab_pedidos.getValueAt(i,1)));
                pedido.setFechamento(String.valueOf(tab_pedidos.getValueAt(i,2)));
                pedido.setEmbarque(String.valueOf(tab_pedidos.getValueAt(i, 3)));
                pedido.setObservacao(String.valueOf(tab_pedidos.getValueAt(i, 4)));
                listArch.add(pedido);
        }
        
        arqvPedido.tabela(id_op, listArch);
        arqvPedido.edit = true;
            
        }else{
            JOptionPane.showMessageDialog(null,"Selecione um pedido");
        }
        
    }//GEN-LAST:event_upd_pedidoActionPerformed

    private void del_pedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_del_pedidoActionPerformed
        
        int selectedRow = -1;
        selectedRow = tab_pedidos.getSelectedRow();
        if(selectedRow>=0){
            DefaultTableModel modelo = (DefaultTableModel) tab_pedidos.getModel();
            //Desarquivando Pedido
            OpArqvDAO oparqvDAO = new OpArqvDAO();
            oparqvDAO.archivePedidos(Integer.parseInt(String.valueOf(tab_pedidos.getValueAt(selectedRow, 0))), false);
                
            modelo.removeRow(selectedRow);
            
        }else{
            JOptionPane.showMessageDialog(null,"Selecione um pedido");
        }
    }//GEN-LAST:event_del_pedidoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_pedido;
    private javax.swing.JComboBox<String> box_category;
    private javax.swing.JComboBox<String> box_ee;
    private javax.swing.JComboBox<String> box_largTecido;
    private javax.swing.JComboBox<String> box_lonas;
    private javax.swing.JButton button_confirm;
    private javax.swing.JButton button_return;
    private com.toedter.calendar.JDateChooser cal_dataFim;
    private com.toedter.calendar.JDateChooser cal_dataInicio;
    private javax.swing.JTextField cal_espessura;
    private javax.swing.JFormattedTextField cal_horaFim;
    private javax.swing.JFormattedTextField cal_horaInicio;
    private javax.swing.JTextField cal_resp;
    private javax.swing.JToggleButton cor_btnConcerto;
    private com.toedter.calendar.JDateChooser cor_dataFim;
    private com.toedter.calendar.JDateChooser cor_dataInicio;
    private javax.swing.JFormattedTextField cor_horaFim;
    private javax.swing.JFormattedTextField cor_horaInicio;
    private javax.swing.JTextField cor_resp;
    private javax.swing.JButton del_pedido;
    private javax.swing.JTextField field_espessura;
    private javax.swing.JTextField field_length;
    private javax.swing.JTextField field_mtsExtra;
    private javax.swing.JTextArea field_observation;
    private javax.swing.JLabel idText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel label_category;
    private javax.swing.JLabel label_ee;
    private javax.swing.JLabel label_espessura;
    private javax.swing.JLabel label_length;
    private javax.swing.JLabel label_lonas;
    private javax.swing.JLabel label_lonas1;
    private javax.swing.JLabel label_obs;
    private javax.swing.JLabel label_obs1;
    private javax.swing.JLabel label_obs2;
    private javax.swing.JLabel label_width;
    private javax.swing.JTextArea obs_cal;
    private javax.swing.JTextArea obs_cor;
    private javax.swing.JTextArea obs_pre;
    private com.toedter.calendar.JDateChooser pre_dataFim;
    private com.toedter.calendar.JDateChooser pre_dataInicio;
    private javax.swing.JFormattedTextField pre_horaFim;
    private javax.swing.JFormattedTextField pre_horaInicio;
    private javax.swing.JTextField pre_resp;
    private javax.swing.JFormattedTextField pre_tempo;
    public javax.swing.JTable tab_pedidos;
    private javax.swing.JTable tab_pedidosOp;
    private javax.swing.JButton upd_pedido;
    // End of variables declaration//GEN-END:variables
}
