package org.sicredi.entity;

import java.io.Serializable;

public class SessaoVotacaoVotoId implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4122315715705845737L;
	private long idSessaoVotacao;
	private long nuCpf;
		 
	public long getIdSessaoVotacao() {
		return idSessaoVotacao;
	}
	public void setIdSessaoVotacao(int idSessaoVotacao) {
		this.idSessaoVotacao = idSessaoVotacao;
	}
	public long getNuCpf() {
		return nuCpf;
	}
	public void setNuCpf(long nuCpf) {
		this.nuCpf = nuCpf;
	}
	
	
}
