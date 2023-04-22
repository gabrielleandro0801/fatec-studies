package poo04;

import javax.swing.JOptionPane;

public class TesteDisciplina {

  public static void main(String[] args) {
    String aux;
    String nome, professor;
    int semestre;
    boolean ofertada;
    nome = JOptionPane.showInputDialog("Nome da disciplina");
    professor = JOptionPane.showInputDialog("Nome do professor");
    aux = JOptionPane.showInputDialog("Num. do semestre");
    semestre = Integer.parseInt(aux);
    aux = JOptionPane.showInputDialog("Ofertada?");
    ofertada = Boolean.parseBoolean(aux);

    Disciplina disciplina = new Disciplina(nome, professor, semestre, ofertada);

    JOptionPane.showMessageDialog(
      null,
      "Nome da disciplina: " + disciplina.getNome()
    );
    JOptionPane.showMessageDialog(
      null,
      "Prof. da disciplina: " + disciplina.getProfessor()
    );
    JOptionPane.showMessageDialog(
      null,
      "Num. do semestre: " + disciplina.getSemestre()
    );
    JOptionPane.showMessageDialog(
      null,
      "Ofertada? " + disciplina.getOfertada()
    );
  }
}
