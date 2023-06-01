package exercicio_sistemaBancario;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exercicio_sistemaBancario.ContaUniversitaria;

public class ContaUniversitariaTest {

	private ContaUniversitaria conta;
	private ContaUniversitaria contaDestino;

	@BeforeEach
	public void setUp() {
		conta = new ContaUniversitaria();
		conta.deposito(1000.0);
		contaDestino = new ContaUniversitaria();
		contaDestino.deposito(500.0);
	}

	@Test
	public void transferencia_DeveTransferirValorEntreContas() throws SaldoInsuficienteException {
		ContaUniversitaria origem = new ContaUniversitaria();
		origem.setSaldo(1000.0);

		ContaUniversitaria destino = new ContaUniversitaria();
		destino.setSaldo(500.0);

		double valorTransferencia = 300.0;

		origem.transferencia(destino, valorTransferencia, destino.getSaldo());

		double saldoOrigemEsperado = 700.0;
		double saldoDestinoEsperado = 800.0;

		Assertions.assertEquals(saldoOrigemEsperado, origem.getSaldo());
		Assertions.assertEquals(saldoDestinoEsperado, destino.getSaldo());
	}

	@Test
	public void transferencia_DeveLancarSaldoInsuficienteException_QuandoSaldoInsuficiente() {
		ContaUniversitaria origem = new ContaUniversitaria();
		origem.setSaldo(100.0);

		ContaUniversitaria destino = new ContaUniversitaria();
		destino.setSaldo(500.0);

		double valorTransferencia = 200.0;

		Assertions.assertThrows(SaldoInsuficienteException.class, () -> {
			origem.transferencia(destino, valorTransferencia, destino.getSaldo());
		});
	}

	@Test
	public void transferencia_DeveLancarIllegalArgumentException_QuandoValorTransferenciaMenorIgualZero() {
		ContaUniversitaria origem = new ContaUniversitaria();
		origem.setSaldo(1000.0);

		ContaUniversitaria destino = new ContaUniversitaria();
		destino.setSaldo(500.0);

		double valorTransferencia = 0.0;

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			origem.transferencia(destino, valorTransferencia, destino.getSaldo());
		});
	}

	@Test
	public void transferencia_DeveLancarIllegalArgumentException_QuandoSaldoDestinoUltrapassaLimite() {
	    ContaUniversitaria origem = new ContaUniversitaria();
	    origem.setSaldo(1000.0);

	    ContaUniversitaria destino = new ContaUniversitaria();
	    destino.setSaldo(1500.0);

	    double valorTransferencia = 1000.0;

	    Assertions.assertThrows(IllegalArgumentException.class, () -> {
	        origem.transferencia(destino, valorTransferencia, destino.getSaldo());
	    });
	}


	@Test
	public void transferencia_DeveTransferirValorEntreContasEAtualizarSaldoNovo() throws SaldoInsuficienteException {
	    ContaUniversitaria origem = new ContaUniversitaria();
	    origem.setSaldo(1000.0);

	    ContaUniversitaria destino = new ContaUniversitaria();
	    destino.setSaldo(500.0);

	    double valorTransferencia = 300.0;
	    double saldoNovoDestino = 800.0; // Valor correto

	    origem.transferencia(destino, valorTransferencia, saldoNovoDestino);

	    double saldoOrigemEsperado = 700.0;
	    double saldoDestinoEsperado = 800.0;

	    Assertions.assertEquals(saldoOrigemEsperado, origem.getSaldo());
	    Assertions.assertEquals(saldoDestinoEsperado, destino.getSaldo());
	}


	@Test
	public void transferencia_DeveLancarSaldoInsuficienteException_QuandoSaldoInsuficienteEAtualizarSaldoNovo() {
		ContaUniversitaria origem = new ContaUniversitaria();
		origem.setSaldo(100.0);

		ContaUniversitaria destino = new ContaUniversitaria();
		destino.setSaldo(500.0);

		double valorTransferencia = 200.0;
		double saldoNovoDestino = 700.0;

		Assertions.assertThrows(SaldoInsuficienteException.class, () -> {
			origem.transferencia(destino, valorTransferencia, saldoNovoDestino);
		});
	}

	@Test
	public void transferencia_DeveLancarIllegalArgumentException_QuandoValorTransferenciaMenorIgualZeroEAtualizarSaldoNovo() {
		ContaUniversitaria origem = new ContaUniversitaria();
		origem.setSaldo(1000.0);

		ContaUniversitaria destino = new ContaUniversitaria();
		destino.setSaldo(500.0);

		double valorTransferencia = 0.0;
		double saldoNovoDestino = 700.0;

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			origem.transferencia(destino, valorTransferencia, saldoNovoDestino);
		});
	}

	@Test
	public void transferencia_DeveLancarIllegalArgumentException_QuandoSaldoDestinoUltrapassaLimiteEAtualizarSaldoNovo() {
		ContaUniversitaria origem = new ContaUniversitaria();
		origem.setSaldo(1000.0);

		ContaUniversitaria destino = new ContaUniversitaria();
		destino.setSaldo(1500.0);

		double valorTransferencia = 1000.0;
		double saldoNovoDestino = 2000.0;

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			origem.transferencia(destino, valorTransferencia, saldoNovoDestino);
		});
	}

	@Test
	public void testSaqueSaldoSuficiente() {
		double valorSaque = 500.0;
		conta.saque(valorSaque);
		double saldoEsperado = 1000.0 - valorSaque;
		assertEquals(saldoEsperado, conta.getSaldo(), 0.001);
	}

	@Test
	public void testSaqueSaldoInsuficiente() {
		double valorSaque = 1200.0;
		assertThrows(IllegalArgumentException.class, () -> {
			conta.saque(valorSaque);
		});
		assertEquals(1000.0, conta.getSaldo(), 0.001);
	}

	@Test
	public void testDepositoSaldoLimiteExcedido() {
		double valorDeposito = 1500.0;
		assertThrows(IllegalArgumentException.class, () -> {
			conta.deposito(valorDeposito);
		});
	}

	@Test
	public void testDepositoSaldoLimiteNaoExcedido() {
		double valorDeposito = 500.0;
		conta.deposito(valorDeposito);
		assertEquals(1500.0, conta.getSaldo(), 0.001);
	}

	@Test
	public void testTransferirSaldoInsuficiente() {
	    ContaUniversitaria origem = new ContaUniversitaria();
	    origem.setSaldo(100.0);

	    ContaUniversitaria destino = new ContaUniversitaria();
	    destino.setSaldo(0.0);

	    double valorTransferencia = 200.0;

	    try {
	        origem.transferencia(destino, valorTransferencia, destino.getSaldo());
	        fail("Uma exceção SaldoInsuficienteException deveria ter sido lançada.");
	    } catch (SaldoInsuficienteException e) {
	        assertEquals("Saldo insuficiente para realizar transferência", e.getMessage());
	    }

	    assertEquals(100.0, origem.getSaldo());
	    assertEquals(0.0, destino.getSaldo());
	}
	
	
	@Test
    public void testTransferenciaComSaldoDestinoUltrapassaLimite() {
        ContaUniversitaria origem = new ContaUniversitaria();
        ContaUniversitaria destino = new ContaUniversitaria();
        double saldoOrigem = 1000.0;
        double valorTransferencia = 500.0;
        double limiteSaldo = 2000.0;
        
        origem.setSaldo(saldoOrigem);
        
        assertThrows(IllegalArgumentException.class, () -> {
            origem.transferencia(destino, valorTransferencia, limiteSaldo + 1);
        });
    }

}
