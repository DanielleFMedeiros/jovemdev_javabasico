package segunda_aula.exercicio_carro;

import javax.swing.JOptionPane;

public class Carro {
	
	String marca;
	Cor cor;
	int anoFabricacao;
	
	public enum Cor{
		BLACK,
		GRAY, 
		WHITE,
		GREEN,
		YELLOW,
		BLUE,
		RED;
	}

	public Carro(String marca, int anoFabricacao, Cor cor){
		this.marca = marca;
		this.anoFabricacao = anoFabricacao;
		this.cor = cor;
	}

	public String getMarca(){
		return marca;
	}

	public int getAnoFabricacao(){
		return anoFabricacao;
	}

	public Cor getCor(){
		return cor;
	}

}
