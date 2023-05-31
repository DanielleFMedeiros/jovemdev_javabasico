package exemplo_polimorfismo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import exercicio_polimorfismo.Cilindro;
import exercicio_polimorfismo.Circulo;
import exercicio_polimorfismo.Forma;
import exercicio_polimorfismo.Quadrado;
import exercicio_polimorfismo.Triangulo;

public class PolimorfismoTest {
    List<Forma> formas = new ArrayList<Forma>();

    @Before
    public void init() {
        formas.add(new Cilindro());
        formas.add(new Circulo());
        formas.add(new Quadrado());
        formas.add(new Triangulo());
    }

    @Test
    @DisplayName("Teste desenhar cilindro")
    public void desenharCilindro() {
        String s = formas.get(0).desenhar();
        assertEquals("Sou a forma Cilindro", s);
    }

    @Test
    @DisplayName("Teste desenhar Circulo")
    public void desenharCirculo() {
        String s = formas.get(1).desenhar();
        assertEquals("Sou a forma Circulo", s);
    }

    @Test
    @DisplayName("Teste desenhar Quadrado")
    public void desenharQuadrado() {
        String s = formas.get(2).desenhar();
        assertEquals("Sou a forma Quadrado e tenho 4 lados", s);
    }

    @Test
    @DisplayName("Teste desenhar Triangulo")
    public void desenharTriangulo() {
        String s = formas.get(3).desenhar();
        assertEquals("Sou a forma Triangulo e tenho 3 lados", s);
        if (formas.get(3) instanceof Triangulo) {
            Triangulo t = (Triangulo) formas.get(3);
            assertEquals(3, t.getLados());
        }
    }

    @Test
    @DisplayName("Teste calcular área círculo")
    public void calcAreaCirculo() {
        String s = "";
        if (formas.get(1) instanceof Circulo) {
            Circulo c = (Circulo) formas.get(1);
            s = c.calculaArea();
        }

        assertEquals("Minha área pode ser calculada", s);
    }
}
