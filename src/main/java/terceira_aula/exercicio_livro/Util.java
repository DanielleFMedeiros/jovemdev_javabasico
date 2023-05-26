package terceira_aula.exercicio_livro;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Util {

    public static ArrayList<Object> cadastrarAutor() {
		ArrayList<Object> autores = new ArrayList<>();
		boolean cadastrarAutor = true;
		while (cadastrarAutor) {
			JOptionPane.showMessageDialog(null, "=== Cadastro de Autor ===");
			String nome = JOptionPane.showInputDialog("Nome do Autor:");
			String sexo = JOptionPane.showInputDialog("Sexo do autor:");
            char sex = sexo.charAt(0);
			int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do autor"));

			Autor autor = new Autor(nome, sex, idade);
			autores.add(autor);

			boolean dadosValidos = autor.validar();

			if (dadosValidos) {
				cadastrarAutor(); 
				JOptionPane.showMessageDialog(null, "Autor cadastrado com sucesso!");
			} else {
				JOptionPane.showMessageDialog(null, "Dados inválidos do Autor. Digite novamente.");
				continue; 
			}

			int resposta = JOptionPane.showConfirmDialog(null, "Deseja cadastrar outro autor?", "Cadastro de Autor",
                    JOptionPane.YES_NO_OPTION);
            cadastrarAutor = (resposta == JOptionPane.YES_OPTION);
		}

		return autores;

	}

	public static int escolherOP() {
		String menu = "1 - Cadastrar Autor\r\n"
				+ "2 - Cadastrar Livros (escolher entre os autores cadastrados)\r\n"
				+ "3 - Listar todos os livros cadastrados (todos os dados do livro, inclusive os autores com todos os dados)\r\n"
				+ "4 - Pesquisar por autor (listar todos os livros de um autor)\r\n"
				+ "5 - Pesquisar por faixa de valor do livro (mínimo e máximo)  \r\n"
                + "6 - Listar todos os livros cujo autores tenham crianças (idade <=12)\r\n"
                + "7 - Listar todos os livros que foram escritos apenas por mulheres ou por homens (o usuário informa qual sexo deseja realizar a consulta).\r\n"
                + "8 - Sair";

		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}

    //exibir titulo minusculo
 

}
