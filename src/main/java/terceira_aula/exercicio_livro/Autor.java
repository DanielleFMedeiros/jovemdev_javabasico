package terceira_aula.exercicio_livro;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Autor {
    private String nome;
    private String sexo;
    private int idade;
    //idade nao pode ser negativa
    //sexo f ou m

    public Autor(String nome, int i, int idade){
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public String toString(){
        return "Autor: " + nome + ", Sexo: " + sexo + ", idade: " + idade;
    }

    public boolean validar() {
        if (getNome().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "O nome do autor deve ser preenchido");
			return false;
		}

		if (sexo != "F" || sexo != "M") {
			JOptionPane.showMessageDialog(null, "sexo inválido, tente novamente");
			return false;
		}
		if (idade < 0) {
			JOptionPane.showMessageDialog(null, "idade inválida, digite novamente");
			return false;
		}
		return true;
    }

    public void add(ArrayList<Autor> autores) {
    }

}
