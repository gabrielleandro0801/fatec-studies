import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Teste {

  public static void main(String[] args) {
    Partido partido = new Partido();

    ArrayList<Candidato> candidatos = new ArrayList<Candidato>();

    JOptionPane.showMessageDialog(
      null,
      "Bem vindo ao Sistema de Gerenciamento de Partidos Eleitorais!"
    );
    partido.setNome_partido(
      JOptionPane.showInputDialog(null, "Digite o nome do Partido: ")
    );
    partido.setSigla(
      JOptionPane.showInputDialog(null, "Digite a sigla do Partido: ")
    );

    JOptionPane.showMessageDialog(
      null,
      "Agora, adicione 3 candidatos ao partido!"
    );
    int i = 0;
    while (i < 3) {
      Candidato cand = new Candidato();
      cand.setNome_candidato(
        JOptionPane.showInputDialog("Informe o nome do Candidato: ")
      );
      cand.setNumero(
        Integer.parseInt(
          JOptionPane.showInputDialog("Informe o numero do Candidato: ")
        )
      );
      cand.setTipo_candidatura(
        JOptionPane.showInputDialog(
          "Informe o tipo do Candidato (Prefeito | Vereador): "
        )
      );
      cand.setData_nascimento(
        JOptionPane.showInputDialog(
          "Informe a data de nascimento do Candidato (Prefeito | Vereador): "
        )
      );

      candidatos.add(cand);
      i++;
    }
    partido.setCandidatos(candidatos);

    String valores = "";
    for (Candidato c : candidatos) {
      valores +=
        c.getNome_candidato() +
        " - " +
        c.getTipo_candidatura() +
        " - " +
        c.getNumero() +
        " - " +
        c.getData_nascimento() +
        "\n";
    }

    JOptionPane.showMessageDialog(
      null,
      partido.getNome_partido() + " - " + partido.getSigla() + "\n" + valores
    );
    JOptionPane.showMessageDialog(null, "Boa eleicao!");
  }
}
