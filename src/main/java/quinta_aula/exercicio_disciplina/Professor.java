package quinta_aula.exercicio_disciplina;

public class Professor extends Pessoa{
    private EnumFormacao formacao;

    public Professor(String nome, EnumFormacao formacao) {
        super(nome);
        this.formacao = formacao;
    }

    public EnumFormacao getFormacao() {
        return formacao;
    }

    public void setFormacao(EnumFormacao formacao) {
        this.formacao = formacao;
    }
}
