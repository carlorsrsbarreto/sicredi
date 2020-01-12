package org.sicredi.service;

import org.sicredi.enumeration.StatusSessaoVotacaoEnum;
import org.sicredi.repository.SessaoVotacaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EncerraSessaoService {
	private SessaoVotacaoRepository sessaoVotacaoRepository;
	
	public EncerraSessaoService(SessaoVotacaoRepository sessaoVotacaoRepository) {
		this.sessaoVotacaoRepository = sessaoVotacaoRepository;
	}
	
	@Transactional
	public void encerrarSessao() {
		this.sessaoVotacaoRepository.encerrarVotacao(StatusSessaoVotacaoEnum.FECHADO.getStatus());
	}
}
