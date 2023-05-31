package quinta_aula.exercicio_farmacia.util;

import java.util.ArrayList;
import java.util.List;

import quinta_aula.exercicio_farmacia.model.*;
import quinta_aula.exercicio_farmacia.model.Medicamento;

public class Util {

    private List<Medicamento> medicamentos;
    private List<Pessoa> pessoas;

    public Util() {
        this.medicamentos = new ArrayList<>();
        this.pessoas = new ArrayList<>();
    }

    public void cadastrarMedicamento(Medicamento medicamento) {
        medicamentos.add(medicamento);
    }

    public void cadastrarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public void prescreverMedicamento(Pessoa pessoa, Medicamento medicamento) {
        if (pessoa.possuiAlergiaContraindicada(medicamento)) {
            System.out.println("A pessoa possui alergia contraindicada ao medicamento. A prescrição não pode ser realizada.");
        } else if (!medicamento.getIndicacoes().contains(pessoa.getSintoma())) {
            System.out.println("O sintoma da pessoa não está na lista de indicações do medicamento. A prescrição não pode ser realizada.");
        } else {
            pessoa.adicionarMedicamento(medicamento);
            System.out.println("Medicamento prescrito com sucesso para a pessoa.");
        }
    }

    public String listarPessoasEMedicamentos() {
        String result = "";

        for (Pessoa pessoa : pessoas) {
            result += "Pessoa: " + pessoa.getNome() + "\n";
            result += "Medicamentos: " + pessoa.getMedicamentos() + "\n\n";
        }

        return result;
    }


    public Medicamento selecionarMedicamento(String nome) {
        for (Medicamento medicamento : medicamentos) {
            if (medicamento.getNome().equals(nome)) {
                return medicamento;
            }
        }
        return null;
    }

    public Pessoa selecionarPessoa(String nome) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getNome().equals(nome)) {
                return pessoa;
            }
        }
        return null;
    }
}
