package exercicio_sistemaBancario.model;

import exercicio_sistemaBancario.Exception.SaldoInsuficienteException;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Conta {
	private int numero;
	private int agencia;
	private String nomeCorrentista;
	protected double saldo;

	public Conta(double saldoInicial) {
		this.saldo = saldoInicial;
	}

	public Conta() {

	}

	public Conta(int numero, int agencia, String nomeCorrentista) {
		this.numero = numero;
		this.agencia = agencia;
		this.nomeCorrentista = nomeCorrentista;
		this.saldo = 0.0;
	}
    public int getNumero() {
        return numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public String getNomeCorrentista() {
        return nomeCorrentista;
    }

	
	public void deposito(double valorDeposito) {
		//verificar se valor é maior q 0
		saldo = saldo + valorDeposito;
	}

	public void saque(double valorSaque) {
		//verificar se o saldo é igual ou maior q o valorsaque
		saldo = saldo - valorSaque;
	}

	public void transferencia(Conta contaDestino, double valorTransferencia, double saldoNovo) throws SaldoInsuficienteException {
		if (valorTransferencia <= 0) {
			throw new IllegalArgumentException("O valor da transferência deve ser maior que zero.");
		}
		if (saldo < valorTransferencia) {
			throw new SaldoInsuficienteException("Saldo insuficiente para realizar transferencia");
		} else {
			 saldo = saldo - valorTransferencia;
		        contaDestino.deposito(valorTransferencia);
		}

	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double novoSaldo) {
		this.saldo = novoSaldo;

	}

}
