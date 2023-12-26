/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Lenovo
 */

import java.awt.*;
import java.awt.print.*;
import javax.swing.JFrame;
        
public class ImprimirOp {
    public ImprimirOp(){
        //Job de impressão
        PrinterJob job = PrinterJob.getPrinterJob();
    
        //Definido objeto a ser impresso
        job.setPrintable(new Layout());
    
        //Diálogo de impressão
        if(job.printDialog()){
            try{
                //imprimindo objeto
                job.print();
            } catch(PrinterException e){
                e.printStackTrace();
            }
        }
    
    }
    
    
    
    public static void main(String[] args){
        new ImprimirOp();
    }
 
    
}

