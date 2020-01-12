package org.sicredi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SessaoVotacao {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idSessaoVotacao;
	@Column(unique=true)
	private int idPauta;
	private Date dtInicioVotacao;
	private Date dtFinalVotacao;
	private int idStatusSessaoVotacao;
	
	public int getIdSessaoVotacao() {
		return idSessaoVotacao;
	}
	public void setIdSessaoVotacao(int idSessaoVotacao) {
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
	
	
}
