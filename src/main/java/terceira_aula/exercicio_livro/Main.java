package terceira_aula.exercicio_livro;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        ArrayList<Autor> autores = new ArrayList<>();

    int opcao;
    do{
        opcao = Util.escolherOP();
        switch (opcao) {
            case 1:
                ArrayList<Object> autor = Util.cadastrarAutor();
                autor.add(autores);
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                JOptionPane.showMessageDialog(null, "Encerrando o programa.");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida.");
                break;
        }
    }while(opcao!=0);
    }
}
