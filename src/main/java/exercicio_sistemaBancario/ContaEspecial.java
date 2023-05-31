package exercicio_sistemaBancario;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class ContaEspecial extends Conta {
	private double limite=200.0;

	@Override
	public void saque(double valorSaque) {
		if (valorSaque <= limite) {
			super.saque(valorSaque);
		}else {
			System.out.println("Valor de saque excede o limite disponível.");
		}
		
	}

	

}
