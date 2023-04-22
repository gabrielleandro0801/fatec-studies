import ataque.Atacante;
import defesa.Zagueiro;
import javax.swing.JOptionPane;
import meio_campo.MeioCampista;

public class Teste {

  public static void main(String[] args) {
    String nome = JOptionPane.showInputDialog("Digite o nome do zagueiro");
    int numero = Integer.parseInt(
      JOptionPane.showInputDialog("Digite o numero do zagueiro")
    );
    double altura = Float.parseFloat(
      JOptionPane.showInputDialog("Digite a altura do zagueiro")
    );
    Zagueiro zagueiro = new Zagueiro(nome, numero, altura);

    nome = JOptionPane.showInputDialog("Digite o nome do meia");
    numero =
      Integer.parseInt(JOptionPane.showInputDialog("Digite o numero do meia"));
    String qualidade = JOptionPane.showInputDialog(
      "Digite a qualidade do meia"
    );
    MeioCampista meia = new MeioCampista(nome, numero, qualidade);

    nome = JOptionPane.showInputDialog("Digite o nome do atacante");
    numero =
      Integer.parseInt(
        JOptionPane.showInputDialog("Digite o numero do atacante")
      );
    String peBom = JOptionPane.showInputDialog("Digite o o pe bom do atacante");
    Atacante atacante = new Atacante(nome, numero, peBom);

    int opcao;
    do {
      opcao =
        Integer.parseInt(
          JOptionPane.showInputDialog(
            "<1> Jogar com zagueiro\n<2> Jogar com meia\n<3> Jogar com atacante\n<0> Sair"
          )
        );

      switch (opcao) {
        case 1:
          zagueiro.jogarBola();
          break;
        case 2:
          meia.jogarBola();
          break;
        case 3:
          atacante.jogarBola();
          break;
        case 0:
          System.exit(0);
          break;
        default:
          JOptionPane.showMessageDialog(
            null,
            "Opcao invalida!",
            "Erro",
            JOptionPane.ERROR_MESSAGE
          );
          break;
      }
    } while (opcao != 0);
  }
}
