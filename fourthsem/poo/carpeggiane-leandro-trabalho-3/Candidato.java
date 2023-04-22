public class Candidato {

  private String nome_candidato;
  private int numero;
  private String tipo_candidatura;
  private String data_nascimento;

  public String getNome_candidato() {
    return nome_candidato;
  }

  public void setNome_candidato(String nome_candidato) {
    this.nome_candidato = nome_candidato;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public String getTipo_candidatura() {
    return tipo_candidatura;
  }

  public void setTipo_candidatura(String tipo_candidatura) {
    this.tipo_candidatura = tipo_candidatura;
  }

  public String getData_nascimento() {
    return data_nascimento;
  }

  public void setData_nascimento(String data_nascimento) {
    this.data_nascimento = data_nascimento;
  }

  public Candidato(
    String nome_candidato,
    int numero,
    String tipo_candidatura,
    String data_nascimento
  ) {
    this.nome_candidato = nome_candidato;
    this.numero = numero;
    this.tipo_candidatura = tipo_candidatura;
    this.data_nascimento = data_nascimento;
  }

  public Candidato() {}
}
