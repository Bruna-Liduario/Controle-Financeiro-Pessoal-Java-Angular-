package com.sistema.financeiro.exceptions;

public class NotFoundException extends Exception {	

	private static final long serialVersionUID = 1L;
	
	public NotFoundException(String mensagem) {
		super(mensagem);
	}	

}
