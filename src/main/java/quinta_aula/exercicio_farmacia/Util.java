package quinta_aula.exercicio_farmacia;
import quinta_aula.exercicio_farmacia.EnumAdministracao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Util {
	private Prescricao prescricao;
	private Scanner scanner;
	private List<Pessoa> pessoas;
	private List<Medicamento> medicamentos;

	public Util() {
		prescricao = new Prescricao();
		scanner = new Scanner(System.in);
		pessoas = new ArrayList<>();
		medicamentos = new ArrayList<>();
	}

	public void cadastrarMedicamento() {
		System.out.println("Cadastro de Medicamento");
		System.out.print("Nome: ");
		String nome = scanner.nextLine();

		System.out.print("Administração (injetavel, topico, oral, supositorio): ");
		String administracaoStr = scanner.nextLine();
		EnumAdministracao administracao = EnumAdministracao.valueOf(administracaoStr.toUpperCase());

		System.out.print("Quantidade de alergias contraindicadas: ");
		String quantidadeAlergiasStr = scanner.nextLine();
		int quantidadeAlergias;

		try {
			quantidadeAlergias = Integer.parseInt(quantidadeAlergiasStr);
		} catch (NumberFormatException e) {
			System.out.println("Quantidade de alergias inválida. Certifique-se de inserir um número inteiro.");
			return;
		}

		List<String> alergiasContraindicadas = new ArrayList<>();
		for (int i = 0; i < quantidadeAlergias; i++) {
			System.out.print("Alergia #" + (i + 1) + ": ");
			String alergia = scanner.nextLine();
			alergiasContraindicadas.add(alergia);
		}

		System.out.print("Quantidade de indicações: ");
		int quantidadeIndicacoes = Integer.parseInt(scanner.nextLine());

		List<String> indicacoes = new ArrayList<>();
		for (int i = 0; i < quantidadeIndicacoes; i++) {
			System.out.print("Indicação #" + (i + 1) + ": ");
			String indicacao = scanner.nextLine();
			indicacoes.add(indicacao);
		}

		prescricao.cadastrarMedicamento(nome, administracao, alergiasContraindicadas, indicacoes);
	}

	public void cadastrarPessoa() {
		System.out.println("Cadastro de Pessoa");
		System.out.print("Nome: ");
		String nome = scanner.nextLine();
		System.out.print("Sintoma: ");
		String sintoma = scanner.nextLine();
		System.out.print("Quantidade de alergias: ");
		int quantidadeAlergias = Integer.parseInt(scanner.nextLine());

		List<String> alergias = new ArrayList<>();
		for (int i = 0; i < quantidadeAlergias; i++) {
			System.out.print("Alergia #" + (i + 1) + ": ");
			String alergia = scanner.nextLine();
			alergias.add(alergia);
		}

		prescricao.cadastrarPessoa(nome, sintoma, alergias);
	}

	public String prescreverMedicamento(String pessoaNome) {
		Pessoa pessoa = null;
		Medicamento medicamentoIdeal = null;

		// Encontrar a pessoa correspondente ao nome informado
		for (Pessoa p : pessoas) {
			if (p.getNome().equals(pessoaNome)) {
				pessoa = p;
				break;
			}
		}

		if (pessoa == null) {
			return "Pessoa não encontrada.";
		}

		// Verificar qual medicamento é ideal para a pessoa
		for (Medicamento medicamento : medicamentos) {
			if (medicamento.getIndicacoes().contains(pessoa.getSintoma())
					&& !pessoa.getAlergias().contains(medicamento.getNome())) {
				medicamentoIdeal = medicamento;
				break;
			}
		}

		if (medicamentoIdeal == null) {
			return "Não há medicamento indicado para o sintoma da pessoa.";
		}

		return "O medicamento ideal para " + pessoa.getNome() + " é: " + medicamentoIdeal.getNome();
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
