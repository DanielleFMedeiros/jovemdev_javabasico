package primeira_aula;

import javax.swing.JOptionPane;

public class Main {
	
	public static void main(String[] args) {

		String pessoas = JOptionPane.showInputDialog("Digite o número de pessoas: ");
		int qtdePessoas = Integer.parseInt(pessoas);

		String[] nome = new String[qtdePessoas];
        char[] sexo = new char[qtdePessoas];
        double[] p1 = new double[qtdePessoas];
        double[] a1 = new double[qtdePessoas];

		for(int i = 0; i < qtdePessoas; i++) {
			nome[i] = JOptionPane.showInputDialog("Digite seu nome: ");
			System.out.println("Nome: " + nome[i]);
			
			String sex = JOptionPane.showInputDialog("Digite o sexo(F ou M): ");
			sexo[i] = sex.charAt(0);
			System.out.println("Sexo: " + sexo[i]);
			
			String peso = JOptionPane.showInputDialog("Digite seu peso: ");
			p1[i] = Double.parseDouble(peso);
			System.out.println("Peso: " + peso);
			
			String altura = JOptionPane.showInputDialog("Digite sua altura: ");
			a1[i] = Double.parseDouble(altura);
			System.out.println("Altura: " + altura);
			
			double result = calculaImc(a1[i],p1[i]);
			System.out.printf("O IMC é: %.2f \n", result);
			
			String avalia = avaliaImc(result, sexo[i]);
			System.out.println("Avaliação do Imc: " + avalia);

		}
		
	}
	
	public static double calculaImc(double a1, double p1) {
		return p1/(a1*a1);
	}
	
	private static String avaliaImc(double result, char sexo) {
		if(sexo == 'F' || sexo == 'f' ){
			if(result<19.1) {
				return "Abaixo do peso";
			}else if(result<25.8 && result>19.1) {
				return "Peso ideal";
			}else if(result<27.3 && result>25.9){
				return"Pouco acima do peso";
			}else if(result<32.3 && result>27.4){
				return "Acima do peso";
			}else{
				return "Obesidade";
			}
		}else if(sexo == 'M'|| sexo == 'm' ){
			if(result<20.7) {
				return "Abaixo do peso";
			}else if(result<26.4 && result>20.7) {
				return "Peso ideal";
			}else if(result<27.8 && result>26.5) {
				return "Pouco acima do peso";
			}else if(result<31.1 && result>27.9) {
				return "Acima do peso";
			}else if(result>31.2) {
				return "Obesidade";
			}
		}else {
			return "Digite novamente";
		}
		return null;
		
	}

}
