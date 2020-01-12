package org.sicredi.exception;

import org.sicredi.util.exception.SicrediException;

public class UsuarioNaoAutorizadoVotarException extends SicrediException{

	private static final String MESSAGE = "Usuario não autorizado para votar";
	private static final String CODE = "ERO006";
	
	public UsuarioNaoAutorizadoVotarException() {
		super(CODE,MESSAGE);
	}
}
