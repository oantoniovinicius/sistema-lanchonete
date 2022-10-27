package controle;
import modelo.*;
import java.util.ArrayList;

public class ControleProduto {
    private ArrayList<Produto> produtos = new ArrayList<>();
    private ArrayList<Item> itens = new ArrayList<>();

    //Construtores
    public void cadastrarProduto(String nomeProduto, String tipo, String descricao, int quantidade, double valor){
        Produto cadastro = new Produto(nomeProduto, descricao, tipo, quantidade, valor);
        produtos.add(cadastro);
    }

    //Getters e Setters 
    public ArrayList<Produto> getProdutos(){ 
        return produtos;
    }
    public ArrayList<Item> getItens(){ 
        return itens;
    }

    //Métodos
    public Produto pesquisarProduto(int codigo){
        Produto p = null;
        for(int i = 0; i < produtos.size(); i++){
            if(codigo == produtos.get(i).getCodigoProduto()){
                p = produtos.get(i);
                break;
            }
        }
        return p;
    }

    public String ImprimeProduto(){
        return itens.imprimirItem();
    }


}
