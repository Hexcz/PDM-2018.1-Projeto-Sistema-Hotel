package com.ifpb.model;

import java.time.LocalDate;

public class CartaoCredito {
	private String numero;
	private LocalDate data;
	
	public CartaoCredito(String numero, LocalDate data) {
		this.numero = numero;
		this.data = data;
	}

	public String getNumero() {
		return numero;
	}

	public LocalDate getData() {
		return data;
	}
	
}
