package com.ifpb.control;

import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

import com.ifpb.model.Quarto;
import com.ifpb.model.Reserva;


public class GerenciaQuarto {
		private static ArrayList<Quarto> quartos = new ArrayList<>();
		
		public static boolean create(Quarto novoQuarto) {
			if(!quartos.isEmpty() && quartos.indexOf(novoQuarto)>=0) {
				return false;
			}
			return quartos.add(novoQuarto);
			
		}

		private static int readInternal(int numeroQuarto) {
			
			for(int i=0;i<quartos.size();i++) {
				if(quartos.get(i).getNumero() == numeroQuarto)
					return i;
			}		
			return -1;
		}
		
		public static Quarto read(int numeroQuarto) {
			
			for(Quarto q: quartos) {
				if(q.getNumero() == numeroQuarto)
					return q;
			}
			return null;
		}

		public static boolean update(int numeroQuarto, Quarto quarto) {
			if(readInternal(numeroQuarto)!= -1 && delete(numeroQuarto)==true) {
				return create(quarto);
			}
			return false;
		}
		
		public static boolean delete(int numeroQuarto) {
			if(quartos.isEmpty() && readInternal(numeroQuarto) == -1)
				return false;
			else
				quartos.remove(readInternal(numeroQuarto));
				return true;
		}
		
		public static boolean mudarStatus(int numeroQuarto) {
			for(Quarto q : quartos) {
				if(q.getNumero()==numeroQuarto) {
					if(q.getStatus()=="Reservado") {
						q.setStatus("Livre");
					}else {
						q.setStatus("Reservado");
					}
					return true;
				}
			}
			return false;
		}
		
		public static ArrayList<Quarto> listarQuartosLivres(LocalDate i, LocalDate f){
			ArrayList<Quarto> q = new ArrayList<>();
			for(Quarto quarto:quartos) {
				if(isQuartoLivre(quarto.getNumero(), i, f)) {
					q.add(quarto);
				}
			}
			return q;
		}

		public static boolean isQuartoLivre(int numero, LocalDate i, LocalDate f) {
			List<Reserva> reservas = GerenciaReserva.listarReserva();
			for(Reserva r : reservas) {
				for(int numeroQuarto:r.getNumerosQuartos()) {
					if(numeroQuarto == numero) {
						if(i.isAfter(r.getDataFim()) || f.isBefore(r.getDataInicio())) {
							return true;
						}else return false;
					}
				}
			}
			return true;
		}
		
		public static List<Quarto> listar(){
			return quartos;
		}
		
		@Override
		public String toString() {
			return quartos.toString();
		}
		
		
}
