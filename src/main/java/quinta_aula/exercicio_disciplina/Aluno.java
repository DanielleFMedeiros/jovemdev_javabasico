package quinta_aula.exercicio_disciplina;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {

	private List<Disciplina> disciplinas;
	private List<Double> notas;

	public Aluno(String nome) {
		super(nome);
		this.disciplinas = new ArrayList<>();
		this.notas = new ArrayList<>();
	}

	public void matricularDisciplina(Disciplina disciplina) {
		disciplinas.add(disciplina);
		notas.add(0.0);
	}

	public void adicionarNota(Disciplina disciplina, double nota) {
		int index = disciplinas.indexOf(disciplina);
		if (index != -1) {
			notas.set(index, nota);
		}
	}

	public double obterNota(Disciplina disciplina) {
		int index = disciplinas.indexOf(disciplina);
		if (index != -1) {
			return notas.get(index);
		}
		return 0.0;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public List<Double> getNotas() {
		return notas;
	}

	public void setNotas(List<Double> notas) {
		this.notas = notas;
	}

}
