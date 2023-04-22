package poo01;

import javax.swing.JOptionPane;

public class TesteAluno {

  public static void main(String[] args) {
    String nome;
    int id;
    double peso;
    char sexo;
    boolean formando;
    String aux;

    nome = JOptionPane.showInputDialog("Informe o Nome");
    aux = JOptionPane.showInputDialog("Informe a Idade");
    id = Integer.parseInt(aux);
    aux = JOptionPane.showInputDialog("Informe o Peso");
    peso = Double.parseDouble(aux);
    aux = JOptionPane.showInputDialog("Informe o Sexo");
    sexo = aux.charAt(0);

    Aluno aluno = new Aluno(nome, id, peso, sexo);

    JOptionPane.showMessageDialog(null, "Nome: " + aluno.getNome());
    JOptionPane.showMessageDialog(null, "Idade: " + aluno.getIdade());
    JOptionPane.showMessageDialog(null, "Peso: " + aluno.getPeso());
    JOptionPane.showMessageDialog(null, "Sexo: " + aluno.getSexo());

    aux = JOptionPane.showInputDialog("Informe a Idade novamente");
    id = Integer.parseInt(aux);
    aux = JOptionPane.showInputDialog("Informe o Peso novamente");
    peso = Double.parseDouble(aux);
    aux = JOptionPane.showInputDialog("Este aluno e formando?");
    formando = Boolean.parseBoolean(aux);

    aluno.setIdade(id);
    aluno.setPeso(peso);
    aluno.setFormando(formando);

    JOptionPane.showMessageDialog(null, "Nome: " + aluno.getNome());
    JOptionPane.showMessageDialog(null, "Idade: " + aluno.getIdade());
    JOptionPane.showMessageDialog(null, "Peso: " + aluno.getPeso());
    JOptionPane.showMessageDialog(null, "Sexo: " + aluno.getSexo());
    JOptionPane.showMessageDialog(null, "Formando? " + aluno.getFormando());
  }
}
