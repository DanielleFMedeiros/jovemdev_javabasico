package terceira_aula.exercicio_livro;

import java.util.List;

public class Livro {
    private String titulo;
    private String autores;
    private double preco;
    private List<Livro> livros;

    public Livro(String titulo, String autores, double preco) {
		this.titulo = titulo;
		this.autores = autores;
		this.preco = preco;
	}
    
    public String getTitulo() {
        return titulo;
    }

    public String getAutores() {
        return autores;
    }

    public double getPreco() {
        return preco;
    }

    //cadastrar livros - arraylist
    //não permitir valores menores ou iguais a 0

}
