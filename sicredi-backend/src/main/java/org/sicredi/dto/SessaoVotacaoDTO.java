package org.sicredi.dto;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.sicredi.entity.SessaoVotacao;
import org.sicredi.enumeration.StatusSessaoVotacaoEnum;

public class SessaoVotacaoDTO {
	private int idPauta;
	private int qtdTempoMinutosVotacao;
	public int getIdPauta() {
		return idPauta;
	}
	public void setIdPauta(int idPauta) {
		this.idPauta = idPauta;
	}
	public int getQtdTempoMinutosVotacao() {
		return qtdTempoMinutosVotacao;
	}
	public void setQtdTempoMinutosVotacao(int qtdTempoMinutosVotacao) {
		this.qtdTempoMinutosVotacao = qtdTempoMinutosVotacao;
	}

	public static SessaoVotacao parseFromSessaoVotacaoDTO(SessaoVotacaoDTO sessaoVotacaoDTO) {
		SessaoVotacao sessaoVotacao = new SessaoVotacao();
		sessaoVotacao.setIdPauta(sessaoVotacaoDTO.getIdPauta());
		Date dateTimeIni = Calendar.getInstance().getTime(); 
		
		int qtdTempoMinutosVotacao = sessaoVotacaoDTO.getQtdTempoMinutosVotacao();
		if (qtdTempoMinutosVotacao==0) {
			qtdTempoMinutosVotacao = 1;
		} 
		
		Date dateTimeFin = DateUtils.addMinutes(dateTimeIni, qtdTempoMinutosVotacao); 
	    sessaoVotacao.setDtInicioVotacao(dateTimeIni);
		sessaoVotacao.setDtFinalVotacao(dateTimeFin);
		sessaoVotacao.setIdStatusSessaoVotacao(StatusSessaoVotacaoEnum.ABERTO.getStatus());
		return sessaoVotacao;
	}
	
	
	
}
