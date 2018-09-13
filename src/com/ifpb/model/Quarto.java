package com.ifpb.model;

public class Quarto {
	private int numero;
	private String status;
	private TipoQuarto tipoquarto;
	public Quarto(int numero, String status, TipoQuarto tipoquarto) {
		this.numero = numero;
		this.status = status;
		this.tipoquarto = tipoquarto;
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
