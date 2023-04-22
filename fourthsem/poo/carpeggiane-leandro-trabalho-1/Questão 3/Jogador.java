public class Jogador extends Pessoa {

  private int numero;
  private String posicao;

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public String getPosicao() {
    return posicao;
  }

  public void setPosicao(String posicao) {
    this.posicao = posicao;
  }

  public Jogador(String nome, double salario, int numero, String posicao) {
    super(nome, salario);
    this.numero = numero;
    this.posicao = posicao;
  }
}
