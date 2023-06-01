package exercicio_farmaciaproduto;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ProdutoHospitalarTest {
    @Test
    public void testConstrutor() {
        ProdutoHospitalar produto = new ProdutoHospitalar("Máscara", 100, 10.99);
        assertEquals("Máscara", produto.getNome());
        assertEquals(100, produto.getEstoque());
        assertEquals(10.99, produto.getValor(), 0.01);
    }
}
