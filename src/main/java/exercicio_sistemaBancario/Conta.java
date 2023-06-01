package exercicio_sistemaBancario;

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
		if(valorDeposito>0) {
			saldo = saldo + valorDeposito;
		}else {
			throw new IllegalArgumentException("O valor do depósito deve ser maior que zero.");
		}
	}

	public void saque(double valorSaque) {
		if(saldo>=valorSaque) {
			saldo = saldo - valorSaque;
		}else {
			throw new IllegalArgumentException("O valor insuficiente");
		}
		
		
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
