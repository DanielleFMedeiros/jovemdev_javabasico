package quinta_aula.exercicio_disciplina;

import java.util.List;

public class Main {
	public static void main(String[] args) {

		Professor professor1 = new Professor("João", EnumFormacao.GRADUACAO);
		Professor professor2 = new Professor("Maria", EnumFormacao.POS_GRADUACAO);

		Aluno aluno1 = new Aluno("Pedro");
		Aluno aluno2 = new Aluno("Ana");

		Disciplina disciplina1 = new Disciplina("Matemática", 60, professor1);
		Disciplina disciplina2 = new Disciplina("História", 40, professor2);
		Disciplina disciplina3 = new Disciplina("Português", 80, professor1);

		aluno1.matricularDisciplina(disciplina1);
		aluno1.matricularDisciplina(disciplina2);
		aluno2.matricularDisciplina(disciplina1);
		aluno2.matricularDisciplina(disciplina3);

		aluno1.adicionarNota(disciplina1, 7.5);
		aluno1.adicionarNota(disciplina2, 8.0);
		aluno2.adicionarNota(disciplina1, 6.0);
		aluno2.adicionarNota(disciplina3, 9.5);

		List<Disciplina> disciplinasAluno1 = Util.listarDisciplinasPorAluno(aluno1);
		System.out.println("Disciplinas do Aluno 1 (" + aluno1.getNome() + "):");
		for (Disciplina disciplina : disciplinasAluno1) {
			System.out.println(disciplina.getNome());
		}

		double mediaAluno2Disciplina1 = Util.calcularMediaPorAluno(aluno2, disciplina1);
		System.out.println("Média do Aluno 2 (" + aluno2.getNome() + ") na disciplina " + disciplina1.getNome() + ": "
				+ mediaAluno2Disciplina1);

		List<Disciplina> disciplinasPosGraduacao = Util
				.listarDisciplinasComPosGraduacao(List.of(disciplina1, disciplina2, disciplina3));
		System.out.println("Disciplinas lecionadas por professores com pós-graduação:");
		for (Disciplina disciplina : disciplinasPosGraduacao) {
			System.out.println(disciplina.getNome());
		}
	}
}
