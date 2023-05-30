package quinta_aula.exercicio_disciplina;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    String nome;
    int cargaHoraria; 
    Professor professor;
    List<Double> notas = new ArrayList<>();
    List<Disciplina> disciplinas = new ArrayList<>(); // Corrigido para ArrayList<Disciplina>

    public Disciplina(String nome, int cargaHoraria, Professor professor) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
    }

    public String getNome() {
        return nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public Professor getProfessor() {
        return professor;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }

    public List<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }

    
    @Override
    public String toString() {
        return "Disciplina: " + nome + ", Carga Horária: " + cargaHoraria + ", Professor: " + professor.getNome();
    }

}
