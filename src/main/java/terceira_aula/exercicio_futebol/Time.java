package terceira_aula.exercicio_futebol;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor

public class Time {

	private EnumTime nome;
	private List<Jogador> jogadores;

	public Time(EnumTime nome) {
		this.nome = nome;
		this.jogadores = new ArrayList();
	}

	public void cadastrarJogador(String nome, int numeroCamisa, int gols) {
		Jogador jogador = new Jogador(nome, numeroCamisa, gols);
		jogadores.add(jogador);
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void adicionarJogador(Jogador jogador) {
		jogadores.add(jogador);
	}

	public int getTotalGolsMarcados() {
		int totalGols = 0;
		for (Jogador jogador : jogadores) {
			totalGols += jogador.getGolsMarcados();
		}
		return totalGols;
	}

	public Jogador getArtilheiro() {
		Jogador artilheiro = null;
		int maxGols = 0;
		for (Jogador jogador : jogadores) {
			if (jogador.getGolsMarcados() > maxGols) {
				maxGols = jogador.getGolsMarcados();
				artilheiro = jogador;
			}
		}
		return artilheiro;
	}

	public EnumTime getNome() {
		return nome;
	}

}
