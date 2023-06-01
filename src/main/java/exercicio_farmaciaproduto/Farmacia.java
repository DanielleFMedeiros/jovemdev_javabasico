package exercicio_farmaciaproduto;

import java.util.ArrayList;
import java.util.List;

public class Farmacia {
    private List<Produto> produtos;
    private List<Cliente> clientes;

    public Farmacia() {
        produtos = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    public void cadastrarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void realizarVenda(Cliente cliente, Produto produto, int quantidade, String nomeMedico) {
        if (produto instanceof Medicamentos) {
            Medicamentos medicamento = (Medicamentos) produto;
            if (medicamento.isReceitaObrigatoria() && nomeMedico.isEmpty()) {
                throw new IllegalArgumentException("É necessário informar o nome do médico que prescreveu o medicamento.");
            }
            if (medicamento.isReceitaObrigatoria() && !nomeMedico.isEmpty()) {
                System.out.println("Venda de medicamento com retenção de receita. Médico: " + nomeMedico);
            }
        } else if (produto instanceof Perfumaria) {
            if (cliente.getSaldoDevedor() >= 300) {
                throw new IllegalArgumentException("Não é possível vender perfumaria para cliente com dívida superior a 300,00.");
            }
        }

        if (produto.getEstoque() < quantidade) {
            throw new IllegalArgumentException("Não há estoque suficiente para realizar a venda.");
        }

        double valorVenda = produto.getValor() * quantidade;
        cliente.setSaldoDevedor(cliente.getSaldoDevedor() + valorVenda);
        produto.setEstoque(produto.getEstoque() - quantidade);
        System.out.println("Venda realizada com sucesso.");
    }

    public void pagarConta(Cliente cliente, double valorPagamento) {
        double saldoDevedor = cliente.getSaldoDevedor();
        if (valorPagamento >= saldoDevedor) {
            cliente.setSaldoDevedor(0.0);
            System.out.println("Conta do cliente " + cliente.getNome() + " paga integralmente.");
        } else {
            cliente.setSaldoDevedor(saldoDevedor - valorPagamento);
            System.out.println("Pagamento parcial realizado. Saldo devedor atualizado: " + cliente.getSaldoDevedor());
        }
    }

    public List<Produto> consultarProdutos() {
        return produtos;
    }

    public List<Cliente> consultarClientes() {
        return clientes;
    }
}