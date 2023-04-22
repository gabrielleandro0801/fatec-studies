import java.util.ArrayList;
import java.util.Random;

public class Equipe {

  private double orcamentoAnual;
  private boolean escalada;
  private ArrayList<Jogador> alJogador = new ArrayList<Jogador>();
  Random random = new Random();

  public double getOrcamentoAnual() {
    return orcamentoAnual;
  }

  public void setOrcamentoAnual(double orcamentoAnual) {
    this.orcamentoAnual = orcamentoAnual;
  }

  public boolean getEscalada() {
    return escalada;
  }

  public void setEscalada(boolean escalada) {
    this.escalada = escalada;
  }

  public ArrayList<Jogador> getAlJogador() {
    return alJogador;
  }

  public void setAlJogador(ArrayList<Jogador> alJogador) {
    this.alJogador = alJogador;
  }

  public Equipe(ArrayList<Jogador> jogadores) {
    this.orcamentoAnual = 150000;
    this.escalada = false;
    this.alJogador = jogadores;
  }

  public int jogarPartida() {
    if (escalada) {
      this.escalada = false;
      return random.nextInt(3);
    }
    return 3;
    //0 - derrota
    //1 - empate
    //2 - vitoria
    //3 - falha
  }

  public void atualizaOrcamento(int opcao, double valor) {
    if (opcao == 1) {
      this.orcamentoAnual += valor;
    } else {
      this.orcamentoAnual -= valor;
    }
  }
}
