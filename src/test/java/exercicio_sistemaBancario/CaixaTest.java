package exercicio_sistemaBancario;

import exercicio_sistemaBancario.Conta;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CaixaTest {

    private Caixa caixa;
    private Conta contaOrigem;
    private Conta contaDestino;

    @BeforeEach
    public void setUp() {
        caixa = new Caixa();
        contaOrigem = new Conta(1234, 5678, "João");
        contaDestino = new Conta(5678, 1234, "Maria");
    }

    @Test
    public void testTransferencia_SaldoSuficiente() throws SaldoInsuficienteException {
        contaOrigem.setSaldo(200.0);
        contaDestino.setSaldo(100.0);
        caixa.transferencia(contaOrigem, contaDestino, 150.0);
        double saldoOrigem = contaOrigem.getSaldo();
        double saldoDestino = contaDestino.getSaldo();
        Assertions.assertEquals(50.0, saldoOrigem);
        Assertions.assertEquals(250.0, saldoDestino);
    }

    @Test
    public void testTransferencia_SaldoInsuficiente() {
        contaOrigem.setSaldo(100.0);
        contaDestino.setSaldo(200.0);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            caixa.transferencia(contaOrigem, contaDestino, 150.0);
        });
    }
}
