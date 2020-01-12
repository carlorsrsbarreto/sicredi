package org.sicredi.dto;

import java.util.Date;

public class RelatorioVotacaoDTO {
	private String nmPauta;
	private Date dtInicioVotacao;
	private Date dtFinalVotacao;
	private int qtdVotosTrue;
	private int qtdVotosFalse;
	private String status;
	public String getNmPauta() {
		return nmPauta;
	}
	public void setNmPauta(String nmPauta) {
		this.nmPauta = nmPauta;
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
	public int getQtdVotosTrue() {
		return qtdVotosTrue;
	}
	public void setQtdVotosTrue(int qtdVotosTrue) {
		this.qtdVotosTrue = qtdVotosTrue;
	}
	public int getQtdVotosFalse() {
		return qtdVotosFalse;
	}
	public void setQtdVotosFalse(int qtdVotosFalse) {
		this.qtdVotosFalse = qtdVotosFalse;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
