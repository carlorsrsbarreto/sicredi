package org.sicredi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table (name="SessaoVotacaoVoto", uniqueConstraints = {@UniqueConstraint(columnNames= {"nuCpf", "idSessaoVotacao"})})
@IdClass(SessaoVotacaoVotoId.class)
public class SessaoVotacaoVoto {
	@Id
	private long idSessaoVotacao;
	@Id
	private long nuCpf;
	private String voto;
	private int votoComputado;
		 
	public long getIdSessaoVotacao() {
		return idSessaoVotacao;
	}
	public void setIdSessaoVotacao(long idSessaoVotacao) {
		this.idSessaoVotacao = idSessaoVotacao;
	}
	
	public String getVoto() {
		return voto;
	}
	public void setVoto(String voto) {
		this.voto = voto;
	}
	public long getNuCpf() {
		return nuCpf;
	}
	public void setNuCpf(long nuCpf) {
		this.nuCpf = nuCpf;
	}
	public int getVotoComputado() {
		return votoComputado;
	}
	public void setVotoComputado(int votoComputado) {
		this.votoComputado = votoComputado;
	}
	
}
