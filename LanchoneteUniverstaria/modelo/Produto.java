package modelo;

public class Produto {
    private String nomeProduto;
    private String tipo;
    private String descricao;
    private int quantidade;
    private Double valor;
    private int codigoProduto=0;
    private static int cont=0;
    
    //Construtures
    public Produto(String nome, String descricao, String tipo, int quantidade, double valor){
        this.nomeProduto = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.valor = valor;
        this.codigoProduto = ++cont;
    }

    //Getters e Setters
    public int getCodigoProduto() {
        return codigoProduto;
    }
    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = ++cont;
    }
    
    public String getNomeProduto() {
        return nomeProduto;
    }
    public void setNomeProduto(String nome) {
        this.nomeProduto = nome;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public int getEstoque() {
        return quantidade;
    }
    public void setEstoque(int estoque) {
        this.quantidade = estoque;
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
}

