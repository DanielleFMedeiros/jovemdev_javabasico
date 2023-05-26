package terceira_aula.exercicio_livro;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Livro {
	private String titulo;
	private List<Autor> autores;
	private double preco;

	public Livro(String titulo, List<Autor> autoresLivro, double preco) {
		this.titulo = titulo;
		this.autores = autoresLivro;
		this.preco = preco;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public static void listarLivrosCadastrados(List<Livro> livros) {
		String message = "=== Livros Cadastrados ===\n\n";

		if (livros.isEmpty()) {
			message += "Nenhum livro cadastrado.";
		} else {
			for (Livro livro : livros) {
				message += "Título: " + livro.getTitulo() + "\n";
				message += "Autores:\n";
				for (Autor autor : livro.getAutores()) {
					message += "- " + autor.getNome() + "\n";
				}
				message += "Preço: R$" + livro.getPreco() + "\n\n";
			}
		}

		JOptionPane.showMessageDialog(null, message);
	}

	static Autor buscarAutor(ArrayList<Autor> autores, String nomeAutor) {
		for (Autor autor : autores) {
			if (autor.getNome().equalsIgnoreCase(nomeAutor)) {
				return autor;
			}
		}
		return null;
	}

	public static List<Livro> listarLivrosAutoresComCriancas(List<Livro> livros) {
		List<Livro> livrosComCriancas = new ArrayList<>();

		for (Livro livro : livros) {
			List<Autor> autores = livro.getAutores();
			boolean possuiCriancas = false;

			for (Autor autor : autores) {
				if (autor.getIdade() <= 12) {
					possuiCriancas = true;
					break;
				}
			}

			if (possuiCriancas) {
				livrosComCriancas.add(livro);
			}
		}
		return livrosComCriancas;
	}

	public static List<Livro> listarLivrosPorSexoDosAutores(List<Livro> livros, char sexo) {
		List<Livro> livrosPorSexo = new ArrayList<>();

		for (Livro livro : livros) {
			boolean possuiAutoresDoSexoInformado = true;
			List<Autor> autores = livro.getAutores();

			for (Autor autor : autores) {
				if (autor.getSexo() != sexo) {
					possuiAutoresDoSexoInformado = false;
					break;
				}
			}

			if (possuiAutoresDoSexoInformado) {
				livrosPorSexo.add(livro);
			}
		}

		return livrosPorSexo;
	}

	public static List<Livro> listarLivrosPorAutor(List<Livro> livros, Autor autor) {
		List<Livro> livrosPorAutor = new ArrayList<>();

		for (Livro livro : livros) {
			List<Autor> autores = livro.getAutores();

			if (autores.contains(autor)) {
				livrosPorAutor.add(livro);
			}
		}

		return livrosPorAutor;
	}

}
