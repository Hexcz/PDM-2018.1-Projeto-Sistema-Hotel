package com.ifpb.exceptions;

public class QuartoReservadoException extends Exception{
	public QuartoReservadoException() {
		super("Quarto já esta reservado");
	}
}
