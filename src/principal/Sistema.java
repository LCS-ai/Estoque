package principal;

import todososprodutos.Lista;

public class Sistema {
    public static void main(String[] args) {
        Lista lista = new Lista();
        boolean start = true;
        do {
            int opcao = Lista.inInt(
                "\n=========| Digite a opção desejada |=========\n\n"+
                "[1] Visualizar estoque\n"+
                "[2] Pesquisar produto\n"+
                "[3] Adicionar produto\n"+
                "[4] Apagar produto\n"+
                "[5] Sair\n"+
                "\n=============================================");
            switch (opcao) {
                case 1:
                    lista.mostraEstoque();
                    break;
                case 2:
                    break;
                case 3:
                    lista.adicionaProdutoNaLista();
                    break;
                case 4:
                    break;
                case 5:
                    start = false;
                    break;
                default:
                    break;
            }
        } while(start);
        System.exit(0);
    }
}