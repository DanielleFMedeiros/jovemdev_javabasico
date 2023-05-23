package segunda_aula.exercicio_carro;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import segunda_aula.Pessoa;

public class Main {
	
	static List<Carro> carros = new ArrayList<Carro>();
	
	public static void main(String[] args) {
		
		String menu = "1 - Cadastrar Carro\n"
				+ "2 - Listar os carros por período de fabricação\n"
				+ "3 - Listar carros por marca\n"
				+ "4 - Listar carros por cor\n\n"
				+ "5 - Sair";
		
		int op = 0;
		do {
			op = Integer.parseInt(JOptionPane.showInputDialog(menu));
			if(op == 1) {
				Carro c = new Carro();
				c.cadastra();
				carros.add(c);
			}
			if(op == 2) {
				Carro c = new Carro();
				c.listarPorPeriodo();
				carros.add(c);
			}
			if(op == 3) {
//				Carro c = new Carro();
//				c.listarPorPeriodo();
//				carros.add(c);
			}
			if(op == 4) {
//				Carro c = new Carro();
//				c.listarPorPeriodo();
//				carros.add(c);
			}
		}while(op != 5);
	}

}
