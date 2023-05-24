package terceira_aula.exercicio_futebol;

import javax.swing.JOptionPane;

public class Util {

	public static int escolherOP() {
		String menu = "1 - Cadastrar times\r\n"
				+ "2 - Listar todos jogadores de um time\r\n"
				+ "3 - Verificar artilheiro do campeonato\r\n"
				+ "4 - Verificar qual time fez mais gols no campeonato\r\n"
				+ "5 - Sair \r\n";
				
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}
//cadastro time
	//cadastro de cada jogador do referido time
	
	//listar todos os jogadores de um time
	//verificar artilheiro do campeonato
	//verificar qual time fez mais gols no campeonato
}
