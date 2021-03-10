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
    public void testValor_Solo() {
        Solo s = new Solo();
        s.Valor_Solo(1);
        assertEquals(9.0, s.getFosforo());
    }
    
    /**
     *
     */
    @Test
    public void test2Valor_Solo() {
        Solo s = new Solo();
        s.Valor_Solo(2);
        assertEquals(12.0, s.getFosforo());
    }

    
}
