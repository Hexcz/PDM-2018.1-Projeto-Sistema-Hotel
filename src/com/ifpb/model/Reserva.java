package com.ifpb.model;

import java.util.Objects;

public class Reserva {
    private int codigo;
    private String status;
    private String cpfHospede;
    private String matriculaFuncionario;
    private int numeroQuarto;

    public Reserva(int codigo, String status, String cpfHospede, String matriculaFuncionario, int numeroQuarto) {
        this.codigo = codigo;
        this.status = status;
        this.cpfHospede = cpfHospede;
        this.matriculaFuncionario = matriculaFuncionario;
        this.numeroQuarto = numeroQuarto;
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

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(int numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    @Override
    public boolean equals(Object o) {
//        if (this == o) return true;
        if (!(o instanceof Reserva)) return false;
        Reserva reserva = (Reserva) o;
        return codigo == reserva.getCodigo();
//                && getNumeroQuarto() == reserva.getNumeroQuarto() &&
//                Objects.equals(getStatus(), reserva.getStatus()) &&
//                Objects.equals(getCpfHospede(), reserva.getCpfHospede()) &&
//                Objects.equals(getMatriculaFuncionario(), reserva.getMatriculaFuncionario());
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
                ", numeroQuarto=" + numeroQuarto +
                "}\n";
    }
}
