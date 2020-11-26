package tests.produto_test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import produto.Produto;

public class ProdutoTest {
    Produto p1, p2, p3;
    
    @Before
    public void inicializaConstrutores() {
        p1 = new Produto("Nike Air-Jordan", "0001");
        p2 = new Produto("Nike SB", "0002", 54);
        p3 = new Produto("Nike Running", "0003", 67, 50);
    }

    @Test
    public void constroiNomeCodigo() {
        assertFalse(p1.getNome().isEmpty());
        assertFalse(p1.getCodigo().isEmpty());
        assertTrue(p1.getEstoque() == 0);
        assertTrue(p1.getEstoqueMinimo() == 0);
    }

    @Test
    public void constroiNomeCodigoEstoque() {
        assertFalse(p2.getNome().isEmpty());
        assertFalse(p2.getCodigo().isEmpty());
        assertTrue(p2.getEstoque() > 0);
        assertTrue(p2.getEstoqueMinimo() == 0);
    }

    @Test
    public void constroiNomeCodigoEstoqueEstoqueMinimo() {
        assertFalse(p3.getNome().isEmpty());
        assertFalse(p3.getCodigo().isEmpty());
        assertTrue(p3.getEstoque() > 0);
        assertTrue(p3.getEstoqueMinimo() > 0);
    }

    @Test
    public void nomeTest() {
        String nome = "Nike Air-Max";
        String nomeAntigo = p1.getNome();
        p1.setNome(nome);
        assertFalse(nomeAntigo.equals(p1.getNome()));
    }

    @Test
    public void codigoTest() {
        String codigo = "Nike Air-Max";
        String codigoAntigo = p1.getCodigo();
        p1.setCodigo(codigo);
        assertFalse(codigoAntigo.equals(p1.getCodigo()));
    }

    @Test
    public void estoqueTest() {
        int estoque = 34;
        int estoqueAntigo = p2.getEstoque();
        p2.setEstoque(estoque);
        assertNotEquals(estoqueAntigo, p2.getEstoque());
    }

    @Test
    public void estoqueMinimoTest() {
        int estoqueMinimo = 24;
        int estoqueMinimoAntigo = p3.getEstoqueMinimo();
        p3.setEstoqueMinimo(estoqueMinimo);
        assertNotEquals(estoqueMinimoAntigo, p3.getEstoqueMinimo());
    }
}
