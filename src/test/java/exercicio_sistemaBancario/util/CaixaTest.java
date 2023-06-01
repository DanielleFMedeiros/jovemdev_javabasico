package exercicio_sistemaBancario.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exercicio_sistemaBancario.model.Conta;
import exercicio_sistemaBancario.util.Caixa;

public class CaixaTest {

	private Conta contaOrigem;
	private Conta contaDestino;
	private Caixa caixa;

	@BeforeEach
	public void setUp() {
		contaOrigem = new Conta();
		contaOrigem.deposito(1000.0);

		contaDestino = new Conta();
		contaDestino.deposito(500.0);

		caixa = new Caixa();
	}

	@Test
	public void testTransferenciaSaldoSuficiente() {
		double valorTransferencia = 300.0;
		caixa.transferencia(contaOrigem, contaDestino, valorTransferencia);

		double saldoOrigemEsperado = 1000.0 - valorTransferencia;
		double saldoDestinoEsperado = 500.0 + valorTransferencia;

		Assertions.assertEquals(saldoOrigemEsperado, contaOrigem.getSaldo(), 0.001);
		Assertions.assertEquals(saldoDestinoEsperado, contaDestino.getSaldo(), 0.001);
	}

	@Test
	public void testTransferenciaSaldoInsuficiente() {
		double valorTransferencia = 1500.0;
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			caixa.transferencia(contaOrigem, contaDestino, valorTransferencia);
		});

		Assertions.assertEquals(1000.0, contaOrigem.getSaldo(), 0.001);
		Assertions.assertEquals(500.0, contaDestino.getSaldo(), 0.001);
	}

}
