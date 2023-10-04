/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author Lenovo
 */
public class Pedido {
    
    int id;
    Date fechamento;
    Date embarque;
    String nomeCliente;
    String observacao;

    public int getId() {
        return id;
    }

    public void setId(int id_pedido) {
        this.id = id;
    }

    public Date getFechamento() {
        return fechamento;
    }

    public void setFechamento(Date fechamento) {
        this.fechamento = fechamento;
    }

    public Date getEmbarque() {
        return embarque;
    }

    public void setEmbarque(Date embarque) {
        this.embarque = embarque;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    
    
}
