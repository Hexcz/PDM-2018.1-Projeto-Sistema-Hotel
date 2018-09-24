package com.ifpb.exceptions;

public class ListaHospedeVaziaException extends Exception{
	public ListaHospedeVaziaException() {
		super("Não existe nenhum hóspede cadastrado");
	}
}
