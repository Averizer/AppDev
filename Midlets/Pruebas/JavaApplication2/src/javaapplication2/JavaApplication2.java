/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import javax.swing.JOptionPane;

/**
 *
 * @author AlanAntonio
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FPMP fpmp = new FPMP();
        String a = fpmp.NumeroF(Integer.parseInt(JOptionPane.showInputDialog(null, "ingresa")));
        // String b = fpmp.palindromo(JOptionPane.showInputDialog(null,"ingresa2"));

        //System.out.print(" ... " + a +"  " + b);
        System.out.print(" ... " + a);
    }

}
