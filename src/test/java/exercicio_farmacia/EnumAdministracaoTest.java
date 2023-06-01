package exercicio_farmacia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import quinta_aula.exercicio_farmacia.enuns.EnumAdministracao;

public class EnumAdministracaoTest {

    @Test
    public void testEnumValues() {
        EnumAdministracao[] administracoes = EnumAdministracao.values();

        Assertions.assertEquals(4, administracoes.length);
        Assertions.assertEquals(EnumAdministracao.INJETAVEL, administracoes[0]);
        Assertions.assertEquals(EnumAdministracao.TOPICO, administracoes[1]);
        Assertions.assertEquals(EnumAdministracao.ORAL, administracoes[2]);
        Assertions.assertEquals(EnumAdministracao.SUPOSITORIO, administracoes[3]);
    }

    @Test
    public void testEnumToString() {
        Assertions.assertEquals("INJETAVEL", EnumAdministracao.INJETAVEL.toString());
        Assertions.assertEquals("TOPICO", EnumAdministracao.TOPICO.toString());
        Assertions.assertEquals("ORAL", EnumAdministracao.ORAL.toString());
        Assertions.assertEquals("SUPOSITORIO", EnumAdministracao.SUPOSITORIO.toString());
    }

    @Test
    public void testEnumOrdinal() {
        Assertions.assertEquals(0, EnumAdministracao.INJETAVEL.ordinal());
        Assertions.assertEquals(1, EnumAdministracao.TOPICO.ordinal());
        Assertions.assertEquals(2, EnumAdministracao.ORAL.ordinal());
        Assertions.assertEquals(3, EnumAdministracao.SUPOSITORIO.ordinal());
    }
}
