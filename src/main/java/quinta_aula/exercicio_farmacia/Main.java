package quinta_aula.exercicio_farmacia;

public class Main {
	public static void main(String[] args) {
        Util util = new Util();

        util.cadastrarMedicamento();
        util.cadastrarPessoa();

        String nomeDaPessoa = "Nome da Pessoa"; // Insira o nome correto da pessoa aqui
        String resultadoPrescricao = util.prescreverMedicamento(nomeDaPessoa);
        System.out.println(resultadoPrescricao);

        util.listarPessoasEMedicamentos();
    }
}
