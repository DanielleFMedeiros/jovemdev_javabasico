package quinta_aula.exercicio_disciplina;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import quinta_aula.exercicio_disciplina.*;

import java.util.ArrayList;
import java.util.List;

public class UtilTest {
    private Util util;

    @Before
    public void setup() {
        util = new Util();
        util.cadastrarProfessor("João", EnumFormacao.GRADUACAO);
        util.cadastrarProfessor("Maria", EnumFormacao.ESPECIALIZACAO);
        util.cadastrarProfessor("Pedro", EnumFormacao.POS_GRADUACAO);

        util.cadastrarAluno("Lucas");
        util.cadastrarAluno("Julia");

        util.cadastrarDisciplina("Matemática", 60, util.getProfessores().get(0));
        util.cadastrarDisciplina("História", 40, util.getProfessores().get(1));
        util.cadastrarDisciplina("Física", 80, util.getProfessores().get(2));

        List<Disciplina> disciplinasLucas = new ArrayList<>();
        disciplinasLucas.add(util.getDisciplinas().get(0));
        disciplinasLucas.add(util.getDisciplinas().get(2));
        util.escolherDisciplinas(util.getAlunos().get(0), disciplinasLucas);

        List<Disciplina> disciplinasJulia = new ArrayList<>();
        disciplinasJulia.add(util.getDisciplinas().get(1));
        util.escolherDisciplinas(util.getAlunos().get(1), disciplinasJulia);

        double[] notasLucas = {7.5, 8.0, 9.0};
        util.informarNotas(util.getAlunos().get(0), util.getDisciplinas().get(0), notasLucas);

        double[] notasJulia = {6.5, 7.0, 8.0};
        util.informarNotas(util.getAlunos().get(1), util.getDisciplinas().get(1), notasJulia);
    }

    @Test
    public void testListarDisciplinasComMedia() {
        String expectedOutput1 = "Disciplina: Matemática, Média: 8.17";
        String expectedOutput2 = "Disciplina: História, Média: 7.17";

        String output1 = util.listarDisciplinasComMedia(util.getAlunos().get(0));
        String output2 = util.listarDisciplinasComMedia(util.getAlunos().get(1));

        Assert.assertEquals(expectedOutput1, output1);
        Assert.assertEquals(expectedOutput2, output2);
    }

    @Test
    public void testListarDisciplinasPosGraduacao() {
        String expectedOutput = "Disciplina: Física";

        String output = util.listarDisciplinasPosGraduacao();

        Assert.assertEquals(expectedOutput, output);
    }
}

