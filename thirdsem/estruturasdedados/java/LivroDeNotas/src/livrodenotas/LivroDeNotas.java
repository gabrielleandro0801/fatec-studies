package livrodenotas;

// classe LivroDeNotas: registrar as notas de vários alunos de um curso
public class LivroDeNotas {
    // atributos
    private String nomeDoCurso;

    // construtores
    public LivroDeNotas(String nomeDoCurso) {
        this.nomeDoCurso = nomeDoCurso;
    }
    // recriar o padrão, porque foi criado um diferente
    public LivroDeNotas() {}
    // lista de parâmetros diferente: sobrecarga
    
    // métodos de acesso
    public String getNomeDoCurso() {
        return nomeDoCurso;
    }
    // método modificador
    public void setNomeDoCurso(String nomeDoCurso) {
        this.nomeDoCurso = nomeDoCurso;
    }
    
}
