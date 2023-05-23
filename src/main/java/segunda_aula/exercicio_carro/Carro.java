package segunda_aula.exercicio_carro;

import javax.swing.JOptionPane;

public class Carro {
	
	String marca;
	String cor;
	int anoFabricacao;
	int anoInicial;
	int anoFinal;

	
	public enum Cor{BLACK, GRAY, WHITE}
	
	public void cadastra() {
		marca = JOptionPane.showInputDialog("Marca: ");
		anoFabricacao = Integer.parseInt(JOptionPane.showInputDialog("Ano Fabricação: "));
		System.out.println("Selecione uma cor");
		System.out.println("1 - Vermelho");
	    System.out.println("2 - Verde");
	    System.out.println("3 - Azul");
	    System.out.print("Opção: ");
	    
	}
		
	
	
	public void listarPorPeriodo() {
		JOptionPane.showMessageDialog(null, "Qual período você deseja? ");
		anoInicial = Integer.parseInt(JOptionPane.showInputDialog("Ano Inicial: "));
		anoFinal = Integer.parseInt(JOptionPane.showInputDialog("Ano final: "));
		if(anoInicial >= anoFabricacao && anoFinal<= anoFabricacao) {
			System.out.println(marca + ", Ano: " + anoFabricacao);
		}else {
			System.out.println("Digite um periodo válido");
		}
	}
	
	
	public void listarPorMarca(){
		marca = JOptionPane.showInputDialog("Marca: ");
		if (marca.equals(marca.toUpperCase())) {
		    System.out.println(marca);
		} else {
		    System.out.println("A string não foi digitada totalmente em letras maiúsculas.");
		}
	}



	
	
}
