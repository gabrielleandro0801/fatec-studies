public class ListaPrimUlt extends ListaSimples {

  private No ultimo;

  public ListaPrimUlt() {
    super(); // usa o construtor da classe pai
    this.setUltimo(null);
  }

  public No getUltimo() {
    return this.ultimo;
  }

  public void setUltimo(No ultimo) {
    this.ultimo = ultimo;
  }

  @Override
  public void insereInicio(int i) {
    super.insereInicio(i); // tudo que foi feito no metodo do pai acontece aqui tambem com a chamada do super
    if (getUltimo() == null) {
      setUltimo(null);
    }
  }

  @Override
  public int removeInicio() {
    int i = super.removeInicio();
    if (getPrimeiro() == null) { // isso quer dizer que a lista esvaziou, entao precisa arrumar o ultimo
      setUltimo(null);
    }
    return i;
  }

  @Override
  public void insereFim(int i) {
    No novo = new No(i);
    if (estaVazia()) {
      setPrimeiro(novo);
    } else {
      ultimo.setProximo(novo);
    }
    setUltimo(novo);
  }

  @Override
  public int removeFim() {
    int i = getUltimo().getInfo();
    if (getPrimeiro() == getUltimo()) { // se verdadeiro, significa que tem um so
      setPrimeiro(null);
      setUltimo(null);
    } else {
      No aux = getPrimeiro();
      while (aux.getProximo() != getUltimo()) {
        aux = aux.getProximo();
      }
      aux.setProximo(null);
      setUltimo(aux); // o penultimo se torna o ultimo
    }
    return i;
  }
}
