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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof CartaoCredito)) return false;
		CartaoCredito that = (CartaoCredito) o;
		return Objects.equals(getNumero(), that.getNumero()) &&
				Objects.equals(getData(), that.getData());
	}

	@Override
	public int hashCode() {

		return Objects.hash(getNumero(), getData());
	}

	@Override
	public String toString() {
		return "CartaoCredito{" +
				"numero='" + numero + '\'' +
				", data=" + data +
				'}';
	}
}
