package terceira_aula.exercicio_futebol;

import java.util.List;

import javax.swing.JOptionPane;

public class Util {
	static String desejaVoltar;
	public static int escolherOP() {
		String menu = "1 - Cadastrar Time\r\n"
				+ "2 - Listar todos jogadores de um time\r\n"
				+ "3 - Verificar artilheiro do campeonato\r\n"
				+ "4 - Verificar qual time fez mais gols no campeonato\r\n"
				+ "5 - Sair \r\n";
				
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}
	//cadastro time
	//cadastro de cada jogador do referido time
	public static String voltarAoMenu(){
		desejaVoltar = JOptionPane.showInputDialog("Deseja voltar ao menu? ");
		String resposta = "sim";
		if(desejaVoltar.equals("sim")){
			escolherOP();
		}else{
			Jogador.cadastrar();
		}
		return resposta;
	}
/* 
	public static boolean voltar(){
		if(desejaVoltar.equals("sim")){
			return true;
		}else{
			return false;
		}
	}
	*/

    public static Object listaJogadoresTime(List<Time> lista) {

        return null;
    }

    public static Object listaArtilheiros(List<Time> lista) {
        return null;
    }
	public static Object listaTimeGols(List<Time> lista) {
		return null;
	}


	
	//listar todos os jogadores de um time
	//verificar artilheiro do campeonato
	//verificar qual time fez mais gols no campeonato
}
