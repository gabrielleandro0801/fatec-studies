public class Medico {

  private String nome;
  private String cpf;
  private String dataNascimento;
  private String crm;
  private String especialidade;

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return this.nome;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getCpf() {
    return this.cpf;
  }

  public String getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(String dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public String getCrm() {
    return crm;
  }

  public void setCrm(String crm) {
    this.crm = crm;
  }

  public String getEspecialidade() {
    return especialidade;
  }

  public void setEspecialidade(String especialidade) {
    this.especialidade = especialidade;
  }

  public Medico(
    String nome,
    String cpf,
    String dataNascimento,
    String crm,
    String especialidade
  ) {
    this.nome = nome;
    this.cpf = cpf;
    this.dataNascimento = dataNascimento;
    this.crm = crm;
    this.especialidade = especialidade;
  }

  public void examinarPaciente(String nomePaciente) {
    System.out.println("\nExaminando " + nomePaciente + "...");
    System.out.println(nomePaciente + " examinado com sucesso!");
  }

  public void agendarRetorno(String nomePaciente) {
    System.out.println(
      "O(a) paciente " + nomePaciente + " deve retornar daqui a uma semana!"
    );
  }
}
