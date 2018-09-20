package com.ifpb.model;

import java.time.LocalDate;
import java.util.Arrays;
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
    private Hospedagem hospedagem;

<<<<<<< HEAD
    public Reserva(int codigo, String status, String cpfHospede, String matriculaFuncionario, int[] numerosQuartos, LocalDate dataInicio, LocalDate dataFim)
    			throws QuartoInvalidoException
=======
    public Reserva(int codigo, String status, String cpfHospede, String matriculaFuncionario, int[] numerosQuartos,
<<<<<<< HEAD
    		LocalDate dataInicio, LocalDate dataFim, Hospedagem hospedagem) throws QuartoInvalidoException
=======
    		LocalDate dataInicio, LocalDate dataFim) throws QuartoInvalidoException
>>>>>>> 8906f4aef06a69fa73e8bcfcdff0d9ca80350430
>>>>>>> 6bd750831fc065f46074850d4ab874f8237c8d28
    {
        this.codigo = codigo;
        this.status = status;
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
        
        //perguntar o numero de quartos no app
    }
    
    public LocalDate getDataInicio() {
		return dataInicio;
	}
    
<<<<<<< HEAD

    public Hospedagem getHospedagem() {
		return hospedagem;
	}



	public void setHospedagem(Hospedagem hospedagem) {
		this.hospedagem = hospedagem;
	}



=======
	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public LocalDate getDataFim() {
		return dataFim;
	}
	
	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}
	
>>>>>>> 6bd750831fc065f46074850d4ab874f8237c8d28
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
