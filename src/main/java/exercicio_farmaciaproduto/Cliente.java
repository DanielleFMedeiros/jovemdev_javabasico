package exercicio_farmaciaproduto;


public class Cliente {
    private String nome;
    private double saldoDevedor;

    public Cliente(String nome, double saldoDevedor) {
        this.nome = nome;
        this.saldoDevedor = saldoDevedor;
    }

    // getters e setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldoDevedor() {
        return saldoDevedor;
    }

    public void setSaldoDevedor(double saldoDevedor) {
        this.saldoDevedor = saldoDevedor;
    }

    public void pagarConta(double valorPagamento) {
        if (valorPagamento > saldoDevedor) {
            saldoDevedor = 0.0;
        } else {
            saldoDevedor -= valorPagamento;
        }
    }

}
