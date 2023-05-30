package quinta_aula.exercicio_disciplina;
import java.util.ArrayList;
import java.util.List;

import quinta_aula.exercicio_disciplina.EnumFormacao;


public class Main {
    public static void main(String[] args) {
        
        Util util = new Util();
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
        
        util.listarDisciplinasComMedia(util.getAlunos().get(0));
        util.listarDisciplinasComMedia(util.getAlunos().get(1));
      
        util.listarDisciplinasPosGraduacao();
    }
}
