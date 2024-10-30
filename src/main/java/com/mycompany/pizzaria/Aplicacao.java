/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.pizzaria;

import classes.Pizzaria;
import java.util.*;

public class Aplicacao {

    static Scanner scan = new Scanner(System.in);
    static int menu = 0, menuC = 0, menuC2 = 0, menuC3 = 0, menuC4 = 0, menuC5 = 0, indiceAlterar, indiceExcluir = 0, menuV = 0, mesa = 0, menuV2 = 0, tamPizza = -1, mesaC = 0, menuE = 0, selecaoS = 0, selecaoB = 0, selecaoA = 0, opcao = 0;
    static String novoVolume = null, novoNome, volume, endereco = null, nomeC = null, enderecoC = null, telefoneC = null, quantPorcao;
    static float novoPreco;
    static Pizzaria pizzaria = Pizzaria.getInstance();//para padrao de projeto

    public static void main(String[] args) {
        do {
            System.out.println("\nP I Z Z A R I A ");
            if (pizzaria.algoFoiCadastrado() == false) {
                while (true) {
                    System.out.println("1-Cadastro");
                    try {
                        menu = scan.nextInt();
                    } catch (InputMismatchException e) {
                        scan.nextLine();
                        menu = 0;
                    }
                    if (menu == 1) {
                        break;
                    } else {
                        System.out.println("Valor invalido");

                    }
                }

            } else {
                while (true) {
                    System.out.println("1-Cadastro\n2-Vender\n3-Relatório\n4-Finalizar");
                    try {
                        menu = scan.nextInt();
                        if (menu > 0 && menu < 5) {
                            break;
                        } else {
                            System.out.println("Opção de menu inexistente");
                        }
                    } catch (InputMismatchException e) {
                        scan.nextLine();
                        System.out.println("Valor Inválido");
                    }
                }
            }

            switch (menu) {
                case 1:
                    do {
                        while (true) {
                            try {
                                System.out.println("\n1-Cadastrar produtos\n2-Alterar produtos cadastrados\n3-Excluir produtos cadastrados\n4-Consultar cadastros\n5-Sair");
                                menuC = scan.nextInt();
                                if (menuC > 0 && menuC < 6) {
                                    break;
                                } else {
                                    System.out.println("Opção de menu inexistente");
                                }
                            } catch (InputMismatchException e) {
                                scan.nextLine();
                                System.out.println("Valor Inválido");
                            }
                        }

                        if (menuC != 5) {
                            switch (menuC) {
                                case 1: //cadastrar
                                    cadastrar();
                                    break;
                                case 2: //alterar 
                                    alterar();
                                    break;
                                case 3: //excluir
                                    excluir();
                                    break;
                                case 4:
                                    consultar(); //consultar cadastrados
                                    break;
                                default:
                                    System.out.println("Valor Inválido");
                            }
                        }

                    } while (menuC != 5);

                    break;

                case 2: //vender
                    vender();
                    break;
                case 3: //relatorio
                    relatorio();
                    break;
                case 4:
                    System.out.println("Finalizando programa...");
                    break;
                default:
                    System.out.println("Valor inválido");
            }

        } while (menu != 4);

    }

    public static void cadastrar() {
        while (true) {
            try {
                System.out.println("\nCADASTRAR:\n1-Sabores\n2-Bebidas\n3-Acompanhamentos\n4-Voltar");
                menuC2 = scan.nextInt();
                if (menuC2 > 0 && menuC2 < 5) {
                    break;
                } else {
                    System.out.println("Opção de menu inexistente");
                }
            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.println("Valor Inválido");
            }
        }

        scan.nextLine(); //limpar
        if (menuC2 != 4) {
            String nome;
            Float preco;
            System.out.println("Nome do produto: ");
            nome = scan.nextLine();
            while (true) {
                try {
                    do {
                    System.out.println("Preço do produto: ");
                    preco = scan.nextFloat(); 
                        if (preco<=0) {
                            System.out.println("Não é permitido valores negativos em preços. Tente novamente");
                        }
                    } while (preco<=0);
                    
                    break;
                } catch (InputMismatchException e) {
                    scan.nextLine();
                    System.out.println("Valor Inválido");
                }
            }

            scan.nextLine();
            switch (menuC2) {
                case 1: //cadastrar sabores
                    pizzaria.adicionarSabor(nome, preco);
                    System.out.println("\nSabor cadastrado com sucesso!");
                    break;
                case 2: //cadastrar bebidas
                    System.out.println("Volume na embalagem: ");
                    volume = scan.nextLine();
                    pizzaria.adicionarBebida(nome, preco, volume);
                    System.out.println("\nBebida cadastrada com sucesso!");
                    break;
                case 3: //cadastrar acompanhamentos
                    System.out.println("Quanto vem na porção? ");
                    quantPorcao = scan.nextLine();
                    pizzaria.adicionarAcompanhamento(nome, preco, quantPorcao);
                    System.out.println("\nAcompanhamento cadastrado com sucesso!");
                    break;
            }

        }
    }

    public static void alterar() {

        boolean podeAlterar = false;
        while (true) {
            try {
                menuC3 = scan.nextInt();
                System.out.println("\nALTERAR:\n1-Sabores\n2-Bebidas\n3-Acompanhamentos\n4-Voltar ");

                menuC3 = scan.nextInt();
                if (menuC3 > 0 && menuC3 < 5) {
                    break;
                } else {
                    System.out.println("Opção de menu inexistente");
                }
            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.println("Valor Inválido");
            }
        }

        if (menuC3 != 4) {
            switch (menuC3) {
                case 1: //alterar sabores
                    System.out.println(pizzaria.getSaboresList());
                    if (pizzaria.saborExiste() == true) {
                        podeAlterar = true;
                    }
                    break;
                case 2: //alterar bebidas
                    System.out.println(pizzaria.getBebidasList());
                    if (pizzaria.bebidaExiste() == true) {
                        podeAlterar = true;
                    }
                    break;
                case 3: //alterar acompanhamentos
                    System.out.println(pizzaria.getAcompanhamentosList());
                    if (pizzaria.acompanhamentoExiste() == true) {
                        podeAlterar = true;
                    }
                    break;
            }
            if (podeAlterar) {
                while (true) {
                    try {
                        System.out.println("Selecione uma opção pelo índice:");
                        indiceAlterar = scan.nextInt();
                        scan.nextLine();
                        System.out.println("Novo nome do produto: ");
                        novoNome = scan.nextLine();
                        do {
                        System.out.println("Novo preço do produto: ");
                        novoPreco = scan.nextFloat(); 
                        if (novoPreco<=0) {
                            System.out.println("Não é permitido valores negativos em preços. Tente novamente");
                        }
                    } while (novoPreco<=0);
                        break;
                    } catch (InputMismatchException e) {
                        scan.nextLine();
                        System.out.println("Valor Inválido");
                    }
                }

                if (menuC3 == 2) {
                    System.out.println("Volume na embalagem: ");
                    novoVolume = scan.nextLine();
                    scan.nextLine();
                } else if (menuC3 == 3) {
                    System.out.println("Unidades por porção: ");
                    quantPorcao = scan.nextLine();
                }

                if (pizzaria.alterar(indiceAlterar, menuC3, novoNome, novoPreco, quantPorcao, novoVolume) == true) {
                    System.out.println("Índice " + indiceAlterar + " alterado com sucesso!");
                } else {
                    System.out.println("A Operação de alterar falhou!");
                }
            } else {
                System.out.println("Nenhum produto para ser alterado");
            }
        }
    }

    public static void excluir() {
        while (true) {
            try {
                System.out.println("\nEXCLUIR:\n1-Sabores\n2-Bebidas\n3-Acompanhamentos\n4-Voltar ");

                menuC4 = scan.nextInt();
                if (menuC4 > 0 && menuC4 < 5) {
                    break;
                } else {
                    System.out.println("Opção de menu inexistente");
                }
            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.println("Valor Inválido");
            }
        }

        if (menuC4 != 4) {
            boolean podeExcluir = false;

            switch (menuC4) {
                case 1: //excluir sabores
                    System.out.println(pizzaria.getSaboresList());
                    if (pizzaria.saborExiste() == true) {
                        podeExcluir = true;
                    }
                    break;
                case 2: //excluir bebidas
                    System.out.println(pizzaria.getBebidasList());
                    if (pizzaria.bebidaExiste() == true) {
                        podeExcluir = true;
                    }
                    break;
                case 3: //excluir acompanhamentos
                    System.out.println(pizzaria.getAcompanhamentosList());
                    if (pizzaria.acompanhamentoExiste() == true) {
                        podeExcluir = true;
                    }
                    break;
            }
            if (podeExcluir) {
                while (true) {
                    try {
                        System.out.println("Selecione uma opção pelo índice:");
                        indiceExcluir = scan.nextInt();
                        if (indiceExcluir >= 0) {
                            break;
                        } else {
                            System.out.println("O valor precisa ser maior que 0 ");
                        }
                    } catch (InputMismatchException e) {
                        scan.nextLine();
                        System.out.println("Valor Inválido");
                    }
                }

                if (pizzaria.excluir(indiceExcluir, menuC4) == false) {
                    System.out.println("Operacao de excluir falhou!");
                } else {
                    System.out.println("Operação realizada!");
                }
            } else {
                System.out.println("Nenhum produto para ser excluido");
            }
        }
    }

    public static void consultar() {
        do {
            while (true) {
                try {
                    System.out.println("\nCONSULTAR CADASTRADOS:\n1-Sabores\n2-Bebidas\n3-Acompanhamentos\n4-Voltar");

                    menuC5 = scan.nextInt();
                    if (menuC5 > 0 && menuC5 < 5) {
                        break;
                    } else {
                        System.out.println("Opção de menu inexistente");
                    }
                } catch (InputMismatchException e) {
                    scan.nextLine();
                    System.out.println("Valor Inválido");
                }
            }

            switch (menuC5) {
                case 1:
                    System.out.println(pizzaria.getSaboresList());
                    break;
                case 2:
                    System.out.println(pizzaria.getBebidasList());
                    break;
                case 3:
                    System.out.println(pizzaria.getAcompanhamentosList());
                    break;
            }
        } while (menuC5 != 4);
    }

    public static void vender() {

        do {
            while (true) {
                try {
                    System.out.println("\nVENDER: \n1- pedido presencial\n2-pedido delivery\n3-Sair");
                    menuV = scan.nextInt();
                    if(menuV > 0 && menuV < 4){
                    break;
                    }else{
                             System.out.println("Opção de menu inexistente");
                    }
                } catch (InputMismatchException e) {
                    scan.nextLine();
                    System.out.println("Valor Inválido");
                }
            }

            if (menuV == 1 || menuV == 2) {
                do {
                    while (true) {
                        try {
                            System.out.println("1-Pizzas\n2-Bebidas\n3-Acompanhamentos\n4-Finalizar pedido");
                            menuE = scan.nextInt();
                            if(menuE > 0 && menuE < 5){
                            break;
                            }else{
                                     System.out.println("Opção de menu inexistente");
                            }
                        } catch (InputMismatchException e) {
                            scan.nextLine();
                            System.out.println("Valor Inválido");
                        }
                    }

                    scan.nextLine();
                    switch (menuE) {
                        case 1: //vender pizza
                            tamPizza = venderPizza(pizzaria);
                            break;
                        case 2: //vender bebidas
                            venderBebidas(pizzaria);
                            break;
                        case 3:
                            venderAcompanhamento(pizzaria);
                            break;
                    }
                    if (menuE == 4) {
                        System.out.println("Nome do cliente:");
                        nomeC = scan.nextLine();
                        if (menuV == 1) {

                            while (true) {
                                try {
                                    System.out.println("Mesa do pedido: ");
                                    
                                    mesaC = scan.nextInt();
                                    break;
                                } catch (InputMismatchException e) {
                                    scan.nextLine();
                                    System.out.println("Valor Inválido");
                                }
                            }
                            scan.nextLine();
                        } else if (menuV == 2) {
                            System.out.println("Endereço do cliente:");
                            enderecoC = scan.nextLine();
                            System.out.println("Telefone do cliente:");
                            telefoneC = scan.nextLine();
                        }
                        System.out.println("Valor a pagar: R$" + pizzaria.fazerPedido(tamPizza, menuV, nomeC, enderecoC, telefoneC, mesaC));

                        System.out.println("Qual o valor pago pelo cliente?");
                        float valorPago = scan.nextFloat();
                        System.out.println(pizzaria.valorPago(valorPago));
                    }
                } while (menuE != 4);
            }
        } while (menuV != 3);
    }

    public static int venderPizza(Pizzaria pizzaria) {
        int selecaoS = 0, tamPizza = 0;
        Scanner scan = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\nQual o tamanho?");
                pizzaria.getTamanhosPizzaList();
                tamPizza = scan.nextInt();
                break;
            } catch (InputMismatchException e) {
                scan.nextLine();
                System.out.println("Valor Inválido");
            }
        }
        System.out.println("Selecione os sabores para a " + pizzaria.getTamanhosPizzaList(tamPizza) + ":");
        System.out.println(pizzaria.getSaboresList());
        System.out.println("[-1] para finalizar.");
        do {
            while (true) {
                try {
                    selecaoS = scan.nextInt();
                    if(selecaoS > -2){
                    break;
                    }else{
                             System.out.println("O valor precisa ser maior que -2");
                    }
                } catch (InputMismatchException e) {
                    scan.nextLine();
                    System.out.println("Valor Inválido");
                }
            }

            if (selecaoS != -1) {
                pizzaria.selecaoSabores(selecaoS);
            }
        } while (selecaoS != -1);
        return tamPizza;
    }

    public static void venderBebidas(Pizzaria pizzaria) {
        int selecaoB = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Selecione as bebidas:");
        System.out.println(pizzaria.getBebidasList());
        System.out.println("[-1] para finalizar.");
        do {

            while (true) {
                try {
                    selecaoB = scan.nextInt();
                    if(selecaoB > -2){
                    break;
                    }else{
                             System.out.println("O valor precisa ser maior que -2 ");
                    }
                } catch (InputMismatchException e) {
                    scan.nextLine();
                    System.out.println("Valor Inválido");
                }
            }
            if (selecaoB != -1) {
                pizzaria.selecaoBebida(selecaoB);
            }
        } while (selecaoB != -1);
    }

    public static void venderAcompanhamento(Pizzaria pizzaria) {
        int selecaoA = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Selecione os Acompanhamentos:");
        System.out.println(pizzaria.getAcompanhamentosList());
        System.out.println("[-1] para finalizar.");
        do {
            while (true) {
                try {
                    selecaoA = scan.nextInt();
                    if(selecaoA > -2){
                    break;
                    }else{
                             System.out.println("O valor precisa ser maior que -2 ");
                    }
                } catch (InputMismatchException e) {
                    scan.nextLine();
                    System.out.println("Valor Inválido");
                }
            }

            if (selecaoA != -1) {
                pizzaria.selecaoAcomp(selecaoA);
            }
        } while (selecaoA != -1);
    }

    public static void relatorio() {
        do {
            while (true) {
                try {
                    System.out.println("1-Valor total arrecadado.\n2- Os mais requisitados em tamanho de pizza, sabores, bebidas e acompanhamentos.\n3- Histórico dos pedidos.\n4-Voltar");
                    
                    opcao = scan.nextInt();
                    if(opcao > 0 && opcao < 5){
                    break;
                    }else{
                             System.out.println("Opção de menu inexistente");
                    }
                } catch (InputMismatchException e) {
                    scan.nextLine();
                    System.out.println("Valor Inválido");
                }
            }
            System.out.println("RELATÓRIO:");

            if (opcao != 4) {
                if (opcao == 1) {
                    System.out.println("O valor total arrecadado é de " + pizzaria.valorTotalArrecadado());
                } else if (opcao == 2) {
                    System.out.println("O tamanho da pizza mais requisitado " + pizzaria.tamanhoRequisitado());
                    System.out.println("O sabor mais requisitado foi " + pizzaria.saborRequisitado());
                    System.out.println("O acompanhamento mais requisitado foi " + pizzaria.acompanhamentoRequisitado());
                    System.out.println("O bebida mais requisitada foi " + pizzaria.bebidaRequisitada());
                } else if (opcao == 3) {
                    System.out.println("HISTÓRICO DE PEDIDOS:");
                    pizzaria.historicoPedido();
                }
            }
        } while (opcao != 4);
    }
}
