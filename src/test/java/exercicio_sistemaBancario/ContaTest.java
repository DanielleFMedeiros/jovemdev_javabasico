package exercicio_sistemaBancario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Assert;

public class ContaTest {

	@Test
	void testDeposito() {
		Conta conta = new Conta();
		conta.deposito(100.0);
		Assertions.assertEquals(100.0, conta.getSaldo(), 0.001);
	}

	@Test
	void testConstrutor() {
		int numero = 123;
		int agencia = 456;
		String nomeCorrentista = "John Doe";

		Conta conta = new Conta(numero, agencia, nomeCorrentista);

		assertEquals(numero, conta.getNumero());
		assertEquals(agencia, conta.getAgencia());
		assertEquals(nomeCorrentista, conta.getNomeCorrentista());
		assertEquals(0.0, conta.getSaldo());
	}

	@Test
	void testTransferencia() throws SaldoInsuficienteException {
		Conta contaOrigem = new Conta();
		contaOrigem.setSaldo(500.0);

		Conta contaDestino = new Conta();
		contaDestino.setSaldo(200.0);

		double valorTransferencia = 300.0;
		contaOrigem.transferencia(contaDestino, valorTransferencia, valorTransferencia);

		Assertions.assertEquals(200.0, contaOrigem.getSaldo(), 0.001);
		Assertions.assertEquals(500.0, contaDestino.getSaldo(), 0.001);
	}

	@Test
	public void testTransferencia2() throws SaldoInsuficienteException {
		Conta contaOrigem = new Conta(123, 456, "João");
		contaOrigem.deposito(1000.0);

		Conta contaDestino = new Conta(789, 123, "Maria");
		contaDestino.deposito(500.0);

		double valorTransferencia = 500.0;

		contaOrigem.transferencia(contaDestino, valorTransferencia, valorTransferencia);

		double saldoContaOrigemEsperado = 500.0;
		double saldoContaDestinoEsperado = 1000.0;

		Assertions.assertEquals(saldoContaOrigemEsperado, contaOrigem.getSaldo());
		Assertions.assertEquals(saldoContaDestinoEsperado, contaDestino.getSaldo());
	}

	@Test
	void testTransferenciaSaldoInsuficiente() {
		Conta contaOrigem = new Conta();
		contaOrigem.setSaldo(100.0);

		Conta contaDestino = new Conta();
		contaDestino.setSaldo(200.0);

		double valorTransferencia = 300.0;

		Assertions.assertThrows(SaldoInsuficienteException.class, () -> {
			contaOrigem.transferencia(contaDestino, valorTransferencia, valorTransferencia);
		});
	}
	
	@Test
	void testValorTransferenciaMenorQueZero_Exception() throws SaldoInsuficienteException {
	    Conta contaOrigem = new Conta();
	    contaOrigem.setSaldo(0.0);

	    Conta contaDestino = new Conta();
	    contaDestino.setSaldo(200.0);

	    double valorTransferencia = -200;
	    double saldoNovo = contaOrigem.getSaldo() - valorTransferencia; // Corrigido: usar "-" em vez de "+"

	    try {
	        contaOrigem.transferencia(contaDestino, valorTransferencia, saldoNovo);
	        fail("SaldoInsuficienteException não foi lançada.");
	    } catch (IllegalArgumentException e) {
	        assertEquals("O valor da transferência deve ser maior que zero.", e.getMessage());
	    }
	}





	@Test
	void testTransferenciaSaldoSuficiente() throws SaldoInsuficienteException {
		Conta contaOrigem = new Conta(100.0);
		Conta contaDestino = new Conta(0.0);

		contaOrigem.transferencia(contaDestino, 50.0, 0);

		assertEquals(50.0, contaOrigem.getSaldo());
		assertEquals(50.0, contaDestino.getSaldo());
	}

	@Test
	public void testSaque() {
		Conta conta = new Conta();
		conta.setSaldo(100.0);
		conta.saque(50.0);
		Assert.assertEquals(50.0, conta.getSaldo(), 0.001);
	}

}
