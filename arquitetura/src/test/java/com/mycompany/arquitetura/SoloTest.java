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
    public void testaMemoriacalculaQTDKgHectareDaFonteDeFosforo(){
       MemoriadeCalculo m = new MemoriadeCalculo();
       assertEquals(123.95079365079366,m.calculaQTDKgHectareDaFonteDeFosforo(12.0,8.59,1,0.7));
    }

    @Test
    public void testeNecessidadeDePotassioAdicionarMemoriadeCalculo(){
       MemoriadeCalculo m = new MemoriadeCalculo();
       CorrecaoCTC c = new CorrecaoCTC();
       assertEquals(0.2367,m.necessidadeDePotassioAdicionar(3.0,c.participacaoAtualdoPnaCTC(c.calculaCTCMOL(c.calculaSCMOL(0.15,5.76,1.63), 5.35), 0.15), 0.15));
    }
    
    @Test
    public void testeCalculoPrimeiroTipodeCorrecao(){
        MemoriadeCalculo m = new MemoriadeCalculo();
        CorrecaoCTC c = new CorrecaoCTC();
        assertEquals(12.395079365079367,c.calculoPrimeiroTipodeCorrecaoDeFosforo(m.calculaQTDKgHectareDaFonteDeFosforo(12.0,8.59,1,0.7),1));        
    }
    
    @Test
    public void testeCalculoSegundoTipodeCorrecao(){
        MemoriadeCalculo m = new MemoriadeCalculo();
        CorrecaoCTC c = new CorrecaoCTC();
        assertEquals(34.70622222222223,c.calculoSegundoTipodeCorrecaoDeFosforo(m.calculaKgAlqueiroDaFonteDeFosforo(12.0,8.59,1,0.7), 1));        
    }
    @Test
    public void testePrimeiroTipodeCorrecao(){
        CorrecaoCTC c = new CorrecaoCTC();
        assertEquals("Magnésio",c.nomePrimeiroTipodeCorrecao(5));        
    }
    @Test
    public void testeSegundoTipodeCorrecao(){
        CorrecaoCTC c = new CorrecaoCTC();
        assertEquals("Nitrogênio",c.nomeSegundoTipodeCorrecao(3));        
    }
    @Test
    public void testeCustoCorrecaoPporHa(){
        CorrecaoCTC c = new CorrecaoCTC();
        MemoriadeCalculo m = new MemoriadeCalculo();
        assertEquals(24.79015873015873,c.custoCorrecaoPporHa(m.calculaKgAlqueiroDaFonteDeFosforo(12.0,8.59,1,0.7), 1, 200)); 
    }
    @Test
    public void testeQuantidadeAaplicar(){
        MemoriadeCalculo m = new MemoriadeCalculo();
        assertEquals(123.95079365079366,m.calculaQTDKgHectareDaFonteDeFosforo(12.0,8.59,1,0.7)); 
    }
    @Test
    public void testeParticipacaoAtualdoPnaCTC(){
        CorrecaoCTC c = new CorrecaoCTC();
        assertEquals(1.1636927851047323,c.participacaoAtualdoPnaCTC(c.calculaCTCMOL(c.calculaSCMOL(0.15,5.76,1.63), 5.35), 0.15)); 
    }
    @Test
    public void testeParticipacaoDoPnaCTCposCorrecao(){
        CorrecaoCTC c = new CorrecaoCTC();
        assertEquals(3,c.participacaoDoPnaCTCposCorrecao(3)); 
    }
    @Test
    public void testeParticipacaoIdealdoPnaCTC(){
        CorrecaoCTC c = new CorrecaoCTC();
        assertEquals(3,c.participacaoIdealdoPnaCTC(2)); 
    }
    @Test
    public void testeCalculaQTDKgHectareDeFonteDePotassio(){
       CorrecaoCTC c = new CorrecaoCTC();
       MemoriadeCalculo m = new MemoriadeCalculo();   
       double necessidadeDePotassioAdicionar = 0.0;
       necessidadeDePotassioAdicionar = m.necessidadeDePotassioAdicionar(3.0,c.participacaoAtualdoPnaCTC(c.calculaCTCMOL(c.calculaSCMOL(0.15,5.76,1.63), 5.35), 0.15), 0.15);
       assertEquals(450.5462068965517,c.calculaQTDKgHectareDeFonteDePotassio(85,necessidadeDePotassioAdicionar,1)); 
    }
    @Test
    public void testeCalculaCustoPorHectareDeFonteDePotassio(){
        CorrecaoCTC c = new CorrecaoCTC();
       MemoriadeCalculo m = new MemoriadeCalculo();   
       double necessidadeDePotassioAdicionar = 0.0;
       necessidadeDePotassioAdicionar = m.necessidadeDePotassioAdicionar(3.0,c.participacaoAtualdoPnaCTC(c.calculaCTCMOL(c.calculaSCMOL(0.15,5.76,1.63), 5.35), 0.15), 0.15);
       assertEquals(225.27310344827586,c.calculaCustoPorHectareDeFonteDePotassio(1, 1,500.0, c.calculaQTDKgHectareDeFonteDePotassio(85,necessidadeDePotassioAdicionar,1))); 
    }
    
}
