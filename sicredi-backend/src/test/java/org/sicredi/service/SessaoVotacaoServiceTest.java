package org.sicredi.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.sicredi.dto.SessaoVotacaoDTO;
import org.sicredi.exception.AbrirSessaoVotacaoException;
import org.sicredi.exception.ValidarEntradaSessaoVotacaoException;
import org.sicredi.repository.SessaoVotacaoRepository;
import org.sicredi.validacao.SessaoVotacaoServiceValidator;
import org.springframework.dao.DataIntegrityViolationException;

public class SessaoVotacaoServiceTest {
	
	@Mock
	private SessaoVotacaoRepository sessaoVotacaoRepository;
	@InjectMocks
	private SessaoVotacaoServiceValidator sessaoVotacaoServiceValidator;

	private SessaoVotacaoService sessaoVotacaoService;
	
	 @Before
	  public void init(){
	    MockitoAnnotations.initMocks(this);
		sessaoVotacaoService = Mockito.spy(new SessaoVotacaoService(sessaoVotacaoRepository,sessaoVotacaoServiceValidator));

	 }
	
	@Test
	public void abrirSessaoTest() {		
		SessaoVotacaoDTO sessaoVotacaoDTO = new SessaoVotacaoDTO();
		sessaoVotacaoDTO.setIdPauta(1);
		sessaoVotacaoDTO.setQtdTempoMinutosVotacao(3);
		sessaoVotacaoService.abrirSessao(sessaoVotacaoDTO);
		Mockito.verify(sessaoVotacaoService).abrirSessao(sessaoVotacaoDTO);
	}

	@Test
	public void abrirSessaoTempoZeroTest() {		
		SessaoVotacaoDTO sessaoVotacaoDTO = new SessaoVotacaoDTO();
		sessaoVotacaoDTO.setIdPauta(1);
		sessaoVotacaoDTO.setQtdTempoMinutosVotacao(0);
		sessaoVotacaoService.abrirSessao(sessaoVotacaoDTO);
		Mockito.verify(sessaoVotacaoService).abrirSessao(sessaoVotacaoDTO);
	}

	@Test(expected = ValidarEntradaSessaoVotacaoException.class)
	public void abrirSessaoSemParametroTest() {		;
		sessaoVotacaoService.abrirSessao(null);
		Mockito.verify(sessaoVotacaoService).abrirSessao(null);
	}
	
	@Test(expected = ValidarEntradaSessaoVotacaoException.class)
	public void abrirSessaoTempoNegativoTest() {		;
		SessaoVotacaoDTO sessaoVotacaoDTO = new SessaoVotacaoDTO();
		sessaoVotacaoDTO.setIdPauta(1);
		sessaoVotacaoDTO.setQtdTempoMinutosVotacao(-1);
		sessaoVotacaoService.abrirSessao(sessaoVotacaoDTO);
		Mockito.verify(sessaoVotacaoService).abrirSessao(sessaoVotacaoDTO);
	}
	
	@Test(expected = ValidarEntradaSessaoVotacaoException.class)
	public void abrirSessaoPautaInvalidaTest() {		;
		SessaoVotacaoDTO sessaoVotacaoDTO = new SessaoVotacaoDTO();
		sessaoVotacaoDTO.setIdPauta(-1);
		sessaoVotacaoDTO.setQtdTempoMinutosVotacao(1);
		sessaoVotacaoService.abrirSessao(sessaoVotacaoDTO);
		Mockito.verify(sessaoVotacaoService).abrirSessao(sessaoVotacaoDTO);
	}
	
	@Test(expected = AbrirSessaoVotacaoException.class)
	public void abrirSessaoJaAbertaTest() {		
		DataIntegrityViolationException dataIntegrityViolationException = new DataIntegrityViolationException("DataIntegrityViolationException");
		Mockito.when(sessaoVotacaoRepository.save(Mockito.any())).thenThrow(dataIntegrityViolationException);
		SessaoVotacaoDTO sessaoVotacaoDTO = new SessaoVotacaoDTO();
		sessaoVotacaoDTO.setIdPauta(1);
		sessaoVotacaoDTO.setQtdTempoMinutosVotacao(0);
		sessaoVotacaoService.abrirSessao(sessaoVotacaoDTO);
		Mockito.verify(sessaoVotacaoService).abrirSessao(sessaoVotacaoDTO);
	}
	
}
