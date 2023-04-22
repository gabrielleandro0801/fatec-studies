public class Clientes {

  private String nome;
  private String sobrenome;
  private String cpf;
  private String endereco;

  public Clientes() {
    this.nome = "Sandra";
    this.sobrenome = "Geroldo";
    this.cpf = "123.456.789-10";
    this.endereco = "AAAA";
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getSobrenome() {
    return sobrenome;
  }

  public void setSobrenome(String sobrenome) {
    this.sobrenome = sobrenome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public void imprimeCliente() {
    System.out.println("\nNome: " + this.getNome());
    System.out.println("\nSobrenome: " + this.getSobrenome());
    System.out.println("\nCPF: " + this.getCpf());
    System.out.println("\nEndereco: " + this.getEndereco());
  }
}
