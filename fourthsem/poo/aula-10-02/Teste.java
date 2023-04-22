public class Teste {

  public static void main(String[] args) {
    Clientes c = new Clientes();
    Conta minhaConta = new Conta();
    minhaConta.setTitular(c);
    System.out.println(minhaConta.getTitular());
    c.imprimeCliente();
    minhaConta.getTitular().imprimeCliente();
    minhaConta.imprimeConta();
  }
}
