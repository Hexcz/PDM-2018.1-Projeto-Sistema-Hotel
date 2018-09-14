package com.ifpb.control;

import java.util.ArrayList;

import com.ifpb.model.Quarto;


public class GerenciaQuarto {
		private ArrayList<Quarto> quartos;
		
		public GerenciaQuarto() {
			quartos = new ArrayList<>();
		}
		
		public int buscarQuarto(int numeroQuarto) {
			for(int i = 0; i<quartos.size();i++) {
				if(quartos.get(i).getNumero() == numeroQuarto)
					return i;
			}
			return -1;
		}
		
		public boolean addQuarto(Quarto novoQuarto) {
			if(buscarQuarto(novoQuarto.getNumero())<0)
				return quartos.add(novoQuarto);
			return false;
		}
}
