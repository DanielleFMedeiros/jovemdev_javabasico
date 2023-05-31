package exercicio_sistemaBancario;

public class ContaUniversitaria extends Conta {
	
	private static final double LIMITE_SALDO = 2000.0;
	
	@Override
	public void saque(double valorSaque) {
		if (valorSaque>saldo) {
            throw new IllegalArgumentException("O saldo não pode ultrapassar R$ 2.000,00");
		}else {
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
    public void transferencia(Conta contaDestino, double valorTransferencia) {
        if (valorTransferencia > saldo) {
            throw new IllegalArgumentException("Saldo insuficiente para transferência");
        }

        if (contaDestino instanceof ContaUniversitaria) {
            double novoSaldoDestino = contaDestino.getSaldo() + valorTransferencia;
            if (novoSaldoDestino > LIMITE_SALDO) {
                throw new IllegalArgumentException("O saldo da conta destino não pode ultrapassar R$ 2.000,00");
            }
        
        }else {
        	saldo -= valorTransferencia;
            contaDestino.setSaldo(contaDestino.getSaldo() + valorTransferencia);
        }

        
    }
}
