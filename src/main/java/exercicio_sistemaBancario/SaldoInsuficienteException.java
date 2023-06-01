package exercicio_sistemaBancario;

public class SaldoInsuficienteException extends Exception {
	public SaldoInsuficienteException(String mensagem) {
		super(mensagem);
	}
}
