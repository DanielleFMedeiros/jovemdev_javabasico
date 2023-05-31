package quinta_aula.exercicio_disciplina;

import static org.junit.Assert.assertEquals;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AlunoTest {
	@Test
	public void testMatricularDisciplina() {
		Aluno aluno = new Aluno("Pedro");
		Disciplina disciplina = new Disciplina("Matemática", 60, new Professor("João", EnumFormacao.GRADUACAO));

		aluno.matricularDisciplina(disciplina);

		List<Disciplina> disciplinas = aluno.getDisciplinas();
		Assert.assertEquals(1, disciplinas.size());
		Assert.assertTrue(disciplinas.contains(disciplina));
	}

	@Test
	public void testAdicionarNota() {
		Aluno aluno = new Aluno("Pedro");
		Disciplina disciplina = new Disciplina("Matemática", 60, new Professor("João", EnumFormacao.GRADUACAO));

		aluno.matricularDisciplina(disciplina);
		aluno.adicionarNota(disciplina, 7.5);

		double nota = aluno.obterNota(disciplina);
		Assert.assertEquals(7.5, nota, 0.001);
	}

	@Test
	public void testObterNota() {
		Aluno aluno = new Aluno("Maria");
		Disciplina disciplina = new Disciplina("História", 60, new Professor("Prof. Santos", EnumFormacao.GRADUACAO));

		aluno.matricularDisciplina(disciplina);
		aluno.adicionarNota(disciplina, 8.5);

		assertEquals(8.5, aluno.obterNota(disciplina), 0.01);
	}

	@Test
	public void testObterNotaDisciplinaNaoMatriculada() {
		Aluno aluno = new Aluno("Pedro");
		Disciplina disciplina = new Disciplina("Geografia", 60, new Professor("Prof. Lima", EnumFormacao.GRADUACAO));

		assertEquals(0.0, aluno.obterNota(disciplina), 0.01);
	}

}
