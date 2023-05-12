public class Conta {

  private int numero;
  private double saldo;
  private double limite;
  private Clientes titular;

  public Conta() {
    this.numero = 123;
    this.saldo = 10000.00;
    this.limite = 1000;
  }

  public int getNumero() {
    return numero;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }

  public double getLimite() {
    return limite;
  }

  public void setLimite(double limite) {
    this.limite = limite;
  }

  public Clientes getTitular() {
    return titular;
  }

  public void setTitular(Clientes titular) {
    this.titular = titular;
  }

  public void imprimeConta() {
    System.out.println("\nNumero: " + this.getNumero());
    System.out.println("\nSaldo: " + this.getSaldo());
    System.out.println("\nLimite: " + this.getLimite());
    //System.out.println("\nLimite: "+this.titular);
    //não se pode imprimir dessa forma
  }
}
