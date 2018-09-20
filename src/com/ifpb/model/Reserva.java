package com.ifpb.model;

import java.util.Objects;

import exceptions.QuartoInvalidoException;

public class Reserva {
    private int codigo;
    private String status;
    private String cpfHospede;
    private String matriculaFuncionario;
    private int[] numerosQuartos;

    public Reserva(int codigo, String status, String cpfHospede, String matriculaFuncionario, int[] numerosQuartos)
    			throws QuartoInvalidoException
    {
        this.codigo = codigo;
        this.status = status;
        this.cpfHospede = cpfHospede;
        this.matriculaFuncionario = matriculaFuncionario;
        for(int q:numerosQuartos) {
        	// aqui vai lançar a exceção se o quarto ja estiver ocupado
        }
        this.numerosQuartos = numerosQuartos;
        //perguntar o numero de quartos no app
        
    }
    
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCpfHospede() {
        return cpfHospede;
    }

    public void setCpfHospede(String cpfHospede) {
        this.cpfHospede = cpfHospede;
    }

    public String getMatriculaFuncionario() {
        return matriculaFuncionario;
    }

    public void setMatriculaFuncionario(String matriculaFuncionario) {
        this.matriculaFuncionario = matriculaFuncionario;
    }

    public int[] getNumeroQuarto() {
        return numerosQuartos;
    }

    public void setNumeroQuarto(int[] numerosQuartos) {
        this.numerosQuartos = numerosQuartos;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Reserva)) return false;
        Reserva reserva = (Reserva) o;
        return codigo == reserva.getCodigo();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getCodigo(), getStatus(), getCpfHospede(), getMatriculaFuncionario(), getNumeroQuarto());
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "codigo=" + codigo +
                ", status='" + status + '\'' +
                ", cpfHospede='" + cpfHospede + '\'' +
                ", matriculaFuncionario='" + matriculaFuncionario + '\'' +
                ", numeroQuarto=" + numerosQuartos +
                "}\n";
    }
}
