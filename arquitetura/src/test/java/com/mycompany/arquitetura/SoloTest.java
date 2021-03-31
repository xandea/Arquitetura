/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.arquitetura;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author xande
 */
public class SoloTest {
    
    public SoloTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of Valor_Solo method, of class Solo.
     
     */
    @Test
    public void ideal1ValorSolo() {
        Solo s = new Solo();
        s.calculaSoloIdeial(1);
        assertEquals(9.0, s.getFosforo());
    }
    
    @Test
    public void ideal2ValorSolo() {
        Solo s = new Solo();
        s.calculaSoloIdeial(2);
        assertEquals(12.0, s.getFosforo());
    }
    
    @Test
    public void idealMO(){
        Solo s = new Solo();
        s.setMateriaOrganica(30.7);
        assertEquals(3.07,s.getMateriaOrganica());
    }
    
    @Test
    public void idealCarbono(){
        Solo s = new Solo();
        s.setMateriaOrganica(30.7);
        s.setCarbono(s.getMateriaOrganica());
        assertEquals(17.848837209302324,s.getCarbono());
    }

    @Test
    public void testaSCMOL(){
        CorrecaoCTC c = new CorrecaoCTC();
        assertEquals(7.54,c.calculaSCMOL(0.15,5.76,1.63));   
    }
    
    @Test
    public void testaCTCCmol(){
        CorrecaoCTC c = new CorrecaoCTC();
        assertEquals(12.89,c.calculaCTCMOL(c.calculaSCMOL(0.15,5.76,1.63),5.35));
    }
    
    @Test
    public void testaVPorcentagem(){
        CorrecaoCTC c = new CorrecaoCTC();   
        assertEquals(58.494957331264544,c.calculaVPorcentagem(c.calculaCTCMOL(c.calculaSCMOL(0.15,5.76,1.63),5.35),c.calculaSCMOL(0.15,5.76,1.63)));
    }
    
    @Test
    public void testaMemoriaCalculoSulfatoSimplesKGHectare(){
       MemoriadeCalculo m = new MemoriadeCalculo();
       assertEquals(123.95079365079366,m.calculaSulfatoSimplesKGHectare(12.0,8.59,1,0.7));
    }
    
    @Test
    public void testeNecessidadeDeKadicionar(){
       MemoriadeCalculo m = new MemoriadeCalculo();
       assertEquals(0.2367,m.necessidadeDeKadicionar(0.03, 0.15, 5.35, 5.76, 1.63));
    }
    
    @Test
    public void testeCorrecaoEnxofre(){
        MemoriadeCalculo m = new MemoriadeCalculo();
        CorrecaoCTC c = new CorrecaoCTC();
        assertEquals(12.395079365079365,c.correcaoEnxofre(m.calculaSulfatoSimplesKGHectare(12.0,8.59,1,0.7),1));        
    }
}
