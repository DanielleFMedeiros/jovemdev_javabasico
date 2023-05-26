package terceira_aula.exercicio_livro;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class Util {

	public static ArrayList<Object> cadastrarAutor() {
		ArrayList<Object> autores = new ArrayList<>();
		boolean cadastrarAutor = true;
		while (cadastrarAutor) {
			JOptionPane.showMessageDialog(null, "=== Cadastro de Autor ===");
			String nome = JOptionPane.showInputDialog("Nome e sobrenome do Autor:");
			String sexo = JOptionPane.showInputDialog("Sexo do autor:");
			char sex = sexo.charAt(0);
			int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do autor"));

			Autor autor = new Autor(nome, sex, idade);

			boolean dadosValidos = autor.validar();

			if (dadosValidos) {
				autores.add(autor);
				JOptionPane.showMessageDialog(null, "Autor cadastrado com sucesso!");
			} else {
				int resposta;
				do {
					resposta = JOptionPane.showConfirmDialog(null, "Deseja corrigir os campos inválidos?",
							"Cadastro de Autor", JOptionPane.YES_NO_OPTION);

					if (resposta == JOptionPane.YES_OPTION) {
						if (autor.getNome().trim().isEmpty()) {
							autor.setNome(JOptionPane.showInputDialog("Nome do Autor:"));
						}

						if (autor.getSexo() != 'F' && autor.getSexo() != 'M') {
							sexo = JOptionPane.showInputDialog("Sexo do autor:");
							autor.setSexo(sexo.charAt(0));
						}

						if (autor.getIdade() <= 0) {
							idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade do autor"));
							autor.setIdade(idade);
						}

						dadosValidos = autor.validar();
					}
				} while (resposta == JOptionPane.YES_OPTION);

				if (dadosValidos) {
					autores.add(autor);
					JOptionPane.showMessageDialog(null, "Autor cadastrado com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o autor.");
				}
			}

			int resposta = JOptionPane.showConfirmDialog(null, "Deseja cadastrar outro autor?", "Cadastro de Autor",
					JOptionPane.YES_NO_OPTION);
			cadastrarAutor = (resposta == JOptionPane.YES_OPTION);

			if (!cadastrarAutor) {
				break;
			}
		}

		return autores;
	}

	public static void cadastrarLivro(ArrayList<Autor> autores, ArrayList<Livro> livros) {
	    JOptionPane.showMessageDialog(null, "=== Cadastrar Livro ===");
	    String titulo = JOptionPane.showInputDialog("Título do Livro:");
	    double preco = Double.parseDouble(JOptionPane.showInputDialog("Preço do Livro:"));

	    List<Autor> autoresLivro = new ArrayList<>();
	    boolean cadastrarAutor = true;
	    while (cadastrarAutor) {
	        String nomeAutor = JOptionPane.showInputDialog("Digite o nome do autor do livro:");
	        Autor autorEncontrado = Livro.buscarAutor(autores, nomeAutor);
	        if (autorEncontrado != null) {
	            autoresLivro.add(autorEncontrado);
	        } else {
	            JOptionPane.showMessageDialog(null, "Autor não encontrado. Por favor, cadastre o autor antes de cadastrar o livro.");
	            return; 
	        }

	        int resposta = JOptionPane.showConfirmDialog(null, "Deseja cadastrar outro autor para o livro?",
	                "Cadastro de Autor", JOptionPane.YES_NO_OPTION);
	        cadastrarAutor = (resposta == JOptionPane.YES_OPTION);
	    }

	    Livro livro = new Livro(titulo, autoresLivro, preco);
	    livros.add(livro);

	    JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");
	}


	public static void listarLivrosCadastrados(ArrayList<Livro> livros) {
	    if (livros.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Nenhum livro cadastrado.");
	        return;
	    }

	    JOptionPane.showMessageDialog(null, "=== Livros Cadastrados ===");
	    for (Livro livro : livros) {
	        String infoLivro = "Título: " + livro.getTitulo() + "\n";
	        infoLivro += "Autores: ";

	        List<Autor> autores = livro.getAutores();
	        for (Autor autor : autores) {
	            infoLivro += "Nome: " + autor.getNome() + "\n";
	            infoLivro += "Sexo: " + autor.getSexo() + "\n";
	            infoLivro += "Idade: " + autor.getIdade() + "\n";
	            infoLivro += "\n";
	        }
	        
	        infoLivro += "Preço: " + livro.getPreco() + "\n";


	        JOptionPane.showMessageDialog(null, infoLivro);
	    }
	}
	
	public static void listarLivrosPorAutor(ArrayList<Livro> livros) {
	    String nomeAutor = JOptionPane.showInputDialog("Digite o nome do autor:");

	    List<Livro> livrosPorAutor = new ArrayList<>();
	    for (Livro livro : livros) {
	        List<Autor> autores = livro.getAutores();
	        for (Autor autor : autores) {
	            if (autor.getNome().equalsIgnoreCase(nomeAutor)) {
	                livrosPorAutor.add(livro);
	                break;
	            }
	        }
	    }

	    if (livrosPorAutor.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Nenhum livro cadastrado pelo autor informado.");
	        return;
	    }

	    JOptionPane.showMessageDialog(null, "=== Livros do autor " + nomeAutor + " ===");
	    for (Livro livro : livrosPorAutor) {
	        String infoLivro = "Título: " + livro.getTitulo() + "\n";
	        infoLivro += "Autores: ";
	        List<Autor> autores = livro.getAutores();
	        for (int i = 0; i < autores.size(); i++) {
	            infoLivro += autores.get(i).getNome();
	            if (i < autores.size() - 1) {
	                infoLivro += ", ";
	            }
	        }
	        infoLivro += "\nPreço: " + livro.getPreco();

	        JOptionPane.showMessageDialog(null, infoLivro);
	    }
	}

	
	public static void pesquisarPorFaixaDeValor(ArrayList<Livro> livros) {
	    double valorMinimo = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor mínimo:"));
	    double valorMaximo = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor máximo:"));

	    boolean livrosEncontrados = false;

	    for (Livro livro : livros) {
	        if (livro.getPreco() >= valorMinimo && livro.getPreco() <= valorMaximo) {
	            livrosEncontrados = true;

	            String infoLivro = "Título: " + livro.getTitulo() + "\n";
	            infoLivro += "Autores: ";
	            List<Autor> autores = livro.getAutores();
	            for (int i = 0; i < autores.size(); i++) {
	                infoLivro += autores.get(i).getNome();
	                if (i < autores.size() - 1) {
	                    infoLivro += ", ";
	                }
	            }
	            infoLivro += "\nPreço: " + livro.getPreco();

	            JOptionPane.showMessageDialog(null, infoLivro);
	        }
	    }

	    if (!livrosEncontrados) {
	        JOptionPane.showMessageDialog(null, "Nenhum livro cadastrado na faixa de valor informada.");
	    }
	}

	public static void listarLivrosAutoresComCriancas(ArrayList<Livro> livros) {
	    List<Livro> livrosComCriancas = Livro.listarLivrosAutoresComCriancas(livros);

	    if (livrosComCriancas.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Nenhum livro cadastrado cujos autores tenham crianças.");
	        return;
	    }

	    JOptionPane.showMessageDialog(null, "=== Livros cujos autores têm crianças ===");
	    for (Livro livro : livrosComCriancas) {
	        String infoLivro = "Título: " + livro.getTitulo() + "\n";
	        infoLivro += "Autores: ";
	        List<Autor> autores = livro.getAutores();
	        for (int i = 0; i < autores.size(); i++) {
	            infoLivro += autores.get(i).getNome();
	            if (i < autores.size() - 1) {
	                infoLivro += ", ";
	            }
	        }
	        infoLivro += "\nPreço: " + livro.getPreco();

	        JOptionPane.showMessageDialog(null, infoLivro);
	    }
	}

	public static void listarLivrosPorSexoDosAutores(ArrayList<Livro> livros) {
	    char sexo = JOptionPane.showInputDialog("Informe o sexo dos autores que deseja pesquisar (M para masculino, F para feminino):").charAt(0);

	    List<Livro> livrosPorSexo = Livro.listarLivrosPorSexoDosAutores(livros, sexo);

	    if (livrosPorSexo.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Nenhum livro cadastrado escrito apenas por " + (sexo == 'M' ? "homens." : "mulheres."));
	        return;
	    }

	    JOptionPane.showMessageDialog(null, "=== Livros escritos apenas por " + (sexo == 'M' ? "homens ===" : "mulheres ==="));
	    for (Livro livro : livrosPorSexo) {
	        String infoLivro = "Título: " + livro.getTitulo() + "\n";
	        infoLivro += "Autores: ";
	        List<Autor> autores = livro.getAutores();
	        for (int i = 0; i < autores.size(); i++) {
	            infoLivro += autores.get(i).getNome();
	            if (i < autores.size() - 1) {
	                infoLivro += ", ";
	            }
	        }
	        infoLivro += "\nPreço: " + livro.getPreco();

	        JOptionPane.showMessageDialog(null, infoLivro);
	    }
	}


	public static int escolherOP() {
		String menu = "1 - Cadastrar Autor\r\n" + "2 - Cadastrar Livros (escolher entre os autores cadastrados)\r\n"
				+ "3 - Listar todos os livros cadastrados (todos os dados do livro, inclusive os autores com todos os dados)\r\n"
				+ "4 - Pesquisar por autor (listar todos os livros de um autor)\r\n"
				+ "5 - Pesquisar por faixa de valor do livro (mínimo e máximo)  \r\n"
				+ "6 - Listar todos os livros cujos autores tenham crianças (idade <=12)\r\n"
				+ "7 - Listar todos os livros que foram escritos apenas por mulheres ou por homens (o usuário informa qual sexo deseja realizar a consulta).\r\n"
				+ "0 - Sair";

		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}

}
