package edu.dosw.lab.testing;

import edu.dosw.lab.modelo.Banco;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BancoTest {

    @Test
    void testConstructorYGetters() {
        Banco banco = new Banco("01", "BANCOLOMBIA");
        
        assertEquals("01", banco.getCodigoBanco());
        assertEquals("BANCOLOMBIA", banco.getNombreBanco());
    }
}
