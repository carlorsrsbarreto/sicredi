package org.sicredi.exception;

import org.sicredi.util.exception.SicrediException;

public class SessaoVotacaoNaoEncontradaException extends SicrediException{

	private static final String MESSAGE = "Sessão não encontrada";
	private static final String CODE = "ERO003";
	
	public SessaoVotacaoNaoEncontradaException() {
		super(CODE,MESSAGE);
	}
}
