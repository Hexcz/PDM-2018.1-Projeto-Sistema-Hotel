package com.ifpb.control;
import java.util.ArrayList;
import java.util.List;

import com.ifpb.model.Reserva;

public class GerenciaReserva {
	private List<Reserva> reservas;
	
	public GerenciaReserva() {
		reservas = new ArrayList<>();
	}
	
	public boolean create(Reserva r) {
		if(!reservas.isEmpty() && reservas.indexOf(r)>=0)
			return false;
		return reservas.add(r);
	}
	
	public Reserva read(int codigo) {
		for(Reserva r: reservas) {
			if(r.getCodigo() == codigo)
				return r;
		}
		return null;
	}

	@Override
	public String toString() {
		return "GerenciaReserva [reservas=" + reservas + "]";
	}
	
}
