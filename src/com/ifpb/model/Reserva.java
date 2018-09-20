package com.ifpb.model;

import java.time.LocalDate;
import java.util.Objects;

import com.ifpb.control.GerenciaQuarto;
import com.ifpb.exceptions.QuartoInvalidoException;

public class Reserva {
    private int codigo;
    private String status;
    private String cpfHospede;
    private String matriculaFuncionario;
    private int[] numerosQuartos;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public Reserva(int codigo, String status, String cpfHospede, String matriculaFuncionario, int[] numerosQuartos, LocalDate dataInicio, LocalDate dataFim)
    			throws QuartoInvalidoException
    {
        this.codigo = codigo;
        this.status = status;
        this.cpfHospede = cpfHospede;
        this.matriculaFuncionario = matriculaFuncionario;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        for(int q:numerosQuartos) {
        	if(GerenciaQuarto.isQuartoLivre(q)) {
        		throw new QuartoInvalidoException();
        	}
        }
        this.numerosQuartos = numerosQuartos;
        //perguntar o numero de quartos no app
        
    }
    
    public LocalDate getDataInicio() {
		return dataInicio;
	}
    
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public LocalDate getDataFim() {
		return dataFim;
	}
	
	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
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
