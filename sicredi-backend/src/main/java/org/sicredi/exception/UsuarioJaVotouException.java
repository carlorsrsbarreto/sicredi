package org.sicredi.exception;

import org.sicredi.util.exception.SicrediException;

public class UsuarioJaVotouException extends SicrediException{

	private static final String MESSAGE = "Usuario já votou";
	private static final String CODE = "ERO008";
	
	public UsuarioJaVotouException() {
		super(CODE,MESSAGE);
	}
}
