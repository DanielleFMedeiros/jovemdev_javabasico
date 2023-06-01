package exercicio_sistemaBancario.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import exercicio_sistemaBancario.model.ContaEspecial;

public class ContaEspecialTest {
    
    @Test
    void testSaqueDentroDoLimite() {
        ContaEspecial conta = new ContaEspecial();
        conta.setSaldo(500.0);
        conta.setLimite(200.0);

        double valorSaque = 100.0;
        double saldoAnterior = conta.getSaldo();
        
        conta.saque(valorSaque);
        
        double saldoAtual = conta.getSaldo();
        
        assertEquals(saldoAnterior - valorSaque, saldoAtual, 0.001);
    }
    @Test
    void testSaqueExcedeLimite() {
        ContaEspecial conta = new ContaEspecial();
        conta.setSaldo(500.0);
        conta.setLimite(200.0);

        double valorSaque = 400.0;

        // Utiliza assertThrows para verificar se a exceção é lançada
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            conta.saque(valorSaque);
        });

        // Verifica se a mensagem da exceção está correta
        assertEquals("Valor de saque excede o limite disponível.", exception.getMessage());
    }

    
    @Test
    void testSetLimiteLimiteNegativo() {
        ContaEspecial conta = new ContaEspecial();

        assertThrows(IllegalArgumentException.class, () -> conta.setLimite(-200.0));
    }
}
