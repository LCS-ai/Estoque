package produto;

import org.junit.*;

import static org.junit.Assert.*;

public class ProdutoComVariacoesTest {
    ProdutoComVariacoes p1;
    
    @Before
    public void inicializaConstrutor() {
        p1 = new ProdutoComVariacoes("Nike", "NK0023", "Preto");
        p1.novaVariacao("33/34");
        p1.novaVariacao("35/36");
        p1.novaVariacao("37/38");
        p1.novaVariacao("39/40");
        p1.novaVariacao("41/42");
    }

    @Test
    public void testaNome() {
        assertEquals("Nike", p1.getNome());
    }


}
