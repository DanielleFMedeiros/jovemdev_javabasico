package exercicio_sistemaBancario.util;

import exercicio_sistemaBancario.model.Conta;

public class Caixa {
	public void transferencia(Conta origem, Conta destino, double valor) {
		if (origem.getSaldo() < valor) {
			throw new IllegalArgumentException("Saldo insuficiente para transferência");
		}

		origem.setSaldo(origem.getSaldo() - valor);
		destino.setSaldo(destino.getSaldo() + valor);
	}

}
