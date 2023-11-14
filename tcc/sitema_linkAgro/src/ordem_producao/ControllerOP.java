/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ordem_producao;



public class ControllerOP {
    private static CUOrdemProducaoGUI cuOrdemProducaoGui;
    private static ROrdemProducaoGUI rOrdemProducaoGUI;

    
    public static ROrdemProducaoGUI getrOrdemProducaoGUI() {
        return rOrdemProducaoGUI;
    }

    public static void setrOrdemProducaoGUI(ROrdemProducaoGUI rOrdemProducaoGUI) {
        ControllerOP.rOrdemProducaoGUI = rOrdemProducaoGUI;
    }
    

    public static void setCUOrdemProducao(CUOrdemProducaoGUI cuOrdemProducaoGui) {
        ControllerOP.cuOrdemProducaoGui = cuOrdemProducaoGui;
    }

    public static CUOrdemProducaoGUI getCUOrdemProducao() {
        return cuOrdemProducaoGui;
    }
    
}

