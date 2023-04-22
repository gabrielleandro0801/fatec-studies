import static javax.swing.JOptionPane.*;

import java.util.ArrayList;
import java.util.List;

public class TestaCurso {

  private static List<Curso> alCurso;

  public static void main(String[] args) {
    alCurso = new ArrayList<Curso>();

    while (true) {
      int i = showOptionDialog(
        null,
        "Escolha uma opcao",
        "Cadastro de Cursos",
        0,
        3,
        null,
        new String[] {
          "Incluir",
          "Excluir",
          "Alterar",
          "Consultar",
          "Relatorio",
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
    Curso curso = new Curso();

    String cd = showInputDialog("Informe o codigo do Curso: ");
    curso.setCodCurso(cd);

    if (alCurso.contains(curso)) {
      showMessageDialog(null, "Curso ja cadastrado!", "Erro", ERROR_MESSAGE);
      return;
    }

    String str = showInputDialog("Informe o nome do Curso: ");
    if (str == null) return;
    curso.setNomeCurso(str);

    String ch = showInputDialog("Informe a Carga Horaria do Curso:");
    curso.setCargaHorariaCurso(ch);

    alCurso.add(curso);
  }

  private static void excluir() {
    Curso curso = new Curso();

    String cd = showInputDialog("Informe o codigo do Curso: ");
    if (cd == null) return;
    curso.setCodCurso(cd);

    int posicao = alCurso.indexOf(curso);

    if (posicao == -1) {
      showMessageDialog(
        null,
        "Esse Curso nao existe no cadastro " + curso.getNomeCurso(),
        "Erro",
        ERROR_MESSAGE
      );
      return;
    }

    showMessageDialog(null, "Removido: " + alCurso.remove(posicao));
  }

  private static void alterar() {
    Curso curso = new Curso();

    String cd = showInputDialog("Informe o codigo do Curso: ");
    if (cd == null) return;
    curso.setCodCurso(cd);

    int posicao = alCurso.indexOf(curso);

    if (posicao == -1) {
      showMessageDialog(
        null,
        "Esse Curso nao existe no cadastro " + curso.getNomeCurso(),
        "Erro",
        ERROR_MESSAGE
      );
      return;
    }

    String str = showInputDialog("Informe o novo nome:");
    if (str == null) return;
    curso.setNomeCurso(str);

    String ch = showInputDialog("Informe a Carga Horaria do Curso:");
    curso.setCargaHorariaCurso(ch);

    alCurso.set(posicao, curso);
    showMessageDialog(null, "Cadastro atualizado:\n" + curso);
  }

  private static void consultar() {
    Curso curso = new Curso();

    String cd = showInputDialog("Informe o codigo do Curso");
    if (cd == null) return;
    curso.setCodCurso(cd);

    int posicao = alCurso.indexOf(curso);

    if (posicao == -1) {
      showMessageDialog(
        null,
        "Esse Curso nao existe no cadastro " + curso.getNomeCurso(),
        "Erro",
        ERROR_MESSAGE
      );
      return;
    }

    showMessageDialog(null, "Dados do Curso:\n" + alCurso.get(posicao));
  }

  private static void relatorio() {
    String str = "Relatorio de Cursos:\n";
    for (Curso curso : alCurso) str += "\n" + curso;
    showMessageDialog(null, str);
  }

  private static void sair() {
    System.exit(0);
  }
}
