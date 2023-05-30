package quinta_aula.exercicio_disciplina;

import java.util.ArrayList;
import java.util.List;

public class Util {

	public static List<Disciplina> listarDisciplinasPorAluno(Aluno aluno) {
		return aluno.getDisciplinas();
	}

	public static double calcularMediaPorAluno(Aluno aluno, Disciplina disciplina) {
		return aluno.obterNota(disciplina);
	}

	public static List<Disciplina> listarDisciplinasComPosGraduacao(List<Disciplina> disciplinas) {
		List<Disciplina> disciplinasPosGraduacao = new ArrayList<>();
		for (Disciplina disciplina : disciplinas) {
			Professor professor = disciplina.getProfessor();
			if (professor.getFormacao() == EnumFormacao.POS_GRADUACAO) {
				disciplinasPosGraduacao.add(disciplina);
			}
		}
		return disciplinasPosGraduacao;
	}
}