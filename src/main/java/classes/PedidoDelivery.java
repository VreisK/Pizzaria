/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.util.ArrayList;

/**
 *
 * @author Micro
 */
public class PedidoDelivery extends Pedido{
    private String telefoneCliente;
    private String enderecoCliente;
    
    public PedidoDelivery(String nomeCliente, Float valorTotal,String escolhaTamanho, ArrayList<Sabor> escolhasSabores, ArrayList<Bebida> escolhasBebidas, ArrayList<Acompanhamento> escolhasAcomp, String telefoneCliente, String enderecoCliente) {
        super(nomeCliente, valorTotal, escolhaTamanho, escolhasSabores, escolhasBebidas, escolhasAcomp);
        this.telefoneCliente = telefoneCliente;
        this.enderecoCliente = enderecoCliente;
    }
    
    @Override
    public String toString() {
        return "nome do Cliente= " + nomeCliente + ", telefone do cliente= "+ telefoneCliente + ", endereço do cliente= " + enderecoCliente +", data do pedido= " + data + ", valor do pedido= " + valorTotal + ", Tamanho da pizza= " + escolhaTamanho + ", Sabores= " + escolhasSabores + ", Bebidas= " + escolhasBebidas + ", Acompanhamentos= " + escolhasAcomp;
    }
    
    
    
}
