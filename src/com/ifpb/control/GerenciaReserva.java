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
	
	public boolean update(Reserva r) { 
		if(reservas.set(reservas.indexOf(r), r)!=null)
			return true;
		return false;
	}
	
	public boolean delete(int codigo) {
		if(!reservas.isEmpty())
			return reservas.remove(read(codigo));
		return false;
	}
	
	public List<Reserva> listarReserva(){
		return reservas;
	}
	
	@Override
	public String toString() {
		return "GerenciaReserva [reservas=" + reservas + "]";
	}
	
}
