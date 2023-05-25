package terceira_aula.exercicio_futebol;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Jogador {
	private String nome;
	private int numeroCamisa;
	private int gols;

	public Jogador(String nome, int numeroCamisa, int gols) {
		this.nome = nome;
		this.numeroCamisa = numeroCamisa;
		this.gols = gols;
	}

	public String getNome() {
		return nome;
	}

	public int getNumeroCamisa() {
		return numeroCamisa;
	}

	public int getGolsMarcados() {
		return gols;
	}

	public String toString() {
		return "Nome: " + getNome() + "\n"
				+ "Número Camisa: " + numeroCamisa + "\n"
				+ "Gols Marcados: " + gols + "\n"
				+ "_____________\n";
	}

	boolean validar() {
		if (getNome().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "O nome do jogador deve ser preenchido");
			return false;
		}

		if (numeroCamisa <= 0) {
			JOptionPane.showMessageDialog(null, "Número inválido, escolha outro número");
			return false;
		}
		if (gols < 0) {
			JOptionPane.showMessageDialog(null, "Quantidade de gols inválida, digite novamente");
			return false;
		}
		return true;
	}

	public String getNomeJogador() {
		return nome;
	}

}
