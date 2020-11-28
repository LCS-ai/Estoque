package tests.util_test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import produto.Produto;
import util.Lista;

public class ListaTest {
    Lista lista;

    @Before
    public void inicializaLista() {
        lista = new Lista();
    }

    @Test
    public void adicionaProdutoTest() {
        Produto p = new Produto("tenis", "2p5");
        lista.adicionaProduto(p);
        assertTrue(lista.getListaDeProdutos().contains(p));
    }

    @Test
    public void pesquisaProdutoTest() {
        Produto p = new Produto("Bola de futsal - Topper", "4pe45");
        lista.adicionaProduto(p);
        assertEquals(-1, lista.pesquisaProduto("camiseta"));
        assertEquals(0, lista.pesquisaProduto("Bola"));
    }

    @Test
    public void verificaExistenciaMesmoCodigoTest() {
        Produto p = new Produto("Bola de Basquete - Nike", "23laid9");
        String codigo = p.getCodigo();
        lista.adicionaProduto(p);
        assertTrue(lista.verificaExistenciaMesmoCodigo(codigo));
        assertFalse(lista.verificaExistenciaMesmoCodigo("23"));
    }
    
    @Test
    public void verificaExistenciaMesmoNomeECodigoTest() {
        Produto p = new Produto("Bola de Basquete - Nike", "23laid9");
        String nome = p.getNome();
        String codigo = p.getCodigo();
        lista.adicionaProduto(p);
        assertTrue(lista.verificaExistenciaDoNomeECodigo(nome, codigo));
        assertFalse(lista.verificaExistenciaDoNomeECodigo("Tenis", "23"));
        assertTrue(lista.verificaExistenciaMesmoCodigo(codigo));
        assertFalse(lista.verificaExistenciaMesmoCodigo("23"));
    }
}