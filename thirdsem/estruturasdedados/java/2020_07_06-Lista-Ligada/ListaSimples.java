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
    No novo = new No(i);
    // Se a lista não estiver vazia, pega a referencia do primeiro no e coloca pro novo. O primeiro vira o segundo agora
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
}
