package projetopizza;

import java.util.HashMap;
import java.util.Map;

public class Pizza {

  private String sabor;
  private double preco;
  private int indice = 0;
  static int numero_pizzas = 0;

  Map<Integer, String> ingredientes = new HashMap<Integer, String>();

  public Pizza(String sabor) {
    this.sabor = sabor;
    numero_pizzas++;
  }

  public void adicionaIngrediente(String ingrediente) {
    ingredientes.put(indice++, ingrediente);
  }

  public double getPreco() {
    if (ingredientes.size() <= 2) preco = 30.; else if (
      ingredientes.size() <= 5
    ) preco = 45.; else preco = 60.;
    return preco;
  }

  public String getSabor() {
    return sabor;
  }

  public int getNumeroIngredientes() {
    return ingredientes.size();
  }

  public void listarIngredientes() {
    for (int i = 1; i <= ingredientes.size(); i++) {
      System.out.println(i + " - " + ingredientes.get(i));
    }
  }

  private String pesquisarIngrediente(String ingrediente) {
    if (ingredientes.containsValue(ingrediente)) {
      return String.valueOf(ingredientes.containsValue(ingrediente));
    }
    return null;
  }

  public void apagarTabelaIngredientes() {
    ingredientes.clear();
  }
}
