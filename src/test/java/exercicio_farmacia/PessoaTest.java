package exercicio_farmacia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import quinta_aula.exercicio_farmacia.model.Medicamento;
import quinta_aula.exercicio_farmacia.model.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaTest {

    private Pessoa pessoa;
    private Medicamento medicamento1;
    private Medicamento medicamento2;
    private List<String> alergias;

    @BeforeEach
    public void setUp() {
        alergias = new ArrayList<>();
        alergias.add("Penicilina");
        alergias.add("Sulfametoxazol");

        medicamento1 = new Medicamento("Paracetamol", null, alergias, alergias);
        medicamento2 = new Medicamento("Amoxicilina", null, alergias, alergias);

        medicamento1.adicionarAlergiaContraindicada("Aspirina");
        medicamento2.adicionarAlergiaContraindicada("Penicilina");

        pessoa = new Pessoa("João", "Dor de cabeça", alergias);
    }

    @Test
    public void testAdicionarMedicamento() {
        pessoa.adicionarMedicamento(medicamento1);
        pessoa.adicionarMedicamento(medicamento2);

        List<Medicamento> medicamentos = pessoa.getMedicamentos();

        Assertions.assertEquals(2, medicamentos.size());
        Assertions.assertTrue(medicamentos.contains(medicamento1));
        Assertions.assertTrue(medicamentos.contains(medicamento2));
    }

    @Test
    public void testPossuiAlergiaContraindicada() {
        boolean possuiAlergia1 = pessoa.possuiAlergiaContraindicada(medicamento1);
        boolean possuiAlergia2 = pessoa.possuiAlergiaContraindicada(medicamento2);

        Assertions.assertFalse(possuiAlergia1);
        Assertions.assertTrue(possuiAlergia2);
    }

    @Test
    public void testToString() {
        Assertions.assertEquals("João", pessoa.toString());
    }
}
