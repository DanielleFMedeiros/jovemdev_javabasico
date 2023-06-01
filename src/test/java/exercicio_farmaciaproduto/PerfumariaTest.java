package exercicio_farmaciaproduto;

import org.junit.Test;

import exercicio_farmaciaproduto.Perfumaria;

import static org.junit.Assert.*;

public class PerfumariaTest {

    @Test
    public void testConstrutor() {
        Perfumaria produto = new Perfumaria("Perfume", 50, 59.99);
        assertEquals("Perfume", produto.getNome());
        assertEquals(50, produto.getEstoque());
        assertEquals(59.99, produto.getValor(), 0.01);
    }
}
