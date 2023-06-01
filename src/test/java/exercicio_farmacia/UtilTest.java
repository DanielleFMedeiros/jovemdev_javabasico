package exercicio_farmacia;

import org.junit.Before;
import org.junit.Test;

import quinta_aula.exercicio_farmacia.enuns.EnumAdministracao;
import quinta_aula.exercicio_farmacia.model.Medicamento;
import quinta_aula.exercicio_farmacia.model.Pessoa;
import quinta_aula.exercicio_farmacia.util.Util;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class UtilTest {

    private Util util;

    @Before
    public void setUp() {
        util = new Util();

        // Cadastro de medicamentos
        Medicamento medicamento1 = new Medicamento("Paracetamol", EnumAdministracao.ORAL, new ArrayList<>(), new ArrayList<>());
        Medicamento medicamento2 = new Medicamento("Dipirona", EnumAdministracao.ORAL, new ArrayList<>(), new ArrayList<>());
        util.cadastrarMedicamento(medicamento1);
        util.cadastrarMedicamento(medicamento2);

        // Cadastro de pessoas
        Pessoa pessoa1 = new Pessoa("João", "Dor de cabeça", new ArrayList<>());
        Pessoa pessoa2 = new Pessoa("Maria", "Febre", new ArrayList<>());
        util.cadastrarPessoa(pessoa1);
        util.cadastrarPessoa(pessoa2);
    }

    @Test
    public void testPrescreverMedicamento() {
        // Selecionar uma pessoa previamente cadastrada
        Pessoa pessoa = util.selecionarPessoa("João");

        // Selecionar um medicamento previamente cadastrado
        Medicamento medicamento = util.selecionarMedicamento("Paracetamol");

        // Prescrever medicamento para a pessoa
        util.prescreverMedicamento(pessoa, medicamento);

        // Verificar se o medicamento foi prescrito corretamente para a pessoa
        assertTrue(pessoa.getMedicamentos().contains(medicamento));
    }

    @Test
    public void testListarPessoasEMedicamentos() {
        // Listar todas as pessoas e seus respectivos medicamentos
        String listaPessoasEMedicamentos = util.listarPessoasEMedicamentos();

        // Verificar se a lista está correta
        String expected = "Pessoa: João\nMedicamentos: [Paracetamol]\n\n" +
                "Pessoa: Maria\nMedicamentos: []\n";
        assertEquals(expected, listaPessoasEMedicamentos);
    }
}
