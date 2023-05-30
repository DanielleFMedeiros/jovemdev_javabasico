package quinta_aula.exercicio_disciplina;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {

    private List<Disciplina> disciplinas = new ArrayList<>();

    public Aluno(String nome) {
        super(nome);
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

}
