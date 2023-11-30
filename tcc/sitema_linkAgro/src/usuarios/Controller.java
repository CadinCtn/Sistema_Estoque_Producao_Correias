
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuarios;

import ordem_producao.*;

/**
 *
 * @author Lenovo
 */
public class Controller {
    
    private static CUsuarioGUI cUsuarioGUI;
    private static Usuario usuario;
    private static LoginGUI logingui;
    
    
    //getter setter
    public static LoginGUI getLogingui() {
        return logingui;
    }

    public static void setLogingui(LoginGUI logingui) {
        Controller.logingui = logingui;
    }
    
    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        Controller.usuario = usuario;
    }
    

    public static CUsuarioGUI getcUsuarioGUI() {
        return cUsuarioGUI;
    }

    public static void setcUsuarioGUI(CUsuarioGUI cUsuarioGUI) {
        Controller.cUsuarioGUI = cUsuarioGUI;
    }
    
    

}

