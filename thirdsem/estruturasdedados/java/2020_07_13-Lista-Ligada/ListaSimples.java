public class ListaSimples {

  private No primeiro;

  public ListaSimples() {
    setPrimeiro(null);
  }

  public No getPrimeiro() {
    return this.primeiro;
  }

  public void setPrimeiro(No primeiro) {
    this.primeiro = primeiro;
  }

  public boolean estaVazia() {
    return (primeiro == null);
  }

  public void insereInicio(int i) {
    No novo = new No(i); // Se a lista não estiver vazia, pega a referencia do primeiro no e coloca pro novo. O primeiro vira o segundo agora
    if (!estaVazia()) {
      novo.setProximo(this.primeiro);
    }
    // Depois o "novo" vira o primeiro da lista
    setPrimeiro(novo);
  }

  public int removeInicio() {
    int i = this.primeiro.getInfo();
    setPrimeiro(this.primeiro.getProximo());
    return i;
  }

  public String toString() {
    String s;
    if (estaVazia()) {
      s = "Lista Vazia!";
    } else {
      No aux = this.primeiro;
      s = "Primeiro";
      while (aux != null) {
        s = s + " -> " + aux;
        // variavel aux varrendo a lista
        aux = aux.getProximo();
      }
    }
    return s;
  }

  public void insereFim(int i) {
    No novo = new No(i);
    if (estaVazia()) {
      setPrimeiro(novo);
    } else {
      No aux = getPrimeiro();
      // varre a lista até chegar no ultimo elemento
      while (aux.getProximo() != null) {
        aux = aux.getProximo();
      }
      aux.setProximo(novo);
    }
  }

  public int removeFim() {
    int i;
    if (getPrimeiro().getProximo() == null) { // tem um no so
      i = primeiro.getInfo();
      setPrimeiro(null);
    } else {
      No aux = getPrimeiro();
      while (aux.getProximo().getProximo() != null) {
        aux = aux.getProximo();
      }
      i = aux.getProximo().getInfo();
      aux.setProximo(null);
    }
    return i;
  }
}
