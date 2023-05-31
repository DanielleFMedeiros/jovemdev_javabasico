package exercicio_sistemaBancario;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class Conta {
	private int numero;
	private int agencia;
	private String nomeCorrentista;
	protected double saldo;

	public void deposito(double valorDeposito) {
		saldo = saldo + valorDeposito;
	}

	public void saque(double valorSaque) {
		saldo = saldo - valorSaque;
	}

	public void transferencia(Conta contaDestino, double valorTransferencia) throws SaldoInsuficienteException {
		if (saldo < valorTransferencia) {
			throw new SaldoInsuficienteException("Saldo insuficiente para realizar transferencia");
		} else {
			saldo -= valorTransferencia;
			contaDestino.saldo += valorTransferencia;
		}

	}
}
