public class TesteNo {

  public static void main(String[] args) {
    No no1 = new No(8);
    System.out.println(no1);

    No no2 = new No(14);
    no1.setProximo(no2);
    System.out.println(no1.getProximo().getInfo());
  }
}
