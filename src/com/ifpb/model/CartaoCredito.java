package com.ifpb.model;

import java.time.LocalDate;
import java.util.Objects;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartaoCredito other = (CartaoCredito) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CartaoCredito [numero=" + numero + ", data=" + data + "]";
	}

	

	
}
