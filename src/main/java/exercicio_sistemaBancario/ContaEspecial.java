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
	    } else {
	        throw new IllegalArgumentException("Valor de saque excede o limite disponível.");
	    }
	}

	public void setLimite(double novoLimite) {
	    if (novoLimite >= 0) {
	        this.limite = novoLimite;
	    } else {
	        throw new IllegalArgumentException("O limite deve ser um valor não negativo.");
	    }
	}


	

}
