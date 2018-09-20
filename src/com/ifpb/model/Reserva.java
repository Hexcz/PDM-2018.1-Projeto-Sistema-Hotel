package com.ifpb.model;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

import com.ifpb.control.GerenciaQuarto;

import exceptions.QuartoInvalidoException;

public class Reserva {
    private int codigo;
    private String status;
    private String cpfHospede;
    private String matriculaFuncionario;
    private int[] numerosQuartos;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Hospedagem hospedagem;

    public Reserva(int codigo, String status, String cpfHospede, String matriculaFuncionario, int[] numerosQuartos,
    		LocalDate dataInicio, LocalDate dataFim, Hospedagem hospedagem) throws QuartoInvalidoException
    {
        this.codigo = codigo;
        this.status = status;
        this.cpfHospede = cpfHospede;
        this.matriculaFuncionario = matriculaFuncionario;
        for(int q:numerosQuartos) {
        	if(!GerenciaQuarto.isQuartoLivre(q, this.dataInicio, this.dataFim)) {
        		throw new QuartoInvalidoException();
        	}
        }
        for(int q:numerosQuartos) {
        	GerenciaQuarto.mudarStatus(q);
        }
        this.numerosQuartos = numerosQuartos;
        this.dataInicio = dataInicio;
        this.hospedagem = hospedagem;
        
        //perguntar o numero de quartos no app
    }
    
    

    public Hospedagem getHospedagem() {
		return hospedagem;
	}



	public void setHospedagem(Hospedagem hospedagem) {
		this.hospedagem = hospedagem;
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
    
    public int[] getNumerosQuartos() {
		return numerosQuartos;
	}



	public void setNumerosQuartos(int[] numerosQuartos) {
		this.numerosQuartos = numerosQuartos;
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



	@Override
	public String toString() {
		return "Reserva [codigo=" + codigo + ", status=" + status + ", cpfHospede=" + cpfHospede
				+ ", matriculaFuncionario=" + matriculaFuncionario + ", numerosQuartos="
				+ Arrays.toString(numerosQuartos) + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim
				+ ", hospedagem=" + hospedagem + "]";
	}



}
