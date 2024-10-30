/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author Micro
 */
public abstract class Pedido {
    protected String nomeCliente, data, escolhaTamanho;
    protected Float valorTotal;
    //salvar descricao do pedido
    protected ArrayList<Sabor> escolhasSabores;
    protected ArrayList<Bebida> escolhasBebidas;
    protected ArrayList<Acompanhamento> escolhasAcomp;
    
   
    public Pedido(String nomeCliente, Float valorTotal,String escolhaTamanho, ArrayList<Sabor> escolhasSabores, ArrayList<Bebida> escolhasBebidas, ArrayList<Acompanhamento> escolhasAcomp) {
        this.nomeCliente = nomeCliente;
        setData();
        this.valorTotal = valorTotal;
        this.escolhasSabores = escolhasSabores;
        this.escolhasBebidas = escolhasBebidas;
        this.escolhasAcomp = escolhasAcomp;
        this.escolhaTamanho= escolhaTamanho;
    }
    
    //criar data automatico formatado sempre q chamar no construtor 
    public void setData(){
        Date dataAtual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        data = formato.format(dataAtual);
    }
    
    //metodo excluir da lista com base no indice
    public static void excluir(ArrayList<Pedido> listaPedidos, int indice) {
    listaPedidos.remove(indice);
    }
    
    @Override
    public String toString() {
        return "nomeCliente=" + nomeCliente + ", data=" + data + ", valorTotal=" + valorTotal + ", Tamanho de pizza=" + escolhaTamanho + ", Sabores=" + escolhasSabores + ", Bebidas=" + escolhasBebidas + ", Acompanhamentos=" + escolhasAcomp;
    }

    public Float getValorTotal() {
        return valorTotal;
    }
    
    

}
