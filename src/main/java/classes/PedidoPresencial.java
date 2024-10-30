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
public class PedidoPresencial extends Pedido{
    private int mesa;
    
    public PedidoPresencial(String nomeCliente, Float valorTotal,int mesa,String escolhaTamanho, ArrayList<Sabor> escolhasSabores, ArrayList<Bebida> escolhasBebidas, ArrayList<Acompanhamento> escolhasAcomp) {
        super(nomeCliente, valorTotal, escolhaTamanho, escolhasSabores, escolhasBebidas, escolhasAcomp);
        this.mesa= mesa;
    }
    
    @Override
    public String toString() {
        return "nomeCliente=" + nomeCliente + ", mesa do pedido= "+ mesa +", data=" + data + ", valorTotal=" + valorTotal + ", Tamanho de pizza=" + escolhaTamanho + ", Sabores=" + escolhasSabores + ", Bebidas=" + escolhasBebidas + ", Acompanhamentos=" + escolhasAcomp;
    }
    
}
