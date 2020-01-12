package org.sicredi.validacao;

import org.sicredi.dto.SessaoVotacaoDTO;
import org.sicredi.exception.ValidarEntradaSessaoVotacaoException;
import org.springframework.stereotype.Component;

@Component
public class SessaoVotacaoServiceValidator {

	public void validarEntrada(SessaoVotacaoDTO sessaoVotacaoDTO) {
		
		if (sessaoVotacaoDTO==null)
			throw new ValidarEntradaSessaoVotacaoException();
		
		if (sessaoVotacaoDTO.getIdPauta()<=0)
			throw new ValidarEntradaSessaoVotacaoException();

		if (sessaoVotacaoDTO.getQtdTempoMinutosVotacao()<0)
			throw new ValidarEntradaSessaoVotacaoException();
	
	}
	
}
