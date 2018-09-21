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
	
	public static Reserva read(int codigo) {
		for(Reserva r: reservas) {
			if(r.getCodigo() == codigo)
				return r;
		}
		return null;
	}
	
	public static boolean update(Reserva r) { 
		if(reservas.set(reservas.indexOf(r), r)!=null)
			return true;
		return false;
	}
	
	public static boolean delete(int codigo) {
		if(!reservas.isEmpty())
			return reservas.remove(read(codigo));
		return false;
	}
	
	public static boolean fecharReserva(int codigoReserva) {
		Reserva reserva = read(codigoReserva);
		if(reserva!=null) {
			int quartos[] = reserva.getNumerosQuartos();
			for(int i = 0;i<reserva.getNumerosQuartos().length;i++) {
				if(GerenciaQuarto.mudarStatus(quartos[i])==false)
					return false;
			}
			reserva.setStatus("Encerrada");
			reserva.getHospedagem().setStatus("Paga");
			if(GerenciaReservaEncerrada.add(reserva))
				delete(reserva.getCodigo());
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
