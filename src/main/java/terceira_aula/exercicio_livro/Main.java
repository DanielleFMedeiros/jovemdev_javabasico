package terceira_aula.exercicio_livro;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		ArrayList<Autor> autores = new ArrayList<>();
		ArrayList<Livro> livros = new ArrayList<>();
		int opcao;
		do {
			opcao = Util.escolherOP();
			switch (opcao) {
			case 1:
				ArrayList<Object> autorList = Util.cadastrarAutor();
				for (Object obj : autorList) {
					if (obj instanceof Autor) {
						autores.add((Autor) obj);
					}
				}
				break;
			case 2:
				Util.cadastrarLivro(autores, livros);
				break;

			case 3:
				Util.listarLivrosCadastrados(livros);
				break;
			case 4:
				Util.listarLivrosPorAutor(livros);
				break;
			case 5:
				Util.pesquisarPorFaixaDeValor(livros);
				break;
			case 6:
				Util.listarLivrosAutoresComCriancas(livros);
				break;
			case 7:
				Util.listarLivrosPorSexoDosAutores(livros);
				break;
			case 0:
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida.");
				break;
			}
		} while (opcao != 0);
	}
}
