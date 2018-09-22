package com.ifpb.control;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ifpb.model.Reserva;

public class GerenciaReservaEncerrada {
	private static List<Reserva> reservas = new ArrayList<>();
	
	public static boolean add(Reserva reserva) {
		if(buscarIndiceReserva(reserva.getCodigo())<0)
			return reservas.add(reserva);
		return false;
	}
	
	public static Float ganhoPeriodo(LocalDate inicio, LocalDate Fim) {
		Float ganho = 0f;
		for(Reserva r: reservas) {
			if(r.getDataInicio().equals(inicio) || r.getDataInicio().isAfter(inicio))
				if(r.getDataFim().equals(Fim) || r.getDataFim().isBefore(Fim))
					ganho += r.getHospedagem().getValor();
		}
		return ganho;
	}
	
	public static List<Reserva> reservasPeriodo(LocalDate inicio, LocalDate fim){
		List<Reserva> reservasPeriodo = new ArrayList<>();
		for(Reserva r: reservas) {
			if(r.getDataInicio().equals(inicio) || r.getDataInicio().isAfter(inicio))
				if(r.getDataFim().equals(fim) || r.getDataFim().isBefore(fim))
					reservasPeriodo.add(r);
		}
		return reservasPeriodo;
					
	}
	
	public static int buscarIndiceReserva(int codigo) {
		for(int i = 0;i<reservas.size();i++)
			if(reservas.get(i).getCodigo() == codigo)
				return i;
		return -1;
	}
	
	public static List<Reserva> listar(){
		return reservas;
	}
}
