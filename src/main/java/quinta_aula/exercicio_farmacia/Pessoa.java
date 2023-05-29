package quinta_aula.exercicio_farmacia;

public class Pessoa {
	private String nome;
	private String alergia;
	private String doenca;

	public Pessoa(String nome, String alergia, String doenca) {
		this.nome = nome;
		this.alergia = alergia;
		this.doenca = doenca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAlergia() {
		return alergia;
	}

	public void setAlergia(String alergia) {
		this.alergia = alergia;
	}

	public String getDoenca() {
		return doenca;
	}

	public void setDoenca(String doenca) {
		this.doenca = doenca;
	}

}
