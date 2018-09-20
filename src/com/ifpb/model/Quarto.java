package com.ifpb.model;

public class Quarto {
	private int numero;
	private String status;
	private TipoQuarto tipoquarto;

	public Quarto(int numero, TipoQuarto tipoquarto) {
		this.numero = numero;
		this.status = "Livre";
		this.tipoquarto = tipoquarto;
	}

	@Override
	public String toString() {
		return "numero=" + numero + ", status=" + status + ", tipoquarto=" + tipoquarto + "\n";
	}

	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public TipoQuarto getTipoquarto() {
		return tipoquarto;
	}
	public void setTipoquarto(TipoQuarto tipoquarto) {
		this.tipoquarto = tipoquarto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numero;
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
		Quarto other = (Quarto) obj;
		if (numero != other.numero)
			return false;
		return true;
	}
	
}
