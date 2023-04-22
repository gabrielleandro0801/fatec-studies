/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import projetopizza.Pizza;

public class TestePizza {

  @Test
  public void testeGetPrecoPizzaAte2Sabores() {
    Pizza p1 = new Pizza("Mussarela");
    p1.adicionaIngrediente("Queijo");
    p1.adicionaIngrediente("Tomate");
    assertEquals(30.0, p1.getPreco(), 0);
  }
  /*
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
    }*/

}
