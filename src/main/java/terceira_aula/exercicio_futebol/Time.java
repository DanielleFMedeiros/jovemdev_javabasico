package terceira_aula.exercicio_futebol;

import java.util.List;
import java.util.ArrayList;

public class Time {
	
	private static EnumTime nomeTime;
	private static List<Jogador> jogadores;
	
	public Time(EnumTime nomeTime) {
		this.nomeTime = nomeTime;
		jogadores = new ArrayList();
	}
	
   public void addJogador(Jogador jogador) {
        jogadores.add(jogador);
    }
   
   public List<Jogador> getJogadores() {
       return jogadores;
   }
   
   public EnumTime getNome() {
       return nomeTime;
   }

	void cadastrarTime() {
		Util.escolherTime();
		Jogador j = new Jogador();
		j.cadastrarJogador();
		jogadores.add(j);
		Util.voltarAoMenu();
	}

	public static String listaJogadoresTime(List<Time> lista) {
		Util.escolherTime();
		String ret = "Jogadores do time: " + Util.escolherTime() + "\n";
        for (Jogador jogador : jogadores) {
        	Jogador j = new Jogador();
        	j.cadastrarJogador();
        	return ret + jogadores;
        }
        ret = ret+ "Número Camisa: " + Jogador.getNumeroCamisa() +"\n";
        return ret;
    	//jogador artilheiro do time
    }
	
	private static Object getTime() {
		// TODO Auto-generated method stub
		return null;
	}

	public Jogador getArtilheiro() {
		Jogador artilheiro = jogadores.get(0);
		for (Jogador jogador : jogadores) {
			if(jogador.getGols()>artilheiro.getGols()) {
				artilheiro = jogador;
				}
			}
		return artilheiro;
		}
	}

