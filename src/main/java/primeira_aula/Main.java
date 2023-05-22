package primeira_aula;

import javax.swing.JOptionPane;

public class Main {
	
	public static void main(String[] args, double a1, double p1) {

		int vetor[] = new int[10];
		for(int i = 0; i < 10; i++) {
			String nome = JOptionPane.showInputDialog("Digite seu nome: ");
			System.out.println(nome);
			String sexo = JOptionPane.showInputDialog("Digite o sexo(F ou M): ");
			System.out.println(sexo);
			String peso = JOptionPane.showInputDialog("Digite seu peso: ");
			double p1 = Double.parseDouble(peso);
			System.out.println(peso);
			String altura = JOptionPane.showInputDialog("Digite sua altura: ");
			double a1 = Double.parseDouble(altura);
			System.out.println(altura);

		}

		double result = calculaImc(a1,p1);
		System.out.printf("%.2f", result);
		
		System.out.println(avaliaImc);
		
	
	}
	
	private static double calculaImc(double a1, double p1) {
		double imc = p1/a1;
		return  imc;
	}
	
	private static void avaliaImc(double imc, String sexo, String avaliaImc) {
		for(int i = 0; i < 10; i++) {
			if(sexo == "F" && imc<19.1) {
				System.out.println("Abaixo do peso");
			}else if(sexo == "F" && imc<25.8 && imc>19.1) {
				System.out.println("Peso ideal");
			}else if(sexo == "F" && imc<27.3 && imc>25.9){
				System.out.println("Pouco acima do peso");
			}else if(sexo == "F" && imc<32.3 && imc>27.4){
				System.out.println("Acima do peso");
			}else if(sexo == "F" && imc>=32.4) {
				System.out.println("Obesidade");
			}
			
			if(sexo == "M" && imc<20.7) {
				System.out.println("Abaixo do peso");
			}else if(sexo == "M" && imc<26.4 && imc>20.7) {
				System.out.println("Peso ideal");
			}else if(sexo == "M" && imc<27.8 && imc>26.5) {
				System.out.println("Pouco acima do peso");
			}else if(sexo == "M" && imc<31.1 && imc>27.9) {
				System.out.println("Acima do peso");
			}else if(sexo == "M" && imc>31.2) {
				System.out.println("Obesidade");
			}
		}
		
	}

}
