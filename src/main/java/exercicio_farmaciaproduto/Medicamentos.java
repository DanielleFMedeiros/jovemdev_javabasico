package exercicio_farmaciaproduto;

public class Medicamentos extends Produto {
	private boolean receitaObrigatoria;

	public Medicamentos(String nome, int estoque, double valor, boolean receitaObrigatoria) {
		super(nome, estoque, valor);
		this.receitaObrigatoria = receitaObrigatoria;
	}

	// getters e setters

	public boolean isReceitaObrigatoria() {
		return receitaObrigatoria;
	}

	public void setReceitaObrigatoria(boolean receitaObrigatoria) {
		this.receitaObrigatoria = receitaObrigatoria;
	}
}




