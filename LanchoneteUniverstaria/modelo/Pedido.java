package modelo;
import java.util.ArrayList;
import java.util.Date;

public class Pedido {
    private int numero;
    private Date data;
    private String status = "Em aberto"; 
    private ArrayList<Item> itens = new ArrayList<>();
    private static int cont = 0;
    
    //Construtores
    public Pedido(Date data){
        this.data = data;
        this.status = "Efetuado";
        this.numero = ++cont;
    }

    //Getters e Setters
    public int getNumero(){
        return this.numero;
    }
    public Date getData(){
        return this.data;
    }
    public String getStatus(){
        return this.status;
    }
    public void setNumero(int numero){
        this.numero = numero;
    }
    public void setData(Date data){
        this.data = data;
    }
    public void setStatus(String status){
        this.status = status;
    }
    public ArrayList<Item> getItens(){
        return itens;
    }
    //Métodos 
    public void inserirItem(Item item){
        itens.add(item);
    }
    public double calculaTotal(){

        double total = 0;
        Item item;
        for(int i = 0; i < getItens().size(); i++){
            item = getItens().get(i);
            total += item.calculaSubTotal() * item.getQuantidade();
        }

        return total;
    }
}
