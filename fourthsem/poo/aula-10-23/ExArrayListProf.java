import static javax.swing.JOptionPane.*;

import java.util.ArrayList;
import java.util.List;

public class ExArrayListProf {

  private static List<Professor> lista;

  public static void main(String[] args) {
    lista = new ArrayList<Professor>();

    while (true) {
      int i = showOptionDialog(
        null,
        "Escolha uma op��o",
        "Cadastro de Professores",
        0,
        3,
        null,
        new String[] {
          "Incluir",
          "Excluir",
          "Alterar",
          "Consultar",
          "Relat�rio",
          "Sair",
        },
        "Incluir"
      );
      if (i == -1) System.exit(0);
      if (i == 0) incluir(); else if (i == 1) excluir(); else if (
        i == 2
      ) alterar(); else if (i == 3) consultar(); else if (
        i == 4
      ) relatorio(); else if (i == 5) sair();
    }
  }

  private static void incluir() {
    Professor prof = new Professor();

    String cd = showInputDialog("Informe o codigo do professor: ");
    prof.setCodProf(cd);

    if (lista.contains(prof)) {
      showMessageDialog(
        null,
        "Professor j� cadastrado!",
        "Erro",
        ERROR_MESSAGE
      );
      return;
    }

    String str = showInputDialog("Informe o nome do professor: ");
    if (str == null) return;
    prof.setNomeProf(str);

    lista.add(prof);
  }

  private static void excluir() {
    Professor prof = new Professor();

    String cd = showInputDialog("Informe o codigo do professor: ");
    if (cd == null) return;
    prof.setCodProf(cd);

    int posicao = lista.indexOf(prof);

    if (posicao == -1) {
      showMessageDialog(
        null,
        "Esse professor n�o existe no cadastro " + prof.getNomeProf(),
        "Erro",
        ERROR_MESSAGE
      );
      return;
    }

    showMessageDialog(null, "Removido: " + lista.remove(posicao));
  }

  private static void alterar() {
    Professor prof = new Professor();

    String cd = showInputDialog("Informe o codigo do professor: ");
    if (cd == null) return;
    prof.setCodProf(cd);

    int posicao = lista.indexOf(prof);

    if (posicao == -1) {
      showMessageDialog(
        null,
        "Esse professor n�o existe no cadastro " + prof.getNomeProf(),
        "Erro",
        ERROR_MESSAGE
      );
      return;
    }

    String str = showInputDialog("Informe o novo nome:");
    if (str == null) return;
    prof.setNomeProf(str);

    lista.set(posicao, prof);
    showMessageDialog(null, "Cadastro atualizado:\n" + prof);
  }

  private static void consultar() {
    Professor prof = new Professor();

    String cd = showInputDialog("Informe o codigo do professor");
    if (cd == null) return;
    prof.setCodProf(cd);

    int posicao = lista.indexOf(prof);

    if (posicao == -1) {
      showMessageDialog(
        null,
        "Esse professor n�o existe no cadastro " + prof.getNomeProf(),
        "Erro",
        ERROR_MESSAGE
      );
      return;
    }

    showMessageDialog(null, "Dados do Professor:\n" + lista.get(posicao));
  }

  private static void relatorio() {
    String str = "Relat�rio de Professores:\n";
    for (Professor prof : lista) str += "\n" + prof;
    showMessageDialog(null, str);
  }

  private static void sair() {
    System.exit(0);
  }
}
