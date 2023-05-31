package quinta_aula.exercicio_farmacia.model;

import java.util.List;

import quinta_aula.exercicio_farmacia.enuns.EnumAdministracao;

public class Medicamento {

    private String nome;
    private EnumAdministracao administracao;
    private List<String> alergiasContraindicadas;
    private List<String> indicacoes;

    public Medicamento(String nome, EnumAdministracao administracao, List<String> alergiasContraindicadas, List<String> indicacoes) {
        this.nome = nome;
        this.administracao = administracao;
        this.alergiasContraindicadas = alergiasContraindicadas;
        this.indicacoes = indicacoes;
    }
    

    public String getNome() {
        return nome;
    }

    public EnumAdministracao getAdministracao() {
        return administracao;
    }

    public List<String> getAlergiasContraindicadas() {
        return alergiasContraindicadas;
    }

    public List<String> getIndicacoes() {
        return indicacoes;
    }

    @Override
    public String toString() {
        return nome;
    }
}
