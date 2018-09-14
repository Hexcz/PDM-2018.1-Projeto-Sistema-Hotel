package com.ifpb.control;

import java.util.ArrayList;

import com.ifpb.model.CartaoCredito;

public class GerenciaCartaoCredito {
	private ArrayList<CartaoCredito> cartoes;
	
	public GerenciaCartaoCredito() {
		cartoes = new ArrayList<>();
	}
	
	public boolean remove(String numero) {
		if(!cartoes.isEmpty())
			return cartoes.remove(read(numero));
		return false;
	}
}
