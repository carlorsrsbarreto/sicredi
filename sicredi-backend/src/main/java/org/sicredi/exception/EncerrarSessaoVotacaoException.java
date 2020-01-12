package org.sicredi.exception;

import org.sicredi.util.exception.SicrediException;

public class EncerrarSessaoVotacaoException extends SicrediException{

	private static final String MESSAGE = "Sessão já encerrada";
	private static final String CODE = "ERO004";
	
	public EncerrarSessaoVotacaoException() {
		super(CODE,MESSAGE);
	}
}
