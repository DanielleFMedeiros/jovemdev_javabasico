package terceira_aula.exercicio_futebol;

import javax.swing.JOptionPane;

public class Jogador {
	private static String nomeJogador;
	private static int numeroCamisa;
	private static int golsMarcados;
	
	static void cadastrar() {
		nomeJogador = JOptionPane.showInputDialog("Nome do jogador: ");
		numeroCamisa = Integer.parseInt(JOptionPane.showInputDialog("Número da Camisa: "));
		golsMarcados = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de gols marcados no campeonato: "));
		if(!validar()) {
			cadastrar();
		}
	}
	
	static boolean validar() {
		if(nomeJogador.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "O nome do jogador deve ser preenchido");
			return false;
		}
		

		if(numeroCamisa<=0) {
			JOptionPane.showMessageDialog(null, "Número inválido, escolha outro número");
			return false;
		}
		if(golsMarcados<0) {
			JOptionPane.showMessageDialog(null, "Quantidade de gols inválida, digite novamente");
			return false;
		}
		return true;
	}
	
	public String toString() {
		return "Nome: " + nomeJogador + "\n"
				+ "Número Camisa: " + numeroCamisa + "\n"
				+ "Gols Marcados: " + golsMarcados + "\n"
				+ "_____________\n";
	}

}
