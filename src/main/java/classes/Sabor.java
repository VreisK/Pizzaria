/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author Micro
 */
public class Sabor extends Produto {
    
    public Sabor(String nome, float preco) {
        super(nome, preco);
    }
    
    //exibir tudp
    @Override
    public String toString() {
        return nome+"(R$"+preco+")" ;
    }
    
}
