package com.ifpb.model;

public class ContaBancaria {
    private String titular;
    private int agencia;
    private String numeroConta;
    private boolean contaCorrente;

    public ContaBancaria(String titular, int agencia, String numeroConta, boolean contaCorrente) {
        this.titular = titular;
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.contaCorrente = contaCorrente;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public boolean isContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(boolean contaCorrente) {
        this.contaCorrente = contaCorrente;
    }
}
