package com.dio.application;

import com.dio.classes.Conta;
import com.dio.classes.Pessoa;

import java.util.ArrayList;
import java.util.Scanner;

public class BancoDigital {
    //--
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Conta> contaBancaria;

    public static void main(String[] args) {
        contaBancaria = new ArrayList<Conta>();
        telaInicial();

    }

    public static void telaInicial() {
        String linha = "";
        System.out.println(String.format("%60s", linha).replace(" ", "|") );
        System.out.println(String.format("|               BANCO DIGITAL INNOVATION %18s|", linha));
        System.out.println(String.format("%60s", linha).replace(" ", "|") );
        System.out.println(String.format("| SELECIONE UMA DAS OPCOES: %31s|", linha));
        System.out.println(String.format("|%58s|", linha));
        System.out.println(String.format("| 1 - SALDO %47s|", linha));
        System.out.println(String.format("| 2 - SAQUE %47s|", linha));
        System.out.println(String.format("| 3 - DEPÓSITO %44s|", linha));
        System.out.println(String.format("| 4 - TRANSFERÊNCIA %39s|", linha));
        System.out.println(String.format("| 6 - NOVAS CONTAS %40s|", linha));
        System.out.println(String.format("| 7 - LISTAR CONTAS %39s|", linha));
        System.out.println(String.format("| 9 - FINALIZAR %43s|", linha));
        System.out.println(String.format("|%58s|", linha));
        System.out.println(String.format("%60s", linha).replace(" ", "|") );

        int opcao = sc.nextInt();
        switch (opcao) {
            case 1:
                System.out.println("1 - SALDO\n");
                exibirSaldo();
                break;
            case 2:
                System.out.println("\n2 - SAQUE");
                sacar();
                break;
            case 3:
                System.out.println("\n3 - DEPÓSITO");
                depositar();
                break;
            case 4:
                System.out.println("\n4 - TRANSFERÊNCIA");
                transferir();
                break;
            case 6:
                System.out.println("\n6 - NOVAS CONTAS");
                criarConta();
                break;
            case 7:
                System.out.println("\n7 - LISTAR CONTAS");
                listarContas();
                break;
            case 9:
                System.out.println("\nObrigado por utlizar nossos serviços!");
                System.exit(0);
            default:
                System.out.println("Opção inválida\n");
                telaInicial();
                break;
        }
    }

    //Saldo
    public static void exibirSaldo(){
        System.out.println("\nNúmero Conta: ");
        int numConta = sc.nextInt();

        Conta conta = localizarConta(numConta);

        if (conta != null){
            System.out.println("Seu saldo é:");
            conta.getSaldo();
        }else {
            System.out.println("Conta não encontrada!");
        }
        telaInicial();
    }

    //Criar Conta
    public static void criarConta(){
        System.out.println("\nNome: ");
        String nome = sc.next();

        System.out.println("\nNome: ");
        String email = sc.next();

        Pessoa pessoa = new Pessoa(nome, email);
        Conta conta = new Conta(pessoa);
        contaBancaria.add(conta);
        System.out.println("Conta criada com sucesso!");
        telaInicial();
    }

    // Localizar conta
    private static Conta localizarConta(int numeroConta){
        Conta conta = null;
        if (!contaBancaria.isEmpty()){
            for (Conta c: contaBancaria){
                if (c.getNumeroConta() == numeroConta)
                    conta = c;
            }
        }
        return conta;
    }

    // Depositar
    public static void depositar(){
        System.out.println("\nNúmero Conta: ");
        int numConta = sc.nextInt();

        Conta conta = localizarConta(numConta);

        if (conta != null){
            System.out.println("Digite o valor:");
            double valor = sc.nextDouble();
            conta.depositar(valor);
            System.out.println("Depósito realizado com sucesso!");

        }else {
            System.out.println("Conta não encontrada!");
        }
        telaInicial();
    }

    //Sacar
    public static void sacar(){
        System.out.println("\nNúmero Conta: ");
        int numConta = sc.nextInt();

        Conta conta = localizarConta(numConta);

        if (conta != null){
            System.out.println("Digite o valor:");
            double valorSaque = sc.nextDouble();
            conta.sacar(valorSaque);
        }else {
            System.out.println("Conta não encontrada!");
        }
        telaInicial();
    }

    //transferir
    public static void transferir(){
        System.out.println("Conta de Drigem:");
        int contaOrigem = sc.nextInt();
        //Validando cota origem
        Conta origem = localizarConta(contaOrigem);
        if (origem != null){
            System.out.println("Conta de Destino:");
            int contaDestino = sc.nextInt();
            // Validando destino
            Conta destino = localizarConta(contaDestino);
            if (destino != null){
                System.out.println("Digite o valor a ser transferido:");
                double valorTransferencia = sc.nextDouble();

                origem.transferir(valorTransferencia,destino);
                System.out.println("transferencia realiada com sucesso!");
            }else{
                System.out.println("Conta de destino não localizada!");
            }
        }else {
            System.out.println("Conta de origem não localizada!");
        }
        telaInicial();
    }

    //Listar Contas
    public static void listarContas(){
        if (!contaBancaria.isEmpty()){
            for (Conta conta: contaBancaria){
                conta.toString();
            }
        }else{
            System.out.println("Não há contas Cadastradas!");
        }
        telaInicial();
    }

}
