package exercicio_farmaciaproduto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FarmaciaTest {

    private Farmacia farmacia;
    private Cliente cliente;
    private Produto produto;
    private Medicamentos medicamento;

    @BeforeEach
    void setUp() {
        farmacia = new Farmacia();
        cliente = new Cliente("João", 0);
        produto = new Produto("Produto A", 10, 20.0);
        medicamento = new Medicamentos("Medicamento B", 5, 50.0, true);
        farmacia.cadastrarCliente(cliente);
        farmacia.cadastrarProduto(produto);
        farmacia.cadastrarProduto(medicamento);
    }

    @Test
    void realizarVenda_ProdutoInexistente_DeveLancarExcecao() {
        Produto produtoInexistente = new Produto("Produto Inexistente", 10, 30.0);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            farmacia.realizarVenda(cliente, produtoInexistente, 2, "");
        });
    }

    @Test
    void realizarVenda_EstoqueInsuficiente_DeveLancarExcecao() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            farmacia.realizarVenda(cliente, produto, 15, "");
        });
    }

    @Test
    void realizarVenda_VendaValida_DebitarValorDaContaDoClienteEAtualizarEstoque() {
        farmacia.realizarVenda(cliente, produto, 2, "");
        Assertions.assertEquals(40.0, cliente.getSaldoDevedor());
        Assertions.assertEquals(8, produto.getEstoque());
    }

    @Test
    void realizarVenda_MedicamentoRequerReceitaSemNomeDoMedico_DeveLancarExcecao() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            farmacia.realizarVenda(cliente, medicamento, 1, "");
        });
    }

    @Test
    void realizarVenda_MedicamentoRequerReceitaComNomeDoMedico_DeveImprimirMensagem() {
        farmacia.realizarVenda(cliente, medicamento, 1, "Dr. Médico");
        Assertions.assertEquals(50.0, cliente.getSaldoDevedor());
        Assertions.assertEquals(4, medicamento.getEstoque());
    }

    @Test
    void realizarVenda_PerfumariaComSaldoDevedorSuperiorA300_DeveLancarExcecao() {
        cliente.setSaldoDevedor(400.0);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            farmacia.realizarVenda(cliente, produto, 1, "");
        });
    }

    @Test
    void pagarConta_ValorPagamentoMaiorOuIgualAoSaldoDevedor_ZerarSaldoDevedorDoCliente() {
        cliente.setSaldoDevedor(50.0);
        farmacia.pagarConta(cliente, 50.0);
        Assertions.assertEquals(0.0, cliente.getSaldoDevedor());
    }

    @Test
    void pagarConta_ValorPagamentoMenorQueSaldoDevedor_AtualizarSaldoDevedorDoCliente() {
        cliente.setSaldoDevedor(50.0);
        farmacia.pagarConta(cliente, 30.0);
        Assertions.assertEquals(20.0, cliente.getSaldoDevedor());
    }

    @Test
    void consultarProdutos_RetornarListaDeProdutosCadastrados() {
        Produto produto2 = new Produto("Produto C", 5, 100.0);
        farmacia.cadastrarProduto(produto2);

        List<Produto> produtos = farmacia.consultarProdutos();
        Assertions.assertEquals(3, produtos.size());
        Assertions.assertTrue(produtos.contains(produto));
        Assertions.assertTrue(produtos.contains(medicamento));
        Assertions.assertTrue(produtos.contains(produto2));
    }

    @Test
    void consultarClientes_RetornarListaDeClientesCadastrados() {
        Cliente cliente2 = new Cliente("Maria", 0);
        farmacia.cadastrarCliente(cliente2);

        List<Cliente> clientes = farmacia.consultarClientes();
        Assertions.assertEquals(2, clientes.size());
        Assertions.assertTrue(clientes.contains(cliente));
        Assertions.assertTrue(clientes.contains(cliente2));
    }
}
