/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.calebe.ticketmachine.test;

import br.calebe.ticketmachine.core.PapelMoeda;
import br.calebe.ticketmachine.core.TicketMachine;
import br.calebe.ticketmachine.core.Troco;
import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sighmir
 */
public class Tests {
    
    public Tests() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    TicketMachine tm = new TicketMachine(2);
    
    @Test
    public void testarConstrutor(){
        TicketMachine tm2 = new TicketMachine(50);
        
        assertEquals(tm2.getSaldo(), 0);
        assertEquals(tm2.getValor(), 50);
        
        
    }
    
    @Test
    public void testarInserir() throws PapelMoedaInvalidaException{
        assertEquals(tm.inserir(2), tm.getSaldo());
        assertEquals(tm.inserir(5), tm.getSaldo());
        assertEquals(tm.inserir(10), tm.getSaldo());
        assertEquals(tm.inserir(20), tm.getSaldo());
        assertEquals(tm.inserir(50), tm.getSaldo());
        assertEquals(tm.inserir(100), tm.getSaldo());
    }
    
    @Test
    public void trocoTest(){
        Troco t = new Troco(7);
        PapelMoeda[] pmList = new PapelMoeda[6];
        
        PapelMoeda pm1 = new PapelMoeda(5, 1);
        pmList[1] = pm1;
        
        PapelMoeda pm2 = new PapelMoeda(2, 1);
        pmList[0] = pm2;
        
        assertEquals(pmList[0].getValor(), 2);
        assertEquals(pmList[0].getQuantidade(), 1);
        
        assertEquals(pmList[1].getValor(), 5);
        assertEquals(pmList[1].getQuantidade(), 1);
    }
}
