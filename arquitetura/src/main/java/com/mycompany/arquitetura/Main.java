/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquitetura;

/**
 *
 * @author xande
 */
public class Main {
    public static void main(String[] args){
        Solo s = new Solo(); 
        System.out.println("Valor antes"+s.getCalcio());
        System.out.println("Set solo = 1");
        s.calculaSoloIdeial(1);
        System.out.println("Valor depois"+s.getCalcio()+"\n");
        
        System.out.println("Set solo = 2");
        s.calculaSoloIdeial(2);
        System.out.println("Valor depois"+s.getCalcio());
        
    }
}
