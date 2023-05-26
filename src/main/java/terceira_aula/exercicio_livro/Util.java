package terceira_aula.exercicio_livro;

import javax.swing.JOptionPane;

public class Util {

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
    //menu
    /*  1 - Cadastrar Autor 
        2 – Cadastrar Livros (escolher entre os autores cadastrados)
        3 - Listar todos os livros cadastrados (todos os dados do livro, inclusive os autores com todos os dados)
        4 - Pesquisar por autor (listar todos os livros de um autor) 
        5 - Pesquisar por faixa de valor do livro (mínimo e máximo) 
        6 - Listar todos os livros cujo autores tenham crianças (idade <=12) 
        7 – Listar todos os livros que foram escritos apenas por mulheres ou por homens (o usuário informa qual sexo deseja realizar a consulta).
    */
}
