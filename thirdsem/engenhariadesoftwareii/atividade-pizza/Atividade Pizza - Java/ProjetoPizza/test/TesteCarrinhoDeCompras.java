import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import projetopizza.CarrinhoDeCompras;
import projetopizza.Pizza;

public class TesteCarrinhoDeCompras {

  @Test
  public void testeAdicionarPizzas() {
    CarrinhoDeCompras c1 = new CarrinhoDeCompras();
    Pizza p1 = new Pizza("Portuguesa");
    p1.adicionaIngrediente("queijo");
    p1.adicionaIngrediente("presunto");
    p1.adicionaIngrediente("ovos");
    p1.adicionaIngrediente("cebola");

    Pizza p2 = new Pizza("Marguerita");
    p2.adicionaIngrediente("cebola");
    p2.adicionaIngrediente("alho");
    p2.adicionaIngrediente("manjericao");

    Pizza p3 = new Pizza("Generica");

    c1.adicionarItem(p1);
    c1.adicionarItem(p2);
    c1.adicionarItem(p3);
    assertEquals(2, c1.totalPizzasAdicionadas());
  }

  @Test
  public void testeTotalPagar() {
    CarrinhoDeCompras c1 = new CarrinhoDeCompras();
    Pizza p1 = new Pizza("Portuguesa");
    p1.adicionaIngrediente("mussarela");
    p1.adicionaIngrediente("presunto");
    p1.adicionaIngrediente("ovos");
    p1.adicionaIngrediente("cebola"); //45.00

    Pizza p2 = new Pizza("Marguerita");
    p2.adicionaIngrediente("mussarela de bufala");
    p2.adicionaIngrediente("tomate");
    p2.adicionaIngrediente("manjericao"); //45.00

    Pizza p3 = new Pizza("Calabresa");
    p3.adicionaIngrediente("calabresa");
    p3.adicionaIngrediente("cebola"); //30.00

    c1.adicionarItem(p1);
    c1.adicionarItem(p2);
    c1.adicionarItem(p3);
    assertEquals(120, c1.getTotalPagar(), 0);
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
