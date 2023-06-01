package exercicio_sistemaBancario.model;

import exercicio_sistemaBancario.Exception.SaldoInsuficienteException;

public class ContaUniversitaria extends Conta {

    private static final double LIMITE_SALDO = 2000.0;

    @Override
    public void saque(double valorSaque) {
        if (valorSaque > saldo) {
            throw new IllegalArgumentException("O saldo não pode ultrapassar R$ 2.000,00");
        } else {
            saldo -= valorSaque;
        }
    }

    @Override
    public void deposito(double valorDeposito) {
        if (saldo + valorDeposito > LIMITE_SALDO) {
            throw new IllegalArgumentException("O saldo não pode ultrapassar R$ 2.000,00");
        }

        saldo += valorDeposito;
    }

    @Override
    public void transferencia(Conta contaDestino, double valorTransferencia, double saldoNovo) throws SaldoInsuficienteException {
        if (valorTransferencia <= 0) {
            throw new IllegalArgumentException("O valor da transferência deve ser maior que zero.");
        }
        if (saldoNovo > LIMITE_SALDO) {
            throw new IllegalArgumentException("Saldo do destino ultrapassa o limite da conta universitária");
        }

        if (saldo < valorTransferencia) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar transferência");
        
        
        } else {
        	this.saldo = saldo - valorTransferencia;
            contaDestino.deposito(valorTransferencia);
        }
    }
}
