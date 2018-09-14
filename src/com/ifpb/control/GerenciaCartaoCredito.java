package com.ifpb.control;

import java.util.ArrayList;

import com.ifpb.model.CartaoCredito;

public class GerenciaCartaoCredito {
	private ArrayList<CartaoCredito> cartoes;
	
	public GerenciaCartaoCredito() {
		cartoes = new ArrayList<>();
	}
	
	public boolean create(CartaoCredito cartao){
		if(!cartoes.isEmpty() && cartoes.indexOf(cartao)>=0) {
			return false;
		}
		return cartoes.add(cartao);
	}

	public CartaoCredito read(String numero){
		for(CartaoCredito cartao:cartoes) {
			if(cartao.getNumero().equals(numero)) {
				return cartao;
			}
		}
		return null;
	}

	public boolean remove(String numero) {
		if(!cartoes.isEmpty())
			return cartoes.remove(read(numero));
		return false;
	}

	@Override
	public String toString() {
		return "GerenciaCartaoCredito{" +
				"cartoes=" + cartoes +
				'}';
	}
}
