package org.sicredi.service;

import java.util.List;

import org.sicredi.api.report.ClientMQReportApi;
import org.sicredi.entity.SessaoVotacao;
import org.sicredi.enumeration.StatusSessaoVotacaoEnum;
import org.sicredi.repository.SessaoVotacaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EncerraSessaoService {
	private SessaoVotacaoRepository sessaoVotacaoRepository;
	private ClientMQReportApi clientMQReportApi;

	public EncerraSessaoService(
			SessaoVotacaoRepository sessaoVotacaoRepository,
			ClientMQReportApi clientMQReportApi) {
		this.sessaoVotacaoRepository = sessaoVotacaoRepository;
		this.clientMQReportApi = clientMQReportApi;
		
	}
	
	@Transactional
	public void encerrarSessao() {
		
		List<SessaoVotacao> votacaoAberta = this.sessaoVotacaoRepository.findBySessaoVotacaoEncerrada();
		for (SessaoVotacao sessaoVotacao : votacaoAberta) {
			clientMQReportApi.send(sessaoVotacao.toString());
		}
		
		this.sessaoVotacaoRepository.encerrarVotacao(StatusSessaoVotacaoEnum.FECHADO.getStatus());

	}

}
