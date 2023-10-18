/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordem_producao;

/**
 *
 * @author senai
 */
public class OrdemProducao {
    
    int id;
    String categoria;
    int ee;
    float larguraTecido;
    float metragemTecido;
    int lonas;
    String setor;
    String observacao;
    boolean edit = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getEe() {
        return ee;
    }

    public void setEe(int ee) {
        this.ee = ee;
    }

    public float getLarguraTecido() {
        return larguraTecido;
    }

    public void setLarguraTecido(float larguraTecido) {
        this.larguraTecido = larguraTecido;
    }

    public float getMetragemTecido() {
        return metragemTecido;
    }

    public void setMetragemTecido(float metragemTecido) {
        this.metragemTecido = metragemTecido;
    }

    public int getLonas() {
        return lonas;
    }

    public void setLonas(int lonas) {
        this.lonas = lonas;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }
    
    
    
    
}
