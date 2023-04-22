public class Tecnico extends Pessoa {

  private int experiencia;

  public int getExperiencia() {
    return experiencia;
  }

  public void setExperiencia(int experiencia) {
    this.experiencia = experiencia;
  }

  public Tecnico(String nome, double salario, int experiencia) {
    super(nome, salario);
    this.experiencia = experiencia;
  }

  public boolean escalarTime() {
    System.out.println(this.getNome() + " acabou de escalar a equipe!");
    return true;
  }
}
