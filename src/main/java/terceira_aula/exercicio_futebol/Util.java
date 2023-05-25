package terceira_aula.exercicio_futebol;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Util {

	public static Time cadastrarTime() {
		EnumTime nomeTime = (EnumTime) JOptionPane.showInputDialog(null, "Selecione o nome do Time:",
				"Cadastro de Time",
				JOptionPane.QUESTION_MESSAGE, null, EnumTime.values(), EnumTime.values()[0]);

		Time time = new Time(nomeTime);

		boolean adicionarJogador = true;

		while (adicionarJogador) {
			String nomeJogador = JOptionPane.showInputDialog("Digite o nome do Jogador:");
			int numeroCamisa = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da camisa do Jogador:"));
			int golsMarcados = Integer
					.parseInt(JOptionPane.showInputDialog("Digite a quantidade de gols marcados pelo Jogador:"));

			Jogador jogador = new Jogador(nomeJogador, numeroCamisa, golsMarcados);

			boolean dadosValidos = jogador.validar();

			if (dadosValidos) {
				time.cadastrarJogador(jogador); // Corrigido para passar o objeto jogador como argumento
				JOptionPane.showMessageDialog(null, "Jogador cadastrado com sucesso!");
			} else {
				JOptionPane.showMessageDialog(null, "Dados inválidos do jogador. Digite novamente.");
				continue; // Volta para o início do loop para solicitar dados novamente
			}

			int resposta = JOptionPane.showConfirmDialog(null, "Deseja adicionar mais jogadores?",
					"Adicionar Jogadores",
					JOptionPane.YES_NO_OPTION);
			adicionarJogador = (resposta == JOptionPane.YES_OPTION);
		}

		return time;

	}

	public static void listarJogadores(Time time) {
		if (time != null) {
			List<Jogador> jogadores = time.getJogadores();
			if (jogadores.size() > 0) {
				System.out.println("Jogadores do time " + time.getNome() + ":");
				for (Jogador jogador : jogadores) {
					System.out.println("Nome: " + jogador.getNome());
					System.out.println("Número da camisa: " + jogador.getNumeroCamisa());
					System.out.println("Gols marcados: " + jogador.getGolsMarcados());
					System.out.println();
				}
			} else {
				System.out.println("O time " + time.getNome() + " não possui jogadores cadastrados.");
			}
		} else {
			System.out.println("Time não encontrado.");
		}
	}

	public static Jogador verificarArtilheiro(List<Time> times) {
		List<Jogador> todosJogadores = new ArrayList<>();
		for (Time t : times) {
			todosJogadores.addAll(t.getJogadores());
		}

		Jogador artilheiro = null;
		int maxGols = 0;
		for (Jogador jogador : todosJogadores) {
			if (jogador.getGolsMarcados() > maxGols) {
				maxGols = jogador.getGolsMarcados();
				artilheiro = jogador;
			}
		}

		return artilheiro;
	}

	public static Time verificarTimeMaisGols(List<Time> times) {
		int maxGolsTime = 0;
		Time timeMaisGols = null;
		for (Time t : times) {
			int golsTime = t.getTotalGolsMarcados();
			if (golsTime > maxGolsTime) {
				maxGolsTime = golsTime;
				timeMaisGols = t;
			}
		}

		return timeMaisGols;
	}

	public static int escolherOP() {
		String menu = "1 - Cadastrar Time\r\n"
				+ "2 - Listar todos jogadores de um time\r\n"
				+ "3 - Verificar artilheiro do campeonato\r\n"
				+ "4 - Verificar qual time fez mais gols no campeonato\r\n"
				+ "5 - Sair \r\n";

		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}

	public static Time selecionarTime(List<Time> times) {
		EnumTime[] enumTimes = EnumTime.values();
		String opcoesTimes = "Times disponíveis:\n";
		for (int i = 0; i < enumTimes.length; i++) {
			opcoesTimes += (i + 1) + " - " + enumTimes[i].name() + "\n";
		}
		opcoesTimes += "\nDigite o número do Time:";

		int numeroTime = Integer.parseInt(JOptionPane.showInputDialog(opcoesTimes));
		if (numeroTime >= 1 && numeroTime <= enumTimes.length) {
			EnumTime timeSelecionado = enumTimes[numeroTime - 1];
			for (Time t : times) {
				if (t.getNome() == timeSelecionado) {
					return t;
				}
			}
		}
		return null;

	}

}
