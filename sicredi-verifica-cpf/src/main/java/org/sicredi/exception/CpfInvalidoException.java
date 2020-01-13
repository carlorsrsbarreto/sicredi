package org.sicredi.exception;

import org.sicredi.util.exception.SicrediException;

public class CpfInvalidoException extends SicrediException{

	private static final String MESSAGE = "Sessão já aberta para essa pauta";
	private static final String CODE = "ERO001";
	
	public CpfInvalidoException() {
		super(CODE,MESSAGE);
	}
}
