package produto;

import static org.junit.Assert.assertEquals;

import org.junit.*;

public class ProdutoNumeradoTest {
    ProdutoNumerado pn;

    @Before
    public void inicializaProdutoNumerdo() {
        pn = new ProdutoNumerado("Nike", "NK0001", "33/34");
    }

    @Test
    public void getNomeTest() {
        assertEquals("Nike", pn.getNome());
        
    }

}
