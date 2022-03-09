package com.dio.classes;

import com.dio.utilities.Utils;

public class Conta {

    private static int countConta = 1;
    private int numeroConta;
    private Pessoa pessoa;
    private double saldo = 0d;

    public Conta( Pessoa pessoa) {
        this.numeroConta = countConta;
        this.pessoa = pessoa;
        countConta += 1;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return  "\nNum. Conta: "+ this.getNumeroConta()+
                "\nNome: "+ this.pessoa.getNome()+
                "\nE-mail: "+ this.pessoa.getEmail()+
                "\nsaldo Disponivel: " + Utils.doubleToString(this.getSaldo())+
                "\n";
    }

    public void depositar(double valor){
        if (valor >0) {
            setSaldo(getSaldo() + valor);
            System.out.println("Depósito efetuado com sucesso!");
        }else {
            System.out.println("Valor inválido!");
        }
    }

    public void sacar(double valor){
        if (valor > 0 && this.getSaldo() > valor){
            setSaldo(getSaldo() - valor);
            System.out.println("Saque efetuado com sucesso!");
        }else if (this.getSaldo() < valor){
            System.out.println("Saldo Insuficiente");
        }else{
            System.out.println("Valor inválido!");
        }
    }

    public void transferir(double valor, Conta destinatario){
        if (valor > 0 && this.getSaldo() > valor) {
            setSaldo(getSaldo() - valor);
            destinatario.saldo = destinatario.getSaldo() - valor;
            System.out.println("Transferência realizada com sucesso!");
        }else{
            System.out.println("Não foi possível realizar a transferência!");
        }

    }
}
