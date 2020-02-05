/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package random;

import javax.swing.JOptionPane;

/**
 *
 * @author AlanAntonio
 */
public class Random {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //JOptionPane.showMessageDialog(null, rango);
        
        
        for(int i=0; i<10; i++){
            Double rango = Math.floor(1 + Math.random() * 500);
            System.out.println(rango);
            
        }
    }
    
}
