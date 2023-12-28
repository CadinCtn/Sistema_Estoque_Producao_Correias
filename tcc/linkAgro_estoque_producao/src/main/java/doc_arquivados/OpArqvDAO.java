/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doc_arquivados;

import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ordem_producao.OrdemProducao;
import ordem_producao.PedidoOp;
import pedidos.Pedido;

/**
 *
 * @author Lenovo
 */
public class OpArqvDAO {
    
    
    private Connection connection;
    
    public OpArqvDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    //Criando Relatorio
    public void insertRelatorio(List<Pedido> listPedidos, OrdemProducao op, List<PedidoOp> listPedidoOp, RelatorioOp relatorio){
        
        String criaRelatorio = "INSERT INTO relatorios_op (id, cal_dataInicio, cal_horaInicio, cal_horaFim, cal_dataFim, cal_espessura, cal_responsavel, cal_obs,pre_dataInicio, pre_horaInicio, pre_horaFim, pre_dataFim, pre_tempo, pre_responsavel, pre_obs, cor_dataInicio, cor_horaInicio, cor_horaFim, cor_dataFim, cor_concerto, cor_responsavel, cor_obs) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
        
        try{
            
            //Criando Relatório da Ordem de produção
            PreparedStatement stmt = connection.prepareStatement(criaRelatorio);
                stmt.setInt(1, op.getId());
                
                stmt.setString(2, relatorio.getCal_dataInicio());
                stmt.setString(3, relatorio.getCal_horaInicio());
                stmt.setString(4, relatorio.getCal_horaFim());
                stmt.setString(5, relatorio.getCal_dataFim());
                stmt.setString(6, relatorio.getCal_espessura());
                stmt.setString(7, relatorio.getCal_resp());
                stmt.setString(8, relatorio.getObs_cal());
                
                stmt.setString(9,  relatorio.getPre_dataInicio());
                stmt.setString(10, relatorio.getPre_horaInicio());
                stmt.setString(11, relatorio.getPre_horaFim());
                stmt.setString(12, relatorio.getPre_dataFim());
                stmt.setString(13, relatorio.getPre_tempo());
                stmt.setString(14, relatorio.getPre_resp());
                stmt.setString(15, relatorio.getObs_pre());
                
                stmt.setString(16, relatorio.getCor_dataInicio());
                stmt.setString(17, relatorio.getCor_horaInicio());
                stmt.setString(18, relatorio.getCor_horaFim());
                stmt.setString(19, relatorio.getCor_dataFim());
                stmt.setString(20, relatorio.getCor_concerto());
                stmt.setString(21, relatorio.getCor_resp());
                stmt.setString(22, relatorio.getObs_cor());
                    
                    stmt.execute();
                    stmt.close();
            
                
        } catch(SQLException e){
            e.printStackTrace();
        }
        
        
    }
    
    
    //Select Ordem de Produção arquivada
    public List<OrdemProducao> selectArchivedOrdemProducao(){
        String sql = "SELECT * FROM ordem_producao WHERE status = 'arquivada'";
        
        List<OrdemProducao> opList = new ArrayList();
        
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                OrdemProducao op = new OrdemProducao();
                op.setId(rs.getInt("id"));
                op.setCategoria(rs.getString("categoria"));
                op.setEe(rs.getInt("EE"));
                op.setLarguraTecido(rs.getFloat("largura_tecido"));
                op.setMetragemTecido(rs.getFloat("metragem_tecido"));
                op.setMetExtra(rs.getFloat("met_extra"));
                op.setLonas(rs.getInt("lonas"));
                op.setEspessura(rs.getString("espessura"));
                op.setSetor(rs.getString("setor"));
                op.setObservacao(rs.getString("observacao"));
                
                opList.add(op);
            }
            
            stmt.close();
            rs.close();
                    
            
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }
        
        
        return opList;
    }
    
    //Select pedido
    public Pedido selectPedidobyId(int id){
        
        String sql = "SELECT * FROM pedidos WHERE id = ?";
        Pedido pedido = new Pedido();
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                pedido.setId(id);
                pedido.setNomeCliente(rs.getString("nome_cliente"));
                pedido.setFechamento(rs.getString("data_fechamento"));
                pedido.setEmbarque(rs.getString("data_embarque"));
                pedido.setObservacao(rs.getString("observacao"));
                
            }
            rs.close();
            stmt.close();
            
        } catch(SQLException e) {
            e.printStackTrace();
        }
        
        return pedido;
    }
    
    
    
    
}
