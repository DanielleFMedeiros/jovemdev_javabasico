package segunda_aula.exercicio_carro;

import javax.swing.JOptionPane;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Carro {

	private String marca;
	private Cor cor;
	private int anoFabricacao;

	public enum Cor {
		BLACK, GRAY, WHITE, GREEN, YELLOW, BLUE, RED;
	}

	public Carro(String marca, int anoFabricacao, Cor cor) {
		this.marca = marca;
		this.anoFabricacao = anoFabricacao;
		this.cor = cor;
	}

	public String getMarca() {
		return marca;
	}

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public Cor getCor() {
		return cor;
	}

}
