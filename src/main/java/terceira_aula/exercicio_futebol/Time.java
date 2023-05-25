package terceira_aula.exercicio_futebol;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Time {
	String nomeTime;
	List<Jogador> lista = new ArrayList<Jogador>();
	void cadastrarTime() {
		nomeTime = JOptionPane.showInputDialog("Nome do time: ");
		Jogador.cadastrar();
		Util.voltarAoMenu();
	}
}
