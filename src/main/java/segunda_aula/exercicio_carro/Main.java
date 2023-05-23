package segunda_aula.exercicio_carro;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import segunda_aula.exercicio_carro.Carro.Cor;

public class Main {
	
	public static void main(String[] args) {
		ArrayList<Carro> carros = new ArrayList<>();

		String menu = "1 - Cadastrar Carro\n"
				+ "2 - Listar os carros por período de fabricação\n"
				+ "3 - Listar carros por marca\n"
				+ "4 - Listar carros por cor\n\n"
				+ "5 - Sair";
		
		int op = 0;
		do {
			op = Integer.parseInt(JOptionPane.showInputDialog(menu));
			if(op == 1) {
				String marca = JOptionPane.showInputDialog("Marca: ");
				int anoFabricacao = Integer.parseInt(JOptionPane.showInputDialog("Ano Fabricação: "));
				
				Object[] cores = Cor.values();
				Cor corSelecionada = (Cor) JOptionPane.showInputDialog(null, "Escolha a cor do carro:",
					"Selecionar cor", JOptionPane.PLAIN_MESSAGE,null, cores,cores[0]);
				
				carros.add(new Carro(marca, anoFabricacao, corSelecionada));
				JOptionPane.showMessageDialog(null, "Carro cadastrado com sucesso!");
				

					
			}
			
			if(op == 2) {
				int anoInicial = Integer.parseInt(JOptionPane.showInputDialog("Informe o ano inicial:"));
				int anoFinal = Integer.parseInt(JOptionPane.showInputDialog("Informe o ano final:"));
				
				ArrayList<Carro> carrosPorPeriodo = listarCarrosPorPeriodo(carros, anoInicial, anoFinal);
				double percentualPeriodo = (double) carrosPorPeriodo.size() / carros.size() * 100;
			
				String mostraCarrosPorPeriodo = "Carros cadastrados no período de " + anoInicial + " a " + anoFinal + ":\n";
                    for (Carro carro : carrosPorPeriodo) {
                        mostraCarrosPorPeriodo += "Marca: " + carro.getMarca() + ", Ano: " + carro.getAnoFabricacao() + ", Cor: " + carro.getCor() + "\n" ;
                    }
                    mostraCarrosPorPeriodo += "Percentual: " + percentualPeriodo + "%";

                   System.out.println(mostraCarrosPorPeriodo);
                   
			} 

			if(op == 3) {
				String marcaBusca = JOptionPane.showInputDialog("Informe a marca:").toUpperCase();

				ArrayList<Carro> carrosPorMarca = listarCarrosPorMarca(carros, marcaBusca);
				double percentualMarca = (double) carrosPorMarca.size() / carros.size() * 100;

				String mostraCarroPorMarca = "Carros que possuem a marca " + marcaBusca + ": " + carrosPorMarca.size();
				for (Carro carro : carrosPorMarca) {
					mostraCarroPorMarca += "\nAno: " + carro.getAnoFabricacao() + ", Cor: " + carro.getCor() + "\n";
				}
				mostraCarroPorMarca += "\nPercentual: " + percentualMarca + "%";

				System.out.println(mostraCarroPorMarca);
			}

			if(op == 4) {
				Cor[] coresBusca = Cor.values();
                    Cor corSelecionadaBusca = (Cor) JOptionPane.showInputDialog(null, "Escolha a cor:", "Selecionar Cor",
                            JOptionPane.QUESTION_MESSAGE, null, coresBusca, coresBusca[0]);

                    ArrayList<Carro> carrosPorCor = listarCarrosPorCor(carros, corSelecionadaBusca);
                    double percentualCor = (double) carrosPorCor.size() / carros.size() * 100;

                    String mensagemCor = "Carros cadastrados da cor " + corSelecionadaBusca + ":\n";
                    for (Carro carro : carrosPorCor) {
                        mensagemCor += "Marca: " + carro.getMarca() + ", Ano: " + carro.getAnoFabricacao() + ", Cor: " + carro.getCor() + "\n";
                    }
                    mensagemCor += "Percentual: " + percentualCor + "%";

                    System.out.println( mensagemCor);
                    
				
			}
		}while(op != 5);
	}

	public static ArrayList<Carro> listarCarrosPorPeriodo(ArrayList<Carro> carros, int anoInicial, int anoFinal) {
        ArrayList<Carro> carrosPorPeriodo = new ArrayList<>();
        for (Carro carro : carros) {
            if (carro.getAnoFabricacao() >= anoInicial && carro.getAnoFabricacao() <= anoFinal) {
                carrosPorPeriodo.add(carro);
            }
        }
        return carrosPorPeriodo;
    }

    public static ArrayList<Carro> listarCarrosPorMarca(ArrayList<Carro> carros, String marca) {
        ArrayList<Carro> carrosPorMarca = new ArrayList<>();
        for (Carro carro : carros) {
            if (carro.getMarca().equals(marca)) {
                carrosPorMarca.add(carro);
            }
        }
        return carrosPorMarca;
    }

	public static ArrayList<Carro> listarCarrosPorCor(ArrayList<Carro> carros, Cor cor) {
        ArrayList<Carro> carrosPorCor = new ArrayList<>();
        for (Carro carro : carros) {
            if (carro.getCor() == cor) {
                carrosPorCor.add(carro);
            }
        }
        return carrosPorCor;
    }

}
