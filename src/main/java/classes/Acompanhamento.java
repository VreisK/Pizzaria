/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author Micro
 */
public class Acompanhamento extends Produto{
    private String quantPorcao;

    public Acompanhamento(String nome, Float preco, String quantPorcao) {
        super(nome, preco);
        this.quantPorcao = quantPorcao;
    }

    //alterar
    public void alterar(String novoNome, float novoPreco, String quantPorcao){
        this.nome = novoNome;
        this.preco = novoPreco;
        this.quantPorcao = quantPorcao;
    }
    
    public String getQuantPorcao() {
        return quantPorcao;
    }
    
    //exibir tudp
    @Override
    public String toString() {
        return nome+" " + "("+"porção com " + quantPorcao+ "u" +")" + ": R$" + preco ;
    }
    
}