package poo03;

import javax.swing.JOptionPane;

public class TesteProduto {

  public static void main(String[] args) {
    String aux;
    String nome;
    double preco;
    int quantidade;

    nome = JOptionPane.showInputDialog("Nome do produto");
    aux = JOptionPane.showInputDialog("Preco do produto");
    preco = Double.parseDouble(aux);
    aux = JOptionPane.showInputDialog("Qtd. do produto");
    quantidade = Integer.parseInt(aux);

    Produto produto = new Produto(nome, preco, quantidade);

    JOptionPane.showMessageDialog(
      null,
      "Nome do produto: " + produto.getNome()
    );
    JOptionPane.showMessageDialog(
      null,
      "Preco do produto: " + produto.getPreco()
    );
    JOptionPane.showMessageDialog(
      null,
      "Qtd. do produto: " + produto.getQuantidade()
    );
  }
}
