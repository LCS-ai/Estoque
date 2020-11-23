package principal;

import java.util.ArrayList;
import java.util.List;

import produto.Produto;

public class Sistema {

    public static void main(String[] args) {

        List <Produto> produtos = new ArrayList<>();
        
        Produto p = new Produto("Caixa", "001");
        

        produtos.add(p);
        produtos.add(new Produto("Caixão", "002"));
        
        
        System.out.println(produtos.get(0).getNome());
        System.out.println(produtos.get(1).getNome());

        produtos.remove(p);

        System.out.println(produtos.get(0).getNome());
        Produto t = new Produto("Caixão", "002");
        produtos.add(t);
        System.out.println(produtos.contains(t));

        

    }

}
