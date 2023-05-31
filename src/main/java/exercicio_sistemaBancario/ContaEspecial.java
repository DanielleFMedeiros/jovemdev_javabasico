package exercicio_sistemaBancario;

import lombok.Getter;

@Getter
public class ContaEspecial extends Conta{
	private double limite;
	
	boolean Saque(double valorSaque) {
		if(valorSaque>limite) {
			return false;
		}
		return true;
	}
	
}
