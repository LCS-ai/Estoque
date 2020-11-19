package comparadores;

import java.util.Comparator;
import produto.*;

public class ComparadorPorNome implements Comparator<Produto> {
    @Override
    public int compare(Produto p1, Produto p2) {
        return p1.getNome().compareToIgnoreCase(p2.getNome());
    }
}
