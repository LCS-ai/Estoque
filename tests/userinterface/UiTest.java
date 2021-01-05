package userinterface;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import produto.Produto;
import userinterface.Ui;

public class UiTest {
    Ui ui;
    Produto p1, p2;

    @Before
    public void inicializa() {
        ui = new Ui();
        p1 = new Produto("Adidas", "00023", 34, 20);
    }

    @Test
    public void confereSucessoNaEdicaoTest() {
        Produto p = new Produto("Adidas", "001", 32, 10);
        Produto produtoAntigo = p;
        p.setNome("Nike");
        boolean b = ui.confereSucessoNaEdicao(produtoAntigo, p1);
        assertTrue(b);
    }
     
    @Test
    public void verificaListaVaziaTest() {
        List <Produto> p = new ArrayList<>();
        assertTrue(ui.verificaListaVazia(p));
    }

    @Test
    public void retornaLinhaTest() {
        assertEquals("===", ui.retornaLinha(3));
    }

}
