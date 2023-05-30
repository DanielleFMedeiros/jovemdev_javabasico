package quinta_aula.exercicio_disciplina;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UtilTest {

	@Test
	public void testListarDisciplinasPorAluno() {
		Aluno aluno = new Aluno("João");
		Disciplina disciplina1 = new Disciplina("Matemática", 60, new Professor("Prof. Silva", EnumFormacao.GRADUACAO));
		Disciplina disciplina2 = new Disciplina("Física", 60, new Professor("Prof. Santos", EnumFormacao.GRADUACAO));
		aluno.matricularDisciplina(disciplina1);
		aluno.matricularDisciplina(disciplina2);

		List<Disciplina> disciplinas = Util.listarDisciplinasPorAluno(aluno);

		assertEquals(2, disciplinas.size());
		assertEquals(disciplina1, disciplinas.get(0));
		assertEquals(disciplina2, disciplinas.get(1));
	}

	@Test
	public void testCalcularMediaPorAluno() {
		Aluno aluno = new Aluno("João");

		Professor professor1 = new Professor("Prof. A", EnumFormacao.POS_GRADUACAO);
		Disciplina disciplina1 = new Disciplina("Matemática", 40, professor1);
		aluno.matricularDisciplina(disciplina1);
		aluno.adicionarNota(disciplina1, 7.5);
		aluno.adicionarNota(disciplina1, 8.0);
		aluno.adicionarNota(disciplina1, 9.0);

		Professor professor2 = new Professor("Prof. B", EnumFormacao.POS_GRADUACAO);
		Disciplina disciplina2 = new Disciplina("História", 80, professor2);
		aluno.matricularDisciplina(disciplina2);
		aluno.adicionarNota(disciplina2, 6.0);
		aluno.adicionarNota(disciplina2, 7.0);
		aluno.adicionarNota(disciplina2, 8.0);

		double mediaDisciplina1 = Util.calcularMediaPorAluno(aluno, disciplina1);
		double mediaDisciplina2 = Util.calcularMediaPorAluno(aluno, disciplina2);

		Assert.assertEquals(8.5, mediaDisciplina1, 1.4);
		Assert.assertEquals(7.0, mediaDisciplina2, 8.0);
	}

	@Test
	public void testListarDisciplinasComPosGraduacao() {
		Professor professor1 = new Professor("Prof. Silva", EnumFormacao.GRADUACAO);
		Professor professor2 = new Professor("Prof. Santos", EnumFormacao.POS_GRADUACAO);
		Professor professor3 = new Professor("Prof. Lima", EnumFormacao.ESPECIALIZACAO);

		Disciplina disciplina1 = new Disciplina("Matemática", 60, professor1);
		Disciplina disciplina2 = new Disciplina("Física", 60, professor2);
		Disciplina disciplina3 = new Disciplina("Química", 60, professor3);

		List<Disciplina> disciplinas = new ArrayList<>();
		disciplinas.add(disciplina1);
		disciplinas.add(disciplina2);
		disciplinas.add(disciplina3);

		List<Disciplina> disciplinasPosGraduacao = Util.listarDisciplinasComPosGraduacao(disciplinas);

		assertEquals(1, disciplinasPosGraduacao.size());
		assertEquals(disciplina2, disciplinasPosGraduacao.get(0));
	}
}
