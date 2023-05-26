package terceira_aula.exercicio_livro;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Autor {
    private String nome;
    private char sexo;
    private int idade;
    //idade nao pode ser negativa
    //sexo f ou m

    public Autor(String nome, char sexo, int idade){
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }


    public boolean validar() {
        if (getNome().trim().equals("") || !getNome().contains(" ")){
			JOptionPane.showMessageDialog(null, "O nome e o sobrenome do autor devem ser preenchidos");
			return false;
		}

		if (sexo != 'F' && sexo != 'M') {
			JOptionPane.showMessageDialog(null, "sexo inválido, tente novamente");
			return false;
		}
		if (idade <= 0) {
			JOptionPane.showMessageDialog(null, "idade inválida, digite novamente");
			return false;
		
		}
		return true;
    }
    
    @Override
    public String toString() {
        return "Autor: " + nome + " " + ", Sexo: " + sexo + ", Idade: " + idade;
    }

    public List<Livro> getLivros(List<Livro> todosLivros) {
        List<Livro> livrosDoAutor = new ArrayList<>();

        for (Livro livro : todosLivros) {
            if (livro.getAutores().contains(this)) {
                livrosDoAutor.add(livro);
            }
        }

        return livrosDoAutor;
    }

}
