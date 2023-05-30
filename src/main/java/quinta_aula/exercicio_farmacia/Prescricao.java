package quinta_aula.exercicio_farmacia;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prescricao {
	private List<Medicamento> medicamentos;
	private List<Pessoa> pessoas;
	private Scanner scanner;

	public Prescricao() {
		medicamentos = new ArrayList<>();
		pessoas = new ArrayList<>();
		scanner = new Scanner(System.in);
	}

	public void cadastrarMedicamento(String nome, EnumAdministracao administracao, List<String> alergiasContraindicadas, List<String> indicacoes) {
	    Medicamento medicamento = new Medicamento(nome, administracao, alergiasContraindicadas, indicacoes);
	    medicamentos.add(medicamento);
	    System.out.println("Medicamento cadastrado com sucesso!");
	}

		

	private boolean verificarAlergiaExistente(String alergia) {
		// Implemente a lógica para verificar se a alergia existe
		return true;
	}

	private boolean verificarSintomaExistente(String sintoma) {
		// Implemente a lógica para verificar se o sintoma existe
		return true;
	}

	public void cadastrarPessoa(String nome, String sintoma, List<String> alergias) {
		Pessoa pessoa = new Pessoa(nome, sintoma, alergias);
		pessoas.add(pessoa);
		System.out.println("Pessoa cadastrada com sucesso!");
	}

	public void prescreverMedicamento(String pessoaNome, String medicamentoNome) {
		Pessoa pessoa = null;
		Medicamento medicamento = null;

		// Procurar a pessoa pelo nome
		for (Pessoa p : pessoas) {
			if (p.getNome().equals(pessoaNome)) {
				pessoa = p;
				break;
			}
		}

		// Procurar o medicamento pelo nome
		for (Medicamento m : medicamentos) {
			if (m.getNome().equals(medicamentoNome)) {
				medicamento = m;
				break;
			}
		}

		// Verificar se a pessoa e o medicamento foram encontrados
		if (pessoa == null) {
			System.out.println("Pessoa não encontrada.");
			return;
		}

		if (medicamento == null) {
			System.out.println("Medicamento não encontrado.");
			return;
		}

		// Verificar se o medicamento é indicado para o sintoma da pessoa
		if (!medicamento.getIndicacoes().contains(pessoa.getSintoma())) {
			System.out.println("O medicamento não é indicado para o sintoma da pessoa.");
			return;
		}

		// Verificar se a pessoa é alérgica ao medicamento
		if (pessoa.getAlergias().contains(medicamento.getNome())) {
			System.out.println("A pessoa é alérgica a este medicamento.");
			return;
		}

		// Medicamento prescrito com sucesso para a pessoa
		System.out.println("Medicamento prescrito com sucesso para a pessoa!");
	}

	public void listarPessoasEMedicamentos() {
		for (Pessoa pessoa : pessoas) {
			System.out.println("Nome: " + pessoa.getNome());
			System.out.println("Medicamentos prescritos:");

			for (Medicamento medicamento : medicamentos) {
				if (medicamento.getIndicacoes().contains(pessoa.getSintoma())
						&& !pessoa.getAlergias().contains(medicamento.getNome())) {
					System.out.println("- " + medicamento.getNome());
				}
			}

			System.out.println("-----------------------");
		}
	}
}
