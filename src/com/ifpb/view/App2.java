package com.ifpb.view;

import java.time.LocalDate;

import com.ifpb.control.GerenciaReserva;
import com.ifpb.control.GerenciaReservaEncerrada;
import com.ifpb.exceptions.QuartoInvalidoException;
import com.ifpb.model.Hospedagem;
import com.ifpb.model.Quarto;
import com.ifpb.model.Reserva;
import com.ifpb.model.TipoQuarto;

public class App2 {
	public static void main(String[] args) throws QuartoInvalidoException {
		TipoQuarto tp1 = new TipoQuarto("É o melho quarto");
		Quarto q1 = new Quarto(1, tp1);
		Quarto q2 = new Quarto(2, tp1);
		Quarto q3 = new Quarto(3, tp1);
		int numQuartos[] = {q1.getNumero(), q2.getNumero(), q3.getNumero()};
		Hospedagem hpdg = new Hospedagem("Pendente", 334.5f,1);
		
		Reserva rsv1 = new Reserva(1, "Aberta", "98764567", "1111-2", numQuartos, LocalDate.now(), LocalDate.of(2018, 12, 12), hpdg);
		System.out.println(GerenciaReserva.listarReserva());
	}
}
