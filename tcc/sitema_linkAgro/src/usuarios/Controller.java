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
    
    
    
    //getter setter
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

