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
		return "[numero=" + numero + ", status=" + status + ", tipoquarto=" + tipoquarto + "]";
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
	
}
