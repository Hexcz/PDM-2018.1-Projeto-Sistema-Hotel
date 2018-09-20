package com.ifpb.control;

import java.util.ArrayList;
import java.util.List;

import com.ifpb.model.Reserva;

public class GerenciaReservaEncerrada {
	private static List<Reserva> reservas;
	
	public GerenciaReservaEncerrada() {
		reservas = new ArrayList<>();
	}
	
	public static boolean add(Reserva reserva) {
		if(buscarCodigoReserva(reserva.getCodigo())>0)
			return reservas.add(reserva);
		return false;
	}
	
	public static Reserva buscarReserva(int codigo) {
		for(int i = 0;i<reservas.size();i++)
			if(reservas.get(i).getCodigo() == codigo)
				return reservas.get(i);
		return null;
	}
	
	public static int buscarCodigoReserva(int codigo) {
		for(int i = 0;i<reservas.size();i++)
			if(reservas.get(i).getCodigo() == codigo)
				return i;
		return -1;
	}
	
	public static List<Reserva> listar(){
		return reservas;
	}
}
