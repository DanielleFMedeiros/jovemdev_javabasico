package quinta_aula.exercicio_farmacia;

import java.util.List;

public class Pessoa {
    private String nome;
    private String sintoma;
    private List<String> alergias;

    public Pessoa(String nome, String sintoma, List<String> alergias) {
        this.nome = nome;
        this.sintoma = sintoma;
        this.alergias = alergias;
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
}
