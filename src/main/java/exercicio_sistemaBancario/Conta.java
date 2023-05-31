package exercicio_sistemaBancario;

import lombok.Getter;

@Getter
public class Conta {
	private int numero;
	private int agencia;
	private String nomeCorrentista;
	protected double saldo;

	private String contaDestino;
	
	public Double Deposito() {
		double valorDeposito = 0;
		saldo = saldo + valorDeposito;
		return saldo;	
	}
	
	public Double Saque() {
		double valorSaque = 0;
		saldo = saldo - valorSaque;
		return saldo;
	}
	
	public void Transferencia(Conta contaDestino, double valorTransferencia){
		if(saldo<valorTransferencia) {
			System.out.println("Saldo insuficiente para realizar transferencia");
		}
		
		saldo-= valorTransferencia;
		contaDestino.saldo +=valorTransferencia;
	
	}
	
}
