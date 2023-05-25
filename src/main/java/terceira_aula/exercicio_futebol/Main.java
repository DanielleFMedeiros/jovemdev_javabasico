package terceira_aula.exercicio_futebol;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
public class Main {

	public static void main(String[] args) {
		List<Time> times = new ArrayList<>();
		int op = 0;
		do {
			op = Util.escolherOP();
			switch(op) {
			case 1: 
				Time time = new Time(null);
				time.cadastrarTime();
				times.add(time);
				break;
			case 2:
				JOptionPane.showMessageDialog(null, Time.listaJogadoresTime(times));
			case 3:
				//JOptionPane.showMessageDialog(null, Util.listaArtilheiros(lista));//metodo qm qm fez mais gols de cada time
			case 4:
				//JOptionPane.showMessageDialog(null, Util.listaTimeGols(lista)); //metodo que retorna total de gols do time, percorre tds os j
			case 5:
				JOptionPane.showMessageDialog(null, "Você saiu do programa!");
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida");
				
			}
			
		}while(op != 5);

	}

}
