package exercicio_farmaciaproduto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MedicamentosTest {
    private Medicamentos medicamento;

    @BeforeEach
    void setUp() {
        medicamento = new Medicamentos("Medicamento A", 10, 20.0, true);
    }

    @Test
    void criarMedicamento_GettersDeveRetornarValoresCorretos() {
        Assertions.assertEquals("Medicamento A", medicamento.getNome());
        Assertions.assertEquals(10, medicamento.getEstoque());
        Assertions.assertEquals(20.0, medicamento.getValor());
        Assertions.assertTrue(medicamento.isReceitaObrigatoria());
    }

    @Test
    void setReceitaObrigatoria_AlterarValor_ReceitaObrigatoriaDeveSerAtualizada() {
        medicamento.setReceitaObrigatoria(false);
        Assertions.assertFalse(medicamento.isReceitaObrigatoria());
    }
}
