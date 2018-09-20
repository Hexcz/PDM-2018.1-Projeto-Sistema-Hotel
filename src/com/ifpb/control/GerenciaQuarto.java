package com.ifpb.control;

import java.util.ArrayList;

import com.ifpb.model.Quarto;


public class GerenciaQuarto {
		private ArrayList<Quarto> quartos;
		
		public GerenciaQuarto() {
			quartos = new ArrayList<>();
		}
		
		public boolean create(Quarto novoQuarto) {
			if(read(novoQuarto.getNumero())<0) {
				return quartos.add(novoQuarto);
			}
			return false;
		}

		public int read(int numeroQuarto) {
			for(int i = 0; i<quartos.size();i++) {
				if(quartos.get(i).getNumero() == numeroQuarto)
					return i;
			}
			return -1;
		}

		public boolean update(int numeroQuarto, Quarto quarto) {
			if(read(numeroQuarto)!= -1 && delete(numeroQuarto)==true) {
				return create(quarto);
			}
			return false;
		}
		
		public boolean delete(int numeroQuarto) {
			if(quartos.isEmpty() && read(numeroQuarto) == -1)
				return false;
			else
				quartos.remove(read(numeroQuarto));
				return true;
		}
		
		public boolean mudarStatus(int numeroQuarto) {
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
		
		public ArrayList<Quarto> listarQuartosLivres(){
			ArrayList<Quarto> q = new ArrayList<>();
			for(Quarto quarto:quartos) {
				if(quarto.getStatus()=="Livre") {
					q.add(quarto);
				}
			}
			return q;
		}

		public boolean isQuartoLivre(int codigo) {
			for() {
//				
			}
		}
		
		@Override
		public String toString() {
			return "GerenciaQuarto [quartos=" + quartos + "]";
		}
		
		
}
