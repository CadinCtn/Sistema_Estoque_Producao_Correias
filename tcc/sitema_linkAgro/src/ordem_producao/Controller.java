/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ordem_producao;

/**
 *
 * @author Lenovo
 */
public class Controller {
    private static CUOrdemProducaoGUI cuOrdemProducaoGui;

    public static void setCUOrdemProducao(CUOrdemProducaoGUI cuOrdemProducaoGui) {
        Controller.cuOrdemProducaoGui = cuOrdemProducaoGui;
    }

    public static CUOrdemProducaoGUI getCUOrdemProducao() {
        return cuOrdemProducaoGui;
    }
}

