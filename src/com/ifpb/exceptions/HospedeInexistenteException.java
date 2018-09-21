package com.ifpb.exceptions;

public class HospedeInexistenteException extends Exception{
	public HospedeInexistenteException() {
		super("O cpf do hospede informado não existe");
	}
}
