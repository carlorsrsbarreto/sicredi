package org.sicredi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class SessaoVotacao {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idSessaoVotacao;
	@Column(unique=true)
	private int idPauta;
	private Date dtInicioVotacao;
	private Date dtFinalVotacao;
	private int idStatusSessaoVotacao;
	private long qtVotosSim;
	private long qtVotosNao;

	public long getIdSessaoVotacao() {
		return idSessaoVotacao;
	}
	public void setIdSessaoVotacao(long idSessaoVotacao) {
		this.idSessaoVotacao = idSessaoVotacao;
	}
	public int getIdPauta() {
		return idPauta;
	}
	public void setIdPauta(int idPauta) {
		this.idPauta = idPauta;
	}
	public Date getDtInicioVotacao() {
		return dtInicioVotacao;
	}
	public void setDtInicioVotacao(Date dtInicioVotacao) {
		this.dtInicioVotacao = dtInicioVotacao;
	}
	public Date getDtFinalVotacao() {
		return dtFinalVotacao;
	}
	public void setDtFinalVotacao(Date dtFinalVotacao) {
		this.dtFinalVotacao = dtFinalVotacao;
	}
	public int getIdStatusSessaoVotacao() {
		return idStatusSessaoVotacao;
	}
	public void setIdStatusSessaoVotacao(int idStatusSessaoVotacao) {
		this.idStatusSessaoVotacao = idStatusSessaoVotacao;
	}
	public long getQtVotosSim() {
		return qtVotosSim;
	}
	public void setQtVotosSim(long qtVotosSim) {
		this.qtVotosSim = qtVotosSim;
	}
	public long getQtVotosNao() {
		return qtVotosNao;
	}
	public void setQtVotosNao(long qtVotosNao) {
		this.qtVotosNao = qtVotosNao;
	}
	@Override
	public String toString() {
		return "SessaoVotacao [idSessaoVotacao=" + idSessaoVotacao + ", idPauta=" + idPauta + ", dtInicioVotacao="
				+ dtInicioVotacao + ", dtFinalVotacao=" + dtFinalVotacao + ", idStatusSessaoVotacao="
				+ idStatusSessaoVotacao + ", qtVotosSim=" + qtVotosSim + ", qtVotosNao=" + qtVotosNao + "]";
	}
	
	
	
}
