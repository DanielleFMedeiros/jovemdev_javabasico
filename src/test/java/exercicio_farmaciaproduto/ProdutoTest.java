package exercicio_farmaciaproduto;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProdutoTest {

    @Test
    public void testSetNome() {
        Produto produto = new Produto("Produto A", 10, 9.99);
        produto.setNome("Novo Produto");
        assertEquals("Novo Produto", produto.getNome());
    }

    @Test
    public void testSetValor() {
        Produto produto = new Produto("Produto B", 20, 19.99);
        produto.setValor(15.99);
        assertEquals(15.99, produto.getValor(), 0.01);
    }
}
