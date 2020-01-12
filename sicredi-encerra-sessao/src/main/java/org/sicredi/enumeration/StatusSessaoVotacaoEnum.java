package org.sicredi.enumeration;

public enum StatusSessaoVotacaoEnum {
	
	ABERTO(1),FECHADO(2);
	
	private int status;
	
	private StatusSessaoVotacaoEnum(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}
	
	
}
