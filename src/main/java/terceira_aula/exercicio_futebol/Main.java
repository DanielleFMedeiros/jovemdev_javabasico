package terceira_aula.exercicio_futebol;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
public class Main {

	public static void main(String[] args) {
		List<Time> lista = new ArrayList<Time>();
		int op = 0;
		do {
			op = Util.escolherOP();
			switch(op) {
			case 1: 
				Time t = new Time();
				t.cadastrarTime();
				lista.add(t);
				break;
			case 2:
				JOptionPane.showMessageDialog(null, Util.listaJogadoresTime(lista));
			case 3:
				JOptionPane.showMessageDialog(null, Util.listaArtilheiros(lista));
			case 4:
				JOptionPane.showMessageDialog(null, Util.listaTimeGols(lista));
			case 5:
				JOptionPane.showMessageDialog(null, "Você saiu do programa!");
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida");
				
			}
			
		}while(op != 5);

	}

}
