package controle;
import java.util.ArrayList;
import modelo.*;
import java.util.Date;

public class ControlePedido {
    private ArrayList<Pedido> pedidos = new ArrayList<>();


    //Métodos
    public void cadastrarPedido(Date data){
        Pedido cadastro = new Pedido(data);
        pedidos.add(cadastro);
    }

    public Pedido pesquisarPedido(int codigo){
        Pedido p = null;
        for(int i = 0; i < pedidos.size(); i++){
            if(codigo == pedidos.get(i).getNumero()){
                p = pedidos.get(i);
                break;
            }
        }
        return p;
    }
    public ArrayList<Pedido> getPedidos(){
        return pedidos;
    }

    public Item adicionarItem(int numeroPedido, Produto p, int quantidade){
        Item item = new Item(p, quantidade);//recebe as informações do item
        Pedido pedidos = pesquisarPedido(numeroPedido);//busca na main em qual pedido adicionar o item pelo numero
        pedidos.inserirItem(item);//adiciona o item no pedido 

        return item;
    }

    public void removerPedido(int numeroPedido){
        pedidos.remove(numeroPedido);
    }

    public String imprimirPedido(int numeroPedido){
        Pedido pedido = pesquisarPedido(numeroPedido); 
        
        return  "Numero do pedido: " + pedido.getNumero()+
                "\nData do pedido: " + pedido.getData()+ 
                "\nStatus do pedido: " + pedido.getStatus() +
                "\nValor do pedido: R$" + pedido.calculaTotal();
    }
}