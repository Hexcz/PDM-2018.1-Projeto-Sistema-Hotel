package com.ifpb.control;

import java.util.ArrayList;

import com.ifpb.model.Quarto;


public class GerenciaQuarto {
		private ArrayList<Quarto> quartos;
		
		public GerenciaQuarto() {
			quartos = new ArrayList<>();
		}
		
		public boolean createQuarto(Quarto novoQuarto) {
			if(readQuarto(novoQuarto.getNumero())<0)
				return quartos.add(novoQuarto);
			return false;
		}
		
		public boolean updateQuarto(int numeroQuarto, Quarto quarto) {
			if(readQuarto(numeroQuarto)!= -1 && removeQuarto(numeroQuarto)==true) {
				return createQuarto(quarto);
			}
			return false;
		}
		
		public int readQuarto(int numeroQuarto) {
			for(int i = 0; i<quartos.size();i++) {
				if(quartos.get(i).getNumero() == numeroQuarto)
					return i;
			}
			return -1;
		}
		
		public boolean removeQuarto(int numeroQuarto) {
			if(quartos.isEmpty() && readQuarto(numeroQuarto) == -1)
				return false;
			else
				quartos.remove(readQuarto(numeroQuarto));
				return true;
		}

		@Override
		public String toString() {
			return "GerenciaQuarto{" +
					"quartos=" + quartos +
					'}';
		}
}
