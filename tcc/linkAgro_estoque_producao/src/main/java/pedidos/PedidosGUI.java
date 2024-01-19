/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package pedidos;

import com.toedter.calendar.JTextFieldDateEditor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import menus.Controller;

/**
 *
 * @author Lenovo
 */
public class PedidosGUI extends javax.swing.JDialog {

    /**
     * Creates new form CPedidosGU
     */
    public PedidosGUI(java.awt.Frame parent, boolean modal, Pedido pedido) {
        super(parent, modal);
        initComponents();
        this.pedido = pedido;
        if(pedido != null){
            idField.setText(String.valueOf(pedido.getId()));
            nomeField.setText(pedido.getNomeCliente());
            try{
                dateFech.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(pedido.getFechamento()));
            }catch(ParseException e){
            }
            dateEmba.setText(pedido.getEmbarque());
            prazoField.setText(String.valueOf(pedido.getPrazo()));
            obsField.setText(pedido.getObservacao());

        }
        this.getRootPane().setDefaultButton(btn_confirm);
    }

    Pedido pedido = null;
    
    public void dataEmbarque(){
        avisoText.setText("");
        if(dateFech.getDate() != null && prazoField.getText() != null && !"".equals(prazoField.getText())){
               try{
                    int prazo = Integer.parseInt(prazoField.getText());
                    Calendar calendario = Calendar.getInstance();
                    calendario.setTime(dateFech.getDate());
                    
                    for(int i = 1; i <= prazo; i++){
                        
                        calendario.add(Calendar.DAY_OF_MONTH, 1);
                        if(calendario.get(calendario.DAY_OF_WEEK) == calendario.SATURDAY || calendario.get(calendario.DAY_OF_WEEK) == calendario.SUNDAY){
                            calendario.add(Calendar.DAY_OF_MONTH, 2);
                        }
                    }
                    
                    
                    //Formato da data
                    SimpleDateFormat dateForm = new SimpleDateFormat("dd/MM/yyyy");

                    dateEmba.setText(String.valueOf(dateForm.format(calendario.getTime())));
               }catch(NumberFormatException e){
                   avisoText.setText("!");
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

        jPanel34 = new javax.swing.JPanel();
        idText = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        idText1 = new javax.swing.JLabel();
        nomeField = new javax.swing.JTextField();
        idText2 = new javax.swing.JLabel();
        dateFech = new com.toedter.calendar.JDateChooser();
        idText3 = new javax.swing.JLabel();
        prazoField = new javax.swing.JTextField();
        idText4 = new javax.swing.JLabel();
        jScrollPane34 = new javax.swing.JScrollPane();
        obsField = new javax.swing.JTextArea();
        idText5 = new javax.swing.JLabel();
        btn_confirm = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        dateEmba = new javax.swing.JTextField();
        avisoText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pedido");

        jPanel34.setBackground(new java.awt.Color(255, 255, 255));
        jPanel34.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        idText.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idText.setText("ID Pedido:");

        idText1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idText1.setText("NomeCliente:");

        idText2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idText2.setText("Data Fechamento:");

        // Desabilita a edição do campo de texto associado ao JDateChooser
        JTextFieldDateEditor editor = (JTextFieldDateEditor) dateFech.getDateEditor();
        editor.setEditable(false);

        idText3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idText3.setText("Prazo(dias úteis):");

        prazoField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                prazoFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                prazoFieldFocusLost(evt);
            }
        });
        prazoField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                prazoFieldKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                prazoFieldKeyReleased(evt);
            }
        });

        idText4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idText4.setText("Data Embarque:");

        obsField.setColumns(20);
        obsField.setRows(5);
        jScrollPane34.setViewportView(obsField);

        idText5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idText5.setText("Observação:");

        btn_confirm.setBackground(new java.awt.Color(255, 255, 255));
        btn_confirm.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_confirm.setText("Confirmar");
        btn_confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_confirmActionPerformed(evt);
            }
        });

        btn_cancel.setBackground(new java.awt.Color(255, 255, 255));
        btn_cancel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btn_cancel.setText("Cancelar");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        dateEmba.setEditable(false);

        avisoText.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        avisoText.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_confirm)
                .addGap(18, 18, 18)
                .addComponent(btn_cancel)
                .addGap(380, 380, 380))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel34Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(idText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idText1)
                    .addComponent(idText5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane34, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeField, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idText2)
                    .addComponent(idText4))
                .addGap(18, 18, 18)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateEmba)
                    .addComponent(dateFech, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(idText3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(avisoText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(prazoField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(avisoText, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addComponent(dateFech, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel34Layout.createSequentialGroup()
                        .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(idText)
                                .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(idText1)
                                .addComponent(nomeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(idText2))
                            .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(idText3)
                                .addComponent(prazoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idText5)
                            .addComponent(jScrollPane34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel34Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(idText4)
                                    .addComponent(dateEmba, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                        .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_cancel)
                            .addComponent(btn_confirm))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_confirmActionPerformed
        //if para impedir que seja cadastrado como null
                if (idField.getText().isEmpty() || nomeField.getText().isEmpty() || prazoField.getText().isEmpty() || dateFech.getDate() == null) {
                    //JOptionPane de alerta
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos de cadastro!", "ERRO!", JOptionPane.WARNING_MESSAGE);
                } else {    
                    
                    String fech = null;
                    
                        //Formato da data
                        SimpleDateFormat dateForm = new SimpleDateFormat("dd/MM/yyyy");
        
                        //Fechamento
                        java.util.Date fechUtil = dateFech.getDate(); //Pegando o valor registrado no JDateChooser e colocando em uma variável String
                        fech = dateForm.format(fechUtil);                                
                            
                        
                    try{
                            Pedido pedido = new Pedido();
                            //Criando objeto na classe modelo
                            pedido.setId(Integer.parseInt(idField.getText()));
                            pedido.setPrazo(Integer.parseInt(prazoField.getText()));

                            pedido.setNomeCliente(nomeField.getText());
                            pedido.setFechamento( fech);
                            pedido.setEmbarque( dateEmba.getText());
                            pedido.setObservacao(obsField.getText());
                        PedidoDAO dao = new PedidoDAO();
                        if(this.pedido != null){
                            dao.updatePedido(pedido, pedido.getId());
                        } else {
                            dao.insertPedido(pedido);
                        }
                        Controller.getcPedidosGUI().tabelaProd();
                        Controller.getcPedidosGUI().tabelaArch();

                        dispose();

                    }catch(NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "Preencha os campos ID e PRAZO com valores numéricos inteiros.","ERRO",JOptionPane.ERROR_MESSAGE);
                    }    
                
                }
        
        
        
    }//GEN-LAST:event_btn_confirmActionPerformed

    private void prazoFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prazoFieldKeyPressed
    }//GEN-LAST:event_prazoFieldKeyPressed

    private void prazoFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_prazoFieldKeyReleased
        dataEmbarque();
    }//GEN-LAST:event_prazoFieldKeyReleased

    private void prazoFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_prazoFieldFocusGained
        dataEmbarque();
    }//GEN-LAST:event_prazoFieldFocusGained

    private void prazoFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_prazoFieldFocusLost
        dataEmbarque();
    }//GEN-LAST:event_prazoFieldFocusLost

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        dispose();
    }//GEN-LAST:event_btn_cancelActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avisoText;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_confirm;
    private javax.swing.JTextField dateEmba;
    private com.toedter.calendar.JDateChooser dateFech;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel idText;
    private javax.swing.JLabel idText1;
    private javax.swing.JLabel idText2;
    private javax.swing.JLabel idText3;
    private javax.swing.JLabel idText4;
    private javax.swing.JLabel idText5;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JScrollPane jScrollPane34;
    private javax.swing.JTextField nomeField;
    private javax.swing.JTextArea obsField;
    private javax.swing.JTextField prazoField;
    // End of variables declaration//GEN-END:variables
}