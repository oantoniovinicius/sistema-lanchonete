package modelo;

public class Item {
    private int quantidade;
    private Produto produto;


    public Item(Produto produto, int quantidade){
        this.produto= produto;
        this.quantidade = quantidade;
    }


    //Getters e Setters
    public int getQuantidade() {
        return quantidade;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setQuantidade(int quantidade){
        this.quantidade= quantidade;
    }

    //Métodos

    public double calculaSubTotal(){
        double subTotal= produto.getValor()*1.75;
        return subTotal;
    }

    public String imprimirItem(){
        return "\nTipo do produto: " + produto.getTipo()
        +"\nNome do produto: " + produto.getNomeProduto()
        + " " + produto.getDescricao()
        + "\nValor unitário R$: " + calculaSubTotal()
        + "\nQuantidade: " + getQuantidade(); 
    }
}
