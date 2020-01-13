package org.sicredi.service;

import java.util.Optional;

import org.sicredi.dto.SessaoVotacaoDTO;
import org.sicredi.entity.SessaoVotacao;
import org.sicredi.enumeration.StatusSessaoVotacaoEnum;
import org.sicredi.exception.AbrirSessaoVotacaoException;
import org.sicredi.exception.EncerrarSessaoVotacaoException;
import org.sicredi.exception.SessaoVotacaoNaoEncontradaException;
import org.sicredi.repository.SessaoVotacaoRepository;
import org.sicredi.validacao.SessaoVotacaoServiceValidator;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class SessaoVotacaoService {

	private SessaoVotacaoRepository sessaoVotacaoRepository;
	private SessaoVotacaoServiceValidator sessaoVotacaoServiceValidator;
	
	public SessaoVotacaoService(SessaoVotacaoRepository sessaoVotacaoRepository,SessaoVotacaoServiceValidator sessaoVotacaoServiceValidator) {
		this.sessaoVotacaoRepository=sessaoVotacaoRepository;
		this.sessaoVotacaoServiceValidator=sessaoVotacaoServiceValidator;
	}
	
	public void abrirSessao(SessaoVotacaoDTO sessaoVotacaoDTO) {
		try {
			sessaoVotacaoServiceValidator.validarEntrada(sessaoVotacaoDTO);
			sessaoVotacaoRepository.save(SessaoVotacaoDTO.parseFromSessaoVotacaoDTO(sessaoVotacaoDTO));
		} catch (DataIntegrityViolationException e) {
			throw new AbrirSessaoVotacaoException();
		}
	}


}
