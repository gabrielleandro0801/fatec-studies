package livrodenotas;

public class TesteLivroDeNotas {
    public static void main(String[] args) {
        LivroDeNotas livroDeNotas = new LivroDeNotas("ED");
        System.out.println("antes: " + livroDeNotas.getNomeDoCurso());
        livroDeNotas.setNomeDoCurso("TED");
        System.out.println("depois: " + livroDeNotas.getNomeDoCurso());
        
        LivroDeNotas outroLivroDeNotas = new LivroDeNotas("POO");
        System.out.println("outro livro de notas: " + outroLivroDeNotas.getNomeDoCurso());
    }
}
