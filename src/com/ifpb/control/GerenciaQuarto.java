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

	public boolean removerQuarto(int numeroQuarto) {
		if(quartos.isEmpty() && buscarQuarto(numeroQuarto) == -1)
			return false;
		else
			quartos.remove(buscarQuarto(numeroQuarto));
			return true;
	}

	public boolean atualizarQuarto(int numeroQuarto, Quarto quarto) {
		if(buscarQuarto(numeroQuarto)!= -1 && removerQuarto(numeroQuarto)==true) {
			return addQuarto(quarto);
		}
		return false;
	}

	@Override
	public String toString() {
		return "GerenciaQuarto{" +
				"quartos=" + quartos +
				'}';
	}
}
