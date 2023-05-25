package terceira_aula.exercicio_futebol;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		List<Time> times = new ArrayList<>();

		int opcao;
		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Menu:\n" +
					"1 - Cadastrar Time\n" +
					"2 - Listar Jogadores de um Time\n" +
					"3 - Verificar Artilheiro do Campeonato\n" +
					"4 - Verificar Time com Mais Gols\n" +
					"0 - Sair\n\n" +
					"Digite a opção desejada:"));

			switch (opcao) {
				case 1:
					Time time = Util.cadastrarTime();
					times.add(time);
					break;

				case 2:
					Time timeSelecionado = Util.selecionarTime(times);
					if (timeSelecionado != null) {
						Util.listarJogadores(timeSelecionado);
					} else {
						JOptionPane.showMessageDialog(null, "Time não encontrado.");
					}
					break;

				case 3:
					Jogador artilheiro = Util.verificarArtilheiro(times);
					if (artilheiro != null) {
						JOptionPane.showMessageDialog(null, "Artilheiro do Campeonato: " + artilheiro.getNome() +
								" (" + artilheiro.getGolsMarcados() + " gols)");
					} else {
						JOptionPane.showMessageDialog(null, "Nenhum jogador encontrado.");
					}
					break;
				case 4:
					Time timeMaisGols = Util.verificarTimeMaisGols(times);
					if (timeMaisGols != null) {
						JOptionPane.showMessageDialog(null, "Time com mais gols: " + timeMaisGols.getNome() +
								" (" + timeMaisGols.getTotalGolsMarcados() + " gols)");
					} else {
						JOptionPane.showMessageDialog(null, "Nenhum time encontrado.");
					}
					break;
				case 0:
					JOptionPane.showMessageDialog(null, "Encerrando o programa.");
					break;
				default:
					JOptionPane.showMessageDialog(null, "Opção inválida.");
					break;
			}
		} while (opcao != 0);
	}

}
