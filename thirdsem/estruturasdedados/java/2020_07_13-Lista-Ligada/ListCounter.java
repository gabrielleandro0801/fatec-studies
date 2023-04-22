public class ListCounter extends ListaSimples {

  private int contador;

  public ListCounter() {
    super();
  }

  public int getContador() {
    return this.contador;
  }

  public void setContador(int contador) {
    this.contador = contador;
  }

  @Override
  public void insereInicio(int i) {
    super.insereInicio(i);
    this.contador++;
  }

  @Override
  public int removeInicio() {
    int i = super.removeInicio();
    this.contador--;
    return i;
  }

  @Override
  public void insereFim(int i) {
    super.insereFim(i);
    this.contador++;
  }

  @Override
  public int removeFim() {
    int i = super.removeFim();
    this.contador--;
    return i;
  }
}
