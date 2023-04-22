// package poo02;

import javax.swing.JOptionPane;

public class TesteTurma {

  public static void main(String[] args) {
    String aux;
    String nome, curso;
    int quantidadeDeAlunos, serie;

    nome = JOptionPane.showInputDialog("Informe o nome da turma");
    curso = JOptionPane.showInputDialog("Informe o curso");
    aux =
      JOptionPane.showInputDialog("Informe a quantidade de alunos da turma");
    quantidadeDeAlunos = Integer.parseInt(aux);
    aux = JOptionPane.showInputDialog("Informe a serie da turma");
    serie = Integer.parseInt(aux);

    Turma turma = new Turma(nome, curso, quantidadeDeAlunos, serie);

    JOptionPane.showMessageDialog(null, "Nome da turma: " + turma.getNome());
    JOptionPane.showMessageDialog(null, "Nome do curso: " + turma.getCurso());
    JOptionPane.showMessageDialog(
      null,
      "Qtd. de alunos da turma: " + turma.getQuantidadeDeAlunos()
    );
    JOptionPane.showMessageDialog(null, "Serie da turma: " + turma.getSerie());

    aux =
      JOptionPane.showInputDialog("Informe a quantidade de alunos novamente");
    quantidadeDeAlunos = Integer.parseInt(aux);

    turma.setQuantidadeDeAlunos(quantidadeDeAlunos);

    JOptionPane.showMessageDialog(null, "Nome da turma: " + turma.getNome());
    JOptionPane.showMessageDialog(null, "Curso da turma: " + turma.getCurso());
    JOptionPane.showMessageDialog(
      null,
      "Qtd. de alunos da turma: " + turma.getQuantidadeDeAlunos()
    );
    JOptionPane.showMessageDialog(null, "Serie da turma: " + turma.getSerie());
  }
}
