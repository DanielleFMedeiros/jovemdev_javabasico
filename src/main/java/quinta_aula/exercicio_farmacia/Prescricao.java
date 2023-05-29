package quinta_aula.exercicio_farmacia;

import java.util.List;

public class Prescricao {
	private String pessoa;
	private List <Medicamento> medicamento;
	
	public Prescricao(String pessoa, List <Medicamento> medicamento) {
		this.pessoa = pessoa;
		this.medicamento = medicamento;
	}
	
	
	public String getPessoa() {
		return pessoa;
	}
	public void setPessoa(String pessoa) {
		this.pessoa = pessoa;
	}
	public List <Medicamento> getMedicamento() {
		return medicamento;
	}
	public void setMedicamento(List <Medicamento> medicamento) {
		this.medicamento = medicamento;
	}
}
