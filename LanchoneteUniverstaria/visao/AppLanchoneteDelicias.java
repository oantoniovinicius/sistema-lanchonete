package visao;
import javax.swing.JOptionPane;
import java.util.Date;
import controle.*;
import modelo.*;

public class AppLanchoneteDelicias {
    public static  String menu(){
        return "Escolha uma opção:\n"
                + "1 - Cadastrar produto\n"
                + "2 - Cadastrar Pedido\n"
                + "3 - Inserir Item no pedido\n"
                + "4 - Listar pedido\n"
                + "0 - Sair";
    }

    public static void main(String[] args) {
        ControlePedido cPed = new ControlePedido();
        ControleProduto cPrd = new ControleProduto();

        int escolha;
        int cont = 0;

        escolha= Integer.parseInt(JOptionPane.showInputDialog(menu()));

        while(escolha!=0){
            switch(escolha){
                case 1: {
                    String nome= JOptionPane.showInputDialog(null, "Informe o nome do produto: ");
                    String descricao= JOptionPane.showInputDialog(null, "Descricao do produto: ");
                    int quantidade= Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a quantidade desse produto no estoque: "));
                    String tipo= JOptionPane.showInputDialog(null, "Informe o tipo do produto (salgado, bebida, doce, etc): ");
                    double valor= Double.parseDouble(JOptionPane.showInputDialog(null, "Informe o valor de compra do produto: "));
                    cPrd.cadastrarProduto(nome, tipo, descricao, quantidade, valor);
                    JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
                    break;
                }
                case 2: {
                    Date hoje = new Date();
                    cPed.cadastrarPedido(hoje);
                    JOptionPane.showMessageDialog(null, "Pedido cadastrado com sucesso!" + "\nCódigo do pedido: " + cPed.getPedidos().get(cont).getNumero());
                    cont++;
                    break;
                }
                case 3:{
                    int numero= Integer.parseInt(JOptionPane.showInputDialog("Informe o numero do pedido: "));
                    Pedido pedido = cPed.pesquisarPedido(numero);
                    if(pedido==null){
                        JOptionPane.showMessageDialog(null, "Erro!\n"+
                                                    "Pedido invalido!\nTente novamente.");
                        break;
                    }
                    else{
                        int numeroProduto= Integer.parseInt(JOptionPane.showInputDialog("Informe o numero do item\n"+
                        " para ser adicionado no pedido: "));
                        Produto produto = cPrd.pesquisarProduto(numeroProduto);
                        if(produto==null){
                            JOptionPane.showMessageDialog(null, "Erro!\n"+
                            "Pedido invalido!\nTente novamente.");
                            break;
                        }
                        else{
                            int quantidade= Integer.parseInt(JOptionPane.showInputDialog("Informe quantos produtos desse tipo\ndeseja adicionar ao pedido: "));
                            Item item = cPed.adicionarItem(numero, produto, quantidade);
                            JOptionPane.showMessageDialog(null, "Item inserido com sucesso!" + item.imprimirItem());
                            break;
                        }
                    }
                }
                case 4: {
                    int numero= Integer.parseInt(JOptionPane.showInputDialog("Insira o número do pedido: "));
                    Pedido pedido = cPed.pesquisarPedido(numero);
                    if(numero <= cPed.getPedidos().size()){
                        if(pedido==null){
                            JOptionPane.showMessageDialog(null, "Erro!\n"+
                                                        "Pedido invalido!\n Tente novamente.");
                            break;
                        }
                        else{
                            JOptionPane.showMessageDialog(null, cPed.imprimirPedido(numero));
                            break;
                        }   
                    }else{
                        JOptionPane.showMessageDialog(null, "Erro!\n"+"Pedido invalido!\n Tente novamente.");
                    }
                    break;
                }
            }
            escolha= Integer.parseInt(JOptionPane.showInputDialog(menu()));
        }
        
    }    
}

