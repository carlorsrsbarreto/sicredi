package org.sicredi.exception;

import org.sicredi.util.exception.SicrediException;

public class ValidarEntradaSessaoVotacaoException extends SicrediException{

	private static final String MESSAGE = "Parametros de entrada inválido para abrir uma sessão de votação";
	private static final String CODE = "ERO002";
	
	public ValidarEntradaSessaoVotacaoException() {
		super(CODE,MESSAGE);
	}
}
