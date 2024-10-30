/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Micro
 */
public class Pizzaria {
     private static Pizzaria instance; //para padrao de projeto
     ArrayList<Pedido> pedidosList = new ArrayList<>(); 
     ArrayList<Bebida> bebidasList = new ArrayList<>();
     ArrayList<Sabor> saboresList = new ArrayList<>();
     ArrayList<Acompanhamento> acompanhamentosList = new ArrayList<>();
     ArrayList<String> tamanhosPizzaList = new ArrayList<>(List.of("Pequena(4 fatias,2sabores)= R$15", "Grande(8 fatias,4 sabores)= R$25", "Família(12 fatias,8 sabores)= R$35"));
    int t1,t2,t3;
    boolean algoFoiCadastrado=false;
   
    
    //construtor
    private Pizzaria() {}
    //metodo de construcao para padrao de projeto singleton
    public static Pizzaria getInstance() {
        if (instance == null) {
            instance = new Pizzaria();
        }
        return instance;
    }

    
    public boolean bebidaExiste(){
        if(bebidasList.size() > 0){
            return true;
        }else {
            return false;
        }
    }
    public boolean acompanhamentoExiste(){
        if(acompanhamentosList.size() > 0){
            return true;
        }else {
            return false;
        }
    }
    public boolean saborExiste(){
        if(saboresList.size() > 0){
            return true;
        }else {
            return false;
        }
    }
    //opcao menu cadastrar
    public void adicionarSabor(String nomeProduto, float precoProduto){
        saboresList.add(new Sabor(nomeProduto, precoProduto));
        algoFoiCadastrado=true;
    }
    public void adicionarBebida(String nomeProduto, float precoProduto, String volume){
        bebidasList.add(new Bebida(nomeProduto, precoProduto, volume));
        algoFoiCadastrado=true;
    }
    public void adicionarAcompanhamento(String nomeProduto, float precoProduto, String quantPorcao){
        acompanhamentosList.add(new Acompanhamento(nomeProduto, precoProduto, quantPorcao));
        algoFoiCadastrado=true;
    }
    
    public boolean algoFoiCadastrado(){
        return algoFoiCadastrado;
    }
    
    //opcoes menu Alterar
    public boolean alterar(int indiceAlterar,int indice, String novoNome, float novoPreco, String quantPorcao, String novoVolume){
        if (indice==1) {
            if (indiceAlterar < saboresList.size()) {
            Sabor s = saboresList.get(indiceAlterar);
            s.alterar(novoNome, novoPreco);
            return true;
            }else{
                return false;
            }
         }else if(indice==2){
            if (indiceAlterar < bebidasList.size()) {
            Bebida b = bebidasList.get(indiceAlterar);
            b.alterar(novoNome, novoPreco, novoVolume);
            return true;
            }else{
                return false;
            }
        }else if(indice==3){
            if (indiceAlterar < acompanhamentosList.size()) {
            Acompanhamento a = acompanhamentosList.get(indiceAlterar);
            a.alterar(novoNome, novoPreco, quantPorcao);
            return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
    
    //exibir listas do menu
    public String getPedidosList() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < pedidosList.size(); i++) {
            result.append(i).append(": ").append(pedidosList.get(i).toString()).append("\n");
        }
        return result.toString();
    }
    
    public void getTamanhosPizzaList() { //exibir lista completa
        for(String p : tamanhosPizzaList){
            System.out.println( tamanhosPizzaList.indexOf(p) +" : " + p);
        }
    }
    
    public String getTamanhosPizzaList(int indice){ //exibir apenas uma das opcoes
        if (indice==0){
            t1++;
           return tamanhosPizzaList.get(0); 
        }else if (indice==1){
            t2++;
           return tamanhosPizzaList.get(1);
        }else{
            t3++;
           return tamanhosPizzaList.get(2);
        }
    }
    
    public String getSaboresList() {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < saboresList.size(); i++) {
            result.append(i).append(": ").append(saboresList.get(i).toString()).append("\n");
        }
        return result.toString();
    }
    
    public String getBebidasList() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < bebidasList.size(); i++) {
            result.append(i).append(": ").append(bebidasList.get(i).toString()).append("\n");
        }
        return result.toString();
    }
    
    public String getAcompanhamentosList() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < acompanhamentosList.size(); i++) {
            result.append(i).append(": ").append(acompanhamentosList.get(i).toString()).append("\n");
        }
        return result.toString();
    }
    
    //opcoes menu Excluir
    public boolean excluir(int indiceExcluir, int indice){
        if (indice==1) {
            Sabor.excluirPorIndice(saboresList, indiceExcluir);
            return true;
        }else if(indice==2){
            Bebida.excluirPorIndice(bebidasList, indiceExcluir);
            return true;
        }else if(indice==3){
            Acompanhamento.excluirPorIndice(acompanhamentosList, indiceExcluir);
            return true;
        }else{
            return false;
        }
    }
    
    

//metodos de vender
    ArrayList<Sabor> selecaoSabores = new ArrayList();
    ArrayList<Bebida> selecaoBebidas = new ArrayList();
    ArrayList<Acompanhamento> selecaoAcomp = new ArrayList();
    int cont=0;
    float valorTotal=0;
    //contagem e selecao para pedido
    //selecao= sempre que o cliente escolher do menu, sera adicionado a uma lista e o valor do produto assomado.
     float valor;
     boolean usouPizza=false;
    public void selecaoSabores(int indice){
        usouPizza=true;
        if (indice>=0 && indice<saboresList.size()) {
           cont++; 
           selecaoSabores.add(saboresList.get(indice));
           saboresList.get(indice).setCont();
        }
    }
    private float sabor(int indice){
        valor = selecaoSabores.get(indice).getPreco();
        return valor;
    }
    
    public void selecaoBebida(int indice){
        if (indice>=0 && indice<bebidasList.size()) {
           selecaoBebidas.add(bebidasList.get(indice));
           valorTotal +=bebidasList.get(indice).getPreco();
           bebidasList.get(indice).setCont();
        }
    }
    
    public void selecaoAcomp(int indice){
        if (indice>=0 && indice<acompanhamentosList.size()) {
           selecaoAcomp.add(acompanhamentosList.get(indice));
           valorTotal +=acompanhamentosList.get(indice).getPreco();
           acompanhamentosList.get(indice).setCont();
        }
    }
   
    String tamanhoPizza;
    public float fazerPedido(int tamPizza, int tipoP, String nomeC, String enderecoC, String telefoneC, int mesaC){
          if (usouPizza==true) {
            switch(tamPizza){ //para controle de sabores
              case 0:
                valorTotal += 15; 
                tamanhoPizza = tamanhosPizzaList.get(0);
                if (cont>2){ 
                    for (int i = 2; i < selecaoSabores.size(); i++) {
                        valorTotal+= sabor(i);   
                    }
                }
              break;
              case 1:
                valorTotal += 25;
                tamanhoPizza = tamanhosPizzaList.get(1);
                if (cont>4) { 
                    for (int i = 4; i < selecaoSabores.size(); i++) {
                        valorTotal+= sabor(i);   
                    }
                }
              break;
              case 2:
                valorTotal += 35;
                tamanhoPizza = tamanhosPizzaList.get(2);
                if (cont>8) { 
                    for (int i = 8; i < selecaoSabores.size(); i++) {
                        valorTotal+= sabor(i);   
                    }
                }
              break;
            }  
        }
        
        if (tipoP==1) {
          pedidosList.add(new PedidoPresencial(nomeC, valorTotal, mesaC, tamanhoPizza,selecaoSabores, selecaoBebidas, selecaoAcomp));  
        }else if(tipoP==2){
          pedidosList.add(new PedidoDelivery(nomeC, valorTotal,tamanhoPizza ,selecaoSabores, selecaoBebidas, selecaoAcomp, telefoneC, enderecoC));    
        }
       // zerando atributos
       float valorRetorno = valorTotal;
       valorParaTroco = valorTotal;
       valorTotal = 0.0f;
       usouPizza=false;
       tamanhoPizza=null;
       cont = 0;
      //"zerando" listas
       selecaoSabores = new ArrayList();
       selecaoBebidas = new ArrayList();
       selecaoAcomp = new ArrayList();
       return valorRetorno;
        
    }
    float valorRetorno;
    float valorParaTroco;
    public String valorPago(float valorPago){
        if (valorPago>0 && valorPago==valorParaTroco) {
          valorParaTroco=0.0f;
          return "pagamento certo";
        }else if(valorPago>0 && valorPago>valorParaTroco){
          valorRetorno = valorPago - valorParaTroco;  
          valorParaTroco=0.0f;
          return "Troco: "+valorRetorno;
        }else{//caso o valor pago for menor q o esperado
            valorRetorno = valorParaTroco - valorPago;
            valorParaTroco=0.0f;
            return "Valor que falta: " +valorRetorno; 
        } 
    }

    
    //para relatorio
    public float valorTotalArrecadado(){
        float valorTotalArrecadado = 0;
        for(cont=0;cont < pedidosList.size();cont++){
            valorTotalArrecadado += pedidosList.get(cont).getValorTotal();
        }
        return valorTotalArrecadado;
    }
    
    public String tamanhoRequisitado(){
        if(t1 > t2 && t1 > t3){
            return tamanhosPizzaList.get(0);
        }else if(t2 > t3){
             return tamanhosPizzaList.get(1);
        }else {
              return tamanhosPizzaList.get(2);
        }
    }
    
    public String bebidaRequisitada(){
        int maior = 0;
        int maiorContador = 0;
          if(bebidasList.size() == 0){
            return "Nenhuma bebida cadastrada";
        }
        for(cont=0;cont < bebidasList.size();cont++){
            if(bebidasList.get(cont).getCont() > maior){
                maior = bebidasList.get(cont).getCont();
                maiorContador = cont;
            }
        }
        return bebidasList.get(maiorContador).getNome();
    }
    public String saborRequisitado(){
        int maiorContador = 0;
        int maior = 0;
         if(saboresList.size() == 0){
            return "Nenhum sabor cadastrado";
        }
        for(cont=0;cont < saboresList.size();cont++){
            if(saboresList.get(cont).getCont() > maior){
                maior = saboresList.get(cont).getCont();
                maiorContador = cont;
            }
        }
        return saboresList.get(maiorContador).getNome();
    }
    
    public String acompanhamentoRequisitado(){
        int maior = 0;
          int maiorContador = 0;
          if(acompanhamentosList.size() == 0){
            return "Nenhum acompanhemento cadastrado";
        }
        for(cont=0;cont < acompanhamentosList.size();cont++){
            if(acompanhamentosList.get(cont).getCont() > maior){
                maior = acompanhamentosList.get(cont).getCont();
                maiorContador = cont;
            }
        }
        return acompanhamentosList.get(maiorContador).getNome();
    }
    
    public void historicoPedido(){
        for(cont=0;cont < pedidosList.size();cont++){
            System.out.println( pedidosList.get(cont).toString());
        }
       
    }   
}