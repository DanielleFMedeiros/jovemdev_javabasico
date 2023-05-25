package terceira_aula.exercicio_futebol;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Jogador {
	private String nomeJogador;
	private static int numeroCamisa;
	private int gols;
	
	public Jogador(String nomeJogador, int numeroCamisa, int gols) {
        this.nomeJogador = nomeJogador;
        this.numeroCamisa = numeroCamisa;
        this.gols = gols;
    }


	public Jogador() {
		nomeJogador = (JOptionPane.showInputDialog("Nome do jogador: "));
		numeroCamisa = Integer.parseInt(JOptionPane.showInputDialog("Número da Camisa: "));
		gols = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de gols marcados no campeonato: "));
		if(!validar()) {
			cadastrarJogador();
			
		}
	}


	public String getNome() {
        return nomeJogador;
    }

    public static int getNumeroCamisa() {
        return numeroCamisa;
    }

    public int getGolsMarcados() {
        return gols;
    }
	
	 void cadastrarJogador() {
		nomeJogador = (JOptionPane.showInputDialog("Nome do jogador: "));
		numeroCamisa = Integer.parseInt(JOptionPane.showInputDialog("Número da Camisa: "));
		gols = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de gols marcados no campeonato: "));
		if(!validar()) {
			cadastrarJogador();
			
		}
		
	}
	 
	 public String toString() {
			return "Nome: " + getNomeJogador() + "\n"
					+ "Número Camisa: " + numeroCamisa + "\n"
					+ "Gols Marcados: " + gols + "\n"
					+ "_____________\n";
		}

		
	
	boolean validar() {
		if(getNomeJogador().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "O nome do jogador deve ser preenchido");
			return false;
		}
		

		if(numeroCamisa<=0) {
			JOptionPane.showMessageDialog(null, "Número inválido, escolha outro número");
			return false;
		}
		if(gols<0) {
			JOptionPane.showMessageDialog(null, "Quantidade de gols inválida, digite novamente");
			return false;
		}
		return true;
	}
	
	

	public String getNomeJogador() {
		return nomeJogador;
	}

}
