package quinta_aula.exercicio_disciplina;

import java.util.ArrayList;
import java.util.List;

public class Util {

    private List<Professor> professores = new ArrayList<>();
    private List<Aluno> alunos = new ArrayList<>();
    private List<Disciplina> disciplinas = new ArrayList<>();

    public void cadastrarProfessor(String nome, EnumFormacao formacao) {
        Professor professor = new Professor(nome, formacao);
        professores.add(professor);
        System.out.println("Professor cadastrado com sucesso!");
    }

    public void cadastrarAluno(String nome) {
        Aluno aluno = new Aluno(nome);
        alunos.add(aluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    public void cadastrarDisciplina(String nome, int cargaHoraria, Professor professor) {
        Disciplina disciplina = new Disciplina(nome, cargaHoraria, professor);
        disciplinas.add(disciplina);
    }

    public void escolherDisciplinas(Aluno aluno, List<Disciplina> disciplinas) {
        aluno.setDisciplinas(disciplinas);
    }

    public void informarNotas(Aluno aluno, Disciplina disciplina, double[] notas) {
        List<Double> notasList = new ArrayList<>();
        for (double nota : notas) {
            notasList.add(nota);
        }
        disciplina.setNotas(notasList);
    }
    

    public String listarDisciplinasComMedia(Aluno aluno) {
        StringBuilder builder = new StringBuilder();
        builder.append("Disciplinas com média do aluno ").append(aluno.getNome()).append(":\n");
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getAlunosMatriculados().contains(aluno)) {
                double media = calcularMedia(disciplina, aluno);
                builder.append("Disciplina: ").append(disciplina.getNome()).append(", Média: ").append(media).append("\n");
            }
        }
        return builder.toString();
    }

    private double calcularMedia(Disciplina disciplina, Aluno aluno) {
        double soma = 0.0;
        int count = 0;
        for (Nota nota : disciplina.getNotas()) {
            if (nota.getAluno().equals(aluno)) {
                soma += nota.getValor();
                count++;
            }
        }
        if (count > 0) {
            return soma / count;
        } else {
            return 0.0;
        }
    }


    public String listarDisciplinasPosGraduacao() {
        String output = "Disciplinas de Pós-Graduação:\n";
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getProfessor().getFormacao() == EnumFormacao.POS_GRADUACAO) {
                output += "Disciplina: " + disciplina.getNome() + "\n";
            }
        }
        return output;
    }




    public List<Professor> getProfessores() {
        return professores;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    private double calcularMedia(List<Double> notas) {
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.size();
    }
}
