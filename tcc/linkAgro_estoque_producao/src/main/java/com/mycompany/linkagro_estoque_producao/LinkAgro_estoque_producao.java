/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.linkagro_estoque_producao;

import usuarios.LoginGUI;
import usuarios.Controller;

/**
 *
 * @author Senai
 */
public class LinkAgro_estoque_producao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LoginGUI window = new LoginGUI();
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        Controller.setLogingui(window);
    }
    
}
