package terceira_aula.exercicio_futebol;

import java.util.List;

import javax.swing.JOptionPane;

public class Util {
	static String desejaVoltar;
	
	static EnumTime escolherTime() {
		String menu = "Times disponiveis:\n";
		
		for(EnumTime nomeTime: EnumTime.values()) {
			menu += nomeTime.getCodigo() + " - " + nomeTime.getDescricao()+"\n";
		}
		int op = Integer.parseInt(JOptionPane.showInputDialog(menu));
		return EnumTime.findById(op);
	}
	
	public static int escolherOP() {
		String menu = "1 - Cadastrar Time\r\n"
				+ "2 - Listar todos jogadores de um time\r\n"
				+ "3 - Verificar artilheiro do campeonato\r\n"
				+ "4 - Verificar qual time fez mais gols no campeonato\r\n"
				+ "5 - Sair \r\n";
				
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}
	
	
	public static int voltarAoMenu(){
		desejaVoltar = JOptionPane.showInputDialog("Deseja voltar ao menu? 1-Sim 2-Não");
		int resposta = Integer.parseInt(desejaVoltar);
		if(resposta == 1){
			escolherOP();
		}else if(resposta ==2){
			Jogador jogador = new Jogador();
			jogador.cadastrarJogador();
		}
		return resposta;
	}
    //Buscar time parametro lista times q está no principal
	//metodo retorna artilheiro do campeonato

    public String listaArtilheiros(List<Time> lista) {
        return null;
    }
	public String listaTimeGols(List<Time> lista) {
		return null;
	}

	//listar todos os jogadores de um time
	//verificar artilheiro do campeonato
	//verificar qual time fez mais gols no campeonato
}
