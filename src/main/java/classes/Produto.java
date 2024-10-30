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
public abstract class Produto {
    protected String nome;
    protected Float preco;
    protected int cont;

    public int getCont() {
        return cont;
    }

    public void setCont() {
        this.cont++;
    }

    public String getNome() {
        return nome;
    }
    

    public Produto(String nome, Float preco) {
        this.nome = nome;
        this.preco = preco;
    }
    
    //alterar
    public void alterar(String novoNome, float novoPreco){
        this.nome = novoNome;
        this.preco = novoPreco;
    }
    
    //exibir tudo
    @Override
    public String toString() {
        return "Produto: " + "nome=" + nome + ", preco=" + preco;
    }

    public Float getPreco() {
        return preco;
    }

    //método excluir recebendo a lista e o indice para validar e entao excluir da lista.
    public static void excluirPorIndice(ArrayList<? extends Produto> listaProdutos, int indice) {
        if (indice >= 0 && indice < listaProdutos.size()) {
            listaProdutos.remove(indice);
        }
    }
}
    
    

