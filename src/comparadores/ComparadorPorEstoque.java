package comparadores;

import java.util.Comparator;

import produto.Produto;

public class ComparadorPorEstoque implements Comparator<Produto>{
    public int compare(Produto produto1, Produto produto2) {
        if (produto1.getEstoque() < produto2.getEstoque())
            return -1;
        if (produto1.getEstoque() > produto2.getEstoque())
            return 1;
        else
            return 0;
    }    
}
