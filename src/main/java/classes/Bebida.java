/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author Micro
 */
public class Bebida extends Produto {
    private String volume;

    public Bebida(String nome, Float preco, String volume) {
        super(nome, preco);
        this.volume = volume;
    }
    
    //alterar
    public void alterar(String novoNome, float novoPreco, String novoVolume){
        this.nome = novoNome;
        this.preco = novoPreco;
        this.volume = novoVolume;
    }
    
    //exibir tudo
    @Override
    public String toString() {
        return nome+" " + volume + "(R$"+preco+")" ;
    }
    
    
    
    
}
