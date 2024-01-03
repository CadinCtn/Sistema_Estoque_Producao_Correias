
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menus;

import imprimir.Preview;
import ordem_producao.CUOrdemProducaoGUI;
import ordem_producao.ROrdemProducaoGUI;
import usuarios.CUsuarioGUI;
import usuarios.LoginGUI;
import usuarios.Usuario;



/**
 *
 * @author Lenovo
 */
public class Controller {
    
    private static CUsuarioGUI cUsuarioGUI;
    private static Usuario usuario;
    private static LoginGUI logingui;
    
    private static CUOrdemProducaoGUI cuOrdemProducaoGui;
    private static ROrdemProducaoGUI rOrdemProducaoGUI;
    
    private static Preview preview;


    public static CUsuarioGUI getcUsuarioGUI() {
        return cUsuarioGUI;
    }

    public static void setcUsuarioGUI(CUsuarioGUI cUsuarioGUI) {
        Controller.cUsuarioGUI = cUsuarioGUI;
    }

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        Controller.usuario = usuario;
    }

    public static LoginGUI getLogingui() {
        return logingui;
    }

    public static void setLogingui(LoginGUI logingui) {
        Controller.logingui = logingui;
    }

    public static CUOrdemProducaoGUI getCuOrdemProducaoGui() {
        return cuOrdemProducaoGui;
    }

    public static void setCuOrdemProducaoGui(CUOrdemProducaoGUI cuOrdemProducaoGui) {
        Controller.cuOrdemProducaoGui = cuOrdemProducaoGui;
    }

    public static ROrdemProducaoGUI getrOrdemProducaoGUI() {
        return rOrdemProducaoGUI;
    }

    public static void setrOrdemProducaoGUI(ROrdemProducaoGUI rOrdemProducaoGUI) {
        Controller.rOrdemProducaoGUI = rOrdemProducaoGUI;
    }

    public static Preview getPreview() {
        return preview;
    }

    public static void setPreview(Preview preview) {
        Controller.preview = preview;
    }
    

    
    
    

}

