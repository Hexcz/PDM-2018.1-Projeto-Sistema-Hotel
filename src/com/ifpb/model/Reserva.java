package com.ifpb.model;

import java.time.LocalDate;
import java.util.Arrays;

import com.ifpb.control.GerenciaQuarto;
import com.ifpb.control.GerenciarHospede;
import com.ifpb.exceptions.HospedeInexistenteException;
import com.ifpb.exceptions.ListaHospedeVaziaException;
import com.ifpb.exceptions.QuartoInvalidoException;

public class Reserva {
    private int codigo;
    private static int id;
    private String status;
    private String cpfHospede;
    private String matriculaFuncionario;
    private int[] numerosQuartos;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Hospedagem hospedagem;

    public Reserva(String cpfHospede, String matriculaFuncionario, int[] numerosQuartos, LocalDate dataInicio, LocalDate dataFim, Hospedagem hospedagem) throws QuartoInvalidoException, HospedeInexistenteException, ListaHospedeVaziaException
    {
        this.codigo = ++id;
        this.status = "Aberta";
        if(GerenciarHospede.readHospede(cpfHospede)==null) {
        	throw new HospedeInexistenteException();
        }
        this.cpfHospede = cpfHospede;
        this.matriculaFuncionario = matriculaFuncionario;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
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
        
    }
    
    public LocalDate getDataInicio() {
		return dataInicio;
	}

    public Hospedagem getHospedagem() {
		return hospedagem;
	}



	public void setHospedagem(Hospedagem hospedagem) {
		this.hospedagem = hospedagem;
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
	
	@Override
	public String toString() {
		return "Reserva [codigo=" + codigo + ", status=" + status + ", cpfHospede=" + cpfHospede
				+ ", matriculaFuncionario=" + matriculaFuncionario + ", numerosQuartos="
				+ Arrays.toString(numerosQuartos) + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim
				+ ", " + hospedagem + "]";
	}



}
