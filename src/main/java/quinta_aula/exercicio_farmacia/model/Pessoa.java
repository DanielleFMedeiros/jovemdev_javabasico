package quinta_aula.exercicio_farmacia.model;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {

    private String nome;
    private String sintoma;
    private List<String> alergias;
    private List<Medicamento> medicamentos;

    public Pessoa(String nome, String sintoma, List<String> alergias) {
        this.nome = nome;
        this.sintoma = sintoma;
        this.alergias = alergias;
        this.medicamentos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getSintoma() {
        return sintoma;
    }

    public List<String> getAlergias() {
        return alergias;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void adicionarMedicamento(Medicamento medicamento) {
        medicamentos.add(medicamento);
    }

    public boolean possuiAlergiaContraindicada(Medicamento medicamento) {
        List<String> alergiasContraindicadas = medicamento.getAlergiasContraindicadas();
        for (String alergia : alergiasContraindicadas) {
            if (alergias.contains(alergia)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return nome;
    }
}
