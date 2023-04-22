package model;

public class Funcionario extends Pessoa {

  private int idFuncionario;
  private double salario;
  private String turno;
  private int tipo;

  public Funcionario(
    String nome,
    String cpf,
    String dataNasc,
    Long rg,
    int idFuncionario,
    double salario,
    String turno,
    int tipo
  ) {
    super(nome, cpf, dataNasc, rg);
    this.idFuncionario = idFuncionario;
    this.salario = salario;
    this.tipo = tipo;
    this.turno = turno;
  }

  public Funcionario() {}

  public int getIdFuncionario() {
    return idFuncionario;
  }

  public void setIdFuncionario(int idFuncionario) {
    this.idFuncionario = idFuncionario;
  }

  public double getSalario() {
    return salario;
  }

  public void setSalario(double salario) {
    this.salario = salario;
  }

  public String getTurno() {
    return turno;
  }

  public void setTurno(String turno) {
    this.turno = turno;
  }

  public int getTipo() {
    return tipo;
  }

  public void setTipo(int tipo) {
    this.tipo = tipo;
  }

  @Override
  public String toString() {
    return idFuncionario + " | " + getNome();
  }
}
