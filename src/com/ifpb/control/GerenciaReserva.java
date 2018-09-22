package com.ifpb.control;
import java.util.ArrayList;
import java.util.List;

import com.ifpb.model.Reserva;

public class GerenciaReserva {
	private static List<Reserva> reservas = new ArrayList<>();
	
	public static boolean create(Reserva r) {
		if(!reservas.isEmpty() && reservas.indexOf(r)>=0)
			return false;
		return reservas.add(r);
	}
	
	public static Reserva read(String cpfHospede) {
		for(Reserva r: reservas) {
			if(r.getCpfHospede().equals(cpfHospede))
				return r;
		}
		return null;
	}
	
	public static boolean update(Reserva r) { 
		if(reservas.set(reservas.indexOf(r), r)!=null)
			return true;
		return false;
	}
	
	public static boolean delete(String cpfHospede) {
		if(!reservas.isEmpty())
			return reservas.remove(read(cpfHospede));
		return false;
	}
	
	public static boolean fecharReserva(String cpfHospede) {
		Reserva reserva = read(cpfHospede);
		if(reserva!=null) {
			int quartos[] = reserva.getNumerosQuartos();
			for(int i = 0;i<reserva.getNumerosQuartos().length;i++) {
				if(GerenciaQuarto.mudarStatus(quartos[i])==false)
					return false;
			}
			
			reserva.setStatus("Encerrada");
			reserva.getHospedagem().setStatus("Paga");
			if(GerenciaReservaEncerrada.add(reserva))
				delete(reserva.getCpfHospede());
			return true;
		}
		return false;
	}
	
	public static List<Reserva> listarReserva(){
		return reservas;
	}
	
	@Override
	public String toString() {
		return "GerenciaReserva [reservas=" + reservas + "]";
	}
	
}
