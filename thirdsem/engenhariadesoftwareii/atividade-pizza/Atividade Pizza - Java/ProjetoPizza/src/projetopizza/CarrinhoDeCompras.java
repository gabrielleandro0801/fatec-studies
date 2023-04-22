package projetopizza;

import java.util.ArrayList;

public class CarrinhoDeCompras {

  ArrayList<Pizza> carrinho_de_compras = new ArrayList();
  private double total_pagar = 0;

  public void adicionarItem(Pizza obj) {
    if (obj.getNumeroIngredientes() > 0) {
      carrinho_de_compras.add(obj);
      total_pagar += obj.getPreco();
    }
  }

  public int totalPizzasAdicionadas() {
    return carrinho_de_compras.size();
  }

  public double getTotalPagar() {
    return total_pagar;
  }
}
