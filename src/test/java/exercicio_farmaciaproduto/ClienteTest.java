package exercicio_farmaciaproduto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClienteTest {
    private Cliente cliente;

    @BeforeEach
    void setUp() {
        cliente = new Cliente("João", 100.0);
    }

    @Test
    void criarCliente_GettersDeveRetornarValoresCorretos() {
        Assertions.assertEquals("João", cliente.getNome());
        Assertions.assertEquals(100.0, cliente.getSaldoDevedor());
    }

    @Test
    void setNome_AlterarNome_NomeDeveSerAtualizado() {
        cliente.setNome("Maria");
        Assertions.assertEquals("Maria", cliente.getNome());
    }

    @Test
    void pagarConta_PagarValor_SaldoDevedorDeveSerAtualizado() {
        cliente.pagarConta(50.0);
        Assertions.assertEquals(50.0, cliente.getSaldoDevedor());
    }

    @Test
    void pagarConta_PagarValorSuperiorAoSaldoDevedor_SaldoDevedorDeveSerZero() {
        cliente.pagarConta(150.0);
        Assertions.assertEquals(0.0, cliente.getSaldoDevedor());
    }
}
